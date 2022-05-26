package com.ty.food.controller;

import java.util.ArrayList;
import java.util.List;

import com.ty.food.dto.FoodOrder;
import com.ty.food.dto.Item;
import com.ty.food.service.FoodOrderService;

public class TestUpdateOrderById {
	public static void main(String[] args) {
		Item item1 = new Item();
		item1.setName("Burger");
		item1.setQuantity(2);
		item1.setCost(200);		

		Item item2 = new Item();
		item2.setName("French Fries");
		item2.setQuantity(1);
		item2.setCost(100);

		List<Item> items = new ArrayList<Item>();
		items.add(item1);
		items.add(item2);

		FoodOrderService foodOrderService = new FoodOrderService();
		FoodOrder foodOrder=foodOrderService.updateOrderById(1, items);
		
		if(foodOrder!=null) {
			System.out.println("Order updated");
		}else {
			System.out.println("No order with given id");
		}
	}
}
