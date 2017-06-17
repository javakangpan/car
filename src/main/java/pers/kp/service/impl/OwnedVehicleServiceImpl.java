package pers.kp.service.impl;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;

import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFCellStyle;
import org.apache.poi.hssf.usermodel.HSSFFont;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.hssf.util.CellRangeAddress;
import org.springframework.stereotype.Service;

import pers.kp.dao.IOwnedVehicleDao;
import pers.kp.pojo.OwnedVehicle;
import pers.kp.service.IOwnedVehicleService;

import java.io.InputStream;
@Service
public class OwnedVehicleServiceImpl implements IOwnedVehicleService {

	@Resource
	private IOwnedVehicleDao dao;
	
	@Override
	public List<OwnedVehicle> query(OwnedVehicle car) {
		
		return dao.query(car);
	}

	@Override
	public void save(OwnedVehicle own) throws RuntimeException {
		dao.save(own);
		
	}

	@Override
	public void update(OwnedVehicle own) throws RuntimeException {
		dao.update(own);
		
	}

	@Override
	public void delete(OwnedVehicle own) throws RuntimeException {
		dao.delete(own);
		
	}

	@Override
	public OwnedVehicle queryById(Integer id) {

		return dao.queryById(id);
	}
	
	@Override
	public void readExcel(File file) throws Exception{
		
		
		HSSFWorkbook wb = new HSSFWorkbook(new FileInputStream(file));
		
		HSSFSheet sheet = wb.getSheetAt(0);
		System.out.println(sheet.getSheetName());
	
		List<OwnedVehicle> list=new ArrayList<>();
		int lastRow = sheet.getLastRowNum();
		for (int i = 2; i <= lastRow; i++) {
			
			OwnedVehicle carInfo =new OwnedVehicle();
			
			
			HSSFRow row = sheet.getRow(i);
		
			carInfo.setVehicleId(getValue(row.getCell(1)));
			carInfo.setMemo(getValue(row.getCell(2)));
			carInfo.setModel(getValue(row.getCell(3)));
			carInfo.setLicenseCode(getValue(row.getCell(4)));
			
			list.add(carInfo);
			
			if(i%10==0){
				dao.readSaveExcel(list);
				System.out.println("上传了"+list.size());
				list.clear();
			}	
		}
		
		dao.readSaveExcel(list);
		System.out.println("上传了"+list.size());
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

	@Override
	public InputStream exportExcel() throws Exception {
		
		// 1.获取HSSFWorkbook对象
				HSSFWorkbook wb = new HSSFWorkbook();
				// 2.创建标签页 sheet
				HSSFSheet sheet = wb.createSheet("a123");
				// 3.设计具体的Excel文件内容
				// 合并单元格
				sheet.addMergedRegion(new CellRangeAddress(0, 0, 0, 4));
				// 设置样式
				HSSFCellStyle style = wb.createCellStyle();
				style.setAlignment(HSSFCellStyle.ALIGN_CENTER);
				style.setVerticalAlignment(HSSFCellStyle.ALIGN_CENTER);
				
				// 设置字体
				HSSFFont font = wb.createFont();
				//font.setItalic(true); // 设置斜体
				font.setBoldweight(HSSFFont.BOLDWEIGHT_BOLD);
				// 将字体添加到样式中
				style.setFont(font);
				
				HSSFRow r0 = sheet.createRow(0);
				HSSFCell r0c0 = r0.createCell(0);
				r0c0.setCellValue("自有车辆信息");
				// 将样式设置到单元格中
				r0c0.setCellStyle(style);
				
				// 创建第二行的数据
				HSSFRow r1 = sheet.createRow(1);
				HSSFCell r1c0 = r1.createCell(0);
				r1c0.setCellValue("id");
				HSSFCell r1c1 = r1.createCell(1);
				r1c1.setCellValue("车辆编号");
				HSSFCell r1c2 = r1.createCell(2);
				r1c2.setCellValue("使用单位");
				HSSFCell r1c3 = r1.createCell(3);
				r1c3.setCellValue("车辆类型");
				HSSFCell r1c4 = r1.createCell(4);
				r1c4.setCellValue("车牌号码");
				
			
				List<OwnedVehicle> list = dao.query(null);
				
				// 循环取出数据并插入到Excel文件中
				for (int i = 0; i < list.size(); i++) {
					HSSFRow row = sheet.createRow(i+2);
					OwnedVehicle o = list.get(i);
					row.createCell(0).setCellValue(o.getId());
					row.createCell(1).setCellValue(o.getVehicleId());
					row.createCell(2).setCellValue(o.getMemo());
					row.createCell(3).setCellValue(o.getModel());
					row.createCell(4).setCellValue(o.getLicenseCode());
					
				}
				
				// 生成Excel文件
				OutputStream out = new FileOutputStream("testt.xls");
				System.out.println(out);
				wb.write(out);
				out.flush();
				out.close();
				
				InputStream in = new FileInputStream("testt.xls");
				System.out.println(in);
				return in;
	}

	

}
