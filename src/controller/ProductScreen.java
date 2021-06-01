package controller;

import processing.core.PApplet;
import processing.core.PImage;

public class ProductScreen {

	private int productType;
	
	private PApplet app;
	private PImage p1;
	private PImage p2;
	private PImage p3;
	private PImage p4;
	
	public ProductScreen(PApplet app) {
		this.app = app;
		
		p1 = app.loadImage("data/regular2.png");
		p2 = app.loadImage("data/double2.png");
		p3 = app.loadImage("data/deluxe2.png");
		p4 = app.loadImage("data/monster2.png");
	}

	public int getProductType() {
		return productType;
	}

	public void setProductType(int productType) {
		this.productType = productType;
	}

	public void drawScreen() {
		
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
	
	
}
