package controller;

import processing.core.PApplet;
import processing.core.PImage;

public class ProductScreen {

	private int productType;
	private boolean p1s;
	private boolean p2s;
	
	private PApplet app;
	private PImage p1;
	private PImage p2;
	private PImage p3;
	private PImage p4;
	private PImage fries;
	private PImage soda;
	private PImage fries2;
	private PImage soda2;
	
	public ProductScreen(PApplet app) {
		this.app = app;
		
		p1 = app.loadImage("data/regular2.png");
		p2 = app.loadImage("data/double2.png");
		p3 = app.loadImage("data/deluxe2.png");
		p4 = app.loadImage("data/monster2.png");
		fries = app.loadImage("data/fries.png");
		soda = app.loadImage("data/soda.png");
		fries2 = app.loadImage("data/fries2.png");
		soda2 = app.loadImage("data/soda2.png");
	}

	public int getProductType() {
		return productType;
	}

	public void setProductType(int productType) {
		this.productType = productType;
	}

	public void drawScreen() {
		
		if(!p1s) {
			app.image(fries, 19, 500);
		}else {
			app.image(fries2, 19, 500);
		}
		if(!p2s) {
			app.image(soda, 19, 600);
		}else {
			app.image(soda2, 19, 600);
		}	
		
		switch(productType) {
		case 1:
			app.image(p1, 0, 0);
			break;
		case 2:
			app.image(p2, 0, 0);
			break;
		case 3:
			app.image(p3, 0, 0);
			break;
		case 4:
			app.image(p4, 0, 0);
			break;
		}
	}

	//Getters and setters
	public boolean isP1s() {
		return p1s;
	}

	public void setP1s(boolean p1s) {
		this.p1s = p1s;
	}

	public boolean isP2s() {
		return p2s;
	}

	public void setP2s(boolean p2s) {
		this.p2s = p2s;
	}
	
	
}
