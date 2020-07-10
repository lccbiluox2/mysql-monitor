package com.mysql.mointor.dao;

import java.util.List;
import java.util.Map;

import com.mysql.mointor.domain.MessageTable;

public interface MessageDao {

	void addMesage(MessageTable message);

	Integer getAllMessageCount();




	List getAllMessageList(Map<String, Integer> map);

	void updateMessageCheckById(int id);

	void deleteMessageById(int id);

	int getAllMessageCountNoCheck();

	List getAllMessageListNoCheck(Map<String, Integer> map);

	void delMessageByCheckEquals3();

}
