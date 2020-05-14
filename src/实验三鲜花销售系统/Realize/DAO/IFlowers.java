package 实验三鲜花销售系统.Realize.DAO;

import 实验三鲜花销售系统.Entity.Flower;
import 实验三鲜花销售系统.Interface.DAO.FlowerDAO;
import 连接数据库demo.DBUtil;
import 连接数据库demo.pojo.Student;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

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
            flower.setFlower_color(rs.getString(4));
            flower.setStore_id(rs.getInt(5));
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
                flower.setFlower_color(rs.getString(4));
                flower.setStore_id(rs.getInt(5));
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
                flower.setFlower_color(rs.getString(4));
                flower.setStore_id(rs.getInt(5));
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
        String sql = "insert into flower values(?,?,?,?,?)";
        PreparedStatement ps = null;
        try {
            ps = conn.prepareStatement(sql);
            for(Flower s : list){
                ps.setInt(1, s.getFlower_id());
                ps.setString(2, s.getFlower_name());
                ps.setInt(3,s.getFlower_num());
                ps.setString(4,s.getFlower_color());
                ps.setInt(5,s.getStore_id());
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
