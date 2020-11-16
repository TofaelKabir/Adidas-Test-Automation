package dataProviderUtilityWithXlsReader;

import java.util.ArrayList;

public class XlsDataReaderUtil {

	public static XlsReader reader;

	public static ArrayList<Object[]> getDataFromExcel() {

		ArrayList<Object[]> myData = new ArrayList<Object[]>();
		try {
			reader = new XlsReader("/Users/mohammadsharkar/eclipse-workspace/AdidasTestAutomation/data/AdidasDataReader.xls");
		} catch (Exception e) {
			e.printStackTrace();
		}
		// change only sheet name in line 19
		for (int rowNum = 2; rowNum <= reader.getRowCount("Sheet1"); rowNum++) {
			String email = reader.getCellData("Sheet1", "email", rowNum);
			String passCode = reader.getCellData("Sheet1", "passCode", rowNum);
			Object obj[] = { email, passCode };
			myData.add(obj);
		}
		return myData;
	}
}