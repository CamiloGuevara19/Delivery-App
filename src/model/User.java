package model;

import java.util.ArrayList;

import processing.core.PImage;

public class User implements Comparable<User>{

	private String username;
	private String password;
	private String email;
	private ArrayList<Double> prices;
	private ArrayList<PImage> images;
	
	public User(String userN, String ema, String pass) {
		username = userN;
		email = ema;
		password = pass;
		prices = new ArrayList<>();
		images = new ArrayList<>();
	}

	//Gettters and setters
	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	@Override
	public int compareTo(User user) {
		return username.compareTo(user.getUsername());
	}
	
	public String toString() {
		return username+", "+ email + ", "+password;
	}

	public ArrayList<Double> getPrices() {
		return prices;
	}

	public void setPrices(ArrayList<Double> prices) {
		this.prices = prices;
	}

	public ArrayList<PImage> getImages() {
		return images;
	}

	public void setImages(ArrayList<PImage> images) {
		this.images = images;
	}
	
	
}
