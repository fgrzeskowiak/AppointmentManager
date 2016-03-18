package com.projectsite.dao;

import java.util.List;
import com.projectsite.model.User;

public interface UserDAO extends GenericDAO<User, Long>{
	List<User> getAll();
	User getUserByUsername(String username);
}
