package com.ty.food.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

import com.ty.food.dto.FoodOrder;
import com.ty.food.dto.Item;

public class FoodOrderDao {

	EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("uday");
	EntityManager entityManager = entityManagerFactory.createEntityManager();
	EntityTransaction entityTransaction = entityManager.getTransaction();

	public FoodOrder saveOrder(FoodOrder foodOrder) {
		entityTransaction.begin();
		for (Item item : foodOrder.getItems()) {
			entityManager.persist(item);
		}
		entityManager.persist(foodOrder);
		entityTransaction.commit();
		return entityManager.find(FoodOrder.class, foodOrder.getId());
	}

	public FoodOrder getOrderById(int id) {
		return entityManager.find(FoodOrder.class, id);

	}

	public boolean deleteOrderById(int id) {
		FoodOrder foodOrder = entityManager.find(FoodOrder.class, id);
		if (foodOrder != null) {
			entityTransaction.begin();
			for (Item item : foodOrder.getItems()) {
				entityManager.remove(item);
			}
			entityManager.remove(foodOrder);
			entityTransaction.commit();
			return true;
		} else {
			return false;
		}
	}

	public FoodOrder updateOrderById(int id, List<Item> items) {
		FoodOrder foodOrder = entityManager.find(FoodOrder.class, id);
		foodOrder.setItems(items);
		entityTransaction.begin();
		for (Item item : foodOrder.getItems()) {
			item.setFoodOrder(foodOrder);
			entityManager.merge(item);
		}
		double total = foodOrder.getTotal();
		for (Item item : items) {
			total += item.getCost();
		}
		foodOrder.setTotal(total);
		entityManager.merge(foodOrder);
		entityTransaction.commit();
		return foodOrder;

	}
}
