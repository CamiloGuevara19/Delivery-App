package model;

import processing.core.PApplet;
import processing.core.PImage;

public class Dish extends Product{
	
	private Addition firstA;
	private Addition secondA;
	
	public Dish(String n, double p, PImage img, PApplet app, String an1, String an2, double ap1, double ap2, PImage i1, PImage i2) {
		super(n, p, img, app);
		firstA = new Addition(an1, ap1, i1, app);
		secondA = new Addition(an2, ap2, i2, app);
	}

	public Addition getFirstA() {
		return firstA;
	}

	public void setFirstA(Addition firstA) {
		this.firstA = firstA;
	}

	public Addition getSecondA() {
		return secondA;
	}

	public void setSecondA(Addition secondA) {
		this.secondA = secondA;
	}
	
	
}
