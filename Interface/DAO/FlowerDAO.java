package FlowerStore.Interface.DAO;

import FlowerStore.Entity.Flower;

import java.util.List;

//flower表的接口
public interface FlowerDAO {

    //根据名字查询鲜花
    public Flower CheckFlowersByName(String Name);

    //根据ID查询鲜花
    public Flower CheckFlowersByID(int flowerID);

    //根据数量查询鲜花
    public List<Flower> CheckFlowersByNum(int Num1,int Num2);

    //根据颜色查询鲜花
    public List<Flower> CheckFlowersByColor(String Color);

    //根据店铺名字查询鲜花
    public List<Flower> CheckFlowersByShops(String ShopName);

    //出库鲜花
    public boolean OutFlowers(String Name,int Num,int Store_id);

    //入库鲜花
    public boolean InFlowers(String Name,int Num,int Store_id);

    //培育新鲜花
    public boolean AddFlower(List<Flower> list);

    //查询所有鲜花
    public List<Flower> CheckAllFlowers();

    //查询所有颜色
    public List<String> checkAllColors();

    public List<String> checkAllColorsByStoreID(int StoreID);

    //查询所有店铺ID
    public List<Integer> checkAllShops();

    //最强查询,参数有效则生效
    public List<Flower> PowerfulCHeck(String FlowerName,String FlowerColor,String ShopName,int LowNum,int HighNum,int LowPrice,int HighPrice);

}
