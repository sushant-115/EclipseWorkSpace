package excel;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;



import java.util.Iterator;

import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public abstract class TestExcel {

	public static void main(String[] args) throws IOException{
		
		File file=new File("Book1.xlsx");
		FileInputStream fis=new FileInputStream(file);
		Workbook workbook=new XSSFWorkbook(fis);
		Sheet sheet=workbook.getSheetAt(0);
		Iterator<Row> iterator= sheet.iterator();
		while(iterator.hasNext()){
		Row currentRow=iterator.next();
		Iterator<Cell> cell=currentRow.iterator();
		while(cell.hasNext()){
			Cell currentCell=cell.next();
			if(currentCell.getCellTypeEnum()==CellType.NUMERIC){
				System.out.println(currentCell.getNumericCellValue());
			}
			if(currentCell.getCellTypeEnum()==CellType.STRING)
				System.out.println(currentCell.getStringCellValue());
		}
		}
	}

}
