package 实验三鲜花销售系统.Interface.DAO;

import com.sun.xml.internal.ws.api.ha.StickyFeature;
import 实验三鲜花销售系统.Entity.Customer;
import 实验三鲜花销售系统.Entity.User;

import java.security.SecureRandom;
import java.util.List;

public interface UserDAO {

    public String CheckPassword(String Name);

    public boolean AddUser(List<User> list);

}
