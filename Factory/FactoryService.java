package FlowerStore.Factory;

import FlowerStore.Realize.Service.ICustomerService;
import FlowerStore.Realize.Service.IFlowerStoreService;

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
