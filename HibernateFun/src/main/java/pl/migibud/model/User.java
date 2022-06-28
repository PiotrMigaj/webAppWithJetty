package pl.migibud.model;

import javax.persistence.*;

@Entity
@Table(name = "users")
public class User {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	private String name;
	private String lastName;
	private boolean is_adult;

	public User() {
	}

	public User(String name, String lastName, boolean is_adult) {
		this.name = name;
		this.lastName = lastName;
		this.is_adult = is_adult;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public boolean isIs_adult() {
		return is_adult;
	}

	public void setIs_adult(boolean is_adult) {
		this.is_adult = is_adult;
	}
}
