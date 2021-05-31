package model;

import java.util.ArrayList;

import processing.core.PApplet;
import processing.core.PImage;

public class Dish extends Product{

	public Dish(String n, double p, PImage img, PApplet app) {
		super(n, p, img, app);
		additions = new ArrayList<>();
	}


	private ArrayList<Addition> additions;
	

	public void addAdditions() {
		
	}
}
