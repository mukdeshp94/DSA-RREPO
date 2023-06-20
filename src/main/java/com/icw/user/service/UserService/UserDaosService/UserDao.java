package com.icw.user.service.UserService.UserDaosService;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.icw.user.service.UserService.Repository.UserRepository;
import com.icw.user.service.UserService.Responsebean.UserResponseBean;
import com.icw.user.service.UserService.UserBean.User;

import java.time.LocalDate;
import java.util.*;
import java.util.function.Predicate;


@Component
public class UserDao {
	@Autowired
	private UserRepository userepo;
	private static List<User> users=new ArrayList<>();
	private static Integer usercount=0;
	static {
		users.add(new User(++usercount,"Mukesh","11/12/2022"));
		users.add(new User(++usercount,"Suresh","10/09/2022"));
		users.add(new User(++usercount,"kamlesh","17/08/2022"));
		users.add(new User(++usercount,"Nitesh","24/07/2022"));
		users.add(new User(++usercount,"Rakesh","16/05/2022"));
	}
	
	public List<User> findAll()
	{
		
		return users;
	}
	
	public User findOne(Integer num) {
		
	  User user2 = users.stream().filter(i->i.getId().equals(num)).findFirst().orElse(null);
	  
		
		return user2;
	}
	public void deleteOne(Integer num) {
		
		Predicate<User> pre=u->u.getId().equals(num);
		 users.remove(pre);
		  
			
			
		}
	public User addUser(User user)
	{
	   user.setId(++usercount);
		users.add(user);
		return user;
		
	}
	
	public String userAdd(UserResponseBean userresponse)
	{


		
		return "Data is successfully inserted";
		
	}

}
