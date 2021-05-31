package controller;

import model.Restaurant;
import processing.core.PApplet;

public class MainController {

	//Attributes 
	private PApplet app;
	
	//Relations
	private Restaurant restaurant;
	
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
		restaurant = new Restaurant();
		lgnScreen = new LoginScreen(app);
		sgnScreen = new SignUpScreen(app);
		//createAScreen = new CreateAccountScreen();
	}
	
	public void drawScreens() {
		switch(screen) {
		case 1:
			lgnScreen.drawScreen();
			sgnScreen.deleteTextField();
			break;
		case 2:
			
			break;
		case 3:
			sgnScreen.drawScreen();
			sgnScreen.drawScreen();
			break;
		}
	}
	
	public void ChangeScreen(int mouseX, int mouseY) {
		switch(screen) {
		case 1:
			//login
			if (screen == 1 && mouseX > (115 - (145 / 2))
				&& mouseX < (115 + (145 / 2))
				&& mouseY > (601 - (34 / 2))
				&& mouseY < (601 + (34 / 2))) {
				
				String[] userInfo = lgnScreen.getLoginInfo();
				boolean canLogin = false;
				if(userInfo[0].isEmpty() || userInfo[1].isEmpty()) {
					//WARNING empty fields
				}else {
					canLogin = restaurant.verifyLogin(userInfo[0], userInfo[1]);
				}
				
				if(canLogin) {
					lgnScreen.deleteTextField();
					screen = 2;
				}
	        }
			
			//sign up
			if (screen == 1 && mouseX > 120 && mouseX < 245 && mouseY > 660 && mouseY <688) {
				sgnScreen.showElements();
				lgnScreen.deleteTextField();
				screen = 3;
	        }
			break;
		case 3:
			if (screen == 3 && mouseX > 115 && mouseX < 265 && mouseY > 475 && mouseY <525) {
				
				boolean createdUser = false;
				String createUserInfo[] = sgnScreen.getInfo();
				if(createUserInfo[0].isEmpty() || createUserInfo[1].isEmpty() || createUserInfo[2].isEmpty()) {
					//WARNING empty fields
				}else {
					createdUser = restaurant.createUser(createUserInfo[0], createUserInfo[1], createUserInfo[2]);
				}
								
				if(createdUser) {
					
					sgnScreen.deleteTextField();
					lgnScreen.showTextField();
					screen = 1;
				}
	        }
			break;
		}
	}
}