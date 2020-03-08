package com.roadruwa.comm;

import java.io.FileInputStream;
import java.util.ArrayList;
import java.util.List;

import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public abstract class ExcelReader {
	
	public abstract void mappingVo(String colName, Object obj, String value);
	
	public List<? extends Object> readExcelFile(String filePath, Class<?> clazz) {
		List<Object> users = new ArrayList<Object>();
		try {
			FileInputStream file = new FileInputStream(filePath);
			XSSFWorkbook workbook = new XSSFWorkbook(file);
			int rowindex = 0;
			int columnindex = 0;
			// 시트 수 (첫번째에만 존재하므로 0을 준다)
			// 만약 각 시트를 읽기위해서는 FOR문을 한번더 돌려준다
			XSSFSheet sheet = workbook.getSheetAt(0);
			// 행의 수
			int rows = sheet.getPhysicalNumberOfRows();
			List<String> header = new ArrayList<String>();
			
			for (rowindex = 0; rowindex < rows; rowindex++) {
				// 행을읽는다
				XSSFRow row = sheet.getRow(rowindex);
				if (row != null) {
					// 셀의 수
					int cells = row.getPhysicalNumberOfCells();
					
					Object obj = clazz.newInstance();
					
					for (columnindex = 0; columnindex <= cells; columnindex++) {
						XSSFCell cell = row.getCell(columnindex);
						
						// 셀값을 읽는다
						String value = readCellValue(cell);

						if( rowindex == 0 ) {
							header.add(value);
						} else {
							mappingVo(header.get(columnindex), obj, value);
						}
					}
					
					users.add(obj);

				}
			}
			
			workbook.close();

		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return users;
	}
	
	private String readCellValue(XSSFCell cell) {
		String value = "";
		// 셀이 빈값일경우를 위한 널체크
		if (cell == null) {
			value = "";
			//continue;
		} else {
			// 타입별로 내용 읽기
			CellType copyCellType = cell.getCellTypeEnum();
			switch (copyCellType) {
			case FORMULA:
				value = cell.getCellFormula();
				break;
			case NUMERIC:
				value = cell.getRawValue();// getNumericCellValue() + "";
				break;
			case STRING:
				value = cell.getStringCellValue() + "";
				break;
			case BLANK:
				value =  "";
				break;
			case BOOLEAN:
				value = cell.getBooleanCellValue() + "";
				break;
			case ERROR:
				value = cell.getErrorCellValue() + "";
				break;
			default:
				break;
			
			}
		}
		return value;
	}
}
