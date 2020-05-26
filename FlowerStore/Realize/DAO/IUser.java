package FlowerStore.Realize.DAO;

import FlowerStore.Entity.User;
import FlowerStore.Interface.DAO.UserDAO;
import FlowerStore.Tools.DBUtil;

import java.sql.*;
import java.util.List;

public class IUser implements UserDAO {


    @Override
    public String CheckPassword(String Name) {
        Connection conn = null;
        ResultSet rs = null;
        Statement st = null;
        conn = DBUtil.getConnection();

        User user = new User();
        try {
            String sql = "select * from user where name='" + Name + "'";
            st = conn.createStatement();
            rs = st.executeQuery(sql);
            if (rs.next()) {
                user.setUser_id(rs.getInt(1));
                user.setName(rs.getString(2));
                user.setPassword(rs.getString(3));
                return user.getPassword();
            }

            return null;
        } catch (SQLException throwable) {
            throwable.printStackTrace();
        } finally {
            DBUtil.close(conn, st, null, rs);
        }
        return null;
    }

    @Override
    public boolean AddUser(User s) {
        Connection conn = DBUtil.getConnection();
        String sql = "insert into user values(?,?,?)";
        PreparedStatement ps = null;
        try {
            ps = conn.prepareStatement(sql);
            ps.setInt(1, s.getUser_id());
            ps.setString(2, s.getName());
            ps.setString(3, s.getPassword());
            ps.executeUpdate();
            return true;
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } finally {
            DBUtil.close(conn, null, ps, null);
        }
        return false;
    }

    @Override
    public boolean ChangePassword(int id, String NewPassword) {
        Connection conn = null;
        Statement st = null;
        conn = DBUtil.getConnection();
        try {
            String sql = "Update user set password = '" + NewPassword + "'" + " where user_id =" + id;
            st = conn.createStatement();
            st.execute(sql);
            return true;
        } catch (SQLException throwable) {
            throwable.printStackTrace();
        } finally {
            DBUtil.close(conn, st, null, null);
        }
        return false;
    }
}

