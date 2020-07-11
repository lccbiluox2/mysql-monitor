package com.neo.service;

import java.util.List;
import java.util.Map;

import com.neo.domain.IpcountBean;
import com.neo.query.IpBrokenLineQuery;

public interface IpcountBeanService {

	void addIpCount(List<IpcountBean> list);

	List<IpBrokenLineQuery> getCountByIp(Map<String, String> map);

}
