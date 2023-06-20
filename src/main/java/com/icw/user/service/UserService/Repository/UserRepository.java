package com.icw.user.service.UserService.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.icw.user.service.UserService.UserBean.User;

public interface UserRepository extends JpaRepository<User,Integer> {

	
}
