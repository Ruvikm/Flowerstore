package FlowerStore.Interface.DAO;

import FlowerStore.Entity.Orders;

import java.util.List;

//orders表的接口
public interface OrdersDAO {

    //检索当前顾客ID的所有订单
    public List<Orders> CheckAllMyOrders(int Customer_id);

    //检索当前商店ID的所有订单
    public List<Orders> CheckShopOrders(int Store_id);

    //添加订单
    public boolean AddOrder(List<Orders> list);
    
}
