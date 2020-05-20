package FlowerStore.Realize.Service;

import FlowerStore.Entity.Customer;
import FlowerStore.Entity.User;
import FlowerStore.Factory.FactoryDAO;
import FlowerStore.Interface.Service.CustomerService;
import FlowerStore.Realize.DAO.IUser;

import java.util.List;

public class ICustomerService implements CustomerService {

    @Override
    public void CheckFlowers() {

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
        if (Password.equals(MyPassword) && !Name.equals("root")) {
            return true;
        }
        return false;
    }

    @Override
    public boolean C_Regist(User user, Customer customer) {

        FactoryDAO.getICustomer().AddCustomer(customer);
        user.setUser_id(FactoryDAO.getICustomer().getCustomer(customer.getCustomer_name()).getCustomer_id());
        if (FactoryDAO.getIUser().AddUser(user))
            return true;
        return false;
    }

}
