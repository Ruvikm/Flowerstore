package FlowerStore.Entity;

public class Store {

    private int store_id;//商店ID
    private String store_name;//商店名字
    private String store_location;//商店位置
    private String store_Bishours;//营业时间

    public int getStore_id() {
        return store_id;
    }

    public void setStore_id(int store_id) {
        this.store_id = store_id;
    }

    public String getStore_name() {
        return store_name;
    }

    public void setStore_name(String store_name) {
        this.store_name = store_name;
    }

    public String getStore_location() {
        return store_location;
    }

    public void setStore_location(String store_location) {
        this.store_location = store_location;
    }

    public String getStore_Bishours() {
        return store_Bishours;
    }

    public void setStore_Bishours(String store_Bishours) {
        this.store_Bishours = store_Bishours;
    }
}
