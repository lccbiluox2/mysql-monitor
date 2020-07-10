package com.mysql.mointor.controller;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.mysql.mointor.bean.PageBean;
import com.mysql.mointor.service.MessageService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/messageController") 
public class MessageController {


	@Resource
	private MessageService messageService;
	
	int currentPage =0;
	int pagesize =3;
	
	// 根据id修改留言信息  先根绝id查询信息 然后回显在页面上
	@RequestMapping("/showAllMessage") 
    public String  showAllMessage(Model model,int  currentPage,HttpServletRequest req,HttpServletResponse res) {
		//分页准备数据2017/3/10
		PageBean pageBean = messageService.getAllMessageNoCheck(currentPage,pagesize);
		model.addAttribute("pageBean", pageBean);
		return "/background/message/messageList";
    }
	
	
	@RequestMapping("/updateMessageCheckById") 
    public String  updateMessageCheckById(Model model,int  id,HttpServletRequest req,HttpServletResponse res) {
		
		messageService.updateMessageCheckById(id);
	
		return "redirect:/messageController/showAllMessage?currentPage=0";
    }
	
	
	@RequestMapping("/deleteMessageById") 
    public String  deleteMessageById(Model model,int  id,HttpServletRequest req,HttpServletResponse res) {
		
		messageService.deleteMessageById(id);
	
		return "redirect:/messageController/showAllMessage?currentPage=0";
    }
	
	@RequestMapping("/updateMessageCheckByIdThree") 
    public String  updateMessageCheckByIdThree(Model model,int  id,HttpServletRequest req,HttpServletResponse res) {
		
		messageService.updateMessageCheckByIdThree(id);
	
		return "redirect:/messageController/showAllMessage?currentPage=0";
    }
		
}
