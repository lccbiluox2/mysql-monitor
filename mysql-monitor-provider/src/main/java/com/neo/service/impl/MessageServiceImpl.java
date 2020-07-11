package com.neo.service.impl;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.neo.bean.PageBean;
import com.neo.dao.MessageDao;
import com.neo.domain.MessageTable;
import com.neo.service.MessageService;

@Service
public class MessageServiceImpl implements MessageService{

		@Autowired
		private MessageDao messageDao;

		@Override
		public void addMesage(MessageTable message) {
			// TODO Auto-generated method stub
			messageDao.addMesage(message);
		}



		@Override
		public PageBean getAllMessage(int currentPage, int pagesize) {
			int recordCount = messageDao.getAllMessageCount();
			int pageCount = recordCount % pagesize == 0 ? recordCount / pagesize : recordCount / pagesize +1;
			if(currentPage > pageCount ){
				currentPage = pageCount;
			}
			if(currentPage < 1){
				currentPage = 1;
			}
			
			int lastItem = (currentPage-1)*pagesize;
			Map<String,Integer> map=new HashMap<String,Integer>();
			map.put("pagesize",pagesize);
			map.put("lastItem",lastItem);
			
			return new PageBean(currentPage, pagesize, recordCount, messageDao.getAllMessageList(map));
		}



		@Override
		public void updateMessageCheckById(int id) {
			messageDao.updateMessageCheckById(id);
		}



		@Override
		public void deleteMessageById(int id) {
			// TODO Auto-generated method stub
			messageDao.deleteMessageById(id);
		}



		@Override
		public void updateMessageCheckByIdThree(int id) {
			// TODO Auto-generated method stub
			messageDao.updateMessageCheckById(id);
		}



		@Override
		public PageBean getAllMessageNoCheck(int currentPage, int pagesize) {
			int recordCount = messageDao.getAllMessageCountNoCheck();
			int pageCount = recordCount % pagesize == 0 ? recordCount / pagesize : recordCount / pagesize +1;
			if(currentPage > pageCount ){
				currentPage = pageCount;
			}
			if(currentPage < 1){
				currentPage = 1;
			}
			
			int lastItem = (currentPage-1)*pagesize;
			Map<String,Integer> map=new HashMap<String,Integer>();
			map.put("pagesize",pagesize);
			map.put("lastItem",lastItem);
			
			return new PageBean(currentPage, pagesize, recordCount, messageDao.getAllMessageListNoCheck(map));
		}



		@Override
		public void delMessageByCheckEquals3() {
			// TODO Auto-generated method stub
			messageDao.delMessageByCheckEquals3();
		}

		
		
		

	
}
