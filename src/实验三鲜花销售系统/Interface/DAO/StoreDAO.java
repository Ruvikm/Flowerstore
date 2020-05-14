package 实验三鲜花销售系统.Interface.DAO;

import 实验三鲜花销售系统.Entity.Customer;
import 实验三鲜花销售系统.Entity.Flower;
import 实验三鲜花销售系统.Entity.Store;

import java.util.List;

public interface StoreDAO {

    public boolean AddStore(List<Store> list);

    public List<Store> CheckAllStore();

    public boolean SetStoreName(int Store_id,String Name);

    public boolean SetStoreLocation(int Store_id,String Location);

    public boolean SetStoreManager(int Store_id,int store_manager);


}
