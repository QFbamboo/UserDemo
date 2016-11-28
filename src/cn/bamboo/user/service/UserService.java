package cn.bamboo.user.service;

import cn.bamboo.user.dao.UserDao;
import cn.bamboo.user.domain.User;

/**
 * User的业务层
 * 
 * */
public class UserService {
	private UserDao userDao = new UserDao();

	public void regist(User user) throws UserException {
		/**
		 * 1,使用用户名去查询,如果返回null,完成添加
		 * 2,如果返回的不是Null,抛出异常
		 */
		User _user=userDao.findByUserName(user.getUsername());
		if(_user!=null) throw new UserException("用户名"+user.getUsername()+"已被注册过了！");
		userDao.add(user);
		
	}
}