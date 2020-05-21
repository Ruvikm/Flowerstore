package FlowerStore.Interface.DAO;

import FlowerStore.Entity.User;

import java.util.List;

public interface UserDAO {

    public String CheckPassword(String Name);

    public boolean AddUser(User s);

    public boolean ChangePassword(int id,String NewPassword);

}
