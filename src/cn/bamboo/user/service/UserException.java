package cn.bamboo.user.service;

/**
 * 自定义一个异常类
 * 	只是给出父类中的构造器即可！方法用来构造对象
 * @author p1411
 * 
 */
public class UserException extends Exception {

	public UserException() {
		
	}

	public UserException(String message, Throwable cause) {

	}

	public UserException(String message, Throwable cause,
			boolean enableSuppression, boolean writableStackTrace) {
		super(message, cause, enableSuppression, writableStackTrace);
		// TODO Auto-generated constructor stub
	}

	public UserException(String message) {
		super(message);
		// TODO Auto-generated constructor stub
	}

	public UserException(Throwable cause) {
		super(cause);
		// TODO Auto-generated constructor stub
	}

}
