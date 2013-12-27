package com.jerome.basic.beans;

import java.util.ArrayList;

public class Garden {

	ArrayList<Flower> flowerbed = new ArrayList<Flower>();

	private static Garden instance;

	public static Garden getInstance() {
		if (instance == null) {
			instance = new Garden();
		}
		return instance;
	}

	public void addFlower(Flower flower) {
		flowerbed.add(flower);
	}// some methods omitted
}