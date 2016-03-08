/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.mavenproject1;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

/**
 *
 * @author Administrator
 */
public class write_xlsx {
    /*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


    public static void write_xlsx(ArrayList<Person> person , ArrayList<String> projects) throws FileNotFoundException, IOException {
        
        
        
        File myFile = new File("F:\\log1\\log_output.xlsx");
        FileInputStream fis = new FileInputStream(myFile);
        XSSFWorkbook myWorkBook = new XSSFWorkbook(fis);
        XSSFSheet mySheet = myWorkBook.getSheetAt(0);
        Row row0 = mySheet.createRow(0);
        for(String p : projects){
            int cellnum = 2;
            Cell cell = row0.createCell(cellnum);
            cell.setCellValue(p);
            cellnum = cellnum + 2;
            
        }
        int rownum = mySheet.getLastRowNum() + 1;
        Row row1 = mySheet.createRow(rownum++);
        
        Cell cell_date = row1.createCell(0);
        
        Date date = new Date();
        cell_date.setCellValue(date.toString());
        int i = 0;
        for(Person p : person){
            Row row = null;
            row = mySheet.createRow(rownum++);
            i++;
            int cellnum = 0;
            
            Cell cell = row.createCell(cellnum);
            cell.setCellValue(p.getName());
            Cell cell1 = row.createCell(cellnum);
            cell1.setCellValue(p.getXue_ya_high());
            cellnum++;
            Cell cell2 = row.createCell(cellnum);
            cell.setCellType(p.getXue_ya_low());
            Cell cell3 = row.createCell(cellnum);
            cell3.setCellValue(p.getXue_tang());
            
            
        }
         FileOutputStream os = new FileOutputStream(myFile);
         myWorkBook.write(os);
        /*File myFile = new File("F:\\log1\\log_output.xlsx");
        FileInputStream fis = new FileInputStream(myFile);
        XSSFWorkbook myWorkBook = new XSSFWorkbook(fis);
        XSSFSheet mySheet = myWorkBook.getSheetAt(0);

        int rownum = mySheet.getLastRowNum() + 1;
        Row row1 = mySheet.createRow(rownum++);
        Cell cell2 = row1.createCell(0);
        Date date = new Date();
        cell2.setCellValue(date.toString());
        int i = 0;
        for (String key : server_list) {
            Row row = null;
            if (i != 22) {
               row = mySheet.createRow(rownum++);
            } else {
               rownum = rownum + 2;
               row =  mySheet.createRow(rownum++);               
            }
            i++;
            int cellnum = 0;

            List<String> event = map.get(key);

            Cell cell = row.createCell(cellnum);
            cell.setCellValue(key);
            Cell cell1 = row.createCell(cellnum + 2);
            cell1.setCellValue(event.toString().substring(1, event.toString().length() - 1));
        }
        FileOutputStream os = new FileOutputStream(myFile);
        myWorkBook.write(os);
                */
    }

}


