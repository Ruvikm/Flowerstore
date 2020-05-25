package FlowerStore.Interface.DAO;

import FlowerStore.Entity.Flower;
import FlowerStore.Entity.ShopList;

import java.util.List;

public interface ShopListDAO {

    public List<ShopList> CheckAllList(int CustomerID);

    public boolean DeleteItem(int ListID);

    public boolean AddItem(List<ShopList> list);

    public boolean SetItemNum(int ShopListID,int Num);

    public int getShopListID(int CustomerID,int FlowerID);
}