package FlowerStore.Interface.Service;

import FlowerStore.Entity.Flower;
import FlowerStore.Entity.Orders;
import FlowerStore.Entity.Store;

import java.util.List;

public interface FlowerStoreService {

    public Object[][] Sell_CheckAllFlowers(String head[],int StoreID);//销售鲜花(查询所有鲜花)

    public List<Flower> CheckFlowerByStoreID(int StoreID);

    public List<String> CheckAllColorsByStoreID(int StoreID);

    public Object[][] FilterFlowers(String FlowerName, String FlowerColor, String ShopName, int LowNum, int HighNum, int LowPrice, int HighPrice,String head[]);

    public void Cultivate();//培育新品种鲜花

    public void CheckNum();//查看库存

    public void CheckOrders();//查看订单

    public void CheckSales();//查看销售情况

    public boolean Login(String Name,String MyPassword);//登录

    public void In();//入库

    public void Out();//出库

    public List<Store> CheckAllMyStore(); //查询所有店铺

    public boolean EditInformation(int StoreID,String Name,String Location,String WorkTime);//修改店铺信息

    public Store CheckStoreByName(String Name); //根据名字检索店铺

    public Store CheckStoreByID(int StoreID);

    public boolean ChangePassWord(int CustomerID,String OldPassWord,String NewPassWord);//修改密码

    public  Object[][] CheckAllStoreOrders(String head[],int StoreID); //检索该商店的所有订单
}
