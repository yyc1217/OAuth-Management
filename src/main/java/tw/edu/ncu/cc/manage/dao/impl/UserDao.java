package tw.edu.ncu.cc.manage.dao.impl;

import java.util.Optional;

import org.springframework.stereotype.Repository;

import tw.edu.ncu.cc.manage.dao.IUserDao;
import tw.edu.ncu.cc.manage.dao.support.AbstractOAuthServiceDao;
import tw.edu.ncu.cc.manage.domain.User;

@Repository
public class UserDao extends AbstractOAuthServiceDao<User> implements IUserDao {

	@Override
	public Optional<User> find(String account) {
		return get(userUrl + account);
	}

	@Override
	public User create(User user) {
		post(userUrl, user);
		return user;
	}

}