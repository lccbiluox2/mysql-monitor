package com.mysql.mointor.dao;

import java.util.List;

import com.mysql.mointor.domain.NewsTable;
import com.mysql.mointor.domain.UserTable;

public interface NewsDao {

	void addnews(NewsTable news);


	List<NewsTable> getAllNewsByUser(UserTable user);

	List<NewsTable> getAllNews();



	void deleteNewsById(int id);


	NewsTable getNewsById(int id);


	void updateNewsById(NewsTable news);

}
