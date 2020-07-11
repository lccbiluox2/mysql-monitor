package com.neo.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.neo.dao.NewsDao;
import com.neo.domain.NewsTable;
import com.neo.domain.UserTable;
import com.neo.service.NewsService;

@Service
public class NewsServiceImpl implements NewsService{

		@Autowired
		private NewsDao newsDao;

		@Override
		public void addnews(NewsTable news) {
			// TODO Auto-generated method stub
			newsDao.addnews(news);
		}

		@Override
		public List<NewsTable> getAllNewsByUser(UserTable user) {
			//判断是不是管理员  0是管理员
			if(user.getGroup_code().equals("0")){
				return newsDao.getAllNews();
				
			//普通人
			}else{
				return newsDao.getAllNewsByUser(user);
			}
		}

		@Override
		public void deleteNewsById(int id) {
			// TODO Auto-generated method stub
			newsDao.deleteNewsById(id);
		}

		@Override
		public NewsTable getNewsById(int id) {
			// TODO Auto-generated method stub
			return newsDao.getNewsById(id);
		}

		@Override
		public void updateNewsById(NewsTable news) {
			// TODO Auto-generated method stub
			newsDao.updateNewsById(news);
		}

		@Override
		public List<NewsTable> getAllNews() {
			// TODO Auto-generated method stub
			return newsDao.getAllNews();
		}

		

	
}
