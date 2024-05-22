package com.project.jobs.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.project.jobs.dto.Member;
import com.project.jobs.service.MemberService5963;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;


@Controller
@RequestMapping("/member")
public class MemberController5963 {

	@Autowired
	MemberService5963 memverService;
	
	// 개인회원 스크랩한 공고 리스트 
	@RequestMapping("/recruitScrapList")
	public String recruitScrapList() {
		
		return "/member/recruit_scrap_list";
	}
	
	// 개인회원 공고 스크랩하기
	@RequestMapping("/addRecruitScrap")
	public String addRecruitScrap(HttpServletRequest request, @RequestParam("recruit_no")Long recruit_no) {
		System.out.println("스크랩 공고 하기");
		
		HttpSession session = request.getSession();
		Member member = (Member) session.getAttribute("loggedInMember");
		Long mem_no = member.getMem_no();
		
		memverService.addRecruitScrap(mem_no, recruit_no);
		
		return "";
	}
	
}
