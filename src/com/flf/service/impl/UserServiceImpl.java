package com.flf.service.impl;

import java.util.List;
import com.flf.entity.User;
import com.flf.mapper.UserMapper;
import com.flf.service.UserService;

public class UserServiceImpl implements UserService {

	private UserMapper userMapper;

	public User getUserById(Integer userId) {

		return userMapper.getUserById(userId);
	}

	public boolean insertUser(User user) {

		int count = userMapper.getCountByName(user.getLoginname());
		if (count > 0) {
			return false;
		} else {
			userMapper.insertUser(user);
			return true;
		}

	}

	public List<User> listPageUserForAdmin(User user) {
		return userMapper.listPageUserForAdmin(user);
	}

	public List<User> listPageUser(User user) {
		return userMapper.listPageUser(user);
	}

	public void updateUser(User user) {

		userMapper.updateUser(user);
	}

	public void updateUserBaseInfo(User user) {
		userMapper.updateUserBaseInfo(user);
	}

	public void updateUserRights(User user) {
		userMapper.updateUserRights(user);
	}

	public User getUserByNameAndPwd(String loginname, String password) {

		User user = new User();
		user.setLoginname(loginname);
		user.setPassword(password);
		return userMapper.getUserInfo(user);
	}

	@Override
	public User getUserByAccountAndIDCardNum(String accountAndIdCardNum) {
		User user = new User();
		user.setCustomerId(accountAndIdCardNum);
		return userMapper.getUserInfo2(user);
	}
	
	public UserMapper getUserMapper() {
		return userMapper;
	}

	public void setUserMapper(UserMapper userMapper) {
		this.userMapper = userMapper;
	}

	public void deleteUser(int userId) {
		userMapper.deleteUser(userId);
	}

	public User getUserAndRoleById(Integer userId) {

		return userMapper.getUserAndRoleById(userId);
	}

	public void updateLastLogin(User user) {

		userMapper.updateLastLogin(user);
	}

	public List<User> listAllUser() {

		return userMapper.listAllUser();
	}


}
