package model.entities;

public class User {
	
	//Attributes
	private Integer id;
	private String name;
	private String email;
	private String password;
	
	//Constructors
	public User() {
	}
	
	public User(Integer id, String name, String email, String password) {
		this.id = id;
		this.name = name;
		this.email = email;
		this.password = password;
	}

	
	//Getters and Setters
	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}
	
	
	//toString
	@Override
	public String toString() {
		return id.toString();
	}
	
	
	
}