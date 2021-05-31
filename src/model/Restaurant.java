package model;

import java.util.ArrayList;
import java.util.Collections;

import processing.core.PApplet;
import processing.core.PImage;

public class Restaurant {

	private PApplet app;
	private PImage p1;
	private PImage p2;
	private PImage p3;
	private PImage p4;
	
	private ArrayList<User> registeredUsers;
	private ArrayList<Product> restaurantProducts;
	
	public Restaurant(PApplet app) {
		this.app = app;
		
		registeredUsers = new ArrayList<>();
		restaurantProducts = new ArrayList<>();
		
		//add products to visualize
		loadImages();
		loadProducts();
	}
	
	private void loadProducts() {
		
		Product pr1 = new Product("Regular Burger", 2.99, p1, app);
		Product pr2 = new Product("Double Burger", 3.99, p2, app);
		Product pr3 = new Product("Deluxe Burger", 3.50, p3, app);
		Product pr4 = new Product("Monster Burger", 5.99, p4, app);
		restaurantProducts.add(pr1);
		restaurantProducts.add(pr2);
		restaurantProducts.add(pr3);
		restaurantProducts.add(pr4);
	}

	private void loadImages() {
		p1 = app.loadImage("data/regular1.png");
		p2 = app.loadImage("data/double1.png");
		p3 = app.loadImage("data/deluxe1.png");
		p4 = app.loadImage("data/monster1.png");
	}

	public boolean verifyLogin(String username, String password) {
		
		boolean created = false;
		User existingUser = binarySearchUser(username);
		if(existingUser != null) {
			if(password.equals(existingUser.getPassword())) {
				//LOGIN
				created = true;
			}else {
				//WARNING USER AND PASSWORD MISSMATCH
			}
		}else {
			//WARNING NOT EXISTING USER
		}
		return created;
	}

	public boolean createUser(String username, String email, String password) {
		User user = new User(username, email, password);
		boolean created = false;
		
		if(registeredUsers.size() == 0) {
			registeredUsers.add(user);
			created = true;
		}else {
			//validate if the username is already taken. First organize the list for binary search
			Collections.sort(registeredUsers);
			User repeated = binarySearchUser(username);
			if(repeated == null) {
				registeredUsers.add(user);
				created = true;
			}else {
				//WARNING TAKEN USERNAME
			}
		}
		return created;
	}

	private User binarySearchUser(String username) {
		User foundUser = null;
		int init = 0;
		int end = registeredUsers.size()-1;
		int mid = (init+end)/2;
		
		if(registeredUsers.size() == 1) {
			if(username.equals(registeredUsers.get(0).getUsername())) {
				foundUser = registeredUsers.get(0);
			}
		}else {
			while(init <= end) {
				
				mid = (init+end)/2;
				
				if(username.equals(registeredUsers.get(mid).getUsername())) {
					foundUser = registeredUsers.get(mid);
				}else if(username.compareTo(registeredUsers.get(mid).getUsername())<0) {
					end = mid-1;
				}else {
					init = mid+1;
				}
			}
		}
		return foundUser;
	}

	//getters and setters
	public ArrayList<User> getRegisteredUsers() {
		return registeredUsers;
	}

	public void setRegisteredUsers(ArrayList<User> registeredUsers) {
		this.registeredUsers = registeredUsers;
	}

	public ArrayList<Product> getRestaurantProducts() {
		return restaurantProducts;
	}

	public void setRestaurantProducts(ArrayList<Product> restaurantProducts) {
		this.restaurantProducts = restaurantProducts;
	}	
}
