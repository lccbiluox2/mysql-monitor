package com.neo.service.impl;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.neo.dao.IpcountBeanDao;
import com.neo.domain.IpcountBean;
import com.neo.query.IpBrokenLineQuery;
import com.neo.service.IpcountBeanService;

@Service
public class IpcountBeanServiceImpl  implements IpcountBeanService{
	
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
