package com.neo.service;

import java.util.List;

import com.neo.domain.RentTable;
import com.neo.domain.UserTable;

public interface RentService {

	void addRent(RentTable rent);

	List<RentTable> getAllRentByUser(UserTable user);

	void updateRentPhoto(Integer integer, String filePath, String small_filePath);

	void deleteRentById(int id);

	RentTable getRentById(int id);

	void updateRentById(RentTable rent);

	List<RentTable> getAllRent();

	List<RentTable> searchRentByCondition(RentTable rent);

	List<RentTable> getRentByHstate(int h_state);

}
