package com.maduar.springbootdemo.entity;

public class ProvinceAndCityForMappingForm {
    private String province;
    private String city;

    public String getProvince() {
        return province;
    }

    public void setProvince(String province) {
        this.province = province;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public void show() {
        System.out.println("province: " + province + ",  city: " + city);
    }
}