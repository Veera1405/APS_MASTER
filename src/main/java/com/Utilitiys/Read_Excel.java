package com.Utilitiys;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import com.Constant.Aps_project_constant;

public class Read_Excel {
	public static List<String> usernamelist = new ArrayList<String>();
	public static List<String> passwordlist = new ArrayList<String>();

	public FileInputStream loadExcel() throws IOException {

		try {
			String Excelpath = System.getProperty("user.dir") + Aps_project_constant.EXCELPATH;
			FileInputStream File = new FileInputStream(Excelpath);
			XSSFWorkbook Workbook = new XSSFWorkbook(File);
			XSSFSheet sheet = Workbook.getSheetAt(0);

			Iterator<Row> rowIterator = sheet.iterator();
			while (rowIterator.hasNext()) {
				Row rowValue = rowIterator.next();
				Iterator<Cell> columnIteatore = rowValue.iterator();
				int i = 2;

				while (columnIteatore.hasNext()) {
					if (i % 2 == 0) {
						usernamelist.add(columnIteatore.next().getStringCellValue());
					} else {
						passwordlist.add(columnIteatore.next().getStringCellValue());
					}
					i++;
				}

			}

		} catch (FileNotFoundException e) {
			throw new RuntimeException(e);
		}
		return null;

	}

	public static void main(String[] args) throws IOException {
		Read_Excel read = new Read_Excel();
		read.loadExcel();
		System.out.println(usernamelist);
		System.out.println(passwordlist);
	}

}
