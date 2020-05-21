package FlowerStore.Realize;


import FlowerStore.Entity.User;
import FlowerStore.Realize.DAO.IUser;

import java.util.ArrayList;
import java.util.List;

public class TestDAO {

    public static void main(String[] args) {

        //region IFlowers测试

        //测试 CheckFlowersByName(String Name)

        /*Scanner scanner = new Scanner(System.in);
        String name = scanner.next();
        IFlowers iFlowers = new IFlowers();
        Flower flower = Flower.getFlower();
        flower = iFlowers.CheckFlowersByName(name);
        System.out.println(flower.getFlower_id()+flower.getFlower_name()+flower.getFlower_num()+flower.getFlower_color()+flower.getStore_id());*/

        //测试 CheckFlowersByNum(int Num)

        /*Scanner scanner = new Scanner(System.in);
        int num=scanner.nextInt();
        IFlowers iFlowers = new IFlowers();
        List<Flower> list = new ArrayList<Flower>();
        list = iFlowers.CheckFlowersByNum(num);
        for(int i=0;i<list.size();i++)
        {
            Flower flower=new Flower();
            flower=list.get(i);
            System.out.println(flower.getFlower_id()+flower.getFlower_name()+flower.getFlower_num()+flower.getFlower_color()+flower.getStore_id());
        }*/


        //测试  CheckFlowersByColor(String Color)
        /*String Color="绿色";
        IFlowers iFlowers = new IFlowers();
        List<Flower> list = new ArrayList<Flower>();
        //String sql = "select * from flower where flower_color='"+Color+"'";
        //System.out.println(sql);
        list = iFlowers.CheckFlowersByColor(Color);
        for(int i=0;i<list.size();i++)
        {
            Flower flower=list.get(i);
            System.out.println(flower.getFlower_id()+flower.getFlower_name()+flower.getFlower_num()+flower.getFlower_color()+flower.getStore_id());
        }*/


        //测试 InFlowers(String Name,int Num)  ||  OutFlowers(String Name,int Num)

        /*Scanner scanner = new Scanner(System.in);
        String Name=scanner.next();
        int num=scanner.nextInt();
        IFlowers iFlowers = new IFlowers();
        iFlowers.OutFlowers(Name,num,6422);*/


        //测试 AddFlower(List<Flower> list)

        /*List<Flower> list = new ArrayList<Flower>();
        Flower flower=new Flower();
        flower.setFlower_name("GGB");
        flower.setFlower_num(200);
        flower.setFlower_color("红色");
        list.add(flower);
        IFlowers iFlowers = IFlowers.getIFlowers();
        iFlowers.AddFlower(list);*/

        //endregion


        //region ICustomers测试

        //测试 AddCustomer(List<Customer> list)

        /*List<Customer> list = new ArrayList<Customer>();
        Customer customer =Customer.getCustomer();
        customer.setCustomer_name("Ruvikm");
        customer.setCustomer_sex("男");
        customer.setCustomer_sign("Nia!");
        customer.setCustomer_phone("16693932085");
        list.add(customer);
        ICustomer iCustomer=ICustomer.getICustomer();
        iCustomer.AddCustomer(list);*/

        //测试 SetCustomer_name||SetCustomer_phone||SetCustomer_sign||SetCustomer_sex
        /*ICustomer iCustomer=ICustomer.getICustomer();
        int Customer_id=143257;
        String Name="Lord123321";
        String Sex="Man";
        String Sign="Alone";
        String Phone="999999";
        //String sql = "Update customer set customer_name = '"+ Name +"'"+ " where customer_id ="+Customer_id;
        //System.out.println(sql);
        iCustomer.SetCustomer_phone(Customer_id,Phone);*/

        //测试 getCustomer
        /*ICustomer iCustomer=ICustomer.getICustomer();
        Customer customer=Customer.getCustomer();
        String Name="Lord123321";
        String sql = "select * from customer where customer_name = '"+Name+"'";
        System.out.println(sql);
        customer=iCustomer.getCustomer(Name);
        System.out.println(customer.getCustomer_id()+customer.getCustomer_name()+customer.getCustomer_sex()+customer.getCustomer_sign()+customer.getCustomer_phone());*/


        //endregion


        //region IStore测试

        //测试 AddStore
        /*List<Store> list = new ArrayList<Store>();
        Store store=new Store();
        store.setStore_id(124355);
        store.setStore_name("Warma店");
        store.setStore_location("Warx星");
        store.setStore_manager(4124);
        list.add(store);
        IStore iStore=IStore.getIStore();
        iStore.AddStore(list);*/


        //测试 CheckAllStore
        /*List<Store> list = new ArrayList<Store>();
        IStore iStore=IStore.getIStore();
        list=iStore.CheckAllStore();
        for(int i=0;i<list.size();i++)
        {
            Store store=new Store();
            store=list.get(i);
            System.out.println(store.getStore_id()+store.getStore_name()+store.getStore_location()+store.getStore_manager());
        }*/


        //测试 SetStoreName|| SetStoreLocation || SetStoreManager

        /*String Name="沃尔玛";
        String Location="火星";
        int Manager=999;
        IStore iStore=IStore.getIStore();
        //iStore.SetStoreName(124355,Name);
        //iStore.SetStoreLocation(124355,Location);
        iStore.SetStoreManager(124355,Manager);*/


        //endregion 测试


        //region IOrders测试

        /*List<Orders> list = new ArrayList<Orders>();
        Orders orders=new Orders();
        orders.setOrders_id(543);
        orders.setFlower_id(613);
        orders.setQuantity(432);
        orders.setCustomer_id(754);
        orders.setStore_id(89);
        orders.setDate("2020/5/20");
        list.add(orders);
        IOrders iOrders =new IOrders();
        iOrders.AddOrder(list);*/

        //测试 CheckAllMyOrders || CheckShopOrders
        /*IOrders iOrders = new IOrders();
        List<Orders> list = new ArrayList<Orders>();
        list = iOrders.CheckShopOrders(4);
        for(int i=0;i<list.size();i++)
        {
            Orders orders=new Orders();
            orders=list.get(i);
            System.out.println(orders.getOrders_id());
            System.out.println(orders.getFlower_id());
            System.out.println(orders.getQuantity());
            System.out.println(orders.getStore_id());
            System.out.println(orders.getCustomer_id());
            System.out.println(orders.getDate());
        }*/

        //endregion


        //region User测试

        //测试 AddUser
       /* List<User> list = new ArrayList<User>();
        User user=new User();
        user.setUser_id(11);
        user.setName("Ruvik");
        user.setPassword("123321");
        list.add(user);
        IUser iUser=new IUser();
        iUser.AddUser(list);*/


        //测试 CheckPassword
        /*IUser iUser=new IUser();
        System.out.println(iUser.CheckPassword("Ruvik"));*/


        //测试ChangePassword
        /*String NewPassword="123321";
        String Name="Ruvikm";
        String sql = "Update user set password = '" + NewPassword + "'" + " where name =" + "''" + Name + "'";
*/

        //endregion


    }

}
