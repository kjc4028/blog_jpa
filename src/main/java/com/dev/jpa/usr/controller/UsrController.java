package com.dev.jpa.usr.controller;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.web.servlet.server.Session;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.web.authentication.logout.SecurityContextLogoutHandler;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.dev.jpa.usr.entity.RoleEntity;
import com.dev.jpa.usr.entity.RoleUsrEntity;
import com.dev.jpa.usr.entity.UsrEntity;
import com.dev.jpa.usr.service.RoleUsrService;
import com.dev.jpa.usr.service.UsrService;


@Controller
@RequestMapping("/usr")
public class UsrController {
	
	private Logger logger = LoggerFactory.getLogger(UsrController.class);

	@Autowired
	UsrService usrService;
	
	@Autowired
	RoleUsrService roleUsrService;
	
	@RequestMapping("")
	public String home(){
		logger.info("home page connect...한글테스트");
		return "redirect:/";
	}

	@RequestMapping("/show")
	public String show(Model model) throws NoSuchFieldException, SecurityException{
		List<UsrEntity> memberList =  usrService.findAll();
		System.out.println("show count-------------------" + memberList.size());
		for(UsrEntity mem : memberList){
			System.out.println("show-------------------");
		}
		model.addAttribute("mList",memberList);
		return "redirect:/";
	}

	@RequestMapping(value="/join", method=RequestMethod.GET)
	public String joinView(HttpServletRequest req, HttpServletResponse res, UsrEntity usrEntity, Model model){
		return "usr/usrC";
	}
	
	@RequestMapping(value="/join", method=RequestMethod.POST)
	public String insert(HttpServletRequest req, HttpServletResponse res, UsrEntity usrEntity, Model model){
		
		 
		usrService.save(usrEntity);
		System.out.println("insert-------------------");
		System.out.println(usrEntity.toString());
		
		RoleUsrEntity roleUsrEntity = new RoleUsrEntity();
		roleUsrEntity.setRoleCd("R01"); 
		roleUsrEntity.setUsrId(usrEntity.getUsrId());
		roleUsrService.save(roleUsrEntity);
		return "redirect:/";
	}	
	
	@RequestMapping(value="/login", method=RequestMethod.GET)
	public String loginView(HttpServletRequest req, HttpServletResponse res, UsrEntity usrEntity, Model model){
		System.out.println(">>>>>>>>>>>>>>>>");
		return "usr/login";
	}	
	
	@RequestMapping(value = "/logout", method = RequestMethod.GET)
	public String loout(HttpServletRequest request, HttpServletResponse response) throws Exception {
	Authentication auth = SecurityContextHolder.getContext().getAuthentication();
	if (auth != null){
	new SecurityContextLogoutHandler().logout(request, response, auth);
	}
	return "redirect:/";
	}

	@RequestMapping(value = "/loginSuccess", method = RequestMethod.GET)
	public String loginResult(HttpServletRequest request, HttpServletResponse response) throws Exception {
		Authentication auth = SecurityContextHolder.getContext().getAuthentication();
		if(auth.getName().equals("anonymousUser")){
			return "/main/mainWeb";
		}
		HttpSession session = request.getSession();
		User user = (User)auth.getPrincipal();
		session.setAttribute("user", user);	
	return "redirect:/";
	}
	
	@ResponseBody
	@RequestMapping(value = "/namedTest", method = RequestMethod.GET)
	public void namedTest(HttpServletRequest request, HttpServletResponse response) throws Exception {
		//메소드명으로 쿼리 생성 테스트
		//동일한 명의 속성이 포함되어 있는경우 정상적으로 조회하는지 확인
		List<UsrEntity> list =  usrService.findByRoleRoleCd("R01");
		
		System.out.println("named test ......");
		for(int i=0; i<list.size(); i++) {
			System.out.println(list.get(i).getUsrNm() + " " + list.get(i).getRole().getRoleCd());
		}
		
	}
	

}
