package com.neo.dao;

import java.util.List;

import com.neo.domain.NewsTable;
import com.neo.domain.UserTable;

public interface NewsDao {

	void addnews(NewsTable news);


	List<NewsTable> getAllNewsByUser(UserTable user);

	List<NewsTable> getAllNews();



	void deleteNewsById(int id);


	NewsTable getNewsById(int id);


	void updateNewsById(NewsTable news);

}
