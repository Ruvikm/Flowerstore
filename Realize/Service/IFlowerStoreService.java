package FlowerStore.Realize.Service;

import FlowerStore.Entity.Customer;
import FlowerStore.Entity.Flower;
import FlowerStore.Entity.Orders;
import FlowerStore.Entity.Store;
import FlowerStore.Factory.FactoryDAO;
import FlowerStore.Factory.FactoryService;
import FlowerStore.Interface.Service.FlowerStoreService;
import FlowerStore.Realize.DAO.IUser;

import javax.swing.*;
import java.util.ArrayList;
import java.util.List;

public class IFlowerStoreService implements FlowerStoreService {

    @Override
    public Object[][] Sell_CheckAllFlowers(String head[],int StoreID) {

        Object[][] data = null;
        List<Flower> list = FactoryDAO.getIFlowers().CheckFlowersByShops(FactoryDAO.getIStore().CheckStoreByID(StoreID).getStore_name());
        data = new Object[list.size()][head.length];
        if (list.size() != 0) {
            for (int i = 0; i < list.size(); i++) {
                for (int j = 0; j < head.length; j++) {
                    data[i][0] = list.get(i).getFlower_name();
                    data[i][1] = list.get(i).getFlower_price();
                    data[i][2] = list.get(i).getFlower_num();
                    data[i][3] = list.get(i).getFlower_color();
                }
            }
        }
        return data;
    }

    @Override
    public List<Flower> CheckFlowerByStoreID(int StoreID) {
        return FactoryDAO.getIFlowers().CheckFlowersByShops(FactoryDAO.getIStore().CheckStoreByID(StoreID).getStore_name());
    }

    @Override
    public List<String> CheckAllColorsByStoreID(int StoreID) {
        return FactoryDAO.getIFlowers().checkAllColorsByStoreID(StoreID);
    }

    @Override
    public Object[][] FilterFlowers(String FlowerName, String FlowerColor, String ShopName, int LowNum, int HighNum, int LowPrice, int HighPrice, String[] head) {
        Object [][]data=null;
        List<Flower> list=FactoryDAO.getIFlowers().PowerfulCHeck(FlowerName,FlowerColor,ShopName,LowNum,HighNum,LowPrice,HighPrice);
        data=new Object[list.size()][head.length];

        for(int i=0;i<list.size();i++){
            for(int j=0;j<head.length;j++){
                data[i][0]=list.get(i).getFlower_name();
                data[i][1]=list.get(i).getFlower_price();
                data[i][2]=list.get(i).getFlower_num();
                data[i][3]=list.get(i).getFlower_color();
            }
        }
        return data;
    }

    @Override
    public boolean Cultivate(List<Flower> list) {
        return FactoryDAO.getIFlowers().AddFlower(list);
    }

    @Override
    public void CheckNum() {

    }

    @Override
    public void CheckOrders() {

    }

    @Override
    public void CheckSales() {

    }

    @Override
    public boolean Login(String Name, String MyPassword) {

        IUser iUser = FactoryDAO.getIUser();
        String Password = iUser.CheckPassword(Name);
        if (Password.equals(MyPassword) && Name.equals("root")) {
            return true;
        }
        return false;

    }

    @Override
    public boolean In(int StoreID,String FlowerName,int Num) {
       return FactoryDAO.getIFlowers().InFlowers(FlowerName,Num,StoreID);
    }

    @Override
    public boolean Out(int StoreID,String FlowerName,int Num) {
        List<Flower> flowerList = new ArrayList<>();
        flowerList = FactoryDAO.getIFlowers().PowerfulCHeck(FlowerName, null, FactoryDAO.getIStore().CheckStoreByID(StoreID).getStore_name(), -1, -1, -1, -1);
        int NowNum = flowerList.get(0).getFlower_num();
        if (NowNum >= Num)
            return FactoryDAO.getIFlowers().OutFlowers(FlowerName, Num, StoreID);
        return false;
    }

    @Override
    public List<Store> CheckAllMyStore() {
        return FactoryDAO.getIStore().CheckAllStore();
    }

    @Override
    public boolean EditInformation(int StoreID, String Name, String Location, String WorkTime) {
        boolean flag1 = true;
        boolean flag2 = true;
        boolean flag3 = true;
        if (Name != null)
            if (!FactoryDAO.getIStore().SetStoreName(StoreID, Name))
                flag1 = false;
        if (Location != null)
            if (!FactoryDAO.getIStore().SetStoreLocation(StoreID, Location))
                flag2 = false;
        if (WorkTime != null)
            if (!FactoryDAO.getIStore().SetStoreWorkTime(StoreID, WorkTime))
                flag3 = false;

        return flag1 && flag2 && flag3;
    }

    @Override
    public Store CheckStoreByName(String Name) {
        return FactoryDAO.getIStore().CheckStoreByName(Name);
    }

    @Override
    public boolean ChangePassWord(int CustomerID, String OldPassWord,String NewPassWord) {
        Customer customer=FactoryDAO.getICustomer().getCustomerbyId(CustomerID);
        if(!OldPassWord.equals("")&&!NewPassWord.equals("")){
            if(OldPassWord.equals(FactoryDAO.getIUser().CheckPassword(customer.getCustomer_name()))){
                FactoryDAO.getIUser().ChangePassword(1,NewPassWord);
                return true;
            }
        }
        return false;
    }

    @Override
    public  Object[][] CheckAllStoreOrders(String head[],int StoreID) {
        Object[][] data = null;
        List<Orders> list = FactoryDAO.getIOrders().CheckShopOrders(StoreID);
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
    public Store CheckStoreByID(int StoreID) {
        return FactoryDAO.getIStore().CheckStoreByID(StoreID);
    }
}
