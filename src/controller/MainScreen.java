package controller;

import model.Restaurant;

public class MainScreen {

	private Restaurant restaurant;
	
	public MainScreen(Restaurant res) {
		restaurant = res;
	}
	
	public void showProducts() {
		int x = 19;
		int y = 227;
		
		for (int i = 0; i <restaurant.getRestaurantProducts().size() ; i++) {
			restaurant.getRestaurantProducts().get(i).drawProduct(x,y);
			x+=169;
			
			if(x>=201) {
				y+=200;
				x = 19;
			}
		}
	}

}
