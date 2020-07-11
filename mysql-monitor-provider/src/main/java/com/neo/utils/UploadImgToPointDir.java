package com.neo.utils;

import java.io.File;


import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Iterator;

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.io.output.ByteArrayOutputStream;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;
import org.springframework.web.multipart.commons.CommonsMultipartResolver;



public class UploadImgToPointDir {
	
	
	//得到图片上传时间名称
		public static String getDateNow(){
			
			        Calendar now = Calendar.getInstance();  
			        
			        System.out.println("now="+now);
			        
			        int year = now.get(Calendar.YEAR);
			        int  month = (now.get(Calendar.MONTH) + 1);
			        int  day = now.get(Calendar.DAY_OF_MONTH);
			        int  shi = now.get(Calendar.HOUR_OF_DAY);
			        int  fen = now.get(Calendar.MINUTE);
			       
			        String myMonth = "";
			        String  myday = "";
			        String  myshi = "";
			        String  myfen = "";
			        if( month < 9){
			        	myMonth = "0"+month;
			        }else{
			        	myMonth = ""+month;
			        }
			        
			        if( day < 9){
			        	myday = "0"+day;
			        }else{
			        	myday = ""+day;
			        }
			        
			        if( shi < 9){
			        	myshi = "0"+shi;
			        }else{
			        	myshi = ""+shi;
			        }
			        if( fen < 9){
			        	myfen = "0"+fen;
			        }else{
			        	myfen = ""+fen;
			        }
			        
			        System.out.println(year+myMonth+myday+myshi+myfen);
			        
			        return year+"/"+myMonth+"/"+myday+"/"+myshi+"/"+myfen;

			    }  
		
	
	
	
	
	//得到图片上传时间名称
	public static String getDate(){
		
		        Calendar now = Calendar.getInstance();  
		        int year = now.get(Calendar.YEAR);
		        int  month = (now.get(Calendar.MONTH) + 1);
		        int  day = now.get(Calendar.DAY_OF_MONTH);
		        int  shi = now.get(Calendar.HOUR_OF_DAY);
		        int  fen = now.get(Calendar.MINUTE);
		        long  haomiao = now.getTimeInMillis();
		        
		        String myMonth = "";
		        String  myday = "";
		        String  myshi = "";
		        String  myfen = "";
		        if( month < 9){
		        	myMonth = "0"+month;
		        }else{
		        	myMonth = ""+month;
		        }
		        
		        if( day < 9){
		        	myday = "0"+day;
		        }else{
		        	myday = ""+day;
		        }
		        
		        if( shi < 9){
		        	myshi = "0"+shi;
		        }else{
		        	myshi = ""+shi;
		        }
		        if( fen < 9){
		        	myfen = "0"+fen;
		        }else{
		        	myfen = ""+fen;
		        }
		        
		        System.out.println(year+myMonth+myday+myshi+myfen+haomiao);
		        
		        return year+myMonth+myday+myshi+myfen+haomiao;

		    }  
	
	

	public static String uploadImgToPointDir2(HttpServletRequest request, String uploadfileDir,String newFileName){
		
		String newfileName = newFileName;//上传后的文件名
		/*得到上下文  解析器*/
		CommonsMultipartResolver multipartResolver  = new CommonsMultipartResolver(request.getSession().getServletContext());
		/*因为request中传入的一大堆数据，有字符串，有文件，这里要挑选出来，处理文件*/
		if(multipartResolver.isMultipart(request)){
			/*转化*/
			MultipartHttpServletRequest  multiRequest = (MultipartHttpServletRequest)request;
			//得到项目的目录
			String path = request.getSession().getServletContext().getRealPath(uploadfileDir);
			Iterator<String>  iter = multiRequest.getFileNames();//遍历文件名称，可以知道有多少文件
			while(iter.hasNext()){
				MultipartFile file = multiRequest.getFile((String)iter.next());//这里得到的文件是MultipartFile类型
				if(file != null){
					if(file.getOriginalFilename() != ""){
						try {
							InputStream  stream  = file.getInputStream();
					        newfileName = newfileName + file.getOriginalFilename().substring(file.getOriginalFilename().lastIndexOf('.'));
					        
					        //拼接一个完整的文件路径名
					        String newFilePath = path+ "/"   + newfileName;
					      
					        //判断文件所在的文件夹是否存在，不存在就自动建立
					        File mkdieFile = new File(newFilePath);  
					        
					        if(!mkdieFile.getParentFile().exists()) {  
					        	 //如果目标文件所在的目录不存在，则创建父目录  
					        	 System.out.println("目标文件所在目录不存在，准备创建它！");  
					        	 if(! mkdieFile.getParentFile().mkdirs()) {  
					        	      System.out.println("创建目标文件所在目录失败！");  
					        	      return "";//如果文件夹创建失败 就返回空
					        	 }  
					        } 
					        //开始上传文件
					      
			        	   ByteArrayOutputStream baos = new ByteArrayOutputStream();
					       OutputStream bos = new FileOutputStream(newFilePath);
					        // 建立一个上传文件的输出流
			                int bytesRead = 0;
			                byte[] buffer = new byte[8192];
			                while ((bytesRead = stream.read(buffer, 0, 8192)) != -1) {
			                	bos.write(buffer, 0, bytesRead);// 将文件写入服务器
			                }
			                bos.close();//关闭输出流
					        
					        stream.close();//关闭输入流
						} catch (IOException e) {
							// TODO Auto-generated catch block
							 return "";//如果文件上传异常  就返回空
						}
					}
				}
			}
		}
		return newfileName;//否者才返回文件名
	}
	
	
	
	
}
