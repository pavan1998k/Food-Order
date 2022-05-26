package com.ty.food.service;

import java.util.List;

import com.ty.food.dao.FoodOrderDao;
import com.ty.food.dto.FoodOrder;
import com.ty.food.dto.Item;

public class FoodOrderService {
	
	FoodOrderDao foodOrderDao=new FoodOrderDao();
	public FoodOrder saveOrder(FoodOrder foodOrder) {
		return foodOrderDao.saveOrder(foodOrder);
	}
	
	public FoodOrder getOrderById(int id) {
		return foodOrderDao.getOrderById(id);
	}
	
	public boolean deleteOrderById(int id) {
		return foodOrderDao.deleteOrderById(id);
	}
	
	public FoodOrder updateOrderById(int id,List<Item> items) {
		return foodOrderDao.updateOrderById(id, items);
	}
}
