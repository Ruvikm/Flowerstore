package FlowerStore.Entity;

public class Flower {
    private int flower_id;//鲜花ID
    private String flower_name;//鲜花名字
    private int flower_num;//鲜花数量
    private int flower_price;//鲜花价格
    private String flower_color;//鲜花颜色
    private int store_id;//商店ID

    public int getFlower_id() {
        return flower_id;
    }

    public void setFlower_id(int flower_id) {
        this.flower_id = flower_id;
    }

    public String getFlower_name() {
        return flower_name;
    }

    public void setFlower_name(String flower_name) {
        this.flower_name = flower_name;
    }

    public int getFlower_num() {
        return flower_num;
    }

    public void setFlower_num(int flower_num) {
        this.flower_num = flower_num;
    }

    public String getFlower_color() {
        return flower_color;
    }

    public void setFlower_color(String flower_color) {
        this.flower_color = flower_color;
    }

    public int getStore_id() {
        return store_id;
    }

    public void setStore_id(int store_id) {
        this.store_id = store_id;
    }

    public int getFlower_price() {
        return flower_price;
    }

    public void setFlower_price(int flower_price) {
        this.flower_price = flower_price;
    }
}
