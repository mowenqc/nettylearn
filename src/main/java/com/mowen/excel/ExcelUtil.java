package com.mowen.excel;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

/***
 * @description : 
 *
 * @author: mowen
 * @time: 2019/6/27 14:20
 * @since: v1.0
 */
public class ExcelUtil {

    public static Map<Integer, List<List<Object>>> extractExcel(String path) throws IOException {
        if(path == null || path == ""){
            throw new IllegalArgumentException("path 不能为空~");
        }
        File file = new File(path);
        if(!file.exists()){
            throw new IllegalArgumentException("路径文件不存在");
        }
        FileInputStream inputStream = new FileInputStream(file);
        String p = path.toLowerCase();
        if(p.endsWith(".xls")){
            return extractXls(inputStream);
        }
        else if(p.endsWith(".xlsx")){
            return extractXlsx(inputStream);
        }
        else {
           throw new IllegalArgumentException("文件格式不对，不能解析");
        }
    }

    private static Map<Integer, List<List<Object>>> extractXls(FileInputStream inputStream)
        throws IOException {
        Workbook workbook = new HSSFWorkbook(inputStream);
        return getIntegerListMap(workbook);
    }

    public static Map<Integer, List<List<Object>>> extractXlsx(InputStream inputStream) throws IOException {
        Workbook workbook = new XSSFWorkbook(inputStream);
        return getIntegerListMap(workbook);
    }

    private static Map<Integer, List<List<Object>>> getIntegerListMap(Workbook workbook) {
        int sheetIndex = workbook.getNumberOfSheets();
        Sheet sheetAt;
        Map<Integer, List<List<Object>>> listHashMap = new HashMap<>();
        List<List<Object>> lists;
        for(int i = 0; i < sheetIndex; i++){
            sheetAt = workbook.getSheetAt(i);
            lists = new ArrayList<>();
            for (Row row: sheetAt){
                List<Object> objects = new ArrayList<>();
                int firstNum = 0;
                int lastNum = row.getLastCellNum();
                System.out.println("first=" + firstNum + ", last=" + lastNum);
                for(int j = firstNum;j < lastNum; j++){
                    Cell cell = row.getCell(j);
                    Object cellData = getCellData(cell);
                    objects.add(cellData);
                }
                lists.add(objects);
            }
            listHashMap.put(i, lists);
        }
        return listHashMap;
    }

    private static Object getCellData(Cell cell){
        if(cell == null){
            return new Null();
        }
        int cellType = cell.getCellType();
        Object object = new Null();
        if(cellType == 3){
            return new Null();
        }
        else if(cellType == 4){
            object =  cell.getBooleanCellValue();
        }
        else if(cellType == 1 || cellType == 2){
            object =  cell.getStringCellValue();
        }
        else if(cellType == 0){
            object =  Double.valueOf(cell.getNumericCellValue()).toString();
        }
        else if(cellType == 5){
            object = cell.getErrorCellValue();
        }
        else {
            try {
                object = cell.getDateCellValue();
            }
            catch (Exception e){
                System.out.println(e.getMessage());
            }
        }
        System.out.println("读取cell的值：" + object);
        return object;
    }

    public static class Null{
        public static Object NULL = null;
    }
    public static void main(String[] args) {
        String path = "D:\\demo.xlsx";
        try {
            Map<Integer, List<List<Object>>> integerListMap = extractExcel(path);
            System.out.println(integerListMap);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
