package com.mysql.mointor.service;

import java.util.List;

import com.mysql.mointor.domain.NewsTable;
import com.mysql.mointor.domain.UserTable;

public interface NewsService {

	void addnews(NewsTable news);

	List<NewsTable> getAllNewsByUser(UserTable user);

	

	void deleteNewsById(int id);

	NewsTable getNewsById(int id);

	void updateNewsById(NewsTable news);

	List<NewsTable> getAllNews();

	

}
