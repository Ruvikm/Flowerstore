package FlowerStore.Realize.DAO;

import FlowerStore.Entity.Store;
import FlowerStore.Interface.DAO.StoreDAO;
import FlowerStore.Tools.DBUtil;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class IStore implements StoreDAO {

    @Override
    public boolean AddStore(List<Store> list) {

        Connection conn = DBUtil.getConnection();
        String sql = "insert into flowerstore values(?,?,?,?)";
        PreparedStatement ps = null;
        try {
            ps = conn.prepareStatement(sql);
            for (Store s : list) {
                ps.setInt(1, s.getStore_id());
                ps.setString(2, s.getStore_name());
                ps.setString(3, s.getStore_location());
                ps.setString(4, s.getStore_Bishours());
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

    @Override
    public List<Store> CheckAllStore() {
        Connection conn = null;
        ResultSet rs = null;
        Statement st = null;
        conn = DBUtil.getConnection();

        List<Store> list = new ArrayList<Store>();
        try {
            String sql = "select * from  flowerstore";
            st = conn.createStatement();
            rs = st.executeQuery(sql);

            while (rs.next()) {

                Store store = new Store();
                store.setStore_id(rs.getInt(1));
                store.setStore_name(rs.getString(2));
                store.setStore_location(rs.getString(3));
                store.setStore_Bishours(rs.getString(4));
                list.add(store);
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
    public boolean SetStoreName(int Store_id, String Name) {

        Connection conn = null;
        Statement st = null;
        conn = DBUtil.getConnection();
        try {
            String sql = "Update  flowerstore set store_name = '" + Name + "'" + " where store_id =" + Store_id;
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
    public boolean SetStoreLocation(int Store_id, String Location) {

        Connection conn = null;
        Statement st = null;
        conn = DBUtil.getConnection();
        try {
            String sql = "Update  flowerstore set store_location = '" + Location + "'" + " where store_id =" + Store_id;
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
    public boolean SetStoreWorkTime(int Store_id,String Time) {

        Connection conn = null;
        Statement st = null;
        conn = DBUtil.getConnection();
        try {
            String sql = "Update  flowerstore set store_Bishours = '" + Time + "'" + " where store_id =" + Store_id;
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
    public Store CheckStoreByID(int StoreID) {
        Connection conn = null;
        ResultSet rs = null;
        Statement st = null;
        conn = DBUtil.getConnection();
        try {
            String sql = "select * from  flowerstore where store_id="+StoreID;
            st = conn.createStatement();
            rs = st.executeQuery(sql);
            if (rs.next()) {
                Store store = new Store();
                store.setStore_id(rs.getInt(1));
                store.setStore_name(rs.getString(2));
                store.setStore_location(rs.getString(3));
                store.setStore_Bishours(rs.getString(4));
                return store;
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
    public Store CheckStoreByName(String Name) {
        Connection conn = null;
        ResultSet rs = null;
        Statement st = null;
        conn = DBUtil.getConnection();
        try {
            String sql = "select * from  flowerstore where store_name='"+Name+"'";
            st = conn.createStatement();
            rs = st.executeQuery(sql);
            if (rs.next()) {
                Store store = new Store();
                store.setStore_id(rs.getInt(1));
                store.setStore_name(rs.getString(2));
                store.setStore_location(rs.getString(3));
                store.setStore_Bishours(rs.getString(4));
                return store;
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
