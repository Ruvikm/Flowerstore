package FlowerStore.Realize.DAO;

import FlowerStore.Entity.Flower;
import FlowerStore.Interface.DAO.FlowerDAO;
import FlowerStore.Tools.DBUtil;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class IFlowers implements FlowerDAO {

    @Override
    public Flower CheckFlowersByName(String Name) {

        Connection conn = null;
        ResultSet rs = null;
        Statement st = null;
        conn = DBUtil.getConnection();

        Flower flower=new Flower();
        try {
            String sql = "select * from flower where flower_name='"+Name+"'";
            st = conn.createStatement();
            rs = st.executeQuery(sql);

            rs.next();
            flower.setFlower_id(rs.getInt(1));
            flower.setFlower_name(rs.getString(2));
            flower.setFlower_num(rs.getInt(3));
            flower.setFlower_price(rs.getInt(4));
            flower.setFlower_color(rs.getString(5));
            flower.setStore_id(rs.getInt(6));
            return flower;

        } catch (SQLException throwable) {
            throwable.printStackTrace();
        }finally{
            DBUtil.close(conn, st, null, rs);
        }
        return null;
    }

    @Override
    public List<Flower> CheckFlowersByNum(int Num) {
        Connection conn = null;
        ResultSet rs = null;
        Statement st = null;
        conn = DBUtil.getConnection();

        List<Flower> list = new ArrayList<Flower>();
        try {
            String sql = "select * from flower where flower_num>='"+Num+"'";
            st = conn.createStatement();
            rs = st.executeQuery(sql);

            while(rs.next()){

                Flower flower=new Flower();
                flower.setFlower_id(rs.getInt(1));
                flower.setFlower_name(rs.getString(2));
                flower.setFlower_num(rs.getInt(3));
                flower.setFlower_price(rs.getInt(4));
                flower.setFlower_color(rs.getString(5));
                flower.setStore_id(rs.getInt(6));
                list.add(flower);
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
    public List<Flower> CheckFlowersByColor(String Color) {
        Connection conn = null;
        ResultSet rs = null;
        Statement st = null;
        conn = DBUtil.getConnection();

        List<Flower> list = new ArrayList<Flower>();
        try {
            String sql = "select * from flower where flower_color='"+Color+"'";
            st = conn.createStatement();
            rs = st.executeQuery(sql);

            while(rs.next()){

                Flower flower=new Flower();
                flower.setFlower_id(rs.getInt(1));
                flower.setFlower_name(rs.getString(2));
                flower.setFlower_num(rs.getInt(3));
                flower.setFlower_price(rs.getInt(4));
                flower.setFlower_color(rs.getString(5));
                flower.setStore_id(rs.getInt(6));
                list.add(flower);
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
    public boolean InFlowers(String Name,int Num,int Store_id) {

        Connection conn = null;
        Statement st = null;
        conn = DBUtil.getConnection();
        try {
            String sql = "Update flower set flower_num = flower_num +"+ Num + " where flower_name ='"+Name+"'"+ "and store_id= " +Store_id;
            st = conn.createStatement();
            st.execute(sql);
            return true;
        } catch (SQLException throwable) {
            throwable.printStackTrace();
        }finally{
            DBUtil.close(conn, st, null, null);
        }
        return false;

        

    }

    @Override
    public boolean OutFlowers(String Name,int Num,int Store_id) {

        Connection conn = null;
        Statement st = null;
        conn = DBUtil.getConnection();
        try {
            String sql = "Update flower set flower_num = flower_num -"+ Num + " where flower_name ='"+Name+"'" + "and store_id= " +Store_id;
            st = conn.createStatement();
            st.execute(sql);
            return true;
        } catch (SQLException throwable) {
            throwable.printStackTrace();
        }finally{
            DBUtil.close(conn, st, null, null);
        }
        return false;
    }

    @Override
    public boolean AddFlower(List<Flower> list) {

        Connection conn = DBUtil.getConnection();
        String sql = "insert into flower values(?,?,?,?,?,?)";
        PreparedStatement ps = null;
        try {
            ps = conn.prepareStatement(sql);
            for(Flower s : list){
                ps.setInt(1, s.getFlower_id());
                ps.setString(2, s.getFlower_name());
                ps.setInt(3,s.getFlower_num());
                ps.setInt(4,s.getFlower_price());
                ps.setString(5,s.getFlower_color());
                ps.setInt(6,s.getStore_id());
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

    @Override
    public List<Flower> CheckAllFlowers() {
        Connection conn = null;
        ResultSet rs = null;
        Statement st = null;
        conn = DBUtil.getConnection();

        List<Flower> list = new ArrayList<Flower>();
        try {
            String sql = "select * from flower";
            st = conn.createStatement();
            rs = st.executeQuery(sql);

            while(rs.next()){
                Flower flower=new Flower();
                flower.setFlower_id(rs.getInt(1));
                flower.setFlower_name(rs.getString(2));
                flower.setFlower_num(rs.getInt(3));
                flower.setFlower_price(rs.getInt(4));
                flower.setFlower_color(rs.getString(5));
                flower.setStore_id(rs.getInt(6));
                list.add(flower);
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
    public List<String> checkAllColors() {
        Connection conn = null;
        ResultSet rs = null;
        Statement st = null;
        conn = DBUtil.getConnection();

        List<String> list = new ArrayList<>();
        try {
            String sql = "SELECT  DISTINCT flower_color FROM flower";
            st = conn.createStatement();
            rs = st.executeQuery(sql);

            while(rs.next()){
                Flower flower=new Flower();
                flower.setFlower_color(rs.getString(1));
                list.add(flower.getFlower_color());
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
    public List<Integer> checkAllShops() {
        Connection conn = null;
        ResultSet rs = null;
        Statement st = null;
        conn = DBUtil.getConnection();

        List<Integer> list = new ArrayList<>();
        try {
            String sql = "SELECT  DISTINCT store_id FROM flower";
            st = conn.createStatement();
            rs = st.executeQuery(sql);

            while(rs.next()){
                Flower flower=new Flower();
                flower.setStore_id(rs.getInt(1));
                list.add(flower.getStore_id());
            }
            return list;

        } catch (SQLException throwable) {
            throwable.printStackTrace();
        }finally{
            DBUtil.close(conn, st, null, rs);
        }
        return null;
    }
}
