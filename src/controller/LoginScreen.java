package controller;

import controlP5.ControlP5;
import controlP5.Textfield;
import processing.core.PApplet;

public class LoginScreen {

	//Atributtes
	private int screenManager;
	
	private PApplet app;
	private ControlP5 cp5;
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
		this.app = app;
		cp5 = new ControlP5(app);
		
		
		//Textfields
		
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
		
		//buttons initialization
		//login button
		cp5.addButton("btnLogin").setCaptionLabel("Login")
		 .setColorForeground(colorbtnLHov) 
		 .setColorActive(colorbntLPress) 
	     .setValue(0)
	     .setPosition(33, 480)
	     .setSize(309,50).setColorBackground(colorbtnL)
	     .getCaptionLabel().setSize(24)
	     ;
		
		//create account button
		cp5.addButton("btnCA").setCaptionLabel("Create account")
		 .setColorForeground(colorbtnCAHov)
		 .setColorActive(colorbntCAPress) 
	     .setValue(0)
	     .setPosition(33, 560)
	     .setSize(309,40).setColorBackground(colorbtnCA)
	     .getCaptionLabel().setSize(18)
	     ;
		
	}

	public void drawScreen() {
				
		app.fill(0);
		app.textSize(28);
		app.text("Login", 500, 150);
		app.textSize(16);
		app.text("Enter email or username", 33, 230);
		app.text("Enter password", 33, 355);
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
	
	
}