package 实验三鲜花销售系统.Factory;

import 实验三鲜花销售系统.Realize.DAO.*;

public class FactoryDAO {

    private static FactoryDAO factoryDAO =new FactoryDAO();

    public static FactoryDAO getFactoryDAO(){
        return factoryDAO;
    }

    public static IFlowers getIFlowers(){
        return new IFlowers();
    }

    public static IOrders getIOrders(){
        return new IOrders();
    }

    public static IStore getIStore(){
        return new IStore();
    }

    public static ICustomer getICustomer(){
        return new ICustomer();
    }

    public static IUser getIUser(){
        return new IUser();
    }

}
