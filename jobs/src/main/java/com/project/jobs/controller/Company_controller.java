package com.project.jobs.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.project.jobs.dto.Company;
import com.project.jobs.dto.Member;
import com.project.jobs.service.CompanyService3854;

import jakarta.servlet.http.HttpSession;

@Controller
@RequestMapping("/companies")
public class Company_controller {

	@Autowired
	private CompanyService3854 companyService;

	 @GetMapping
	    public String getAllCompanies(Model model, HttpSession session) {
	        Member loggedInMember = (Member) session.getAttribute("loggedInMember");
	        Long mem_no = loggedInMember != null ? loggedInMember.getMem_no() : null;
	        List<Company> companies = companyService.getAllCompaniesWithInterests(mem_no);
	        model.addAttribute("companies", companies);
	        return "com_list";
	    }

	    @PostMapping("/toggleInterest/{com_no}")
	    @ResponseBody
	    public String toggleInterest(@PathVariable Long com_no, HttpSession session) {
	        Member loggedInMember = (Member) session.getAttribute("loggedInMember");
	        boolean isInterest = companyService.toggleInterestCompany(loggedInMember.getMem_no(), com_no);
	        return "{\"success\": true, \"isInterest\": " + isInterest + "}";
	    }

	    @GetMapping("/interestCompanies")
	    public String getInterestCompanies(Model model, HttpSession session) {
	        Member loggedInMember = (Member) session.getAttribute("loggedInMember");
	        List<Company> interestCompanies = companyService.getInterestCompanies(loggedInMember.getMem_no());
	        model.addAttribute("interestCompanies", interestCompanies);
	        return "member/com_interest_list";
	    }

	@GetMapping("/{com_no}")
	public String getCompanyById(@PathVariable Long com_no, Model model) {
		Company company = companyService.getCompanyById(com_no);
		model.addAttribute("company", company);
		return "companyDetail";
	}

	@PostMapping("/insertCompany")
	public String insertCompany(@ModelAttribute Company company) {
		companyService.insertCompany(company);
		return "redirect:/members/loginForm";
	}

	@PostMapping("/login")
	public String login(@ModelAttribute Company company, Model model, HttpSession session) {
		Company loginCompany = companyService.login(company);
		if (loginCompany != null) {
			session.setAttribute("loggedInCompany", loginCompany);
			return "redirect:/members/index";
		} else {
			model.addAttribute("error", "아이디 또는 비밀번호가 올바르지 않습니다");
			return "redirect:/members/loginForm";
		}
	}

	@GetMapping("/logout")
	public String logout(HttpSession session) {
		session.invalidate();
		return "redirect:/members/loginForm";
	}

	@GetMapping("/delete/{com_no}")
	public String deleteCompany(@PathVariable Long com_no) {
		companyService.deleteCompany(com_no);
		return "redirect:/companies";
	}

	@GetMapping("/checkComId")
	@ResponseBody
	public boolean checkComId(@RequestParam(value = "com_id", required = false) String com_id) {
		if (com_id == null || com_id.trim().isEmpty()) {
			
			return false;
		}
		return companyService.isComIdExists(com_id);
	}
	
	 @GetMapping("/mypage")
	    public String mypage(HttpSession session, Model model) {
	        Company loggedInCompany = (Company) session.getAttribute("loggedInCompany");
	        if (loggedInCompany != null) {
	            model.addAttribute("member", loggedInCompany);
	            model.addAttribute("userName", loggedInCompany.getCom_name());
	            model.addAttribute("mem_no", loggedInCompany.getCom_no());
	            return "company/mypage/mypage3854";
	        } else {
	            return "redirect:/members/loginForm";
	        }
	    }

	@GetMapping("/editProfile")
	public String editLoggedInCompanyForm(HttpSession session, Model model) {
		Company loggedInCompany = getLoggedInCompany(session);
		if (loggedInCompany != null) {
			model.addAttribute("company", loggedInCompany);
			return "company/mypage/myProfile3854";
		} else {
			return "redirect:/members/loginForm";
		}
	}

	@PostMapping("/updateProfile")
	public String updateLoggedInCompany(@ModelAttribute Company company, HttpSession session) {
		Company loggedInCompany = getLoggedInCompany(session);
		if (loggedInCompany != null) {
			company.setCom_no(loggedInCompany.getCom_no());
			companyService.updateCompany(company);
			session.setAttribute("loggedInCompany", company); // 업데이트된 회사 정보를 세션에 다시 저장
			return "redirect:/companies/mypage";
		} else {
			return "redirect:/members/loginForm";
		}
	}

	private Company getLoggedInCompany(HttpSession session) {
		return (Company) session.getAttribute("loggedInCompany");
	}
}