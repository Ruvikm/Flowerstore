package FlowerStore.Interface.DAO;

import FlowerStore.Entity.Store;

import java.util.List;

public interface StoreDAO {

    public boolean AddStore(List<Store> list);

    public List<Store> CheckAllStore();

    public boolean SetStoreName(int Store_id,String Name);

    public boolean SetStoreLocation(int Store_id,String Location);

    public boolean SetStoreManager(int Store_id,int store_manager);


}
