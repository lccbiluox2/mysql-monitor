package com.neo.service;

import com.neo.bean.PageBean;
import com.neo.domain.MessageTable;

public interface MessageService {

	void addMesage(MessageTable message);



	PageBean getAllMessage(int currentPage, int pagesize);



	void updateMessageCheckById(int id);



	void deleteMessageById(int id);



	void updateMessageCheckByIdThree(int id);



	PageBean getAllMessageNoCheck(int currentPage, int pagesize);



	void delMessageByCheckEquals3();

	

	

}
