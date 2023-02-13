package com.test.proxy.staticproxy;

public class TV {
    private String name;
    private String version;

    public TV(String name, String version) {
        this.name = name;
        this.version = version;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getVersion() {
        return version;
    }

    public void setVersion(String version) {
        this.version = version;
    }

    @Override
    public String toString() {
        return "TV{" +
                "name='" + name + '\'' +
                ", version='" + version + '\'' +
                '}';
    }
}
