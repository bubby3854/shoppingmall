package com.project.jobs.dto;

import org.modelmapper.ModelMapper;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@AllArgsConstructor
@NoArgsConstructor
@Data
public class Site_resume {

	private Long s_resume_no; 
	private String mem_no; 
	private String img_url; 
	private String hope_job; 
	private String addr;
	private String part; 
	private String military; 
	private String etc; 
	private String motive; 
	private String personality; 
	private String aspiration; 
	private String growth; 
	private String title;
	private String site_res_name;
	
	private static ModelMapper modelMapper = new ModelMapper();
	
	public static Site_resume of(Site_resume_file site_resume_file) {
		return modelMapper.map(site_resume_file, Site_resume.class);
	}
	
	
}
