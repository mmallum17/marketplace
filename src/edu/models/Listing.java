package edu.models;

import java.sql.Timestamp;

import javax.servlet.ServletSecurityElement;

public class Listing implements java.io.Serializable{
	
	private int id;
	private String name;
	private int price;
	private String description;
	private User seller;	
	private Timestamp timePosted;
	private String imageFilepath;
	
	public Listing(int id, String name, int price, String description, User seller, Timestamp timePosted, String imageFilepath) {
		setId(id);
		setName(name);
		setPrice(price);
		setDescription(description);
		setSeller(seller);
		setTimePosted(timePosted);
		setImageFilepath(imageFilepath);
	}
	
	public void setId(int id) {
		this.id = id;
	}
	
	public int getId() {
		return id;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	
	public String getName() {
		return name;
	}
	
	public void setPrice(int price) {
		this.price = price;
	}
	
	public int getPrice() {
		return price;
	}
	
	public void setDescription(String description) {
		this.description = description;
	}
	
	public String getDescription() {
		return description;
	}
	
	public void setSeller(User seller) {
		this.seller = seller;
	}
	
	public User getSeller() {
		return seller;
	}
	
	public void setTimePosted(Timestamp timePosted) {
		this.timePosted = timePosted;
	}
	
	public Timestamp getTimePosted() {
		return timePosted;
	}
	
	public void setImageFilepath(String imageFilepath) {
		this.imageFilepath = imageFilepath;
	}
	
	public String getImageFilepath() {
		return imageFilepath;
	}

}
