package com.neo.dao;

import com.neo.domain.IpcountBean;

public interface IpCountLogToSqlDao {


	IpcountBean getIpCountByIpAndUrl(IpcountBean ipcountBean1);

	void updateCountById(IpcountBean ipcountBean);

	void addIpCount(IpcountBean ipcountBean1);

}
