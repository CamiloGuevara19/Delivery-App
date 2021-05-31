package controller;

import processing.core.PApplet;

public class MainController {

	//Attributes 
	private PApplet app;
	
	private int width;
	private int height;
	private int screen;	 //integer number that controls which screen is being shown to the user
	
	//Relations
	private LoginScreen lgnScreen; //login screen controller
	private SignUpScreen sgnScreen;
	
	public MainController(int w, int h, PApplet app) {
		this.app = app;
		width = w;
		height = h;
		screen = 1;
		
		//objects initialization
		lgnScreen = new LoginScreen(app);
		sgnScreen = new SignUpScreen(app);
		//createAScreen = new CreateAccountScreen();
	}
	
	public void drawScreens() {
		switch(screen) {
		case 1:
			lgnScreen.drawScreen();
//			if(lgnScreen.getScreenManager()==1) {
//				screen = 2;	//create account screen
//			}else if(lgnScreen.getScreenManager()==2) {
//				screen = 3;	//login success, menu screen
//			}
			sgnScreen.deleteTextField();
			break;
		case 2:
			sgnScreen.drawTextField();
			sgnScreen.drawScreen();
			break;
		case 3:
			break;
		}
	}
	
	public void ChangeScreen(int mouseX, int mouseY) {
		switch(screen) {
		case 1:
			if (screen == 1 && mouseX > (115 - (145 / 2))
				&& mouseX < (115 + (145 / 2))
				&& mouseY > (601 - (34 / 2))
				&& mouseY < (601 + (34 / 2))) {
				lgnScreen.deleteTextField();
				screen = 2;
	        }
			break;
	}
	}
}