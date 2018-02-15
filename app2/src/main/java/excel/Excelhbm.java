package excel;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Iterator;
import java.util.function.Consumer;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class Excelhbm {

	public static void main(String[] args) throws IOException {
		Configuration cfg=new Configuration();
		cfg.configure();
		SessionFactory sf=cfg.buildSessionFactory();
		Session hsession =sf.openSession();
		Transaction tx=hsession.beginTransaction();

		File file=new File("Book1.xlsx");
		FileInputStream fis=new FileInputStream(file);
		Workbook workbook=new XSSFWorkbook(fis);
		Sheet sheet=workbook.getSheetAt(0);
		Iterator<Row> iterator= sheet.iterator();
		while(iterator.hasNext()){
			Product p=new Product();
		Row currentRow=iterator.next();
		
		Iterator<Cell> cellIterator=currentRow.iterator();
		while(cellIterator.hasNext()){
		Cell cell=cellIterator.next();
		int col=cell.getColumnIndex();
		switch (col){
		case 0:
			p.setPid(cell.getNumericCellValue());
			break;
		case 1:
			p.setPname(cell.getStringCellValue());
			break;
		case 2:
			p.setPrice(cell.getNumericCellValue());
			break;
		}
		}	
		hsession.save(p);
		
		}
		tx.commit();
		hsession.close();
	}

}
