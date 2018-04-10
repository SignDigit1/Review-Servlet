package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import utils.DBConnectUtil;

public class UserDao {
	private Connection conn = null;
	private PreparedStatement st = null;
	private ResultSet rs = null;

	public List<User> getUsers(String id) {
		List<User> userLists = new ArrayList<User>();

		try {

			conn = DBConnectUtil.getConnection();
			System.err.println("conn:" + conn);
			String sql = null;
			if (id == null || id.isEmpty()) {
				sql = "select * from user";
				st = conn.prepareStatement(sql);
			} else {
				sql = "select * from user where id=?";
				st = conn.prepareStatement(sql);
				st.setString(1, id);
				
			}

			rs = st.executeQuery();
			while (rs.next()) {
				// System.out.println(rs.getString("id") + "::" +
				// rs.getString("password"));
				User user = new User();
				user.setID(rs.getString("id"));
				user.setPassword(rs.getString("password"));
				userLists.add(user);
			}

		} catch (Exception e) {
			// System.err.println(e);
			e.printStackTrace();
		} finally {
			DBConnectUtil.release(conn, st, rs);
		}

		return userLists;
	}

}
