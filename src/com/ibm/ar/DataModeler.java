package com.ibm.ar;

import java.io.FileInputStream;
import java.io.InputStream;
import java.sql.Date;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Iterator;

import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Row;



public class DataModeler {
	static void parcer(String path) 
	{
	try {
		InputStream ExcelFileToRead = new FileInputStream(path);
		HSSFWorkbook wb = new HSSFWorkbook(ExcelFileToRead);
		
		HSSFSheet sheet = wb.getSheetAt(0);
		HSSFRow row;
		HSSFCell cell;

		Iterator rows = sheet.rowIterator();

		while (rows.hasNext()) {
			
			row = (HSSFRow) rows.next();
			asignate(row);
			/*for(int i=0; i<row.getLastCellNum(); i++) {
				cell = row.getCell(i, Row.CREATE_NULL_AS_BLANK);
				System.out.println(cell.toString());
			}*/

		}
			 //aca se llama a la funcion que sube a la base de datos
             
	} catch (Exception e) {
		e.printStackTrace();
	}
}

	private static void asignate(HSSFRow row) {
		// TODO Auto-generated method stub
		Pais pais = new Pais();
		pais.setId(row.getCell(0, Row.CREATE_NULL_AS_BLANK).getNumericCellValue());
		pais.setNombre(row.getCell(1, Row.CREATE_NULL_AS_BLANK).getStringCellValue());
		String[] aux = row.getCell(2, Row.CREATE_NULL_AS_BLANK).getDateCellValue().toString().split(" ");
    	String fechaString =aux[5]+" "+aux[1]+" "+aux[2]+",";
    	Date fecha = convertir(fechaString);
		pais.setFecha(fecha);
		System.out.println(pais.getId() + pais.getNombre() + pais.getFecha());
		
	}
	private static Date convertir(String string) {
		java.util.Date dob = null;
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy MMM dd");
		try {
			dob = sdf.parse(string);
			Date sqlDate = new Date(dob.getTime());
			return sqlDate;
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			
		}
		return null;
		
	}
	
}
