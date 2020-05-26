package FlowerStore.Interface.DAO;

import FlowerStore.Entity.Store;

import java.util.List;

//flowerstore表的接口

public interface StoreDAO {

    public boolean AddStore(List<Store> list);

    public List<Store> CheckAllStore();

    public boolean SetStoreName(int Store_id,String Name);

    public boolean SetStoreLocation(int Store_id,String Location);

    public boolean SetStoreWorkTime(int Store_id,String Time);

    public Store CheckStoreByID(int StoreID);

    public Store CheckStoreByName(String Name);


}
