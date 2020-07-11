package com.neo.service;

import java.util.List;

import com.neo.domain.NewsTable;
import com.neo.domain.UserTable;

public interface NewsService {

	void addnews(NewsTable news);

	List<NewsTable> getAllNewsByUser(UserTable user);

	

	void deleteNewsById(int id);

	NewsTable getNewsById(int id);

	void updateNewsById(NewsTable news);

	List<NewsTable> getAllNews();

	

}
