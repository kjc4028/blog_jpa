package com.dev.jpa.city;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.PersistenceContext;
import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;


@Controller
@RequestMapping("/city")
public class CityController {

	@Autowired
	CityService cityService;
	
	@RequestMapping(value="/list")
	public String selectAllList(Model model){
		
		
		try {
			System.out.println("DB__connection");
			model.addAttribute("list", cityService.findAll());
		} catch (Exception e) {
			System.out.println("DB_not_connection");
			model.addAttribute("list", null);
		}
		return "city/cityList";
	}

	@RequestMapping(value="/read/{cityId}")
	public String selectOne(Model model, CityEntity city, HttpServletRequest req){
		model.addAttribute("city", cityService.findByCityId(city.getCityId()));
		return "city/cityR";
	}
	
	@RequestMapping(value="/insert", method=RequestMethod.GET)
	public String insertView(Model model, CityEntity cityEntity){
		return "city/cityC";
	}

	@RequestMapping(value="/insert", method=RequestMethod.POST)
	public String insert(Model model, CityEntity cityEntity){
		cityService.saveCity(cityEntity);
		return "redirect:/city/list";
	}
	@RequestMapping(value="/insertem", method=RequestMethod.POST)
	public String insertEm(Model model, CityEntity cityEntity){
		cityService.saveEm(cityEntity);
		return "redirect:/city/list";
	}

	@RequestMapping(value="/update/{cityId}", method=RequestMethod.GET)
	public String updateView(Model model, CityEntity cityEntity){
		return "city/cityU";
	}
	
	@RequestMapping(value="/update/{cityId}", method=RequestMethod.POST)
	public String update(Model model, CityEntity cityEntity){
		cityService.saveCity(cityEntity);
		return "redirect:/city/read/"+cityEntity.getCityId();
	}
 
	@RequestMapping(value="/delete/{cityId}", method=RequestMethod.GET)
	public String delete(Model model, CityEntity cityEntity){
		cityService.deleteById(cityEntity.getCityId());
		return "redirect:/city/list/";
	}
	
	
	
}
