package FlowerStore.Interface.Service;

import FlowerStore.Entity.*;

import java.util.List;

public interface CustomerService {


    //region 查询鲜花
    public Object[][] CheckAllFlowers(String head[]);

    public List<Flower> CheckFlowersByColor(String Color);

    public List<Flower> CheckFlowersByNum(int Num1,int Num2);

    public List<Flower> CheckFlowersByShop(String ShopName);

    public Flower CheckFlowersByName(String Name);

    //花的最强查询
    public Object[][] FilterFlowers(String FlowerName,String FlowerColor,String ShopName,int LowNum,int HighNum,int LowPrice,int HighPrice,String head[]);

    //endregion


    //添加到账单
    public boolean AddToOrders(List<Orders> list);

    //从购物车结账
    public int CheckOut(int CustomerID);

    //查看订单
    public Object[][] CheckMyOrder(String head[],int CustomerID);

    //登录
    public boolean C_Login(String Name, String MyPassword);

    //注册
    public boolean C_Regist(User user, Customer customer);

    //添加到购物车
    public boolean AddToList(List<ShopList> list);

    //查看购物车
    public Object[][] CheckMyList(String head[],int CustomerID);

    //删除购物车中的项目
    public boolean DeleteItem(int CustomerID,String flowerName);


}
