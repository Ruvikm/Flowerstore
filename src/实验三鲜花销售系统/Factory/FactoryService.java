package 实验三鲜花销售系统.Factory;

import 实验三鲜花销售系统.Interface.Service.FlowerStoreService;
import 实验三鲜花销售系统.Realize.DAO.IUser;
import 实验三鲜花销售系统.Realize.Service.ICustomerService;
import 实验三鲜花销售系统.Realize.Service.IFlowerStoreService;

public class FactoryService {

    public static FactoryService factoryService=new FactoryService();

    public FactoryService getFactoryService(){
        return factoryService;
    }

    public IFlowerStoreService getFlowerStoreService(){
        return new IFlowerStoreService();
    }

    public ICustomerService getiCustomerService(){
        return new ICustomerService();
    }

}
