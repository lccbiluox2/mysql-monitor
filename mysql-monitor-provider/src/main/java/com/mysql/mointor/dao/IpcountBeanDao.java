package com.mysql.mointor.dao;

import java.util.List;
import java.util.Map;

import com.mysql.mointor.domain.IpcountBean;
import com.mysql.mointor.query.IpBrokenLineQuery;

public interface IpcountBeanDao {

	void addIpCount(IpcountBean ipcountBean);

	List<IpBrokenLineQuery> getCountByIp(Map<String, String> map);

}
