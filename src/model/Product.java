package model;

import processing.core.PApplet;
import processing.core.PImage;

public class Product {

	//Attributes
	private PApplet app;
	private double price;
	private String name;
	private int amount;
	private PImage image;
	
	
	public Product(String n, double p, PImage img, PApplet app) {
		name = n;
		price = p;
		this.app = app;
		image = img;
	}
	
	public void drawProduct(int x, int y) {
		app.image(image, x, y);
	}
	
	public double getTotal() {
		return amount*price;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getAmount() {
		return amount;
	}

	public void setAmount(int amount) {
		this.amount = amount;
	}	
}
