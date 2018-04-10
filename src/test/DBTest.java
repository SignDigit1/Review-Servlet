package test;

import static org.junit.Assert.*;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import org.junit.Test;

import service.UserService;
import utils.DBConnectUtil;

public class DBTest {

	@Test
	public void test() {
		Connection conn = null;
		PreparedStatement st = null;
		ResultSet rs = null;
		try {

			conn = DBConnectUtil.getConnection();
			System.err.println("conn:" + conn);
			String sql = "select * from user";
			st = conn.prepareStatement(sql);
			rs = st.executeQuery(sql);
			while (rs.next()) {
				System.out.println(rs.getString("id") + "::" + rs.getString("password"));
			}

		} catch (Exception e) {
			// System.err.println(e);
			e.printStackTrace();
		} finally {
			DBConnectUtil.release(conn, st, rs);
		}
	}

	@Test
	public void testUserService() {
		UserService userService = new UserService();
		String usersByJsonString = userService.getUsersByJsonString(null);
		System.out.println(usersByJsonString);
	}

}
