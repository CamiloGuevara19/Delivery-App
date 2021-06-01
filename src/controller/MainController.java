package controller;

import model.Restaurant;
import processing.core.PApplet;
import processing.core.PImage;

public class MainController {

	//Attributes 
	private PApplet app;
	
	//Relations
	private Restaurant restaurant;
	
	private int screen;	 //integer number that controls which screen is being shown to the user
	private String actualUser;
	
	private PImage panelMenu;
	private PImage menuWelcome;
	
	//Relations
	private LoginScreen lgnScreen; //login screen controller
	private SignUpScreen sgnScreen;
	private MainScreen menuScreen;
	private ProductScreen productScreen;
	private CashScreen cashScreen;
	
	public MainController(PApplet app) {
		
		this.app = app;
		screen = 1;
		
		//objects initialization
		restaurant = new Restaurant(app);
		lgnScreen = new LoginScreen(app);
		sgnScreen = new SignUpScreen(app);
		menuScreen = new MainScreen(restaurant);
		productScreen = new ProductScreen(app);
		cashScreen = new CashScreen(app);
		//createAScreen = new CreateAccountScreen();
		
		panelMenu = app.loadImage("data/panel.png");
		menuWelcome = app.loadImage("data/mainmenu.png");
	}
	
	@SuppressWarnings("static-access")
	public void drawScreens() {
		app.textAlign(app.CENTER);
		switch(screen) {
		case 1:
			lgnScreen.drawScreen();
			sgnScreen.deleteTextField();
			break;
		case 2:
			menuScreen.showProducts();
			app.image(panelMenu, 0, 764, 375, 48);
			app.image(menuWelcome, 29, 37);
			app.text("Welcome back!", 185, 115);
			app.text(actualUser, 185, 137);
			
			break;
		case 3:
			sgnScreen.drawScreen();
			sgnScreen.drawScreen();
			break;
		case 4:
			productScreen.drawScreen();
			break;
		case 5:
			cashScreen.drawScreen();
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
					actualUser = userInfo[0];
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
		case 2:
			
			if (screen == 2 && mouseX > 19 && mouseX < 169 && mouseY > 227 && mouseY < 407) {
				productScreen.setProductType(1);
				productScreen.setSelectedP(restaurant.getRestaurantProducts().get(0));
				resetAdditions();
				screen = 4;
	        }
			if (screen == 2 && mouseX > 189 && mouseX < 338 && mouseY > 227 && mouseY < 407) {
				productScreen.setProductType(2);
				productScreen.setSelectedP(restaurant.getRestaurantProducts().get(1));
				resetAdditions();
				screen = 4;
			}
			if (screen == 2 && mouseX > 19 && mouseX < 169 && mouseY > 427 && mouseY < 607) {
				productScreen.setProductType(3);
				productScreen.setSelectedP(restaurant.getRestaurantProducts().get(2));
				resetAdditions();
				screen = 4;
			}
			if (screen == 2 && mouseX > 189 && mouseX < 338 && mouseY > 427 && mouseY < 607) {
				productScreen.setProductType(4);
				productScreen.setSelectedP(restaurant.getRestaurantProducts().get(3));
				resetAdditions();
				screen = 4;
			}
			
			//log out
			if (screen == 2 && mouseX > 328 && mouseX < 346 && mouseY > 779 && mouseY < 798) {
				lgnScreen.showTextField();
				screen = 1;
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
		case 4:
			if (screen == 4 && mouseX > 20 && mouseX < 40 && mouseY > 40 && mouseY < 60) {
				screen = 2;
			}
			
			if (screen == 4 && mouseX > 20 && mouseX < 340 && mouseY > 500 && mouseY < 575) {
				productScreen.setP1s(!productScreen.isP1s());
				
				if(productScreen.isP1s()) {
					productScreen.setPrice(productScreen.getPrice()+1.5);
				}else {
					productScreen.setPrice(productScreen.getPrice()-1.5);
				}
				
			}
			if (screen == 4 && mouseX > 20 && mouseX < 340 && mouseY > 600 && mouseY < 675) {
				productScreen.setP2s(!productScreen.isP2s());
				
				if(productScreen.isP2s()) {
					productScreen.setPrice(productScreen.getPrice()+1.25);
				}else {
					productScreen.setPrice(productScreen.getPrice()-1.25);
				}
			}
			
			if (screen == 4 && mouseX > 198 && mouseX <320 && mouseY > 741 && mouseY < 774) {
				
				cashScreen.setProductType(productScreen.getProductType());
				if(productScreen.isP1s()) {
					cashScreen.setFriesB(true);
				}
				if(productScreen.isP2s()) {
					cashScreen.setSodaB(true);
				}
				
				cashScreen.setBasePrice(productScreen.getPrice());
				screen = 5;
			}
			break;
		case 5:
			if (screen == 5 && mouseX > 20 && mouseX < 50 && mouseY > 30 && mouseY < 60) {
				screen = 2;
			}
			break;
		}
	}//end changeScreen
	
	public void resetAdditions() {
		productScreen.setP1s(false);
		productScreen.setP2s(false);
	}
	
}