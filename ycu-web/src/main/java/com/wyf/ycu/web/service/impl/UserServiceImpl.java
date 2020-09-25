package com.wyf.ycu.web.service.impl;

import com.wyf.ycu.web.model.User;
import com.wyf.ycu.web.repository.UserDao;
import com.wyf.ycu.web.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImpl implements UserService {

	@Autowired
	private UserDao userDao;

	@Override
	public List<User> getUserList() {
		return this.userDao.findAll();
	}

	@Override
	public User findUserById(long id) {
		return this.userDao.findById(id);
	}

	@Override
	public void save(User user) {
		this.userDao.save(user);
	}

	@Override
	public void edit(User user) {
		this.userDao.save(user);
	}

	@Override
	public void delete(long id) {
		this.userDao.deleteById(id);
	}
}
