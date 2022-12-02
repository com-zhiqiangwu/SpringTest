package proxy;

import service.SomeService;
import service.impl.ISomeServiceImpl;

public class ISomeServiceStaticProxyImpl implements SomeService {
    private ISomeServiceImpl  iSomeService;

    public ISomeServiceStaticProxyImpl(ISomeServiceImpl iSomeService) {
        this.iSomeService = iSomeService;
    }

    @Override
    public void doSome() {
        System.out.println("调用方法之前动作");
        iSomeService.doSome();
        System.out.println("调用方法之后的动作");
    }
}
