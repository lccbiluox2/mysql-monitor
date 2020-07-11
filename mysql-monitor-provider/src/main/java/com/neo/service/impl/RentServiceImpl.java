package com.neo.service.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.neo.dao.RentDao;
import com.neo.domain.RentTable;
import com.neo.domain.UserTable;
import com.neo.service.RentService;

@Service
public class RentServiceImpl implements RentService{

		@Autowired
		private RentDao rentDao;

		@Override
		public void addRent(RentTable rent) {
			// TODO Auto-generated method stub
			rentDao.addRent(rent);
		}

		@Override
		public List<RentTable> getAllRentByUser(UserTable user) {
			
			System.out.println(user.toString());
			//判断是不是管理员  0是管理员
			if(user.getGroup_code().equals("0")){
				return rentDao.getAllRentByAdmin(user);
				
			//普通人
			}else{
				return rentDao.getAllRentByUser(user);
			}
			
			
		}

		@Override
		public void updateRentPhoto(Integer integer, String filePath,String small_filePath) {
			Map<String,String> map=new HashMap<String,String>();
			map.put("id",integer+"");
			map.put("h_pic",filePath);
			map.put("h_small_pic",small_filePath);
			rentDao.updateRentPhoto(map);
		}

		@Override
		public void deleteRentById(int id) {
			// TODO Auto-generated method stub
			rentDao.deleteRentById(id);
		}

		@Override
		public RentTable getRentById(int id) {
			// TODO Auto-generated method stub
			return rentDao.getRentById(id);
		}

		@Override
		public void updateRentById(RentTable rent) {
			// TODO Auto-generated method stub
			 rentDao.updateRentById(rent);
		}

		@Override
		public List<RentTable> getAllRent() {
			// TODO Auto-generated method stub
			return rentDao.getAllRent();
		}

		@Override
		public List<RentTable> searchRentByCondition(RentTable rent) {
			// TODO Auto-generated method stub
	
			if( !rent.getH_province().equals(" 请选择") && rent.getMaxPrice() == 0  && rent.getH_type() == 0 ){
				System.out.println("======c1=========");
				return rentDao.searchRentByConditionc1(rent);
			}
			if( !rent.getH_province().equals(" 请选择") && rent.getMaxPrice() == 0  && rent.getH_type() != 0 ){
				System.out.println("======c2=========");
				return rentDao.searchRentByConditionc2(rent);
			}
			if( !rent.getH_province().equals(" 请选择") && rent.getMaxPrice() != 0  && rent.getH_type() == 0 ){
				System.out.println("======c3=========");
				return rentDao.searchRentByConditionc3(rent);
			}
			if( !rent.getH_province().equals(" 请选择") && rent.getMaxPrice() != 0  && rent.getH_type() != 0 ){
				System.out.println("======c4=========");
				return rentDao.searchRentByConditionc4(rent);
			}
			
			
			
			if( rent.getH_province().equals(" 请选择") && rent.getMaxPrice() == 0  && rent.getH_type() == 0 ){
				System.out.println("======c5=========");
				return rentDao.searchRentByConditionc5(rent);
			}
			if( rent.getH_province().equals(" 请选择") && rent.getMaxPrice() == 0  && rent.getH_type() != 0 ){
				System.out.println("======c6=========");
				return rentDao.searchRentByConditionc6(rent);
			}
			if( rent.getH_province().equals(" 请选择") && rent.getMaxPrice() != 0  && rent.getH_type() == 0 ){
				System.out.println("======c7=========");
				return rentDao.searchRentByConditionc7(rent);
			}
			if( rent.getH_province().equals(" 请选择") && rent.getMaxPrice() != 0  && rent.getH_type() != 0 ){
				System.out.println("======c8=========");
				return rentDao.searchRentByConditionc8(rent);
			}
			return rentDao.getAllRent();
			
		}

		@Override
		public List<RentTable> getRentByHstate(int h_state) {
			return rentDao.getRentByHstate(h_state);
		}
			
			
		
}
