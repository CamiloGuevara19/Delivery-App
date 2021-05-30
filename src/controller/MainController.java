package controller;

import processing.core.PApplet;

public class MainController {

	//Attributes 
	private PApplet app;
	
	private int width;
	private int height;
	private int screen;	 //integer number that controls which screen is being shown to the user
	
	//Relations
	private LoginScreen lgnScreen;				//login screen controller
	//private CreateAccountScreen createAScreen;	//create account screen
	
	public MainController(int w, int h, PApplet app) {
		this.app = app;
		width = w;
		height = h;
		screen = 1;
		
		//objects initialization
		lgnScreen = new LoginScreen(app);
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
			break;
		case 2:
			
			break;
		case 3:
			break;
		}
	}
	
	public void ChangeScreen(int mouseX, int mouseY) {
		switch(screen) {
		case 1:
			if (screen == 0 && mouseX > (33 - (309 / 2))
				&& mouseX < (33 + (309 / 2))
				&& mouseY > (250 - (40 / 2))
				&& mouseY < (250 + (40 / 2))) {
				screen = 2;
	        }
			break;
	}
	}
}