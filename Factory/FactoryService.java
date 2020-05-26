package FlowerStore.Factory;

import FlowerStore.Realize.Service.ICustomerService;
import FlowerStore.Realize.Service.IFlowerStoreService;

//服务工厂，分发与界面交互的接口
public class FactoryService {

    private static FactoryService factoryService =new FactoryService();

    public static FactoryService getFactoryService(){
        return factoryService;
    }

    public static IFlowerStoreService getFlowerStoreService(){
        return new IFlowerStoreService();
    }

    public static ICustomerService getiCustomerService(){
        return new ICustomerService();
    }

}
