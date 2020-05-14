package 实验三鲜花销售系统.Interface.Service;

public interface CustomerService {

    public void CheckFlowers();//查询鲜花

    public void Buy();//购买鲜花

    public void CheckMyOrder();//查看订单

    public boolean C_Login(String Name, String MyPassword);//登录
}
