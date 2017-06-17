package pers.kp.action;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;
import java.util.List;

import javax.annotation.Resource;

import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.springframework.stereotype.Controller;

import pers.kp.pojo.OwnedVehicle;
import pers.kp.service.IOwnedVehicleService;

import com.opensymphony.xwork2.ActionSupport;

@Controller
public class OwnedVehicleAction extends ActionSupport {

	@Resource
	private IOwnedVehicleService carService;
	
	private List<OwnedVehicle> list;
	
	private File excel;
	
	private String fileName;
	
	
	

	public String getFileName() {
		return fileName;
	}

	public void setFileName(String fileName) {
		this.fileName = fileName;
	}

	public File getExcel() {
		return excel;
	}

	public void setExcel(File excel) {
		this.excel = excel;
	}

	@Resource
	private IOwnedVehicleService carServiec;

	public String query() {
		setList(carServiec.query(null));
		return SUCCESS;

	}
	
	public String uploadExcel() throws Exception{
		System.out.println("文件已上传:"+excel);
		carService.readExcel(excel);
		return "query";
	}

	public String download(){
		
		System.out.println("开始下载:"+fileName);
		
		return "download";
	}
	
	
	public InputStream getInputStream() {
		
		try {
			return carService.exportExcel();
		} catch (Exception e) {
			
			e.printStackTrace();
		}
		return null;
	}

	
	public List<OwnedVehicle> getList() {
		return list;
	}

	public void setList(List<OwnedVehicle> list) {
		this.list = list;
	}
	
}
