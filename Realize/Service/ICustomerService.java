package FlowerStore.Realize.Service;

import FlowerStore.Factory.FactoryDAO;
import FlowerStore.Interface.Service.CustomerService;
import FlowerStore.Realize.DAO.IUser;

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

}
