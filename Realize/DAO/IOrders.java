package FlowerStore.Realize.DAO;

import FlowerStore.Entity.Orders;
import FlowerStore.Interface.DAO.OrdersDAO;
import FlowerStore.Tools.DBUtil;

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
                orders.setCustomer_id(rs.getInt(4));
                orders.setDate(rs.getString(5));
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
                orders.setCustomer_id(rs.getInt(4));
                orders.setDate(rs.getString(5));
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
        String sql = "insert into orders values(?,?,?,?,?)";
        PreparedStatement ps = null;
        try {
            ps = conn.prepareStatement(sql);
            for(Orders s : list){
                ps.setInt(1, s.getOrders_id());
                ps.setInt(2, s.getFlower_id());
                ps.setInt(3,s.getQuantity());
                ps.setInt(4,s.getCustomer_id());
                ps.setString(5,s.getDate());
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
