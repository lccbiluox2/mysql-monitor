package com.mysql.mointor.dao;

import com.mysql.mointor.domain.IpcountBean;

public interface IpCountLogToSqlDao {


	IpcountBean getIpCountByIpAndUrl(IpcountBean ipcountBean1);

	void updateCountById(IpcountBean ipcountBean);

	void addIpCount(IpcountBean ipcountBean1);

}
