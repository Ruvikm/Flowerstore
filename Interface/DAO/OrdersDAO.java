package FlowerStore.Interface.DAO;

import FlowerStore.Entity.Orders;

import java.util.List;

public interface OrdersDAO {

    public List<Orders> CheckAllMyOrders(int Customer_id);

    public List<Orders> CheckShopOrders(int Store_id);

    public boolean AddOrder(List<Orders> list);
    
}
