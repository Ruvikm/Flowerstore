package 实验三鲜花销售系统.Realize.Service;

import 实验三鲜花销售系统.Factory.FactoryDAO;
import 实验三鲜花销售系统.Interface.Service.CustomerService;
import 实验三鲜花销售系统.Realize.DAO.IUser;

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
