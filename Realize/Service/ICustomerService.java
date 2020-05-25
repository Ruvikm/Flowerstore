package FlowerStore.Realize.Service;

import FlowerStore.Entity.*;
import FlowerStore.Factory.FactoryDAO;
import FlowerStore.Factory.FactoryService;
import FlowerStore.Interface.Service.CustomerService;
import FlowerStore.Realize.DAO.IUser;
import com.sun.org.apache.xpath.internal.operations.Or;

import java.util.ArrayList;
import java.util.Date;
import java.text.SimpleDateFormat;
import java.util.List;

public class ICustomerService implements CustomerService {

    @Override
    public Object[][] CheckAllFlowers(String head[]) {
        //生成表格数据
        Object[][] data = null;
        List<Flower> list = FactoryDAO.getIFlowers().CheckAllFlowers();
        if (list.size()!=0) {
            data = new Object[list.size()][head.length];
            for (int i = 0; i < list.size(); i++) {
                for (int j = 0; j < head.length; j++) {
                    data[i][0] = list.get(i).getFlower_name();
                    data[i][1] = list.get(i).getFlower_price();
                    data[i][2] = list.get(i).getFlower_num();
                    data[i][3] = list.get(i).getFlower_color();
                    data[i][4] = FactoryDAO.getIStore().CheckStoreByID(list.get(i).getStore_id()).getStore_name();
                }
            }
        }
        return data;
    }

    @Override
    public List<Flower> CheckFlowersByColor(String Color) {
        return FactoryDAO.getIFlowers().CheckFlowersByColor(Color);
    }

    @Override
    public List<Flower> CheckFlowersByNum(int Num1, int Num2) {
        return FactoryDAO.getIFlowers().CheckFlowersByNum(Num1, Num2);
    }

    @Override
    public List<Flower> CheckFlowersByShop(String ShopName) {
        return FactoryDAO.getIFlowers().CheckFlowersByShops(ShopName);
    }

    @Override
    public Flower CheckFlowersByName(String Name) {
        return FactoryDAO.getIFlowers().CheckFlowersByName(Name);
    }

    @Override
    public Object[][] FilterFlowers(String FlowerName, String FlowerColor, String ShopName, int LowNum, int HighNum, int LowPrice, int HighPrice,String head[]) {
        Object [][]data=null;
        List<Flower> list=FactoryDAO.getIFlowers().PowerfulCHeck(FlowerName,FlowerColor,ShopName,LowNum,HighNum,LowPrice,HighPrice);
        data=new Object[list.size()][head.length];

        for(int i=0;i<list.size();i++){
            for(int j=0;j<head.length;j++){
                data[i][0]=list.get(i).getFlower_name();
                data[i][1]=list.get(i).getFlower_price();
                data[i][2]=list.get(i).getFlower_num();
                data[i][3]=list.get(i).getFlower_color();
                data[i][4]=FactoryDAO.getIStore().CheckStoreByID(list.get(i).getStore_id()).getStore_name();
            }
        }
        return data;
    }

    @Override
    public int CheckOut(int CustomerID) {

        int sum = 0;
        List<ShopList> list = FactoryDAO.getIShopList().CheckAllList(CustomerID);
        SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");//设置日期格式
        List<Orders> ordersList = new ArrayList<>();
        if (list != null) {
            for (ShopList s : list) {
                Orders orders=new Orders();
                //计算总价
                sum += s.getAllprice();
                //添加到账单中
                orders.setCustomer_id(CustomerID);
                orders.setFlower_id(s.getFlower_id());
                orders.setQuantity(s.getBuynum());
                orders.setDate(df.format(new Date()));
                orders.setStore_id(FactoryDAO.getIStore().CheckStoreByID(s.getFlower_id()).getStore_id());
                ordersList.add(orders);
                //删除购物车里的全部物品
                FactoryDAO.getIShopList().DeleteItem(s.getShoplist_id());
            }
            FactoryDAO.getIOrders().AddOrder(ordersList);
        }



        return sum;

    }

