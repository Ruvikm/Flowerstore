package FlowerStore.Interface.DAO;

import FlowerStore.Entity.Flower;

import java.util.List;

public interface ShopListDAO {

    public List<Flower> CheckAllList(String CustomerID);

    public boolean DeleteItem(String ListID);
}
