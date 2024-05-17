package com.project.jobs.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.project.jobs.dao.ICS_Dao_won;

import jakarta.servlet.http.HttpServletRequest;

@Controller
public class MyController_99 {
	
	@Autowired
	private ICS_Dao_won cs_Dao;
	
	@RequestMapping("/common/index")
	public String root() {
		
		return "/common/write_form";
	}
	
	@RequestMapping("/write_Form_99")
	public String writeForm() {
		
		return "/common/write_form";
	}
	
	@RequestMapping("/write_99")
	public String write(HttpServletRequest request) {
		String mem_no = request.getParameter("mem_no");
		String title = request.getParameter("title");
		String content = request.getParameter("content");
		String category = request.getParameter("category");
		String ch_private = request.getParameter("ch_private");
		
		cs_Dao.writeDao_99(mem_no, title, content, category, ch_private);
		return "redirect:/cs_list_99";
	}
	
	@RequestMapping("/cs_list_99")
	public String list(Model model) {
		
		model.addAttribute("list", cs_Dao.getList_99());
		return "/common/cs_list";
	}
	
	@RequestMapping("/cs_detail_99")
	public String listDetail(HttpServletRequest request, Model model) {
		String cs_no = request.getParameter("cs_no");
		model.addAttribute("dto", cs_Dao.getlistDetail_99(cs_no));
		return "/common/cs_detail";
	}
	
	@RequestMapping("/modify_form_99")
	public String modifyForm(HttpServletRequest request, Model model) {
		
		String cs_no = request.getParameter("cs_no");
		model.addAttribute("dto", cs_Dao.getlistDetail_99(cs_no));
		
		return "/common/modify_form";
	}
	
	@RequestMapping("/modify_99")
	public String modify(HttpServletRequest request, Model model) {
		String cs_no = request.getParameter("cs_no");
		String title = request.getParameter("title");
		String content = request.getParameter("content");
		String category = request.getParameter("category");
		String ch_private = request.getParameter("ch_private");
		cs_Dao.modifyDao_99(title, content, category, ch_private, cs_no);
		
		return "redirect:/cs_detail_99?cs_no="+cs_no;
	}
	
	@RequestMapping("/delete_99")
	public String delete(HttpServletRequest request) {
		String cs_no = request.getParameter("cs_no");
		cs_Dao.deleteDao_99(cs_no);
		
		return "redirect:/cs_list_99";
	}
	
}
