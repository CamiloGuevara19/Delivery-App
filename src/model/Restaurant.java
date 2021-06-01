package model;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
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
	private PImage fries;
	private PImage soda;
	
	private ArrayList<User> registeredUsers;
	private ArrayList<Product> restaurantProducts;
	private ArrayList <String> users;
	private ArrayList <String> passwords;
	private ArrayList <String> emails;
	
	public Restaurant(PApplet app) {
		this.app = app;
		
		registeredUsers = new ArrayList<>();
		restaurantProducts = new ArrayList<>();
		
		//add products to visualize
		loadImages();
		loadProducts();
		createUserList(app);
	}
	
	private void loadProducts() {
		
		Dish pr1 = new Dish("Regular Burger", 2.99, p1, app, "Fries", "Soda", 1.5, 1.25, fries, soda);
		Dish pr2 = new Dish("Double Burger", 3.99, p2, app, "Fries", "Soda", 1.5, 1.25, fries, soda);
		Dish pr3 = new Dish("Deluxe Burger", 3.50, p3, app, "Fries", "Soda", 1.5, 1.25, fries, soda);
		Dish pr4 = new Dish("Monster Burger", 5.99, p4, app, "Fries", "Soda", 1.5, 1.25, fries, soda);
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
		fries = app.loadImage("data/fries.png");
		soda = app.loadImage("data/soda.png");
	}

	public boolean verifyLogin(String username, String password) {
		
		boolean created = false;
		Collections.sort(registeredUsers);		
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
		
		File file = new File ("./data/UserList.txt");
		try {
			FileWriter fw = new FileWriter(file);
			BufferedWriter bw = new BufferedWriter(fw);
			for(int i=0;i<registeredUsers.size();i++) {
				bw.write(registeredUsers.get(i).getUsername()+";"+registeredUsers.get(i).getEmail()+
					";"+registeredUsers.get(i).getPassword());
				bw.newLine();
			}
			
			bw.close();
		}
		catch(IOException e) {
			
		}
		
		createUserList(app);
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
			while(init <= end && foundUser == null) {
				
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
	
	public void createUserList(PApplet app){
		String[] text;
		String[] lines = null;
		ArrayList <String> words;
		words =  new ArrayList<>();
		users = new ArrayList<>();
		emails = new ArrayList<>();
		passwords = new ArrayList<>();
		
		
		text = app.loadStrings("./data/UserList.txt");
		
		for (int i = 0; i < text.length; i++) {
			lines = PApplet.split(text[i], ";");
			for (int j = 0; j < lines.length; j++) {
				words.add(lines[j]);
				}}
		for(int i= 0; i< words.size();i+=3) {
			
			users.add(words.get(i));
			emails.add(words.get(i+1));
			passwords.add(words.get(i+2));
		}
		
		for(int i=0;i<words.size()/3;i++) {
		User user = new User(users.get(i), emails.get(i), passwords.get(i));
		registeredUsers.add(user);
		}
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
