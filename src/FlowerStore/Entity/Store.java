package FlowerStore.Entity;

public class Store {

    private int store_id;
    private String store_name;
    private String store_location;
    private int store_manager;

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

    public int getStore_manager() {
        return store_manager;
    }

    public void setStore_manager(int store_manager) {
        this.store_manager = store_manager;
    }
}
