package 实验三鲜花销售系统.Realize.DAO;

import 实验三鲜花销售系统.Entity.Flower;
import 实验三鲜花销售系统.Entity.Orders;
import 实验三鲜花销售系统.Interface.DAO.OrdersDAO;
import 连接数据库demo.DBUtil;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class IOrders implements OrdersDAO {

    @Override
    public List<Orders> CheckAllMyOrders(int Customer_id) {
        Connection conn = null;
        ResultSet rs = null;
        Statement st = null;
        conn = DBUtil.getConnection();

        List<Orders> list = new ArrayList<Orders>();
        try {
            String sql = "select * from orders where customer_id ='"+Customer_id+"'";
            st = conn.createStatement();
            rs = st.executeQuery(sql);

            while(rs.next()){

                Orders orders=new Orders();
                orders.setOrders_id(rs.getInt(1));
                orders.setFlower_id(rs.getInt(2));
                orders.setQuantity(rs.getInt(3));
                orders.setStore_id(rs.getInt(4));
                orders.setCustomer_id(rs.getInt(5));
                orders.setDate(rs.getString(6));
                list.add(orders);
            }
            return list;

        } catch (SQLException throwable) {
            throwable.printStackTrace();
        }finally{
            DBUtil.close(conn, st, null, rs);
        }
        return null;
    }

    @Override
    public List<Orders> CheckShopOrders(int Store_id) {
        Connection conn = null;
        ResultSet rs = null;
        Statement st = null;
        conn = DBUtil.getConnection();

        List<Orders> list = new ArrayList<Orders>();
        try {
            String sql = "select * from orders where store_id ='"+Store_id+"'";
            st = conn.createStatement();
            rs = st.executeQuery(sql);

            while(rs.next()){

                Orders orders=new Orders();
                orders.setOrders_id(rs.getInt(1));
                orders.setFlower_id(rs.getInt(2));
                orders.setQuantity(rs.getInt(3));
                orders.setStore_id(rs.getInt(4));
                orders.setCustomer_id(rs.getInt(5));
                orders.setDate(rs.getString(6));
                list.add(orders);
            }
            return list;

        } catch (SQLException throwable) {
            throwable.printStackTrace();
        }finally{
            DBUtil.close(conn, st, null, rs);
        }
        return null;
    }

    @Override
    public boolean AddOrder(List<Orders> list) {

        Connection conn = DBUtil.getConnection();
        String sql = "insert into orders values(?,?,?,?,?,?)";
        PreparedStatement ps = null;
        try {
            ps = conn.prepareStatement(sql);
            for(Orders s : list){
                ps.setInt(1, s.getOrders_id());
                ps.setInt(2, s.getFlower_id());
                ps.setInt(3,s.getQuantity());
                ps.setInt(4,s.getStore_id());
                ps.setInt(5,s.getCustomer_id());
                ps.setString(6,s.getDate());
                ps.executeUpdate();
            }
            return true;
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } finally{
            DBUtil.close(conn, null, ps, null);
        }
        return false;
    }
}
