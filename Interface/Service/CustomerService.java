package FlowerStore.Interface.Service;

import FlowerStore.Entity.Customer;
import FlowerStore.Entity.Flower;
import FlowerStore.Entity.User;

import java.util.List;

public interface CustomerService {

    public Object[][] CheckAllFlowers(String head[]);//查询鲜花

    public void Buy();//购买鲜花

    public void CheckMyOrder();//查看订单

    public boolean C_Login(String Name, String MyPassword);//登录

    public boolean C_Regist(User user, Customer customer);
}
