package FlowerStore.Interface.DAO;

import FlowerStore.Entity.Customer;

import java.util.List;

public interface CustomerDAO {

    public boolean SetCustomer_name(int Customer_id,String Name);

    public boolean SetCustomer_sex(int Customer_id,String Sex);

    public boolean SetCustomer_sign(int Customer_id,String Sign);

    public boolean SetCustomer_phone(int Customer_id,String Phone);

    public boolean AddCustomer(Customer s);

    public Customer getCustomerbyId(int customerId);

    public Customer getCustomerbyName(String Name);
}
