package com.icw.user.service.UserService.UserBean;

import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;

@Entity
public class Post {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
   private Integer id;
   private String description;
   
   @ManyToOne(fetch = FetchType.LAZY)
   private User user;

public Integer getId() {
	return id;
}

public void setId(Integer id) {
	this.id = id;
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
   
}
