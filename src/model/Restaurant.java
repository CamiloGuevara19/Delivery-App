package model;

import java.util.ArrayList;
import java.util.Collections;

public class Restaurant {

	private ArrayList<User> registeredUsers;
	private ArrayList<Product> restaurantProducts;
	
	public Restaurant() {
		registeredUsers = new ArrayList<>();
		restaurantProducts = new ArrayList<>();
		
		//add products to visualize
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
