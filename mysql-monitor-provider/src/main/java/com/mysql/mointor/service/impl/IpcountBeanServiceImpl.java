package com.mysql.mointor.service.impl;

import java.util.List;
import java.util.Map;

import com.mysql.mointor.dao.IpcountBeanDao;
import com.mysql.mointor.domain.IpcountBean;
import com.mysql.mointor.query.IpBrokenLineQuery;
import com.mysql.mointor.service.IpcountBeanService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class IpcountBeanServiceImpl  implements IpcountBeanService {
	
	@Autowired
	private IpcountBeanDao ipcountBeanDao;

	@Override
	public void addIpCount(List<IpcountBean> list) {
		// TODO Auto-generated method stub
		for(int i=0;i<list.size();i++){
			IpcountBean ipcountBean = list.get(i);
			System.out.println("-----------ipcountBean--------"+ipcountBean.toString());
			ipcountBeanDao.addIpCount(ipcountBean);
		}
	}

	@Override
	public List<IpBrokenLineQuery> getCountByIp(Map<String, String> map) {
		// TODO Auto-generated method stub
		return ipcountBeanDao.getCountByIp(map);
	}
	
}
