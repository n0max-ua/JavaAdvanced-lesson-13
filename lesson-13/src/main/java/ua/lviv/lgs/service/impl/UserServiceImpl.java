package ua.lviv.lgs.service.impl;

import java.util.List;

import ua.lviv.lgs.dao.UserDao;
import ua.lviv.lgs.dao.impl.UserDaoImpl;
import ua.lviv.lgs.domain.User;
import ua.lviv.lgs.service.UserService;

public class UserServiceImpl implements UserService {

	private static UserServiceImpl userServiceImpl;
	private UserDao userDao;

	private UserServiceImpl() {

		userDao = new UserDaoImpl();

	}

	public static UserService getUserService() {
		if (userServiceImpl == null) {
			userServiceImpl = new UserServiceImpl();
		}
		return userServiceImpl;
	}

	@Override
	public User create(User user) {
		return userDao.create(user);
	}

	@Override
	public User readById(Integer id) {
		return userDao.readById(id);
	}

	@Override
	public User update(Integer id, User user) {
		return userDao.update(id, user);
	}

	@Override
	public void delete(Integer id) {
		userDao.delete(id);

	}

	@Override
	public List<User> readAll() {
		return userDao.readAll();
	}

	@Override
	public User getUserByEmail(String Email) {
		return userDao.getUserByEmail(Email);
	}
}
