package com.neo.dao;

import java.util.List;
import java.util.Map;

import com.neo.domain.RentTable;
import com.neo.domain.UserTable;

public interface RentDao {

	void addRent(RentTable rent);

	List<RentTable> getAllRentByUser(UserTable user);

	List<RentTable> getAllRentByAdmin(UserTable user);

	void updateRentPhoto(Map<String, String> map);

	void deleteRentById(int id);

	RentTable getRentById(int id);

	void updateRentById(RentTable rent);

	List<RentTable> getAllRent();

	List<RentTable> searchRentByConditionc1(RentTable rent);

	List<RentTable> searchRentByConditionc2(RentTable rent);

	List<RentTable> searchRentByConditionc3(RentTable rent);

	List<RentTable> searchRentByConditionc4(RentTable rent);

	List<RentTable> searchRentByConditionc5(RentTable rent);

	List<RentTable> searchRentByConditionc6(RentTable rent);

	List<RentTable> searchRentByConditionc7(RentTable rent);

	List<RentTable> searchRentByConditionc8(RentTable rent);

	List<RentTable> getRentByHstate(int h_state);

	

}
