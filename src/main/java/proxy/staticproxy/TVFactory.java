package proxy.staticproxy;

public class TVFactory implements TVCompany{
    @Override
    public TV productTV() {
        System.out.println("TV factory product tv...");
        return new TV("小米电视","1.0");
    }
}
