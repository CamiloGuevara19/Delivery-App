package controller;

import processing.core.PApplet;
import processing.core.PImage;

public class CashScreen {

	private double basePrice;
	private boolean friesB;
	private boolean sodaB;
	private int productType;
	private PApplet app;
	private PImage p1;
	private PImage p2;
	private PImage p3;
	private PImage p4;
	private PImage fries;
	private PImage soda;
	private PImage cashUI;
	
	public CashScreen(PApplet app) {
		
		this.app = app;
		p1 = app.loadImage("data/regular3.png");
		p2 = app.loadImage("data/double3.png");
		p3 = app.loadImage("data/deluxe3.png");
		p4 = app.loadImage("data/monster3.png");
		fries = app.loadImage("data/fries3.png");
		soda = app.loadImage("data/soda3.png");
		cashUI = app.loadImage("data/shopui.png");
	}
	
	public void drawScreen() {
		
		app.image(cashUI, 0, 37);
		
		switch(productType) {
		case 1:
			app.image(p1, 19, 177);
			break;
		case 2:
			app.image(p2, 19, 177);
			break;
		case 3:
			app.image(p3, 19, 177);
			break;
		case 4:
			app.image(p4, 19, 177);
			break;
		}
		
		if(friesB && !sodaB) {
			app.image(fries, 19, 279);
		}else if(!friesB && sodaB) {
			app.image(soda, 19, 279);
		}else if(friesB && sodaB){
			app.image(fries, 19, 279);
			app.image(soda, 19, 381);
		}
		
		app.fill(211,50,50);
		app.text(basePrice+"", 286, 520);
	}

	public double getBasePrice() {
		return basePrice;
	}

	public void setBasePrice(double basePrice) {
		this.basePrice = basePrice;
	}

	public boolean isFriesB() {
		return friesB;
	}

	public void setFriesB(boolean friesB) {
		this.friesB = friesB;
	}

	public boolean isSodaB() {
		return sodaB;
	}

	public void setSodaB(boolean sodaB) {
		this.sodaB = sodaB;
	}

	public int getProductType() {
		return productType;
	}

	public void setProductType(int productType) {
		this.productType = productType;
	}
}
