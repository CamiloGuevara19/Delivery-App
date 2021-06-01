 package controller;

import model.User;
import processing.core.PApplet;
import processing.core.PImage;

public class HistoryScreen {

	private PApplet app;
	private PImage ui;
	private User user;
	
	public HistoryScreen(PApplet app) {
		this.app = app;
		ui = app.loadImage("data/historyui.png");
	}

	public void drawScene() {
		app.image(ui, 0, 37);
		
		int y = 177;
		if(user != null) {
			for (int i = 0; i < user.getPrices().size(); i++) {
				
				app.image(user.getImages().get(i), 19, y);
				app.fill(0);
				app.text(user.getPrices().get(i)+"", 134, y+65);
				y+=102;
			}
		}
		
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	
}
