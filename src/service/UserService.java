package service;

import java.util.List;

import dao.User;
import dao.UserDao;

public class UserService {
	private UserDao userDao = new UserDao();

	public String getUsersByJsonString(String id) {
		List<User> users = userDao.getUsers(id);
		StringBuffer sb = new StringBuffer("[");
		for (int i = 0; i < users.size(); i++) {
			User user = users.get(i);

			if (i > 0) {
				sb.append(",");
			}
			sb.append("{");
			sb.append("\"id\":\"" + user.getID() + "\"");
			sb.append(",\"password\":\"" + user.getPassword() + "\"");
			sb.append("}");
		}
		sb.append("]");
		return sb.toString();
	}
}
