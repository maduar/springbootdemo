package com.maduar.springbootdemo.xls;

import java.util.Map;
import org.apache.poi.hssf.usermodel.HSSFDataValidation;
import org.apache.poi.hssf.usermodel.HSSFDataValidationHelper;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.DataValidation;
import org.apache.poi.ss.usermodel.DataValidationConstraint;
import org.apache.poi.ss.usermodel.DataValidationHelper;
import org.apache.poi.ss.usermodel.Name;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.util.CellRangeAddressList;


public class CommonHelp {

    public static void setSheet(HSSFSheet sheetPro, CellRangeAddressList provRangeAddressList, String[] provinceArr) {
        DataValidationHelper helper = new HSSFDataValidationHelper((HSSFSheet)sheetPro);
        // 生成下拉框内容
        DataValidationConstraint dvConstraint  = helper.createExplicitListConstraint(provinceArr);
        // 绑定下拉框和作用区域
        DataValidation dataValidation = helper.createValidation(dvConstraint, provRangeAddressList);
        // 对sheet页生效
        sheetPro.addValidationData(dataValidation);
    }


    /**
     * 设置有效性
     * @param offset 主影响单元格所在列，即此单元格由哪个单元格影响联动
     * @param sheet
     * @param rowNum 行数
     * @param colNum 列数
     */
    public static void setDataValidation(String offset,HSSFSheet sheet, int rowNum,int colNum) {
        DataValidationHelper dvHelper = new HSSFDataValidationHelper(sheet);
        DataValidation data_validation_list;
        data_validation_list = getDataValidationByFormula(
            "INDIRECT($" + offset + (rowNum) + ")", rowNum, colNum,dvHelper);
        sheet.addValidationData(data_validation_list);
    }

    /**
     * 加载下拉列表内容
     * @param formulaString
     * @param naturalRowIndex
     * @param naturalColumnIndex
     * @param dvHelper
     * @return
     */
    private static  DataValidation getDataValidationByFormula(
        String formulaString, int naturalRowIndex, int naturalColumnIndex,DataValidationHelper dvHelper) {
        // 加载下拉列表内容
        // 举例：若formulaString = "INDIRECT($A$2)" 表示规则数据会从名称管理器中获取key与单元格 A2 值相同的数据，
        //如果A2是江苏省，那么此处就是江苏省下的市信息。
        DataValidationConstraint dvConstraint = dvHelper.createFormulaListConstraint(formulaString);
        // 设置数据有效性加载在哪个单元格上。
        // 四个参数分别是：起始行、终止行、起始列、终止列
        int firstRow = naturalRowIndex -1;
        int lastRow = naturalRowIndex - 1;
        int firstCol = naturalColumnIndex - 1;
        int lastCol = naturalColumnIndex - 1;
        CellRangeAddressList regions = new CellRangeAddressList(firstRow,
            lastRow, firstCol, lastCol);
        // 数据有效性对象
        // 绑定
        DataValidation data_validation_list = (HSSFDataValidation) dvHelper.createValidation(dvConstraint, regions);
        data_validation_list.setEmptyCellAllowed(false);
        if (data_validation_list instanceof HSSFDataValidation) {
            data_validation_list.setSuppressDropDownArrow(true);
            data_validation_list.setShowErrorBox(true);
        } else {
            data_validation_list.setSuppressDropDownArrow(false);
        }
        // 设置输入信息提示信息
        data_validation_list.createPromptBox("下拉选择提示", "请使用下拉方式选择合适的值！");
        // 设置输入错误提示信息
        //data_validation_list.createErrorBox("选择错误提示", "你输入的值未在备选列表中，请下拉选择合适的值！");
        return data_validation_list;
    }

    /**
     *  计算formula
     * @param offset 偏移量，如果给0，表示从A列开始，1，就是从B列
     * @param rowId 第几行
     * @param colCount 一共多少列
     * @return 如果给入参 1,1,10. 表示从B1-K1。最终返回 $B$1:$K$1
     *
     */
    public static String getRange(int offset, int rowId, int colCount) {
        char start = (char)('A' + offset);
        if (colCount <= 25) {
            char end = (char)(start + colCount - 1);
            return "$" + start + "$" + rowId + ":$" + end + "$" + rowId;
        } else {
            char endPrefix = 'A';
            char endSuffix = 'A';
            if ((colCount - 25) / 26 == 0 || colCount == 51) {// 26-51之间，包括边界（仅两次字母表计算）
                if ((colCount - 25) % 26 == 0) {// 边界值
                    endSuffix = (char)('A' + 25);
                } else {
                    endSuffix = (char)('A' + (colCount - 25) % 26 - 1);
                }
            } else {// 51以上
                if ((colCount - 25) % 26 == 0) {
                    endSuffix = (char)('A' + 25);
                    endPrefix = (char)(endPrefix + (colCount - 25) / 26 - 1);
                } else {
                    endSuffix = (char)('A' + (colCount - 25) % 26 - 1);
                    endPrefix = (char)(endPrefix + (colCount - 25) / 26);
                }
            }
            return "$" + start + "$" + rowId + ":$" + endPrefix + endSuffix + "$" + rowId;
        }
    }


    public static void setData(Workbook book, Sheet hideSheet, ProvinceAndCitySingleton provinceAndCitySingleton) {
        int rowId = 0;
        // 设置第一行，存省的信息

        String[] provinceArr = provinceAndCitySingleton.getProvinceArr();
        String[] areaFatherNameArr = provinceAndCitySingleton.getAreaFatherNameArr();
        Map<String,String[]> areaMap = provinceAndCitySingleton.getAreaMap();

        Row provinceRow = hideSheet.createRow(rowId++);
        provinceRow.createCell(0).setCellValue("省列表");
        for(int i = 0; i < provinceArr.length; i ++){
            Cell provinceCell = provinceRow.createCell(i + 1);
            provinceCell.setCellValue(provinceArr[i]);
        }
        // 将具体的数据写入到每一行中，行开头为父级区域，后面是子区域。
        for(int i = 0;i < areaFatherNameArr.length;i++){
            String key = areaFatherNameArr[i];
            String[] son = areaMap.get(key);
            Row row = hideSheet.createRow(rowId++);
            row.createCell(0).setCellValue(key);
            for(int j = 0; j < son.length; j ++){
                Cell cell = row.createCell(j + 1);
                cell.setCellValue(son[j]);
            }

            // 添加名称管理器
            String range = CommonHelp.getRange(1, rowId, son.length);
            Name name = book.createName();
            //key不可重复
            name.setNameName(key);
            String formula = "area!" + range;
            name.setRefersToFormula(formula);
        }
    }
}
