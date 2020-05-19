package FlowerStore.Interface.DAO;

import FlowerStore.Entity.Flower;

import java.util.List;

public interface FlowerDAO {

    //根据名字查询鲜花
    public Flower CheckFlowersByName(String Name);

    //根据数量查询鲜花
    public List<Flower> CheckFlowersByNum(int Num);

    //根据颜色查询鲜花
    public List<Flower> CheckFlowersByColor(String Color);

    //出库鲜花
    public boolean OutFlowers(String Name,int Num,int Store_id);

    //入库鲜花
    public boolean InFlowers(String Name,int Num,int Store_id);

    //培育新鲜花
    public boolean AddFlower(List<Flower> list);

}
