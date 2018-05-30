package com.maduar.springbootdemo.utils;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import javax.validation.constraints.NotNull;
import org.apache.poi.hssf.usermodel.HSSFDataValidationHelper;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.DataValidation;
import org.apache.poi.ss.usermodel.DataValidationConstraint;
import org.apache.poi.ss.usermodel.DataValidationHelper;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.util.CellRangeAddressList;
import org.apache.poi.util.IOUtils;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class CommonUtils {

    public static void main(String[] args) {
        Cascade();
    }

    public static void Cascade() {
        // 创建一个excel
        @SuppressWarnings("resource")
        Workbook book = new XSSFWorkbook();

        // 创建需要用户填写的sheet
        XSSFSheet sheetPro = (XSSFSheet) book.createSheet("省市县");
        Row row0 = sheetPro.createRow(0);
        row0.createCell(0).setCellValue("省");
        row0.createCell(1).setCellValue("市");
        row0.createCell(2).setCellValue("区");

        ProvinceAndCitySingleton provinceAndCitySingleton = new ProvinceAndCitySingleton();
        String[] provinceArr = provinceAndCitySingleton.getProvinceArr();

        Sheet hideSheet = book.createSheet("area");
        //这一行作用是将此sheet隐藏，功能未完成时注释此行,可以查看隐藏sheet中信息是否正确
        //book.setSheetHidden(book.getSheetIndex(hideSheet), true);
        CommonHelp.setData(book, hideSheet, provinceAndCitySingleton);

        CellRangeAddressList provRangeAddressList = new CellRangeAddressList(1, 20, 0, 0);
        CommonHelp.setSheet(sheetPro, provRangeAddressList, provinceArr);

//        对前20行设置有效性
        for(int i = 2;i < 20;i++){
            CommonHelp.setDataValidation("A" ,sheetPro,i,2);
            CommonHelp.setDataValidation("B" ,sheetPro,i,3);
        }


        FileOutputStream os = null;
        try {
            os = new FileOutputStream("D:/testbbb.xlsx");
            book.write(os);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            IOUtils.closeQuietly(os);
        }
    }


































    public  String createExcel(@NotNull String filePath) {

        try {

            Workbook wb = new HSSFWorkbook();
            OutputStream fileOut = new FileOutputStream(filePath);
            Sheet sheet = wb.createSheet("first");
            Row row = sheet.createRow(0);

            // 设置第一行第一个单元格
            Cell cell = row.createCell(0);
            cell.setCellValue("地区");
            // 设置第一行第二个单元格
            row.createCell(1).setCellValue("姓名");

            String [] list = {
                "性别",
                "男",
                "女"
            };

            // 设置第一行第三个单元格
            row.createCell(2).setCellValue(list[0]);

            // 生成下拉框
            // 只对（0，0, 2, 2）单元格有效   firstRow, lastRow, firstCol, lastCol
            CellRangeAddressList addressList = new CellRangeAddressList(0,0,2,2);
            this.setMutiSelectCell(sheet, addressList, list);

            wb.write(fileOut);
            wb.close();

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

        return null;
    }



    private void setMutiSelectCell(Sheet sheet, CellRangeAddressList addressList, String[] list) {
        DataValidationHelper helper = new HSSFDataValidationHelper((HSSFSheet)sheet);
        // 生成下拉框内容
        DataValidationConstraint dvConstraint  = helper.createExplicitListConstraint(list);
        // 绑定下拉框和作用区域
        DataValidation dataValidation = helper.createValidation(dvConstraint, addressList);
        // 对sheet页生效
        sheet.addValidationData(dataValidation);
    }
}
