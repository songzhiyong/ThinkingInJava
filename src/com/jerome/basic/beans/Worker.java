package com.jerome.basic.beans;

public class Worker extends Person {

	private static final long serialVersionUID = 879972172790835593L;
	private String factoryName;

	public String getFactoryName() {
		return factoryName;
	}

	public void setFactoryName(String factoryName) {
		this.factoryName = factoryName;
	}

	public Worker(String name, int age, String idNum, String factoryName) {
		super(name, age, idNum);
		Garden garden = Garden.getInstance();
		garden.addFlower(new Flower());
		this.factoryName = factoryName;
	}

	@Override
	public String toString() {
		return super.toString() + "Worker [factoryName=" + factoryName + "]";
	}

}
