package com.neo.controller;

import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.neo.domain.RentTable;
import com.neo.domain.UserTable;
import com.neo.service.RentService;

/*
 * 处理出租前台信息
 * 
 */
@Controller
@RequestMapping("/rentIndexController") 
public class RentIndexController {
   
	private Logger logger = Logger.getLogger(RentIndexController.class);
    
	
	@Resource
	private RentService rentService;
	
	/*
	 * 查看所有人的发布的出租信息
	 * 
	 */
	@RequestMapping("/getAllRent") 
    public String  getAllRent(Model model,HttpServletRequest req,HttpServletResponse res) {
		List<RentTable> list = rentService.getAllRent();
		model.addAttribute("rentList",list);
	    return "/index/rent/rentList";
    }
    
	
	@RequestMapping("/showRentDetailById") 
    public String  showRentDetailById(Model model,int id,HttpServletRequest req,HttpServletResponse res) {
		RentTable rent = rentService.getRentById(id);
		model.addAttribute("rent",rent);
	    return "/index/rent/rentDetail";
	  
    }
	
	@RequestMapping("/searchRentByCondition") 
    public String  searchRentByCondition(Model model,RentTable rent,HttpServletRequest req,HttpServletResponse res) {
		
		System.out.println("==============="+rent.toString());
		
		List<RentTable> list = rentService.searchRentByCondition(rent);
		
		model.addAttribute("rentList",list);
	    return "/index/rent/rentList";
    }
	
	
	@RequestMapping("/getRentByHstate") 
    public String  getRentByHstate(Model model,int h_state,HttpServletRequest req,HttpServletResponse res) {
		List<RentTable> list = rentService.getRentByHstate(h_state);
		model.addAttribute("rentList",list);
	    return "/index/rent/rentList";
    }
    
	
	
}