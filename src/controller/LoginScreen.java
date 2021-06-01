package controller;

import controlP5.ControlP5;
import controlP5.Textfield;
import processing.core.PApplet;
import processing.core.PImage;

public class LoginScreen {

	//Atributtes
	private int screenManager;
	
	private PApplet app;
	private ControlP5 cp5;
	private PImage login;
	
	public LoginScreen(PApplet app) {
		screenManager = 0;
			
		//objects initialization
		login = app.loadImage("stlogin.png");
		this.app = app;
		cp5 = new ControlP5(app);
		
		
		//Textfields
		
		//username textfield
		 cp5.addTextfield("txtUser")
	     .setPosition(33,422)
	     .setColorBackground(app.color(236,237,239))
	     .setSize(310,50)
	     .setFocus(true)
	     .setColor(app.color(0,32,70))
	     .setColorActive(app.color(211,50,50))
	     .setCaptionLabel("")
	     .getValueLabel().setSize(14)
	     ;
		 
		//password textfield
		 cp5.addTextfield("txtPassword")
	     .setPosition(33,497)
	     .setColorBackground(app.color(236,237,239))
	     .setSize(310,50)
	     .setFocus(true)
	     .setColor(app.color(0,32,70))
	     .setColorActive(app.color(211,50,50))
	     .setCaptionLabel("")
	     .getValueLabel().setSize(14)
	     ;
	}
	
	public void deleteTextField() {
		cp5.get(Textfield.class, "txtUser").hide();
		cp5.get(Textfield.class, "txtPassword").hide();
	}
	
	public void showTextField() {
		cp5.get(Textfield.class, "txtUser").show();
		cp5.get(Textfield.class, "txtPassword").show();
	}

	@SuppressWarnings("static-access")
	public void drawScreen() {
		
		app.image(login,29,117,317,208);
				
		app.fill(211,50,50);
		app.textSize(16);
		app.text("Welcome back, we missed you!", 185, 64);
		app.text("Create Account",185,681);
		app.textSize(22);
		app.text("Login", 185, 351);
		
		//login button
		app.fill(211,50,50);
		app.noStroke();
		app.rectMode(app.CENTER);
		app.rect(180,601,109,34);
		app.ellipseMode(app.CENTER);
		app.ellipse(130,601,34,34);
		app.ellipse(239,601,34,34);
		app.textSize(16);
		app.fill(255);
		app.text("Login", 185, 606);
		
	}


	public int getScreenManager() {
		return screenManager;
	}

	public void setScreenManager(int screenManager) {
		this.screenManager = screenManager;
	}

	public String[] getLoginInfo() {
		String[] logininfo = new String[2];
		logininfo[0] = cp5.get(Textfield.class, "txtUser").getText();
		logininfo[1] = cp5.get(Textfield.class, "txtPassword").getText();
		return logininfo;
	}
	
	
}