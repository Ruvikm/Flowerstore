package FlowerStore.Realize.DAO;

import FlowerStore.Entity.Customer;
import FlowerStore.Interface.DAO.CustomerDAO;
import FlowerStore.Tools.DBUtil;

import java.sql.*;
import java.util.List;

public class ICustomer implements CustomerDAO {


    @Override
    public boolean AddCustomer(Customer s) {
        Connection conn = DBUtil.getConnection();
        String sql = "insert into customer values(?,?,?,?,?)";
        PreparedStatement ps = null;
        try {
            ps = conn.prepareStatement(sql);
            ps.setInt(1, s.getCustomer_id());
            ps.setString(2, s.getCustomer_name());
            ps.setString(3, s.getCustomer_sex());
            ps.setString(4, s.getCustomer_sign());
            ps.setString(5, s.getCustomer_phone());
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
    public boolean SetCustomer_name(int Customer_id, String Name) {

        Connection conn = null;
        Statement st = null;
        conn = DBUtil.getConnection();
        try {
            String sql = "Update customer set customer_name = '" + Name + "'" + " where customer_id =" + Customer_id;
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

    @Override
    public boolean SetCustomer_sex(int Customer_id, String Sex) {
        Connection conn = null;
        Statement st = null;
        conn = DBUtil.getConnection();
        try {
            String sql = "Update customer set customer_sex = '" + Sex + "'" + " where customer_id =" + Customer_id;
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

    @Override
    public boolean SetCustomer_sign(int Customer_id, String Sign) {
        Connection conn = null;
        Statement st = null;
        conn = DBUtil.getConnection();
        try {
            String sql = "Update customer set customer_sign = '" + Sign + "'" + " where customer_id =" + Customer_id;
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

    @Override
    public boolean SetCustomer_phone(int Customer_id, String Phone) {
        Connection conn = null;
        Statement st = null;
        conn = DBUtil.getConnection();
        try {
            String sql = "Update customer set customer_phone = '" + Phone + "'" + " where customer_id =" + Customer_id;
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

    @Override
    public Customer getCustomerbyId(int customerId) {

        Connection conn = null;
        ResultSet rs = null;
        Statement st = null;
        conn = DBUtil.getConnection();
        Customer customer = new Customer();

        try {
            String sql = "select * from customer where customer_id = " + customerId;
            st = conn.createStatement();
            rs = st.executeQuery(sql);
            if (rs.next()) {
                customer.setCustomer_id(rs.getInt(1));
                customer.setCustomer_name(rs.getString(2));
                customer.setCustomer_sex(rs.getString(3));
                customer.setCustomer_sign(rs.getString(4));
                customer.setCustomer_phone(rs.getString(5));
                return customer;
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
    public Customer getCustomerbyName(String Name) {
        Connection conn = null;
        ResultSet rs = null;
        Statement st = null;
        conn = DBUtil.getConnection();
        Customer customer = new Customer();

        try {
            String sql = "select * from customer where customer_name = " + "'" + Name + "'";
            st = conn.createStatement();
            rs = st.executeQuery(sql);
            if (rs.next()) {
                customer.setCustomer_id(rs.getInt(1));
                customer.setCustomer_name(rs.getString(2));
                customer.setCustomer_sex(rs.getString(3));
                customer.setCustomer_sign(rs.getString(4));
                customer.setCustomer_phone(rs.getString(5));
                return customer;
            }
            return null;

        } catch (SQLException throwable) {
            throwable.printStackTrace();
        } finally {
            DBUtil.close(conn, st, null, rs);
        }
        return null;
    }

}
