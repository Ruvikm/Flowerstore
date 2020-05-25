package FlowerStore.Interface.Service;

import FlowerStore.Entity.*;

import java.util.List;

public interface CustomerService {

    public Object[][] CheckAllFlowers(String head[]);//查询鲜花

    public List<Flower> CheckFlowersByColor(String Color);

    public List<Flower> CheckFlowersByNum(int Num1,int Num2);

    public List<Flower> CheckFlowersByShop(String ShopName);

    public Flower CheckFlowersByName(String Name);

    public boolean AddToOrders(List<Orders> list);

    public int CheckOut(int CustomerID);//购买鲜花

    public Object[][] CheckMyOrder(String head[],int CustomerID);//查看订单

    public boolean C_Login(String Name, String MyPassword);//登录

    public boolean C_Regist(User user, Customer customer);

    public Object[][] FilterFlowers(String FlowerName,String FlowerColor,String ShopName,int LowNum,int HighNum,int LowPrice,int HighPrice,String head[]);

    public boolean AddToList(List<ShopList> list);//添加到购物车

    public Object[][] CheckMyList(String head[],int CustomerID); //查看购物车

    public boolean DeleteItem(int CustomerID,String flowerName); //删除购物车中的项目




}
