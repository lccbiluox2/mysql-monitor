package com.neo.controller;

import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Date;
import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.log4j.Logger;
import org.json.simple.JSONObject;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.neo.domain.RentTable;
import com.neo.domain.UserTable;
import com.neo.service.RentService;
import com.neo.utils.DateUtils;
import com.neo.utils.ImageUtil;
import com.neo.utils.UploadImgToPointDir;

@Controller
@RequestMapping("/rentController") 
public class RentController {

	private Logger logger = Logger.getLogger(RentController.class);
	
	
	@Resource
	private RentService rentService;
	
	
	//添加出租信息
	@RequestMapping("/addRent") 
    public String  addRent(Model model,RentTable rent,HttpServletRequest req,HttpServletResponse res) {
		
		HttpSession session =  req.getSession();
		UserTable user = (UserTable) session.getAttribute("admin");
		
		
		if(user == null){
			return "redirect:/userController/toAdminLogin";
		}
		
		
		rent.setH_address(rent.getH_province()+rent.getH_city()+rent.getH_qu()+rent.getH_address_detail());
		rent.setH_create_time(DateUtils.getFormatDateTime(new Date(), DateUtils.yyyyMMddFormat));
		
		rent.setUser_id(user.getId());
		rent.setUser_name(user.getUser_name());
		rent.setUser_phone(user.getUser_phone());
		
		rentService.addRent(rent);
	    return null;
	  
    }
	
	//添加出租信息 添加出租信息内容的时候 会是图文混排序 这里是上传单张图片的
	@SuppressWarnings("unchecked")
	@RequestMapping("/addRentPicture") 
    public void  addRentPicture(Model model,HttpServletRequest req,HttpServletResponse res) {
		
		// 图片
		String uploadfileDir = "/upload/rent";
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
	
	
	
	/*
	 * 根据不同的人 查询各自发布的信息  管理员可以查看所有人的信息
	 * 
	 */
	@RequestMapping("/getAllRentByUser") 
    public String  getAllRentByUser(Model model,HttpServletRequest req,HttpServletResponse res) {
		
		HttpSession session =  req.getSession();
		UserTable user = (UserTable) session.getAttribute("admin");
		
		
		if(user == null){
			return "redirect:/userController/toAdminLogin";
		}
		
		
		List<RentTable> list = rentService.getAllRentByUser(user);
		model.addAttribute("rentList",list );
	
	    return "/background/rent/rentListByUser";
	  
    }
	
	
	// 转到上传图片页面
	@RequestMapping("/goToRentImgPage") 
    public String  goToRentImgPage(Model model,int id,HttpServletRequest req,HttpServletResponse res) {
		model.addAttribute("id",id );
	    return "/background/rent/rentImg";
	  
    }
	// 转到上传图片页面  开始上传
	@RequestMapping("/uploadRentImg") 
    public String  uploadRentImg(Model model,HttpServletRequest req,HttpServletResponse res) {
		
		//上传大图图片
		String uploadfileDir = "/upload/rent";
		String newFileName = UploadImgToPointDir.getDate();
		// 上传后的文件名
		String fileName = UploadImgToPointDir.uploadImgToPointDir2(req,uploadfileDir, newFileName);
		String id = req.getParameter("id");// 该图片所对应的小说id
		// 拼接字符串 /mystory/upload/brand/demoUploadHydrangeas.jpg
		String filePath =  uploadfileDir + "/" + fileName.trim();
		
	
		//这里是生成缩略图
		// 这里需要绝对路径  比如说在c盘 某个位置
		String fileUploadPath = req.getSession().getServletContext().getRealPath(filePath);
		File file = new File(fileUploadPath);
		String prevfix = "small_";//缩略图的前缀
		//一个生成缩略图的类
		new ImageUtil().thumbnailImage(file, 150, 150, prevfix, true);
		String small_filePath =  uploadfileDir + "/" + prevfix+fileName.trim();
	
		// 将的图片修改 图片的大图 和图片的缩略图
		rentService.updateRentPhoto(new Integer(id), filePath,small_filePath);
		
		return "redirect:/rentController/getAllRentByUser";
	  
    }
	
	
	
	// 根据id删除rent信息
	@RequestMapping("/deleteRentById") 
    public String  deleteRentById(Model model,int id,HttpServletRequest req,HttpServletResponse res) {
		rentService.deleteRentById(id);
		return "redirect:/rentController/getAllRentByUser";
	  
    }

	// 根据id修改rent信息  先根绝id查询信息 然后回显在页面上
	@RequestMapping("/preUpdateRentById") 
    public String  preUpdateRentById(Model model,int id,HttpServletRequest req,HttpServletResponse res) {
		RentTable rent = rentService.getRentById(id);
		
		System.out.println(rent.toString());
		
		model.addAttribute("rent",rent );
		return "/background/rent/updateRent";
	  
    }
	// 根据id修改rent信息  
	@RequestMapping("/updateRentById") 
    public String  updateRentById(Model model,RentTable rent,HttpServletRequest req,HttpServletResponse res) {
		
		HttpSession session =  req.getSession();
		UserTable user = (UserTable) session.getAttribute("admin");
		
		
		if(user == null){
			return "redirect:/userController/toAdminLogin";
		}
		
		
		rent.setH_address(rent.getH_province()+rent.getH_city()+rent.getH_qu()+rent.getH_address_detail());
		rent.setH_create_time(DateUtils.getFormatDateTime(new Date(), DateUtils.yyyyMMddFormat));
		
		rent.setUser_id(user.getId());
		rent.setUser_name(user.getUser_name());
		rent.setUser_phone(user.getUser_phone());
		
		rentService.updateRentById(rent);
		
		return "redirect:/rentController/getAllRentByUser";
	  
    }
	
}
