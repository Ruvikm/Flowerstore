package FlowerStore.Interface.DAO;

import FlowerStore.Entity.Customer;

import java.util.List;

//customer表的接口
public interface CustomerDAO {

    //修改名字
    public boolean SetCustomer_name(int Customer_id, String Name);

    //修改性别
    public boolean SetCustomer_sex(int Customer_id, String Sex);

    //修改签名
    public boolean SetCustomer_sign(int Customer_id, String Sign);

    //修改电话
    public boolean SetCustomer_phone(int Customer_id, String Phone);

    //添加用户
    public boolean AddCustomer(Customer s);

    //根据ID检索用户
    public Customer getCustomerbyId(int customerId);

    //根据名字检索用户
    public Customer getCustomerbyName(String Name);
}
