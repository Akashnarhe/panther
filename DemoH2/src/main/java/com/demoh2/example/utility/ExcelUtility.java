package com.demoh2.example.utility;

import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.ss.usermodel.CellStyle;
import org.apache.poi.ss.usermodel.Font;
import org.apache.poi.ss.usermodel.Workbook;
import org.springframework.web.servlet.view.document.AbstractXlsView;

import com.demoh2.example.model.User;

public class ExcelUtility extends AbstractXlsView {

	@Override
	protected void buildExcelDocument(Map<String, Object> model, Workbook workbook, HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		
		response.setHeader("Content-Disposition", "attachment; filename=\"User_Report.xls\"");

		@SuppressWarnings("unchecked")
		List<User> users = (List<User>) model.get("userList");
		
		HSSFSheet hssfSheet = (HSSFSheet) workbook.createSheet("User List");
		//hssfSheet.setDefaultColumnWidth(30);
		
		CellStyle cellStyle = workbook.createCellStyle();
		Font font = workbook.createFont();
		font.setFontName("Arial");
		font.setBold(true);
		cellStyle.setFont(font);

		HSSFRow header = hssfSheet.createRow(0);
		header.createCell(0).setCellValue("ID");
		header.getCell(0).setCellStyle(cellStyle);
		header.createCell(1).setCellValue("First Name");
		header.getCell(1).setCellStyle(cellStyle);
		header.createCell(2).setCellValue("Last Name");
		header.getCell(2).setCellStyle(cellStyle);
		header.createCell(3).setCellValue("Email ID");
		header.getCell(3).setCellStyle(cellStyle);
		header.createCell(4).setCellValue("Mobile Number");
		header.getCell(4).setCellStyle(cellStyle);

		int rowNumber = 1;
		for (User user : users) {
			HSSFRow row = hssfSheet.createRow(rowNumber++);
			row.createCell(0).setCellValue(user.getId());
			row.createCell(1).setCellValue(user.getFirstName());
			row.createCell(2).setCellValue(user.getLastName());
			row.createCell(3).setCellValue(user.getEmailId());
			row.createCell(4).setCellValue(user.getMobileNumber());
		}
		
		for(int columnIndex = 0; columnIndex < 5; columnIndex++) {
			hssfSheet.autoSizeColumn(columnIndex);
		}
	}

}
