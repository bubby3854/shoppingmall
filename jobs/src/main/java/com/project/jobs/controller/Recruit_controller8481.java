package com.project.jobs.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.project.jobs.dao.ICommonRecruitDao8481;
import com.project.jobs.dto.ComRecruitList;
import com.project.jobs.dto.Recruit;

import jakarta.servlet.http.HttpServletRequest;

@Controller

public class Recruit_controller8481 {
	
	@Autowired
	ICommonRecruitDao8481 dao;
	
	@RequestMapping("/")
	public String index() {
		return "redirect:/recruitList";
	}
	
	
	
	//공고 리스트 
	//@RequestMapping("/recruitList")
	@RequestMapping("/recruitList")
	public String recruitList(HttpServletRequest request, Model model) {
		System.out.println("공고리스트 볼거에요");
		
		List<ComRecruitList> allRecruitList = dao.getRecruitList();
		model.addAttribute("crmlist", allRecruitList);
		
		return "/common/recruit_List";
		
	}
	
	//공고 리스트 검색기능
	@RequestMapping("/recruitsearchlist")
	public String searchRecruitList(@RequestParam("search") String search, ComRecruitList crldto, HttpServletRequest request, Model model) {
		System.out.println("공고리스트 검색을 할거에요");
		System.out.println(search);
		List<ComRecruitList> searchList = dao.getSearchList(search);
		model.addAttribute("crmlist", searchList);
		
		
		return "/common/recruit_List";
	}
	
	//셀렉트 검색(등록일)
	@RequestMapping("recruitselectregdate")
	public String selectRegDate(HttpServletRequest request, Model model) {
		System.out.println("등록일순으로 볼거에요");
		
		List<ComRecruitList> selectLeg = dao.getSelectRegDate();
		model.addAttribute("crmlist", selectLeg);
		
		return "/common/recruit_List";
	}
	
	
	//셀렉트 검색(마감일)
		@RequestMapping("recruitselectdeaddate")
		public String selectRegDate(Model model) {
			System.out.println("마감일순으로 볼거에요");
			
			List<ComRecruitList> selectDead = dao.getSelectDeadLine();
			model.addAttribute("crmlist", selectDead);
			
			return "/common/recruit_List";
		}
	
	
}
