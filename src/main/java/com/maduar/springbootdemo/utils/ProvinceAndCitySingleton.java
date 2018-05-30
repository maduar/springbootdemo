package com.maduar.springbootdemo.utils;

import java.util.HashMap;
import java.util.Map;

public class ProvinceAndCitySingleton {

    private String[] provinceArr;
    private String[] areaFatherNameArr;
    Map<String,String[]> areaMap;

    public ProvinceAndCitySingleton() {
        initProvinceArr();
        initAreaFatherNameArr();
        initAreaMap();
    }

    public String[] getProvinceArr() {
        return provinceArr;
    }

    public String[] getAreaFatherNameArr() {
        return areaFatherNameArr;
    }

    public Map<String, String[]> getAreaMap() {
        return areaMap;
    }

    private void initProvinceArr() {
        String[] provinceArr = {"江苏省","安徽省"};
        this.provinceArr = provinceArr;
    }

    private void initAreaFatherNameArr() {
        String[] areaFatherNameArr ={"江苏省","安徽省","南京市","苏州市","盐城市","合肥市","安庆市"};
        this.areaFatherNameArr = areaFatherNameArr;
    }

    private void initAreaMap() {
        //得到第一级省名称，放在列表里

        //依次列出各省的市、各市的县
        String[] cityJiangSu = {"南京市","苏州市","盐城市"};
        String[] cityAnHui = {"合肥市","安庆市"};
        String[] countyNanjing = {"六合县","江宁县"};
        String[] countySuzhou = {"姑苏区","园区"};
        String[] countyYancheng = {"响水县","射阳县"};
        String[] countyLiuhe = {"瑶海区","庐阳区"};
        String[] countyAnQing = {"迎江区","大观区"};
        //将有子区域的父区域放到一个数组中
        Map<String,String[]> areaMap = new HashMap<String, String[]>();
        areaMap.put("江苏省", cityJiangSu);
        areaMap.put("安徽省",cityAnHui);
        areaMap.put("南京市",countyNanjing);
        areaMap.put("苏州市", countySuzhou);
        areaMap.put("盐城市",countyYancheng);
        areaMap.put("合肥市",countyYancheng);
        areaMap.put("合肥市", countyLiuhe);
        areaMap.put("安庆市",countyAnQing);

        this.areaMap = areaMap;
    }


}
