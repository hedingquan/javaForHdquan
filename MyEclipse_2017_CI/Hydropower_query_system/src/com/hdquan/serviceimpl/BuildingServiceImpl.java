package com.hdquan.serviceimpl;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.hdquan.pojo.Building;
import com.hdquan.pojo.Room;
import com.hdquan.pojo.Unit;
import com.hdquan.service.BuildingService;
import com.hdquan.dao.BuildingDao;

@Service
@Transactional
public  class BuildingServiceImpl implements BuildingService{

	@Autowired
	BuildingDao BuildingDao;
	
	@Override
	public List<Building> allBuilding() {
		// TODO Auto-generated method stub
		return BuildingDao.allBuilding();
	}

	@Override
	public List<Building> limitBuilding(String buildingName) {
		// TODO Auto-generated method stub
		return BuildingDao.limitBuilding(buildingName);
	}

	@Override
	public Building getBuilding(int id) {
		// TODO Auto-generated method stub
		return BuildingDao.getBuilding(id);
	}

	@Override
	public Building updateBuilding(Building building) {
		// TODO Auto-generated method stub
		return BuildingDao.updateBuilding(building);
	}

	@Override
	public Building addBuilding(Building building) {
		// TODO Auto-generated method stub
		return BuildingDao.addBuilding(building);
	}

	@Override
	public Building deleteBuilding(Building building) {
		// TODO Auto-generated method stub
		return BuildingDao.deleteBuilding(building);
	}

	@Override
	public List<Building> BuildingName(){
		// TODO Auto-generated method stub
		return BuildingDao.BuildingName();
	}

	@Override
	public List<Unit> unitName() {
		// TODO Auto-generated method stub
		return BuildingDao.unitName();
	}

	@Override
	public List<Building> OtherBuildingName(){
		// TODO Auto-generated method stub
		return BuildingDao.OtherBuildingName();
	}

	@Override
	public List<Room> Rooms(String buildingName) {
		// TODO Auto-generated method stub
		return BuildingDao.Rooms(buildingName);
	}

	@Override
	public Building getBuilding(String buildingName) {
		// TODO Auto-generated method stub
		return BuildingDao.getBuilding(buildingName);
	}

	@Override
	public Room getRoom(String roomNum) {
		// TODO Auto-generated method stub
		return BuildingDao.getRoom(roomNum);
	}

	@Override
	public Unit getUnit(String uName) {
		// TODO Auto-generated method stub
		return BuildingDao.getUnit(uName);
	}
}
