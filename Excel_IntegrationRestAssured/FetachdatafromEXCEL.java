package Excel_IntegrationRestAssured;

import java.io.IOException;

import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.testng.annotations.Test;

import constant.Constant_Excel;

public class FetachdatafromEXCEL 
{
   static XSSFWorkbook workbook;
   static XSSFSheet sheet;
   static  XSSFCell value;
   
   FetachdatafromEXCEL(String excel_file, String sheet_name ) throws IOException
   {       
	       workbook=new XSSFWorkbook(excel_file);
		   sheet=workbook.getSheet(sheet_name);//created package in java not inside test file, Constant_Excel
		   
		   
		 // value=sheet.getRow(1).getCell(2);
		  //  System.out.println(value);
		      }
           
           
           //we have to format data properly to send into the body then we need to create Dataformatter
   
   
              public static Object  getdatafrom_Excel(int x,int y)        //using object to get  umeric value
           {
        	   DataFormatter formatter=new DataFormatter();
        	   Object value=  formatter.formatCellValue(sheet.getRow(x).getCell(y));
			   return value;
        	  
           }

}


