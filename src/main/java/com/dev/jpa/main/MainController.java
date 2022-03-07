package com.dev.jpa.main;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.dev.jpa.bbs.BbsEntity;
import com.dev.jpa.bbs.BbsService;

@Controller
@RequestMapping("")
public class MainController {
	
	@Autowired
	private BbsService bbsService;
	
	@RequestMapping(value={"", "/"})
	public String mainView(HttpServletRequest req, HttpServletResponse res, Model model){
		
		Page<BbsEntity> pageData = bbsService.findOpenPageMain(1);
		model.addAttribute("pageList", pageData);
		
		return "/main/mainWeb";
	}
}
