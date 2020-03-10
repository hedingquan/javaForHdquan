package com.hdquan.service.impl;

import java.util.List;

import com.hdquan.mapper.AirportMapper;
import com.hdquan.pojo.Airport;
import com.hdquan.service.AirportService;

public class AirportServiceImpl implements AirportService{
	private AirportMapper airportMapper;
	
	
	
	public AirportMapper getAirportMapper() {
		return airportMapper;
	}
	public void setAirportMapper(AirportMapper airportMapper) {
		this.airportMapper = airportMapper;
	}
	public List<Airport> show() {
		// TODO Auto-generated method stub
		return airportMapper.selAll();
	}
	
}
