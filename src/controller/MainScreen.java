package controller;

import model.Restaurant;
import processing.core.PApplet;

public class MainScreen {

	private Restaurant restaurant;
	private PApplet app;
	
	public MainScreen(Restaurant res, PApplet app) {
		restaurant = res;
		this.app = app;
	}
	
	public void showProducts() {
		int x = 29;
		int y = 227;
		
		for (int i = 0; i <restaurant.getRestaurantProducts().size() ; i++) {
			restaurant.getRestaurantProducts().get(i).drawProduct(x,y);
			//app.fill(0);
			//app.rect(x, y, 149, 180);
			x+=169;
			
			if(x>=201) {
				y+=200;
				x = 29;
			}
		}
	}

}
