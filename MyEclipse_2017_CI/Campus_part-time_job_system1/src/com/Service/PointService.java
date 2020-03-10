package com.Service;

import java.util.List;

import com.pojo.Apply;
import com.pojo.Point;
import com.pojo.Work;

public interface PointService {
	
	public Point AddPoint(Point point);
	
	public boolean DeletePoint(Point point);
	
	public Point getPoint(String point_id);
	
	public List<Point> getAllPoint();
	
	public List<Point> getMyPoint(String user_id1);
}
