package 实验三鲜花销售系统.Interface.DAO;

import 实验三鲜花销售系统.Entity.Customer;
import 实验三鲜花销售系统.Entity.Flower;
import 实验三鲜花销售系统.Entity.Orders;

import java.util.List;

public interface CustomerDAO {

    public boolean SetCustomer_name(int Customer_id,String Name);

    public boolean SetCustomer_sex(int Customer_id,String Sex);

    public boolean SetCustomer_sign(int Customer_id,String Sign);

    public boolean SetCustomer_phone(int Customer_id,String Phone);

    public boolean AddCustomer(List<Customer> list);

    public Customer getCustomer(String Name);
}
