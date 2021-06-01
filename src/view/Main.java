package view;

import controller.MainController;
import model.Restaurant;
import processing.core.PApplet;

public class Main extends PApplet{
	
	//Constants
	public final static int WIDTH = 375;
	public final static int HEIGHT = 812;
	//Attributes
	
	//Relations
	private MainController mainController;
	//
	
	public static void main (String[] args) {
		PApplet.main("view.Main");
	}
	
	public void settings() {
	size(375,812);
	}
	
	public void setup() {
		
		//declaration
		mainController = new MainController(WIDTH, HEIGHT, this);
	}

	public void draw() {
		background(255);
		mainController.drawScreens();
		//System.out.println(mouseX+","+mouseY);
	}
	
	public void mousePressed() {
		mainController.ChangeScreen(mouseX, mouseY);
	}
}