package model;

import java.util.ArrayList;
import java.util.Collections;

public class Restaurant {

	private ArrayList<User> registeredUsers;
	
	public Restaurant() {
		registeredUsers = new ArrayList<>();
	}
	
	public void verifyLogin(String username, String password) {
		
		User existingUser = binarySearchUser(username);
		if(existingUser != null) {
			if(password.equals(existingUser.getPassword())) {
				//LOGIN
			}else {
				//WARNING USER AND PASSWORD MISSMATCH
			}
		}else {
			//WARNING NOT EXISTING USER
		}
	}
	


	public void createUser(String email, String username, String password) {
		User user = new User(username, email, password);
		
		if(registeredUsers.size() == 0) {
			registeredUsers.add(user);
		}else {
			//validate if the username is already taken. First organize the list for binary search
			Collections.sort(registeredUsers);
			User repeated = binarySearchUser(username);
			if(repeated == null) {
				registeredUsers.add(user);
			}else {
				//WARNING TAKEN USERNAME
			}
		}
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
}
