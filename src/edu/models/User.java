package edu.models;

public class User implements java.io.Serializable{
	private int id;
	private String name;
	private String email;
	private String imageFilepath;
	
	public User(int id, String name, String email, String imageFilepath) {
		setId(id);
		setName(name);
		setEmail(email);
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
	
	public void setEmail(String email) {
		this.email = email;
	}
	
	public String getEmail() {
		return email;
	}
	
	public void setImageFilepath(String imageFilepath) {
		this.imageFilepath = imageFilepath;
	}
	
	public String imageFilepath() {
		return imageFilepath;
	}
}
