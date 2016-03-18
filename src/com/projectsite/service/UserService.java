package com.projectsite.service;
 
import com.projectsite.dao.DAOFactory;
import com.projectsite.dao.UserDAO;
import com.projectsite.model.User;
import java.math.BigInteger;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class UserService {
    public User addUser(String username, String email, String password) {
        User user = new User();
        User resultUser;
        user.setUsername(username);
        String md5Pass = encryptPassword(password);
        user.setPassword(md5Pass);
        user.setEmail(email);
        user.setActive(true);
        DAOFactory factory = DAOFactory.getDAOFactory();
        UserDAO userDao = factory.getUserDAO();
        resultUser = userDao.create(user);
        return resultUser;
    }
    
    private String encryptPassword (String password) {
    	MessageDigest digest = null;
    	try {
    		digest = MessageDigest.getInstance("MD5");
    	} catch (NoSuchAlgorithmException e) {
    		e.printStackTrace();
    	}
    	digest.update(password.getBytes());
    	String md5Password = new BigInteger(1, digest.digest()).toString(16);
    	return md5Password;
    }
     
    public User getUserById(long userId) {
        DAOFactory factory = DAOFactory.getDAOFactory();
        UserDAO userDao = factory.getUserDAO();
        User user = userDao.read(userId);
        return user;
    }
     
    public User getUserByUsername(String username) {
        DAOFactory factory = DAOFactory.getDAOFactory();
        UserDAO userDao = factory.getUserDAO();
        User user = userDao.getUserByUsername(username);
        return user;
    }
}
