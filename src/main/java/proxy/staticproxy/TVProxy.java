package proxy.staticproxy;

public class TVProxy implements TVCompany{
    private TVCompany tvCompany;

    public TVProxy() {
    }

    @Override
    public TV productTV() {

        System.out.println("TVProxy get order...");
        System.out.println("TVProxy start product...");
        tvCompany = new TVFactory();

        TV tv = tvCompany.productTV();
        return tv;
    }
}
