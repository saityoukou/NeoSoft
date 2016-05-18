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
import org.springframework.web.bind.annotation.RequestParam;

import com.example.domain.Company;
import com.example.domain.CompanyRepository;

@Controller
public class CompanyListController {

	@Autowired
	CompanyRepository companyRepository;

    @RequestMapping("/companyInfoList")
    public String greeting(@RequestParam(value="companyName", required=false) String name, Model model) {
    	List<Company> companyList = null;
    	
    	if( name == null || name.equals("")){
    		companyList = companyRepository.findAll();
    	}else{
    		companyList = companyRepository.findByCompanyName(name);
    	}
        //company = new Company("NeoSoft 日本", "333-222", "川口", "090-9888-8392", "080-3445-5543", "NeoSoft");
    	model.addAttribute("companyList", companyList);	
        return "companyInfoList";
    }
   
}
