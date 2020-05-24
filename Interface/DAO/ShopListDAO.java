package FlowerStore.Interface.DAO;

import FlowerStore.Entity.Flower;
import FlowerStore.Entity.ShopList;

import java.util.List;

public interface ShopListDAO {

    public List<ShopList> CheckAllList(int CustomerID);

    public boolean DeleteItem(int ListID);

    public boolean AddItem(List<ShopList> list);
}
