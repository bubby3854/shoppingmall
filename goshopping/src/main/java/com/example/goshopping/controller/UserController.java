package com.example.goshopping.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttribute;

import com.example.goshopping.domain.Order;
import com.example.goshopping.domain.OrderRepository;
import com.example.goshopping.domain.Product;
import com.example.goshopping.domain.ProductRepository;
import com.example.goshopping.domain.User;
import com.example.goshopping.domain.UserRepository;

import jakarta.servlet.http.HttpSession;

@Controller
public class UserController {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private ProductRepository productRepository;
    

    @Autowired
    private OrderRepository orderRepository;

    @GetMapping("/")
    public String mainPage(Model model, HttpSession session) {
        Iterable<Product> productList = productRepository.findAll();
        model.addAttribute("productList", productList);

        String userId = (String) session.getAttribute("userId");
        if (userId != null) {
            model.addAttribute("loggedIn", true);
            model.addAttribute("userRole", session.getAttribute("userRole"));
        } else {
            model.addAttribute("loggedIn", false);
        }

        return "user/main";
    }

    @GetMapping("/signup")
    public String signupForm(Model model) {
        model.addAttribute("user", new User());
        return "user/signup";
    }

    @PostMapping("/signup")
    public String signupSubmit(@ModelAttribute User user, @RequestParam("confirmUpw") String confirmUpw, Model model) {
        StringBuilder errorMessage = new StringBuilder();

        if (user.getUid() == null || user.getUid().isEmpty()) {
            errorMessage.append("User ID is required.\n");
        }
        if (user.getUpw() == null || user.getUpw().isEmpty()) {
            errorMessage.append("Password is required.\n");
        }
        if (confirmUpw == null || confirmUpw.isEmpty()) {
            errorMessage.append("Password confirmation is required.\n");
        }
        if (user.getUpw() != null && !user.getUpw().equals(confirmUpw)) {
            errorMessage.append("Passwords do not match.\n");
        }
        if (user.getUbirth() == null || user.getUbirth().isEmpty()) {
            errorMessage.append("Birth Date is required.\n");
        }
        if (user.getUaddr() == null || user.getUaddr().isEmpty()) {
            errorMessage.append("Address is required.\n");
        }

        if (errorMessage.length() > 0) {
            model.addAttribute("signupError", errorMessage.toString());
            return "user/signup";
        }

        if ("manager3854".equals(user.getUid())) {
            user.setRole("Manager");
        } else {
            user.setRole("Member");
        }
        userRepository.save(user);
        return "redirect:/login";
    }

    @GetMapping("/login")
    public String loginForm(Model model) {
        model.addAttribute("user", new User());
        return "user/login";
    }

    @PostMapping("/login")
    public String loginSubmit(@ModelAttribute User user, HttpSession session, Model model) {
        User foundUser = userRepository.findByUidAndUpw(user.getUid(), user.getUpw());
        if (foundUser != null) {
            session.setAttribute("userId", foundUser.getUid());
            session.setAttribute("userRole", foundUser.getRole());
            return "redirect:/";
        } else {
            model.addAttribute("loginError", true);
            return "user/login";
        }
    }

    @GetMapping("/logout")
    public String logout(HttpSession session) {
        session.invalidate();
        return "redirect:/";
    }



    @GetMapping("/mypage")
    public String myPage(Model model, HttpSession session) {
        String userId = (String) session.getAttribute("userId");
        User user = userRepository.findFirstByUid(userId);
        model.addAttribute("user", user);
        
        String userRole = (String) session.getAttribute("userRole");
        if ("Manager".equals(userRole)) {
            Iterable<Product> productList = productRepository.findAll();
            model.addAttribute("productList", productList);
        }
        return "user/mypage";
    }

    @GetMapping("/mypage/edit")
    public String editMyPageForm(Model model, @SessionAttribute("userId") String userId) {
        User user = userRepository.findFirstByUid(userId);
        model.addAttribute("user", user);
        return "user/editmypage";
    }

    @PostMapping("/mypage/edit")
    public String editMyPageSubmit(@ModelAttribute User user, @RequestParam("confirmUpw") String confirmUpw, HttpSession session, Model model) {
        StringBuilder errorMessage = new StringBuilder();

        if (user.getUpw() == null || user.getUpw().isEmpty()) {
            errorMessage.append("Password is required.\n");
        }
        if (confirmUpw == null || confirmUpw.isEmpty()) {
            errorMessage.append("Password confirmation is required.\n");
        }
        if (user.getUpw() != null && !user.getUpw().equals(confirmUpw)) {
            errorMessage.append("Passwords do not match.\n");
        }
        if (user.getUbirth() == null || user.getUbirth().isEmpty()) {
            errorMessage.append("Birth Date is required.\n");
        }
        if (user.getUaddr() == null || user.getUaddr().isEmpty()) {
            errorMessage.append("Address is required.\n");
        }

        if (errorMessage.length() > 0) {
            model.addAttribute("editError", errorMessage.toString());
            return "user/editmypage";
        }

        userRepository.save(user);
        session.setAttribute("userId", user.getUid());
        return "redirect:/mypage";
    }
    

    @GetMapping("/admin/users")
    public String listUsers(Model model) {
        model.addAttribute("userList", userRepository.findAll());
        return "admin/userList";
    }

    @GetMapping("/admin/orders")
    public String listUserOrders(Model model) {
        List<Order> orders = orderRepository.findAll();
        model.addAttribute("orderList", orders);
        return "admin/orderList";
    }

  
    
}

