package 实验三鲜花销售系统.Interface.DAO;

import 实验三鲜花销售系统.Entity.Orders;

import java.util.List;

public interface OrdersDAO {

    public List<Orders> CheckAllMyOrders(int Customer_id);

    public List<Orders> CheckShopOrders(int Store_id);

    public boolean AddOrder(List<Orders> list);
    
}
