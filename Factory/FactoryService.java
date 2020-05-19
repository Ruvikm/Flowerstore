package FlowerStore.Factory;

import FlowerStore.Realize.Service.ICustomerService;
import FlowerStore.Realize.Service.IFlowerStoreService;

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
