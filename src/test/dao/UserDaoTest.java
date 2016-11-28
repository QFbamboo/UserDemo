package test.dao;

import org.junit.Test;

import cn.bamboo.user.dao.UserDao;
import cn.bamboo.user.domain.User;

/**
 * UserDao的测试类
 * 
 * @author p1411
 * 
 */
public class UserDaoTest {

	@Test
	public void testFindByUserName() {
		UserDao userDao = new UserDao();
		User user=userDao.findByUserName("张三");
		System.out.println(user);
	}

	@Test
	public void testAdd(){
		UserDao userDao=new UserDao();
		
		User user=new User();
		user.setUsername("bamboo");
		user.setPassword("123456");
		userDao.add(user);
	}
}
