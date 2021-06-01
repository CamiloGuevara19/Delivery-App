package controller;

import controlP5.ControlP5;
import controlP5.Textfield;
import processing.core.PApplet;
import processing.core.PImage;

public class SignUpScreen {
	
	private PApplet app;
	private ControlP5 cp5;
	private PImage btn;
	
	public SignUpScreen(PApplet app) {
		this.app = app;
		cp5 = new ControlP5(app);
		
		btn = app.loadImage("data/singup.png");
	
		//Textfields
		
		 cp5.addTextfield("txtNameS")
	     .setPosition(33,190)
	     .setColorBackground(app.color(236,237,239))
	     .setSize(309,40)
	     .setFocus(true)
	     .setColor(app.color(0,32,70))
	     .setColorActive(app.color(211,50,50))
	     .setCaptionLabel("")
	     .getValueLabel().setSize(14)
	     ;
	
		//email or username textfield
		 cp5.addTextfield("txtEmailS")
	     .setPosition(33,275)
	     .setColorBackground(app.color(236,237,239))
	     .setSize(309,40)
	     .setFocus(true)
	     .setColor(app.color(0,32,70))
	     .setColorActive(app.color(211,50,50))
	     .setCaptionLabel("")
	     .getValueLabel().setSize(14)
	     ;
		 
		//password textfield
		 cp5.addTextfield("txtPasswordS")
	     .setPosition(33,365)
	     .setColorBackground(app.color(236,237,239))
	     .setSize(309,40)
	     .setFocus(true)
	     .setColor(app.color(0,32,70))
	     .setColorActive(app.color(211,50,50))
	     .setCaptionLabel("")
	     .getValueLabel().setSize(14)
	     ;
		 
	}
	
	public void deleteTextField() {
		cp5.get(Textfield.class, "txtNameS").hide();
		cp5.get(Textfield.class, "txtEmailS").hide();
		cp5.get(Textfield.class, "txtPasswordS").hide();
	}
	
	public void showElements() {
		cp5.get(Textfield.class, "txtNameS").show();
		cp5.get(Textfield.class, "txtEmailS").show();
		cp5.get(Textfield.class, "txtPasswordS").show();
	}
	
	public void drawScreen() {
		
		app.fill(0);
		app.textSize(28);
		app.text("Create Account", 135, 100);
		app.textSize(16);
		app.text("Enter Name", 75, 175);
		app.text("Enter email", 75, 260);
		app.text("Enter password", 90, 345);
		app.image(btn, 120, 480);
		app.fill(211,50,50);
		app.text("Back", 185, 600);
		app.fill(255);
	}

	public String[] getInfo() {
		String[] singUpInfo = new String[3];
		
		singUpInfo[0] = cp5.get(Textfield.class, "txtNameS").getText();
		singUpInfo[1] = cp5.get(Textfield.class, "txtEmailS").getText();
		singUpInfo[2] = cp5.get(Textfield.class, "txtPasswordS").getText();
		return singUpInfo;
	}

}
