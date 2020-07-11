package com.neo.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Date;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.json.simple.JSONObject;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.neo.bean.PageBean;
import com.neo.domain.MessageTable;
import com.neo.domain.UserTable;
import com.neo.service.MessageService;
import com.neo.utils.DateUtils;
import com.neo.utils.UploadImgToPointDir;

@Controller
@RequestMapping("/messageIndexController") 
public class MessageIndexController {


	@Resource
	private MessageService messageService;
	
	int currentPage =0;
	int pagesize =3;
	
	// 根据id修改留言信息  先根绝id查询信息 然后回显在页面上
	@RequestMapping("/preAddMessagePage") 
    public String  preUpdateRentById(Model model,int  currentPage,HttpServletRequest req,HttpServletResponse res) {
		//分页准备数据2017/3/10
		PageBean pageBean = messageService.getAllMessage(currentPage,pagesize);
		model.addAttribute("pageBean", pageBean);
		return "/index/message/addMessage";
    }
	
	
	
	
	
	//添加出租信息 添加出租信息内容的时候 会是图文混排序 这里是上传单张图片的
	@SuppressWarnings("unchecked")
	@RequestMapping("/addMessagePicture") 
    public void  addMessagePicture(Model model,HttpServletRequest req,HttpServletResponse res) {
		
		// 图片
		String uploadfileDir = "/upload/message";
		String newFileName = UploadImgToPointDir.getDate();
		String fileNameString = UploadImgToPointDir.uploadImgToPointDir2(
				req, uploadfileDir, newFileName);
		if (!fileNameString.equals(newFileName)) {
			String filePath =  uploadfileDir + "/"+ fileNameString.trim();
			PrintWriter out = null;
			try {
				out = res.getWriter();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			JSONObject obj = new JSONObject();
			obj.put("error", 0);
			obj.put("url", filePath);
			
			out.println(obj.toJSONString());
		}
	    return;
    }
		
		
	
	// 根据id修改rent信息  先根绝id查询信息 然后回显在页面上
	@RequestMapping("/addMessage") 
    public String  addMessage(Model model,MessageTable message,HttpServletRequest req,HttpServletResponse res) {
		
		System.out.println(message.toString());

		HttpSession session =  req.getSession();
		UserTable user = (UserTable) session.getAttribute("admin");
		
		if(user == null){
			return "redirect:/userController/userLogin";
		}
		
		message.setUser_id(user.getId());
		message.setUser_name(user.getUser_name());
		
		message.setCreate_time(DateUtils.getFormatDateTime(new Date(), DateUtils.fullChineseFormat));
		
		messageService.addMesage(message);
		
		return "redirect:/messageIndexController/preAddMessagePage?currentPage=1";
	  
    }
		
		
}
