package com.neo.dao;

import java.util.List;
import java.util.Map;

import com.neo.domain.IpcountBean;
import com.neo.query.IpBrokenLineQuery;

public interface IpcountBeanDao {

	void addIpCount(IpcountBean ipcountBean);

	List<IpBrokenLineQuery> getCountByIp(Map<String, String> map);

}
