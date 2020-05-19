package FlowerStore.Realize.Service;

import FlowerStore.Factory.FactoryDAO;
import FlowerStore.Interface.Service.FlowerStoreService;
import FlowerStore.Realize.DAO.IUser;

public class IFlowerStoreService implements FlowerStoreService {

    @Override
    public int Sell() {
        return 0;
    }

    @Override
    public void Cultivate() {

    }

    @Override
    public void CheckNum() {

    }

    @Override
    public void CheckOrders() {

    }

    @Override
    public void CheckSales() {

    }

    @Override
    public boolean Login(String Name, String MyPassword) {

        IUser iUser = FactoryDAO.getIUser();
        String Password = iUser.CheckPassword(Name);
        if (Password.equals(MyPassword) && Name.equals("root")) {
            return true;
        }
        return false;

    }

    @Override
    public void In() {

    }

    @Override
    public void Out() {

    }
}
