package cn.bamboo.user.dao;

import java.io.FileOutputStream;
import java.io.OutputStreamWriter;

import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.Element;
import org.dom4j.io.OutputFormat;
import org.dom4j.io.SAXReader;
import org.dom4j.io.XMLWriter;

import cn.bamboo.user.domain.User;

/**
 * 数据类
 * 
 * */
public class UserDao {
	private String path = "D:/users.xml";// 依赖数据文件

	/**
	 * 按用户名查询
	 * 
	 * @param username
	 * @return
	 */
	public User findByUserName(String username) {
		/**
		 * 1，得到Document 2,xpath查询 3，校验结果是否为null,如果为null，返回null
		 * 4,如果不为null,需要把Elecment封装到User对象中
		 */

		// 创建解析器
		SAXReader reader = new SAXReader();
		try {
			Document doc = reader.read(path);
			// 2,xpath查询得到Element
			Element ele = (Element) doc.selectSingleNode("//user[@username='"
					+ username + "']");
			if (ele == null)
				return null;
			// 把Element对象封装到User对象中
			User user = new User();
			user.setUsername(ele.attributeValue("username"));// 获取该元素名为username属性值
			user.setPassword(ele.attributeValue("password"));// 该元素名为password属性
			return user;
		} catch (DocumentException e) {
			throw new RuntimeException(e);
		}
	}

	/**
	 * 
	 * @param user
	 */
	public void add(User user) {
		/**
		 * 1，得到Document 2,通过Document得到root元素<users> 3,使用参数，转发成Element对象
		 * 4,把element添加到root元素中 5,保存Document
		 */
		// 创建解析器
		SAXReader reader = new SAXReader();
		try {
			Document doc = reader.read(path);
			// 得到根元素
			Element root = doc.getRootElement();
			// 通过根元素创建新元素
			Element userEle = root.addElement("user");
			// 设置属性
			userEle.addAttribute("username", user.getUsername());
			userEle.addAttribute("password", user.getPassword());

			/**
			 * 保存文档
			 */
			OutputFormat format = new OutputFormat("\t", true);// 缩进使用\t，是否换行，是
			format.setTrimText(true);// 清空原有的换行和缩进

			// 创建XmlWriter
			XMLWriter writer = new XMLWriter(new OutputStreamWriter(
					new FileOutputStream(path), "utf-8"), format);
			writer.write(doc);
			writer.close();
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
	}
}
