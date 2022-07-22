package Resources;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class DataSheet extends Base{
	String path;
	FileInputStream fis;
	FileOutputStream fos;
	private XSSFWorkbook workbook=null;
	private XSSFSheet sheet=null;
	private XSSFRow row=null;
	private XSSFCell cell=null;
	
	public DataSheet(String path) throws IOException {
		this.path=path;
		try {
		fis=new FileInputStream(path);
		workbook=new XSSFWorkbook(fis);
		sheet=workbook.getSheetAt(0);
		fis.close();
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		
	}
	public boolean isSheetPresent(String SheetName) {
		for(int i=0;i<workbook.getNumberOfSheets();i++) {
			if(workbook.getSheetAt(i).equals(SheetName)) {
				return true;
			}
		}
		return false;
	}
	public int rowCount(String SheetName) throws IOException {
		int index=workbook.getSheetIndex(SheetName);
		if(index==-1) {
			return 0;
		}
		sheet=workbook.getSheetAt(index);
		int rowcount=sheet.getLastRowNum();
		workbook.close();
		return rowcount+1;
	}
	public int columnCount(String SheetName) {
		if(!isSheetPresent(SheetName)) {
			return -1;
		}
		sheet=workbook.getSheet(SheetName);
		row=sheet.getRow(1);
		if(row==null) {return -1;}
		return row.getLastCellNum();
		
	}
	public String getCellData(String SheetName,String ColName,int rowNum) {
		try {
			if(rowNum<=0) {
				return "";
			}
			int index=workbook.getSheetIndex(SheetName);
			int colNum=-1;
			if(index==-1) {return "";}
			sheet=workbook.getSheetAt(index);
			row=sheet.getRow(0);
			for(int i=0;i<row.getLastCellNum();i++) {
				//System.out.println(row.getCell(i).getStringCellValue().trim());
				if(row.getCell(i).getStringCellValue().trim().equals(ColName.trim())) {
					colNum=i;
				}
			}
				if(colNum==-1) {return "";}
				sheet=workbook.getSheetAt(index);
				row=sheet.getRow(rowNum-1);
				if(row==null) {return"";}
				cell=row.getCell(colNum);
				if(cell==null) {return "";}
				if(cell.getCellType().name().equals("STRING")) {
					return	cell.getStringCellValue();}
				else if((cell.getCellType().name().equals("NUMERIC"))||(cell.getCellType().name().equals("FORMULA")) ){
					String cellText=org.apache.poi.ss.util.NumberToTextConverter.toText((cell.getNumericCellValue()));
					
					return cellText;}
				else if(cell.getCellType().BLANK!=null) {
						return "";
					}
				else return String.valueOf(cell.getBooleanCellValue());
				
		
		}catch(Exception e) {
			e.printStackTrace();
		}
		return "row"+rowNum+"or colname"+ColName+"does not exists in xls";
	}
	public boolean setCellData(String path,String sheetName, String colName, int rowNum, String data) {
		try {
			fis = new FileInputStream(path);
			workbook = new XSSFWorkbook(fis);

			if (rowNum <= 0)
				return false;

			int index = workbook.getSheetIndex(sheetName);
			int colNum = -1;
			if (index == -1)
				return false;

			sheet = workbook.getSheetAt(index);

			row = sheet.getRow(0);
			for (int i = 0; i < row.getLastCellNum(); i++) {
				// System.out.println(row.getCell(i).getStringCellValue().trim());
				if (row.getCell(i).getStringCellValue().trim().equals(colName))
					colNum = i;
			}
			if (colNum == -1)
				return false;

			sheet.autoSizeColumn(colNum);
			row = sheet.getRow(rowNum - 1);
			if (row == null)
				row = sheet.createRow(rowNum - 1);

			cell = row.getCell(colNum);
			if (cell == null)
				cell = row.createCell(colNum);

			// cell style
			// CellStyle cs = workbook.createCellStyle();
			// cs.setWrapText(true);
			// cell.setCellStyle(cs);
			cell.setCellValue(data);

			fos = new FileOutputStream(path);

			workbook.write(fos);

			fos.close();

		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
		return true;
	}

}
