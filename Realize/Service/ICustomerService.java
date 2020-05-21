package FlowerStore.Realize.Service;

import FlowerStore.Entity.Customer;
import FlowerStore.Entity.Flower;
import FlowerStore.Entity.User;
import FlowerStore.Factory.FactoryDAO;
import FlowerStore.Factory.FactoryService;
import FlowerStore.Interface.Service.CustomerService;
import FlowerStore.Realize.DAO.IUser;

import java.util.List;

public class ICustomerService implements CustomerService {

    @Override
    public List<Flower> CheckAllFlowers() {
        return FactoryDAO.getIFlowers().CheckAllFlowers();
    }

    @Override
    public void Buy() {

    }

    @Override
    public void CheckMyOrder() {

    }

    @Override
    public boolean C_Login(String Name, String MyPassword) {

        IUser iUser = FactoryDAO.getIUser();
        String Password = iUser.CheckPassword(Name);
        if (MyPassword.equals(Password) && !Name.equals("root")) {
            return true;
        }
        return false;
    }

    @Override
    public boolean C_Regist(User user, Customer customer) {
        Customer t = FactoryDAO.getICustomer().getCustomerbyName(customer.getCustomer_name());
        //检查当前用户名是否存在
        if (t==null) {
            FactoryDAO.getICustomer().AddCustomer(customer);
            user.setUser_id(FactoryDAO.getICustomer().getCustomerbyName(customer.getCustomer_name()).getCustomer_id());
            if (FactoryDAO.getIUser().AddUser(user))
                return true;
        }
        return false;
    }

}
