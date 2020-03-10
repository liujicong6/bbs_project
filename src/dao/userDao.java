package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import pojo.user;

import tools.BaseDao;
public class userDao {
	
	public user findUserById(String userId) {
		Connection conn = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		user result = null;
		try {
			conn =  BaseDao.getConnection();//获取连接
			String sql = "select * from bbs_user "
					+ "where userId=?";
			ps = conn.prepareStatement(sql);//创建执行块
			rs = BaseDao.query(ps, new Object[] {userId});// 调用BaseDao的查询方法
			if(rs.next()) {
				// 从结果集获取创建对象
				result = new user();
			}
		} catch (Exception e) {e.printStackTrace();
		} finally {
			try {
				BaseDao.close(conn, ps, rs);
			} catch (Exception e2) {e2.printStackTrace();}
		}
		return result;
	}
	
	
	public int addBookUser(user user) {
		java.sql.Connection conn = null;
		PreparedStatement ps = null;
		try {
			conn = BaseDao.getConnection();
			String sql = "insert into bbs_user(userId,userPsw,userEmail,userPhoto,userAlice,userSex) "
					+ "values(?,?,?,?,?,?)";
			ps = conn.prepareStatement(sql);
			return BaseDao.alter(ps, new Object[] {
				user.getUserId(),user.getUserPsw(),user.getUserEmail(),user.getUserPhoto(),user.getUserAlice(),user.getUserSex()});
		} catch (Exception e) {e.printStackTrace();
		} finally {
			try {
				BaseDao.close(conn, ps, null);
			} catch (Exception e2) {e2.printStackTrace();}
		}
		return 0;
	}
}
