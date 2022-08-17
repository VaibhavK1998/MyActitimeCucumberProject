package org.utilities;

import java.io.FileInputStream;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.ss.usermodel.DateUtil;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class ExcelUtility {
	public void getAlltypeOfCelldata(String filename,String sheetname) throws Exception{
		// to reach cell we have 5 step
				FileInputStream fis= new FileInputStream("./ExcelFiles/"+filename);
				Workbook wb= WorkbookFactory.create(fis); 
				Sheet s1=wb.getSheet(sheetname);     
				//		Row r1 = s1.getRow(0);                      
				//		Cell c1= r1.getCell(1);                     

				for(int a=1; a<=s1.getLastRowNum();a++) {
					Row r1=s1.getRow(a);
					for(int b=0;b<r1.getLastCellNum();b++)
					{
						//String rowdata = r1.getCell(b).getStringCellValue();
						// cellType returns datatype of cells
						//	System.out.println(r1.getCell(b).getCellType());

						CellType ct =r1.getCell(b).getCellType();//this method returns the object of CellType class

						switch(ct) {

						case STRING:System.out.println(r1.getCell(b).getStringCellValue());// this returns string type cellvalue
						break;
						case NUMERIC:
							if(DateUtil.isCellDateFormatted(r1.getCell(b))) { //DateUtil is a class inside we have this method
								 // to check cell is date format or not it returns boolean
								Date dt= r1.getCell(b).getDateCellValue();//this method return the object of date class this is of  java class
								SimpleDateFormat sdf= new SimpleDateFormat("dd-MM-yyyy"); //this class is present in java used for dataformat		                                              
								System.out.println(sdf.format(dt));
							}else {
								System.out.println((long)r1.getCell(b).getNumericCellValue());
							}
							break;	

						case BOOLEAN : System.out.println(r1.getCell(b).getBooleanCellValue());//this returns boolean type cellvalue
						break;
						case FORMULA:  System.out.println(r1.getCell(b).getCellFormula());//return formula type cell value
						break;
						case BLANK :System.out.println("cell is blank");
						break;
						default:System.out.println("invalid cell type");
						}
					}
					System.out.println("==========================");
				}
	}
	

	public String getAllCelldataOfSheet(String sheetname, String filename) throws Exception {
		FileInputStream fis= new FileInputStream("./ExcelFiles/"+filename);
		Workbook wb= WorkbookFactory.create(fis);
		Sheet s1=wb.getSheet(sheetname); 
		String rowdata = null;
		for(int a=1; a<=s1.getLastRowNum();a++) {
			Row r1=s1.getRow(a);
			for(int b=0;b<r1.getLastCellNum();b++)
			{
				rowdata=	r1.getCell(b).getStringCellValue();

				System.out.println("all cell data : "+ rowdata);
				System.out.println(r1.getCell(b).getCellType());

			}

		}
		return rowdata;

	}



	public String getParticularCelldata(String filename,String sheetname,int Rowa,int cellb) throws Exception {
		FileInputStream fis= new FileInputStream("./ExcelFiles/"+filename);
		Workbook wb= WorkbookFactory.create(fis);   
		Sheet s1=wb.getSheet(sheetname);     
		Row r1 = s1.getRow(Rowa);                      
		Cell c1= r1.getCell(cellb);                     

		String data= c1.getStringCellValue();// this method returns the string value of cell
		System.out.println("data :"+data);
		return data;
	}
	
	public void getParticularCellValueOfAnyDataType(String filename,String sheetname,int Rowa,int cellb) throws Exception {
		FileInputStream fis= new FileInputStream("./ExcelFiles/"+filename);
		Workbook wb= WorkbookFactory.create(fis);   
		Sheet s1=wb.getSheet(sheetname);     
		Row r1 = s1.getRow(Rowa);                      
		                     
		CellType ct =r1.getCell(cellb).getCellType();//this method returns the object of CellType class

		switch(ct) {

		case STRING:System.out.println(r1.getCell(cellb).getStringCellValue());// this returns string type cellvalue
		break;
		case NUMERIC:
			if(DateUtil.isCellDateFormatted(r1.getCell(cellb))) { //DateUtil is a class inside we have this method
				 // to check cell is date format or not it returns boolean
				Date dt= r1.getCell(cellb).getDateCellValue();//this method return the object of date class this is of  java class
				SimpleDateFormat sdf= new SimpleDateFormat("dd-MM-yyyy"); //this class is present in java used for dataformat		                                              
				System.out.println(sdf.format(dt));
			}else {
				System.out.println((long)r1.getCell(cellb).getNumericCellValue());
			}
			break;	

		case BOOLEAN : System.out.println(r1.getCell(cellb).getBooleanCellValue());//this returns boolean type cellvalue
		break;
		case FORMULA:  System.out.println(r1.getCell(cellb).getCellFormula());//return formula type cell value
		break;
		case BLANK :System.out.println("cell is blank");
		break;
		default:System.out.println("invalid cell type");
		}
		
	}
	




	
	
	
	
	
	
	
	
	public int getlastRowNo(String filename,String sheetname) throws Exception {
		FileInputStream fis= new FileInputStream("./ExcelFiles/"+filename);
		Workbook wb= WorkbookFactory.create(fis);
		Sheet s1=wb.getSheet(sheetname);
		int lastrow= s1.getLastRowNum();
		System.out.println("lastrow :"+lastrow);
		return lastrow;
	}
	public int getPhysicalRowNo(String filename,String sheetname) throws Exception {
		FileInputStream fis= new FileInputStream("./ExcelFiles/"+filename);
		Workbook wb= WorkbookFactory.create(fis);
		Sheet s1=	wb.getSheet(sheetname);
		int Physicallastrow= s1.getLastRowNum();
		System.out.println("Physicallastrow :"+Physicallastrow);
		return Physicallastrow;

	}
	public int getLastcellNo(String filename,String sheetname) throws Exception{
		FileInputStream fis= new FileInputStream("./ExcelFiles/"+filename);
		Workbook wb= WorkbookFactory.create(fis);   
		Sheet s1=wb.getSheet(sheetname);    
		Row r1 = s1.getRow(0);                      
		int lastcellnum= r1.getLastCellNum();
		System.out.println("lastcellnum :"+lastcellnum);
		return lastcellnum;
	}
	public int lastCellNumOfEachRow(String filename,String sheetname) throws Exception {
		FileInputStream fis= new FileInputStream("./ExcelFiles/"+filename);
		Workbook wb= WorkbookFactory.create(fis);   
		Sheet s1=wb.getSheet(sheetname);    
		int lastrow= s1.getLastRowNum();                      
		int lastcellnum = 0  ;
		for(int i=0; i<=lastrow;i++) { // this for loop returns you last cell no of each row
			Row r1  =  s1.getRow(i);
			lastcellnum= r1.getLastCellNum();
			System.out.println("last cell no of row : "+i+"= "+lastcellnum);

		}
		return lastcellnum	;
	}
}
