package FlowerStore.Interface.Service;

public interface FlowerStoreService {
    public int Sell();//销售鲜花

    public void Cultivate();//培育新品种鲜花

    public void CheckNum();//查看库存

    public void CheckOrders();//查看订单

    public void CheckSales();//查看销售情况

    public boolean Login(String Name,String MyPassword);//登录

    public void In();//入库

    public void Out();//出库
}
