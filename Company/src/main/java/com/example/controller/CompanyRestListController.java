package com.example.controller;

import java.util.List;

import javax.swing.plaf.TextUI;

import org.apache.http.util.TextUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.data.rest.webmvc.RepositoryRestController;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.domain.Company;
import com.example.domain.CompanyRepository;
import com.example.domain.PeoPle;

@RestController
@RequestMapping("/company")
public class CompanyRestListController {

	@Autowired
	CompanyRepository companyRepository;

//    @RequestMapping("/list")
    @RequestMapping(path = "/listRest", method = RequestMethod.GET)
    public List<Company> greeting(@RequestParam(value="companyName", required=false) String name, Model model) {
    	List<Company> companyList = null;
    	
    	if( name == null || name.equals("")){
    		companyList = companyRepository.findAll();
    	}else{
    		companyList = companyRepository.findByCompanyName(name);
    	}
    	
    	return companyList;
    }
}
