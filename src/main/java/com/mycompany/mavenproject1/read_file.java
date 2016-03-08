/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.mavenproject1;

import java.io.File;
import java.io.FileInputStream;
import java.util.ArrayList;
import java.util.Iterator;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

/**
 *
 * @author Zan_Wang
 */
public class read_file {

    public void read_file() {
        File myFile = new File("C://temp/Employee.xlsx");
        FileInputStream fis = null;
        int row_index = 0;
        ArrayList<String> projects = new ArrayList<String>();
        try {

            fis = new FileInputStream(myFile);
             XSSFWorkbook myWorkBook = new XSSFWorkbook (fis);
             XSSFSheet mySheet = myWorkBook.getSheetAt(0);
             Iterator<Row> rowIterator = mySheet.iterator();
             while (rowIterator.hasNext()) {
                Row row = rowIterator.next();
                for(int i = 0; i < row.getLastCellNum() - 1; i++){
                Iterator<Cell> cellIterator = row.cellIterator();
                while (cellIterator.hasNext()) {
                    Cell cell = cellIterator.next();
                    row_index = cell.getRowIndex();
                    if(row.getRowNum() == 0 && cell.getStringCellValue() != null){
                        projects.add(cell.getStringCellValue());
                        
                    }else{
                        
                    }
                }
                }
             }
             
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
