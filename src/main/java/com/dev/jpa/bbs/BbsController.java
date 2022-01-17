package com.dev.jpa.bbs;

import java.util.Date;

import javax.annotation.PostConstruct;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.security.core.userdetails.User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.dev.jpa.category.CategoryEntity;
import com.dev.jpa.category.CategoryService;
import com.dev.jpa.common.CommonUtil;
import com.dev.jpa.usr.entity.UsrEntity;

@Controller
@RequestMapping("/bbs")
public class BbsController {

	@Autowired
	private BbsService bbsService;
	
	@Autowired
	private CategoryService categoryService;
	
	@RequestMapping(value = "/list", method = RequestMethod.GET)
	public String selectList(Model model, HttpServletRequest request, HttpServletResponse response, BbsEntity bbsEntity) {
		//model.addAttribute("pageList", bbsService.findAll());
		
		int pageNum = 1;
		if(request.getParameter("pageNum") !=null && !"".equals(request.getParameter("pageNum"))) {
			pageNum = Integer.parseInt(request.getParameter("pageNum"));
		}
		
		if(pageNum < 0) {
			pageNum = 1;
		}
		
		Page<BbsEntity> pageData = bbsService.findByUsrEntityPage(request.getRemoteUser(), pageNum);
				
		model.addAttribute("pageList", pageData);
		
		return "bbs/bbsList";
	}

	@RequestMapping(value = "/totallist", method = RequestMethod.GET)
	public String selectTotalList(Model model, HttpServletRequest request, HttpServletResponse response, BbsEntity bbsEntity) {
		//model.addAttribute("pageList", bbsService.findAll());
		int pageNum = 1;
		if(request.getParameter("pageNum") !=null && !"".equals(request.getParameter("pageNum"))) {
			pageNum = Integer.parseInt(request.getParameter("pageNum"));
		}
		
		if(pageNum < 0) {
			pageNum = 1;
		}
		Page<BbsEntity> pageData = bbsService.findOpenPage(pageNum);
		
		model.addAttribute("pageList", pageData);
		
		return "bbs/bbsList";
	}

	@RequestMapping(value = "/{bbsSeq}", method = RequestMethod.GET)
	public String selectBbs(@PathVariable int bbsSeq ,Model model, HttpServletRequest request, HttpServletResponse response) {
		
		model.addAttribute("bbsEntity", bbsService.findByBbsSeq(bbsSeq));
		
		return "bbs/bbsR";
	}

	@RequestMapping(value = "/update/{bbsSeq}", method = RequestMethod.GET)
	public String bbsUpdateView(@PathVariable int bbsSeq, Model model, HttpServletRequest request, HttpServletResponse response, BbsEntity bbsEntity) {
		//사용중인 카테고리 리스트 호출
		model.addAttribute("categoryList", categoryService.findByUsrEntityAndUseYn(request.getRemoteUser()));
		model.addAttribute("bbsEntity", bbsService.findByBbsSeq(bbsSeq));
		
		return "bbs/bbsCU";
	}
	
	@RequestMapping(value = "/update/{bbsSeq}", method = RequestMethod.POST)
	public String bbsUpdate(Model model, HttpServletRequest request, HttpServletResponse response, BbsEntity bbsEntity) {
		
		BbsEntity exist_bbsEntity = bbsService.findByBbsSeq(bbsEntity.getBbsSeq());
		
		String replageCts = bbsEntity.getContents().replace("\n", "<br>");
		bbsEntity.setContents(replageCts);
		bbsEntity.setUsrEntity(CommonUtil.getUserIdFromSession(request));
		bbsEntity.setRegDate(exist_bbsEntity.getRegDate()); // 업데이트 시 null 값으로 저장되는 현상 조치
		
		bbsService.save(bbsEntity);
		return "redirect:/bbs/list";
	}
	
	@RequestMapping(value = "/insert", method = RequestMethod.GET)
	public String bbsInsertView(Model model, HttpServletRequest request, HttpServletResponse response, BbsEntity bbsEntity) {
		//사용중인 카테고리 리스트 호출
		//model.addAttribute("categoryList", categoryService.findByUseYn("Y"));
		CategoryEntity categoryEntity = new CategoryEntity();
		categoryEntity.setUsrEntity(CommonUtil.getUserIdFromSession(request));
		model.addAttribute("categoryList", categoryService.findByUsrEntityAndUseYn(request.getRemoteUser()));
		
		return "bbs/bbsCU";
	}

	@RequestMapping(value = "/insert", method = RequestMethod.POST)
	public String bbsInsert(Model model, HttpServletRequest request, HttpServletResponse response, BbsEntity bbsEntity) {
		
		String replageCts = bbsEntity.getContents().replace("\n", "<br>");
		bbsEntity.setContents(replageCts);
		bbsEntity.setUsrEntity(CommonUtil.getUserIdFromSession(request));
		bbsService.save(bbsEntity);
		return "redirect:/bbs/list";
	}
	
	@RequestMapping(value = "/totalSearch", method = RequestMethod.GET)
	public String selectTotalSearchList(Model model, HttpServletRequest request, HttpServletResponse response, BbsEntity bbsEntity) {
		String srchTxt = "";
		if(request.getParameter("srchTxt") != null) {
			bbsEntity.setTitle(request.getParameter("srchTxt"));
			bbsEntity.setContents(request.getParameter("srchTxt"));
			srchTxt = request.getParameter("srchTxt");
		}
		
		bbsEntity.setUseYn("Y");
		int pageNum = 1;
		if(request.getParameter("pageNum") !=null && !"".equals(request.getParameter("pageNum"))) {
			pageNum = Integer.parseInt(request.getParameter("pageNum"));
		}
		
		if(pageNum < 0) {
			pageNum = 1;
		}
		//Page<BbsEntity> pageData = bbsService.findByUseYnAndLikeTitleAndContents(bbsEntity, pageNum);
		Page<BbsEntity> pageData = bbsService.findByUseYnAndLikeTitleAndContentsForDsl(srchTxt, pageNum);
		
		model.addAttribute("pageList", pageData);
		model.addAttribute("srchTxt", srchTxt);
		
		return "bbs/bbsList";
	}
	
}
