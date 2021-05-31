package controller;

import controlP5.ControlP5;
import controlP5.Textfield;
import processing.core.PApplet;

public class SignUpScreen {
	
	private PApplet app;
	private ControlP5 cp5;
	
	private int colorbtnL;
	private int colorbntLPress;
	private int colorbtnLHov;
	
	public SignUpScreen(PApplet app) {
		this.app = app;
		cp5 = new ControlP5(app);
		//this.cp5 = cp5;
		
		colorbtnL = app.color(100,200,120);
		colorbntLPress = app.color(40,140,80);
		colorbtnLHov = app.color(95,217,172);
	
		//Textfields
		
		//email or username textfield
		 cp5.addTextfield("txtName")
	     .setPosition(33,125)
	     .setColorBackground(app.color(190,250,205))
	     .setSize(309,40)
	     .setFocus(true)
	     .setColor(app.color(14,88,62))
	     .setColorActive(app.color(182,250,78))
	     .setCaptionLabel("")
	     .getValueLabel().setSize(14)
	     ;
	
		//email or username textfield
		 cp5.addTextfield("txtEmail")
	     .setPosition(33,250)
	     .setColorBackground(app.color(190,250,205))
	     .setSize(309,40)
	     .setFocus(true)
	     .setColor(app.color(14,88,62))
	     .setColorActive(app.color(182,250,78))
	     .setCaptionLabel("")
	     .getValueLabel().setSize(14)
	     ;
		 
		//password textfield
		 cp5.addTextfield("txtPassword")
	     .setPosition(33,375)
	     .setColorBackground(app.color(190,250,205))
	     .setSize(309,40)
	     .setFocus(true)
	     .setColor(app.color(14,88,62))
	     .setColorActive(app.color(182,250,78))
	     .setCaptionLabel("")
	     .getValueLabel().setSize(14)
	     ;
		 
	}
	
	public void drawTextField() {
		cp5.get(Textfield.class, "txtName").bringToFront();
	}
	
	public void deleteTextField() {
		cp5.get(Textfield.class, "txtName").hide();
		cp5.get(Textfield.class, "txtEmail").hide();
		cp5.get(Textfield.class, "txtPassword").hide();
	}
	
	public void drawScreen() {
		
		app.fill(0);
		app.textSize(28);
		app.text("Create Account", 33, 150);
		app.textSize(16);
		app.text("Enter Name", 33, 105);
		app.text("Enter email or username", 33, 230);
		app.text("Enter password", 33, 355);
	}

}
