package service;

import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.example.domain.Plane;
import org.example.domain.PlaneCargo;
import org.example.domain.PlanePassenger;

import java.io.IOException;
import java.io.InputStream;
import java.util.Iterator;

public class DataProvider {

    public static Plane[] planeArray;

    static {
        try {
            planeArray = planeArrayFromExcel();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public static Plane[] planeArrayFromExcel() throws IOException {

        InputStream is = DataProvider.class.getResourceAsStream("/Planes.xlsx");
        XSSFWorkbook workbook = new XSSFWorkbook(is); // we've got the Excel file!
        XSSFSheet sheet = workbook.getSheetAt(0);

        int numberOfPlanes = sheet.getPhysicalNumberOfRows() - 1;
        Plane[] planeArray = new Plane[numberOfPlanes];
        System.out.println("Number of planes extracted from .xlsx file: " + numberOfPlanes);

        Iterator<Row> rows = sheet.iterator(); // we'll iterate rows in this specific sheet
        rows.next(); // skipping the 1st row

        int rowNumber = 0;
        while (rows.hasNext()) {
            Row row = rows.next(); // jestesmy w 2 rzedzie

            String name = row.getCell(0).getStringCellValue();
            double price = row.getCell(1).getNumericCellValue();
            int flightRange = (int) row.getCell(2).getNumericCellValue();
            int speed = (int) row.getCell(3).getNumericCellValue();
            int fuelCapacity = (int) row.getCell(4).getNumericCellValue();
            int passCapacity = (int) row.getCell(5).getNumericCellValue();
            int carryCapacity = (int) row.getCell(6).getNumericCellValue();


            if (passCapacity > 0) {
                PlanePassenger planePass = new PlanePassenger(name, price, flightRange, speed, fuelCapacity, passCapacity);
                planeArray[rowNumber] = planePass;
            } else {
                PlaneCargo planeCargo = new PlaneCargo(name, price, flightRange, speed, fuelCapacity, carryCapacity);
                planeArray[rowNumber] = planeCargo;
            }

            rowNumber++;
        }
        workbook.close();
        is.close();
        return planeArray;
    }
}
