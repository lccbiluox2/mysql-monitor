package com.mysql.mointor.service;

import java.util.List;
import java.util.Map;

import com.mysql.mointor.domain.IpcountBean;
import com.mysql.mointor.query.IpBrokenLineQuery;

public interface IpcountBeanService {

	void addIpCount(List<IpcountBean> list);

	List<IpBrokenLineQuery> getCountByIp(Map<String, String> map);

}
