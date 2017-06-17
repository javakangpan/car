package pers.kp.excel;

import java.io.FileInputStream;
import java.io.InputStream;

import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;

public class ExcelRead {
	/**
	 * 通过Poi读取Excel文件中的内容
	 * @param args
	 * @throws Exception 
	 */
	public static void main(String[] args) throws Exception {
		InputStream in = new FileInputStream("d:/owned.xls");
		// 1.获取HSSFWorkbook对象
		HSSFWorkbook wb = new HSSFWorkbook(in);
		// 2.获取读取内容所在的sheet页
		HSSFSheet sheet = wb.getSheetAt(0);
		System.out.println(sheet.getSheetName());
		// 3.获取第一行第一列的内容
		// 获取第一行
		/*HSSFRow r1 = sheet.getRow(0);
		System.out.println(r1.getCell(0).toString());*/
		
		
		
		for(int i=2;i<=sheet.getLastRowNum();i++){
			HSSFRow row=sheet.getRow(i);
			HSSFCell c1 = row.getCell(0);
			HSSFCell c2 = row.getCell(1);
			HSSFCell c3 = row.getCell(2);
			HSSFCell c4 = row.getCell(3);
			HSSFCell c5 = row.getCell(4);
//			System.out.println(c1.toString()+""+c2.toString()+""+c2.toString()+""+c3.toString()+""+c4.toString()+"");
			System.out.println(getValue(c1)+"\t"+getValue(c2)+"\t"+getValue(c3)+"\t"+getValue(c4)+"\t"+getValue(c5));
		}
		
		
		

	}
	
	private static String getValue(HSSFCell cell) {
		String cellValue="";
		switch (cell.getCellType()) {
		case HSSFCell.CELL_TYPE_NUMERIC:
			double d= cell.getNumericCellValue();
			int intd=(int)d;
			cellValue=String.valueOf(intd);
			break;
		case HSSFCell.CELL_TYPE_STRING:
			cellValue=cell.getStringCellValue();
			
		default:
			break;
		}
		return cellValue;
	}
	
	
}