    @Override
    public boolean AddToOrders(List<Orders> list) {
        return FactoryDAO.getIOrders().AddOrder(list);
    }

    @Override
    public Object[][] CheckMyOrder(String head[],int CustomerID) {

        //生成表格数据
        Object[][] data = null;
        List<Orders> list = FactoryDAO.getIOrders().CheckAllMyOrders(CustomerID);
        data = new Object[list.size()][head.length];
        if (list.size() != 0) {
            for (int i = 0; i < list.size(); i++) {
                String name = FactoryDAO.getIFlowers().CheckFlowersByID(list.get(i).getFlower_id()).getFlower_name();
                int price = FactoryDAO.getIFlowers().CheckFlowersByID(list.get(i).getFlower_id()).getFlower_price();
                for (int j = 0; j < head.length; j++) {
                    data[i][0] = name;
                    data[i][1] = price;
                    data[i][2] = list.get(i).getQuantity();  // 购买数量
                    data[i][3] = list.get(i).getQuantity() * price;
                    data[i][4]=list.get(i).getDate();
                }
            }
        }
        return data;
    }

    @Override
    public boolean C_Login(String Name, String MyPassword) {

        IUser iUser = FactoryDAO.getIUser();
        String Password = iUser.CheckPassword(Name);
        if (MyPassword.equals(Password) && !Name.equals("root")) {
            return true;
        }
        return false;
    }

    @Override
    public boolean C_Regist(User user, Customer customer) {
        Customer t = FactoryDAO.getICustomer().getCustomerbyName(customer.getCustomer_name());
        //检查当前用户名是否存在
        if (t==null) {
            FactoryDAO.getICustomer().AddCustomer(customer);
            user.setUser_id(FactoryDAO.getICustomer().getCustomerbyName(customer.getCustomer_name()).getCustomer_id());
            if (FactoryDAO.getIUser().AddUser(user))
                return true;
        }
        return false;
    }

    @Override
    public boolean AddToList(List<ShopList> list) {

        for(ShopList item : list){
            //如果购物车已有就直接在上面加上购买数量
            if(FactoryDAO.getIShopList().getShopListID(item.getCustomer_id(),item.getFlower_id())!=-1){
                return FactoryDAO.getIShopList().SetItemNum(FactoryDAO.getIShopList().getShopListID(item.getCustomer_id(),item.getFlower_id()),item.getBuynum());

            }
        }
        //没有则新建一项
        return FactoryDAO.getIShopList().AddItem(list);
    }

    @Override
    public Object[][] CheckMyList(String[] head,int CustomerID) {

        //生成表格数据
        Object [][]data=null;
        List<ShopList> list=FactoryDAO.getIShopList().CheckAllList(CustomerID);
        data=new Object[list.size()][head.length];
        for(int i=0;i<list.size();i++){
            String name=FactoryDAO.getIFlowers().CheckFlowersByID(list.get(i).getFlower_id()).getFlower_name();
            int price=FactoryDAO.getIFlowers().CheckFlowersByID(list.get(i).getFlower_id()).getFlower_price();
            for(int j=0;j<head.length;j++){
                data[i][0]=name;
                data[i][1]=price;
                data[i][2]=list.get(i).getBuynum();
                data[i][3]=list.get(i).getBuynum()*price;
            }
        }
        return data;
    }

    @Override
    public boolean DeleteItem(int CustomerID, String flowerName) {

        List<ShopList> list=FactoryDAO.getIShopList().CheckAllList(CustomerID);
        for(ShopList s : list){
            String name=FactoryDAO.getIFlowers().CheckFlowersByID(s.getFlower_id()).getFlower_name();
            if(name.equals(flowerName))
            {
                FactoryDAO.getIShopList().DeleteItem(s.getShoplist_id());
                return true;
            }
        }
        return false;
    }
}
