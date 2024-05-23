package com.project.jobs.service;

import java.sql.Date;
import java.util.List;

import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.project.jobs.dao.IMember_resume8481;
import com.project.jobs.dto.Career;
import com.project.jobs.dto.Education;
import com.project.jobs.dto.Free_resume;
import com.project.jobs.dto.License;
import com.project.jobs.dto.Site_resume;

@Service
public class Site_resumeService8481 {

	@Autowired
	private IMember_resume8481 siteResumeMapper;
	
	@Autowired
	IMember_resume8481 dao;
	/*
	//라이센스에 Site_resume을 넣어준것
	public void insertFkforLicense(Site_resume site_resume, License liecnsefk) {
		
		// site_resume 테이블에 레코드 삽입
		siteResumeMapper.site_resume_write(site_resume);
        
        // 삽입된 site_resume 테이블의 PK 값을 license 테이블의 FK로 사용
        Long lastId = site_resume.getS_resume_no();
        siteResumeMapper.insertLicense(lastId, liecnsefk.getLicense_name(), liecnsefk.getAgency());
    }
	//커리어에 Site_resume을 넣어준것
	public void insertFkforCareer(Site_resume site_resume, Career careerfk) {
		
		// site_resume 테이블에 레코드 삽입
		siteResumeMapper.site_resume_write(site_resume);
				
		// 삽입된 site_resume 테이블의 PK 값을 license 테이블의 FK로 사용
        Long lastId = site_resume.getS_resume_no();
        siteResumeMapper.insertCareer(lastId, careerfk.getCompany(), careerfk.getCar_join_date(), careerfk.getQuit_date(), careerfk.getMain_part());
        
	}
	//에듀케이션에 Site_resume을 넣어준것
	public void insertFkforEducation(Site_resume site_resume, Education educationfk) {
		
		// site_resume 테이블에 레코드 삽입
		siteResumeMapper.site_resume_write(site_resume);
						
		// 삽입된 site_resume 테이블의 PK 값을 license 테이블의 FK로 사용
		Long lastId = site_resume.getS_resume_no();
		siteResumeMapper.insertEducation(lastId, educationfk.getSchool(), educationfk.getEdu_join_date(), educationfk.getGraduation_date(), educationfk.getGraduation(), educationfk.getGrades(), educationfk.getMajor());
		
	}
     */   
	//위에것들 합치는 작업 (최종적으로 얘를쓴다)
	public void insertfk(Site_resume site_resume)
	{
		// site_resume 테이블에 레코드 삽입
		siteResumeMapper.site_resume_write(site_resume);
	}
	public void insertfk(Site_resume site_resume, License liecnsefk)
	{
		// site_resume 테이블에 레코드 삽입
		siteResumeMapper.site_resume_write(site_resume);
						
		// 삽입된 site_resume 테이블의 PK 값을 license 테이블의 FK로 사용
		Long lastId = site_resume.getS_resume_no();
		siteResumeMapper.insertLicense(lastId, liecnsefk.getLicense_name(), liecnsefk.getAgency());
		
	}
	public void insertfk(Site_resume site_resume, Career careerfk)
	{
		// site_resume 테이블에 레코드 삽입
		siteResumeMapper.site_resume_write(site_resume);
		// 삽입된 site_resume 테이블의 PK 값을 license 테이블의 FK로 사용
		Long lastId = site_resume.getS_resume_no();
		siteResumeMapper.insertCareer(lastId, careerfk.getCompany(), careerfk.getCar_join_date(), careerfk.getQuit_date(), careerfk.getMain_part());
	}
	public void insertfk(Site_resume site_resume, Education educationfk)
	{
		// site_resume 테이블에 레코드 삽입
		siteResumeMapper.site_resume_write(site_resume);
						
		// 삽입된 site_resume 테이블의 PK 값을 license 테이블의 FK로 사용
		Long lastId = site_resume.getS_resume_no();
		siteResumeMapper.insertEducation(lastId, educationfk.getSchool(), educationfk.getEdu_join_date(), educationfk.getGraduation_date(), educationfk.getGraduation(), educationfk.getGrades(), educationfk.getMajor());
	}
	public void insertfk(Site_resume site_resume, License liecnsefk, Career careerfk)
	{
		// site_resume 테이블에 레코드 삽입
		siteResumeMapper.site_resume_write(site_resume);
						
		// 삽입된 site_resume 테이블의 PK 값을 license 테이블의 FK로 사용
		Long lastId = site_resume.getS_resume_no();
		siteResumeMapper.insertLicense(lastId, liecnsefk.getLicense_name(), liecnsefk.getAgency());
		siteResumeMapper.insertCareer(lastId, careerfk.getCompany(), careerfk.getCar_join_date(), careerfk.getQuit_date(), careerfk.getMain_part());
		
	}
	public void insertfk(Site_resume site_resume, License liecnsefk, Education educationfk)
	{
		// site_resume 테이블에 레코드 삽입
		siteResumeMapper.site_resume_write(site_resume);
						
		// 삽입된 site_resume 테이블의 PK 값을 license 테이블의 FK로 사용
		Long lastId = site_resume.getS_resume_no();
		siteResumeMapper.insertLicense(lastId, liecnsefk.getLicense_name(), liecnsefk.getAgency());
		siteResumeMapper.insertEducation(lastId, educationfk.getSchool(), educationfk.getEdu_join_date(), educationfk.getGraduation_date(), educationfk.getGraduation(), educationfk.getGrades(), educationfk.getMajor());
		
	}
	public void insertfk(Site_resume site_resume, Career careerfk, Education educationfk)
	{
		// site_resume 테이블에 레코드 삽입
		siteResumeMapper.site_resume_write(site_resume);
						
		// 삽입된 site_resume 테이블의 PK 값을 license 테이블의 FK로 사용
		Long lastId = site_resume.getS_resume_no();
		siteResumeMapper.insertCareer(lastId, careerfk.getCompany(), careerfk.getCar_join_date(), careerfk.getQuit_date(), careerfk.getMain_part());
		siteResumeMapper.insertEducation(lastId, educationfk.getSchool(), educationfk.getEdu_join_date(), educationfk.getGraduation_date(), educationfk.getGraduation(), educationfk.getGrades(), educationfk.getMajor());
		
	}
	public void insertfk(Site_resume site_resume, License liecnsefk, Career careerfk, Education educationfk)
	{
		// site_resume 테이블에 레코드 삽입
		siteResumeMapper.site_resume_write(site_resume);
						
		// 삽입된 site_resume 테이블의 PK 값을 license 테이블의 FK로 사용
		Long lastId = site_resume.getS_resume_no();
		siteResumeMapper.insertLicense(lastId, liecnsefk.getLicense_name(), liecnsefk.getAgency());
		siteResumeMapper.insertCareer(lastId, careerfk.getCompany(), careerfk.getCar_join_date(), careerfk.getQuit_date(), careerfk.getMain_part());
		siteResumeMapper.insertEducation(lastId, educationfk.getSchool(), educationfk.getEdu_join_date(), educationfk.getGraduation_date(), educationfk.getGraduation(), educationfk.getGrades(), educationfk.getMajor());
		
	}
	//자유 이력서 등록
	public void freeResumeWrite(Free_resume free_resume) {
		
		dao.insert_free_resume(free_resume);
	}
	
	//사이트 이력서 조회
	public List<Site_resume> getSiteResumeList(Long mem_no){
		List<Site_resume> list = dao.getSiteResumeList(mem_no);
		
		return list;
	}
	//자유 이력서 조회
	public List<Free_resume> getFreeResumeList(Long mem_no){
		List<Free_resume> list = dao.getFreeResumeList(mem_no);
		
		return list;
	}
	//사이트 이력서 삭제
	public void deleteSiteResume(Long s_resume_no) {
		
		dao.deleteSiteResume1(s_resume_no);
		dao.deleteSiteResume2(s_resume_no);
		dao.deleteSiteResume3(s_resume_no);
		dao.deleteSiteResume(s_resume_no);
	}
	//자유 이력서 삭제
	public void deleteFreeResume(Long r_resume_no) {
		dao.deleteFreeResume(r_resume_no);
	}
	
}
