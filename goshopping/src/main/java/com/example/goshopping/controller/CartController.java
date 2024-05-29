package com.example.goshopping.controller;

import com.example.goshopping.domain.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import jakarta.servlet.http.HttpSession;

import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping("/cart")
public class CartController {

    @Autowired
    private CartRepository cartRepository;

    @Autowired
    private ProductRepository productRepository;

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private OrderRepository orderRepository;

    @PostMapping("/add")
    public String addToCart(@RequestParam("productId") Long productId, @RequestParam("quantity") int quantity,
                            @RequestParam(value = "redirect", defaultValue = "false") boolean redirect, HttpSession session) {
        String userId = (String) session.getAttribute("userId");
        if (userId == null) {
            return "redirect:/login";
        }
        User user = userRepository.findByUid(userId);

        Product product = productRepository.findById(productId)
                .orElseThrow(() -> new IllegalArgumentException("Invalid product Id:" + productId));

        Cart cart = Cart.builder().user(user).product(product).quantity(quantity).build();

        cartRepository.save(cart);

        if (redirect) {
            return "redirect:/cart/mycart";
        } else {
            return "redirect:/";
        }
    }
    @GetMapping("/mycart")
    public String viewCart(HttpSession session, Model model) {
        String userId = (String) session.getAttribute("userId");
        if (userId == null) {
            return "redirect:/login";
        }
        User user = userRepository.findByUid(userId);

        List<Cart> cartList = cartRepository.findByUser(user);
        double totalPrice = 0.0;
        if (cartList != null) {
            for (Cart cart : cartList) {
                if (cart.getProduct() != null && cart.getProduct().getPPrice() != null) {
                    try {
                        // "850만원" 같은 문자열에서 "만원"을 제거하고 숫자로 변환
                        String priceString = cart.getProduct().getPPrice().replaceAll("[^0-9]", "");
                        double price = Double.parseDouble(priceString);
                        totalPrice += price * cart.getQuantity();
                    } catch (NumberFormatException e) {
                        e.printStackTrace();
                    }
                }
            }
        } else {
            cartList = new ArrayList<>();
        }
        model.addAttribute("cartList", cartList);
        model.addAttribute("totalPrice", totalPrice);
        return "user/cart";
    }

    @PostMapping("/delete/{id}")
    public String deleteFromCart(@PathVariable("id") Long id) {
        cartRepository.deleteById(id);
        return "redirect:/cart/mycart";
    }

    @PostMapping("/order/{id}")
    public String orderProduct(@PathVariable("id") Long id, HttpSession session) {
        String userId = (String) session.getAttribute("userId");
        if (userId == null) {
            return "redirect:/login";
        }
        User user = userRepository.findByUid(userId);

        Cart cart = cartRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Invalid cart Id:" + id));

        Order order = Order.builder().user(user).product(cart.getProduct()).quantity(cart.getQuantity()).build();

        orderRepository.save(order);
        cartRepository.deleteById(id);

        return "redirect:/cart/mycart";
    }
}
