package com.maduar.springbootdemo.utils;

import com.maduar.springbootdemo.entity.ProvinceAndCityForMappingForm;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.ObjectOutput;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.junit.Test;

public class CommonUtilsTest {


    @Test
    public void testCreateExcel() {
        List<ProvinceAndCityForMappingForm> list = new ArrayList<ProvinceAndCityForMappingForm>();
        ProvinceAndCityForMappingForm t1 = new ProvinceAndCityForMappingForm();
        t1.setProvince("安徽省");
        t1.setCity("合肥市");

        ProvinceAndCityForMappingForm t2 = new ProvinceAndCityForMappingForm();
        t2.setProvince("安徽省");
        t2.setCity("蚌埠市");

        ProvinceAndCityForMappingForm t3 = new ProvinceAndCityForMappingForm();
        t3.setProvince("北京市");
        t3.setCity("北京市");

        list.add(t1);
        list.add(t2);
        list.add(t3);

        System.out.println("===================");

        String[] provinceArray = {"安徽省", "北京市"};
        for (ProvinceAndCityForMappingForm p : list) {
            p.show();
        }

        System.out.println("===================");

        Map<String, List<String>> map = new HashMap<String, List<String>>();
        List<String> tempList = null;
        String province;
        String city;

        for (ProvinceAndCityForMappingForm p : list) {
            province = p.getProvince();
            city = p.getCity();

            if(map.get(province) == null) {
                List<String> cityList = new ArrayList<String>();
                cityList.add(city);

                map.put(province, cityList);
            } else {
                map.get(province).add(city);
            }
        }

        Map<String,String[]> areaMap = new HashMap<String, String[]>();
        int len;
        for (Map.Entry<String, List<String>> entry : map.entrySet()) {
            len = entry.getValue().size();
            String[] cityArray = entry.getValue().toArray(new String[len]);
            areaMap.put(entry.getKey(), cityArray);
        }

        for (Map.Entry<String, String[]> entry : areaMap.entrySet()) {
            System.out.println(entry.getKey() + " : " + Arrays.toString(entry.getValue()));
        }
    }

}
