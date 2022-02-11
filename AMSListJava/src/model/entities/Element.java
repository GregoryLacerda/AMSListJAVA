package model.entities;

import java.io.Serializable;
import java.util.Objects;

import model.enums.Status;

public class Element implements Serializable {

	private static final long serialVersionUID = 1L;

	//Attributes
	private Integer id;
	private String name;
	private String coverImage;
	private String siteLink;
	private String description;
	private User user;
	private Status status;

	//Constructors
	public Element() {
	}

	public Element(String name, String coverImage, String siteLink, String description, User user,
			Status status) {
		this.name = name;
		this.coverImage = coverImage;
		this.siteLink = siteLink;
		this.description = description;
		this.user = user;
		this.status = status;
	}
	
	//Getter and Setters
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

	public String getCoverImage() {
		return coverImage;
	}

	public void setCoverImage(String coverImage) {
		this.coverImage = coverImage;
	}

	public String getSiteLink() {
		return siteLink;
	}

	public void setSiteLink(String siteLink) {
		this.siteLink = siteLink;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public Status getStatus() {
		return status;
	}

	public void setStatus(Status status) {
		this.status = status;
	}
	
	//HashCode and Equals
	@Override
	public int hashCode() {
		return Objects.hash(name, siteLink, user);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Element other = (Element) obj;
		return Objects.equals(name, other.name) && Objects.equals(siteLink, other.siteLink)
				&& Objects.equals(user, other.user);
	}

	//ToString
	@Override
	public String toString() {
		return "[Id: " + id + ", Name: " + name + ", CoverImage: " + coverImage + ", SiteLink: " + siteLink
				+ ", Description: " + description + ", User: " + user + ", Status: " + status + ", ";
	}
	
	
}
