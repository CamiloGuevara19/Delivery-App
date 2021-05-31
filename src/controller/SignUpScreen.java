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
		
		colorbtnL = app.color(100,200,120);
		colorbntLPress = app.color(40,140,80);
		colorbtnLHov = app.color(95,217,172);
	
		//Textfields
		
		 cp5.addTextfield("txtNameS")
	     .setPosition(33,190)
	     .setColorBackground(app.color(190,250,205))
	     .setSize(309,40)
	     .setFocus(true)
	     .setColor(app.color(14,88,62))
	     .setColorActive(app.color(182,250,78))
	     .setCaptionLabel("")
	     .getValueLabel().setSize(14)
	     ;
	
		//email or username textfield
		 cp5.addTextfield("txtEmailS")
	     .setPosition(33,275)
	     .setColorBackground(app.color(190,250,205))
	     .setSize(309,40)
	     .setFocus(true)
	     .setColor(app.color(14,88,62))
	     .setColorActive(app.color(182,250,78))
	     .setCaptionLabel("")
	     .getValueLabel().setSize(14)
	     ;
		 
		//password textfield
		 cp5.addTextfield("txtPasswordS")
	     .setPosition(33,365)
	     .setColorBackground(app.color(190,250,205))
	     .setSize(309,40)
	     .setFocus(true)
	     .setColor(app.color(14,88,62))
	     .setColorActive(app.color(182,250,78))
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
		app.text("Create Account", 33, 100);
		app.textSize(16);
		app.text("Enter Name", 33, 175);
		app.text("Enter email", 33, 260);
		app.text("Enter password", 33, 345);
		app.rect(190, 500, 150, 50);
	}

	public String[] getInfo() {
		String[] singUpInfo = new String[3];
		
		singUpInfo[0] = cp5.get(Textfield.class, "txtNameS").getText();
		singUpInfo[1] = cp5.get(Textfield.class, "txtEmailS").getText();
		singUpInfo[2] = cp5.get(Textfield.class, "txtPasswordS").getText();
		return singUpInfo;
	}

}
