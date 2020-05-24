package FlowerStore.Realize.DAO;

import FlowerStore.Entity.Flower;
import FlowerStore.Entity.ShopList;
import FlowerStore.Interface.DAO.ShopListDAO;
import FlowerStore.Tools.DBUtil;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class IShopList implements ShopListDAO {

    @Override
    public List<ShopList> CheckAllList(int CustomerID) {

        Connection conn = null;
        ResultSet rs = null;
        Statement st = null;
        conn = DBUtil.getConnection();

        List<ShopList> list = new ArrayList<>();
        try {
            String sql = "select * from shoplist where customer_id="+CustomerID;
            st = conn.createStatement();
            rs = st.executeQuery(sql);

            while (rs.next()) {
                ShopList shopList=new ShopList();
                shopList.setShoplist_id(rs.getInt(1));
                shopList.setCustomer_id(rs.getInt(2));
                shopList.setFlower_id(rs.getInt(3));
                shopList.setBuynum(rs.getInt(4));
                shopList.setAllprice(rs.getInt(5));
                list.add(shopList);
            }
            return list;

        } catch (SQLException throwable) {
            throwable.printStackTrace();
        } finally {
            DBUtil.close(conn, st, null, rs);
        }
        return null;
    }

    @Override
    public boolean DeleteItem(int ListID) {

        Connection conn = null;
        Statement st = null;
        PreparedStatement stmt = null;
        conn = DBUtil.getConnection();
        try {
            String sql = "delete from shoplist where shoplist_id="+ListID;
            stmt = conn.prepareStatement(sql);
            stmt.execute();
            return true;
        } catch (SQLException throwable) {
            throwable.printStackTrace();
        } finally {
            DBUtil.close(conn, st, null, null);
        }
        return false;
    }

    @Override
    public boolean AddItem(List<ShopList> list) {

        Connection conn = DBUtil.getConnection();
        String sql = "insert into shoplist values(?,?,?,?,?)";
        PreparedStatement ps = null;
        try {
            ps = conn.prepareStatement(sql);
            for (ShopList s : list) {
                ps.setInt(1, s.getShoplist_id());
                ps.setInt(2, s.getCustomer_id());
                ps.setInt(3, s.getFlower_id());
                ps.setInt(4, s.getBuynum());
                ps.setInt(5, s.getAllprice());
                ps.executeUpdate();
            }
            return true;
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } finally {
            DBUtil.close(conn, null, ps, null);
        }
        return false;
    }
}
