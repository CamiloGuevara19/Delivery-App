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
		
		//p1 = app.loadImage(filename);
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
			
			break;
		case 2:
			break;
		case 3:
			break;
		case 4:
			break;
		}
	}
	
	
}
