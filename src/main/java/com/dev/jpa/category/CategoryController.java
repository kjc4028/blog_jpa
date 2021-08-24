package com.dev.jpa.category;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.dev.jpa.common.CommonUtil;
import com.dev.jpa.usr.entity.UsrEntity;
import com.dev.jpa.usr.service.UsrService;

@Controller
@RequestMapping("/category")
public class CategoryController {

	@Autowired
	private CategoryService categoryService;
	
	@RequestMapping("/list")
	public String categoryListView(Model model, HttpServletRequest request, HttpServletResponse response, CategoryEntity categoryEntity) {
		/* model.addAttribute("pageList", categoryService.findAll()); */
		model.addAttribute("pageList", categoryService.findByUsrEntity(CommonUtil.getUserIdFromSession(request)));
		return "category/categoryList";
	}
	
	@RequestMapping(value="/insert", method=RequestMethod.GET)
	public String categoryInsertView(Model model, HttpServletRequest request, HttpServletResponse response, CategoryEntity categoryEntity) {
		return "category/categoryCU";
	}
	
	@RequestMapping(value="/insert", method=RequestMethod.POST)
	public String categoryInsert(Model model, HttpServletRequest request, HttpServletResponse response, CategoryEntity categoryEntity) {
		
		categoryEntity.setUsrEntity(CommonUtil.getUserIdFromSession(request));
		categoryService.save(categoryEntity);
		return "redirect:/category/list";
	}
}
