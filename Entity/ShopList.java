package FlowerStore.Entity;

public class ShopList {
    private int shoplist_id;
    private int customer_id;
    private int flower_id;
    private int buynum;
    private int allprice;

    public int getAllprice() {
        return allprice;
    }

    public void setAllprice(int allprice) {
        this.allprice = allprice;
    }

    public int getBuynum() {
        return buynum;
    }

    public void setBuynum(int buynum) {
        this.buynum = buynum;
    }

    public int getShoplist_id() {
        return shoplist_id;
    }

    public void setShoplist_id(int shoplist_id) {
        this.shoplist_id = shoplist_id;
    }

    public int getCustomer_id() {
        return customer_id;
    }

    public void setCustomer_id(int customer_id) {
        this.customer_id = customer_id;
    }

    public int getFlower_id() {
        return flower_id;
    }

    public void setFlower_id(int flower_id) {
        this.flower_id = flower_id;
    }
}
