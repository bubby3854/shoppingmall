package com.project.jobs.controller;

import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.project.jobs.dao.ICompanyDao3854;
import com.project.jobs.dto.ComInfoDetail;
import com.project.jobs.dto.ComInfoJoinRecruit;
import com.project.jobs.dto.Com_detail;
import com.project.jobs.dto.Com_detail_file;
import com.project.jobs.dto.Company;
import com.project.jobs.dto.Recruit;
import com.project.jobs.dto.Region;
import com.project.jobs.service.CompanyService5963;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;



@Controller
@RequestMapping("/company/mypage")
public class Controller5963 {

	@Autowired
	CompanyService5963 companyService;
	
	//공고 등록 폼 이동
	@RequestMapping("/recruit_write_form")
	public String recruitWriteForm(Model model) {
	    System.out.println("공고 등록 폼에 접근");
	    List<Region> regionList = companyService.getRegion();
	    model.addAttribute("regionList", regionList);
	
	    return "company/mypage/recruit_write_form";
	}

	//공고 등록하기
	@RequestMapping("/registRecruit")
	public String registRecruit(Recruit recruit, Model model) {
		System.out.println("공고 등록하기에 접근");
		
		System.out.println("getCom_no: " + recruit.getCom_no());
		System.out.println("getDeadline_date : " + recruit.getDeadline_date());
		companyService.registRecruit(recruit);
		model.addAttribute("com_no", recruit.getCom_no());
		
		return "/company/mypage/getComRecruitAllList";
	}
	
	//com_no로 공고 리스트
	@RequestMapping("/getComInfoJoinRecruitAllListt")
	public String getComInfoJoinRecruitAllList(Long com_no, Model model) {
		System.out.println("공고 번호로 리스트 출력 접근");
		System.out.println("com_no: " + com_no);
	
		//List<Recruit> comRecruitAllList = companyService.getComRecruitAllList(com_no);
		//model.addAttribute("list", comRecruitAllList);
		List<ComInfoJoinRecruit> comInfoJoinRecruitAllList = companyService.comInfoJoinRecruitList(com_no);
		model.addAttribute("comInfoJoinRecruitAllList", comInfoJoinRecruitAllList);
		
		return "/company/mypage/recruit_list";
	}
	
	
	// 기업 마이페이지 기업소개 디테일 페이지 접속
	@RequestMapping("/info_detail")
	public String infoDetail(HttpServletRequest request, Model model) {
		System.out.println("공고 디테일페이지 접속");
		//HttpSession session = request.getSession();
		//Company company = (Company) session.getAttribute("loggedInCompany");
		//Long com_no = company.getCom_no();
		Long com_no = (long) 1;
		ComInfoDetail comInfoDetail = companyService.getComInfoDetail(com_no);
		model.addAttribute("comInfoDetail", comInfoDetail);
		return "/company/mypage/info_detail";
	}
	
	// 기업 마이페이지 기업소개 작성 페이지 접속
	@RequestMapping("/info_write_form")
	public String infoWriteForm(HttpServletRequest request,Model model) {
		System.out.println("공고 소개 작성페이지 접속");
		HttpSession session = request.getSession();
		model.addAttribute("company", session.getAttribute("loggedInCompany"));

		return "/company/mypage/info_write_form";
	}
	
	@Value("${spring.servlet.multipart.location}")
	private String uploadPath;
	
	// 기업 마이페이지 기업소개 작성
	@RequestMapping("/infoWrite")
	public String infoWrite(Com_detail_file com_detail_file) {
		System.out.println("공고 소개 작성 중");
		//System.out.println(com_detail.getEstablishment());
		System.out.println(com_detail_file);
		
		Com_detail com_detail = new Com_detail();
		com_detail.setCom_no(com_detail_file.getCom_detail_no());
		com_detail.setIntroduction(com_detail_file.getIntroduction());
		com_detail.setPension(com_detail_file.getPension());
		com_detail.setCompensation(com_detail_file.getCompensation());
		com_detail.setFacilities(com_detail_file.getFacilities());
		com_detail.setPolicy(com_detail_file.getPolicy());
		com_detail.setConvenience(com_detail_file.getConvenience());
		com_detail.setSectors(com_detail_file.getSectors());
		com_detail.setP_number(com_detail_file.getP_number());
		com_detail.setEstablishment(com_detail_file.getEstablishment());
		com_detail.setHistory(com_detail_file.getHistory());
		com_detail.setIdeal_talent(com_detail_file.getIdeal_talent());
		String originName = com_detail_file.getFileName();
		
		String newName = UUID.randomUUID().toString() + "_" + originName;
		com_detail.setImg_url(newName);
		System.out.println(originName);
		System.out.println(newName);
		
		System.out.println(com_detail_file);
		System.out.println(com_detail);
		//파일저장
		File file = new File(com_detail.getImg_url());
		
		try {
			com_detail_file.getImg_url().transferTo(file);
		} catch (IllegalStateException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		companyService.comInfoWrite(com_detail);
		
		return "redirect:/company/mypage/info_detail";
	}
	
	// 기업 마이페이지 기업소개 수정 페이지 접속
	@RequestMapping("/info_modify_form")
	public String infoModifyForm(HttpServletRequest request, Model model) {
		System.out.println("공고 소개 수정페이지 접속");
		HttpSession session = request.getSession();
		Company company = (Company) session.getAttribute("loggedInCompany");
		Long com_no = company.getCom_no();
		ComInfoDetail comInfoDetail = companyService.getComInfoDetail(com_no);
		model.addAttribute("comInfoDetail", comInfoDetail);
			
		return "/company/mypage/info_modify_form";
	}
	
	// 기업 마이페이지 기업소개 수정
	@RequestMapping("/infoModify")
	public String infoModify(Com_detail com_detail) {
		System.out.println("공고 소개 수정 중");
		companyService.comInfoModify(com_detail);
			
		return "redirect:/company/mypage/info_detail";
	}
	

	
	
}

