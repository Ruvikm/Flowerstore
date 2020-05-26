package FlowerStore.Entity;

public class User {

    private int user_id;//用户ID 默认ID为1的是管理员
    private String name;//用户名 默认用户名为root为管理员
    private String password;//密码 管理员密码123321

    public int getUser_id() {
        return user_id;
    }

    public void setUser_id(int user_id) {
        this.user_id = user_id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
