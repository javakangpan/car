package pers.kp.excel;

import java.io.FileOutputStream;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.List;

import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFCellStyle;
import org.apache.poi.hssf.usermodel.HSSFFont;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;


import org.apache.poi.ss.util.CellRangeAddress;

import pers.kp.pojo.OwnedVehicle;

public class ExcelCreat {

	

	/**
	 * 通过POI生成Excel文件
	 * @param args
	 * @throws Exception 
	 */
	public static void main(String[] args) throws Exception {
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
		
		
		
		
		// 模拟生成数据
				List<OwnedVehicle> list = new ArrayList<OwnedVehicle>();
				for (int i = 0; i < 100; i++) {
					OwnedVehicle o = new OwnedVehicle();
					o.setId(i+1);
					o.setVehicleId("1000"+i);
					o.setModel("QQ");
					o.setLicenseCode("粤B10000"+i);
					o.setMemo("开发部");
					list.add(o);
				}
				
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
		OutputStream out = new FileOutputStream("d:/test.xls");
		wb.write(out);
		out.flush();
		out.close();



	}

}
