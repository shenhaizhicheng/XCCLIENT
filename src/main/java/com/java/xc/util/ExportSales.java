package com.java.xc.util;

import java.io.FileOutputStream;
import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellStyle;
import org.apache.poi.ss.usermodel.HorizontalAlignment;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.util.CellRangeAddress;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import com.java.xc.domain.Sales;

public class ExportSales {
	public String exportSales(String path, List<Sales> list) {
		Date d = new Date();
		int month = (d.getMonth() + 1);
		String epath = path + "/" + month + "m.xls";
		FileOutputStream fout = null;
		Workbook wb = new XSSFWorkbook();
		Sheet sheet = wb.createSheet("学生表格");
		sheet.addMergedRegion(new CellRangeAddress(4, 8, 5, 9));
		Row row = sheet.createRow(0);
		Cell cell = row.createCell(0);
		cell.setCellValue("菜品编号");
		cell = row.createCell(1);
		cell.setCellValue("菜名");
		cell = row.createCell(2);
		cell.setCellValue("销售日期");
		cell = row.createCell(3);
		cell.setCellValue("客户编号");
		cell = row.createCell(4);
		cell.setCellValue("销售数量");

		for (int i = 0; i < list.size(); i++) {
			row = sheet.createRow(i + 1);
			Sales sa = (Sales) list.get(i);
			row.createCell(0).setCellValue(sa.getSmeid());
			row.createCell(1).setCellValue(sa.getSmename());
			row.createCell(2).setCellValue(sa.getSdate());
			row.createCell(3).setCellValue(sa.getScaccount());
			row.createCell(4).setCellValue(sa.getSnum());
		}
		try {
			fout = new FileOutputStream(epath);
			wb.write(fout);
			return epath;

		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			try {
				fout.close();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return null;

	}
}
