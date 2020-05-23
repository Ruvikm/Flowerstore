package FlowerStore.Realize.DAO;

import FlowerStore.Entity.Flower;
import FlowerStore.Interface.DAO.ShopListDAO;

import java.util.List;

public class IShopList implements ShopListDAO {

    @Override
    public List<Flower> CheckAllList(String CustomerID) {
        return null;
    }

    @Override
    public boolean DeleteItem(String ListID) {
        return false;
    }

}
