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
	private int colorbtnL;
	private int colorbtnCA;
	private int colorbtnLHov;
	private int colorbtnCAHov;
	private int colorbntLPress;
	private int colorbntCAPress;
	
	public LoginScreen(PApplet app) {
		screenManager = 0;
		
		colorbtnL = app.color(100,200,120);
		colorbtnLHov = app.color(95,217,172);
		colorbtnCA = app.color(60,150,100);
		colorbtnCAHov = app.color(85,194,154);
		colorbntLPress = app.color(40,140,80);
		colorbntCAPress = app.color(35,124,74);
		
		//objects initialization
		login = app.loadImage("stlogin.png");
		this.app = app;
		cp5 = new ControlP5(app);
		
		
		//Textfields
		
		//username textfield
		 cp5.addTextfield("txtUser")
	     .setPosition(33,422)
	     .setColorBackground(app.color(190,250,205))
	     .setSize(310,50)
	     .setFocus(true)
	     .setColor(app.color(14,88,62))
	     .setColorActive(app.color(182,250,78))
	     .setCaptionLabel("")
	     .getValueLabel().setSize(14)
	     ;
		 
		//password textfield
		 cp5.addTextfield("txtPassword")
	     .setPosition(33,497)
	     .setColorBackground(app.color(190,250,205))
	     .setSize(310,50)
	     .setFocus(true)
	     .setColor(app.color(14,88,62))
	     .setColorActive(app.color(182,250,78))
	     .setCaptionLabel("")
	     .getValueLabel().setSize(14)
	     ;
		
		//buttons initialization
//		  login button
//		cp5.addButton("btnLogin").setCaptionLabel("Login")
//		 .setColorForeground(colorbtnLHov) 
//		 .setColorActive(colorbntLPress) 
//	     .setValue(0)
//	     .setPosition(33, 480)
//	     .setSize(309,50).setColorBackground(colorbtnL)
//	     .getCaptionLabel().setSize(24)
//	     ;
//		
//		  create account button
//		cp5.addButton("btnCA").setCaptionLabel("Create account")
//		 .setColorForeground(colorbtnCAHov)
//		 .setColorActive(colorbntCAPress) 
//	     .setValue(0)
//	     .setPosition(33, 560)
//	     .setSize(309,40).setColorBackground(colorbtnCA)
//	     .getCaptionLabel().setSize(18)
//	     ;
		
	}
	
	public void deleteTextField() {
		cp5.get(Textfield.class, "txtUser").hide();
		cp5.get(Textfield.class, "txtPassword").hide();
	}
	
	public void showTextField() {
		cp5.get(Textfield.class, "txtUser").show();
		cp5.get(Textfield.class, "txtPassword").show();
	}

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
	
	public void btnLogin() {
		//System.out.println(cp5.get(Textfield.class,"name").getText());
		System.out.println("xd");
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