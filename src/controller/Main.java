package controller;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.io.*;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.*;

import model.Request;
import service.BundleDAO;
import service.RequestDAO;
import view.View;

public class Main {

	public static void main(String[] args) {
		Controller controller = new Controller();
		View view = new View();
		controller.addView(view);
		view.addController(controller);
		///
		BundleDAO bundleService = new BundleDAO();
		RequestDAO requestService = new RequestDAO();

		List<Integer> requestCost = new ArrayList<Integer>();

		List<Integer> bundleRequest = new ArrayList<Integer>();
		List bundles = null;

		ArrayList<ArrayList<Integer>> listOfBundles = new ArrayList<ArrayList<Integer>>();

		try {
			File myFile = new File("src/DataSample.xlsx");
			FileInputStream input = new FileInputStream(myFile);

			XSSFWorkbook myWorkBook = new XSSFWorkbook(input);

			XSSFSheet mySheet = myWorkBook.getSheetAt(0);
			XSSFSheet mySheet1 = myWorkBook.getSheetAt(1);

			DataFormatter df = new DataFormatter();

			String column = "Standard Price";
			Integer columnNo = null;
			List<Cell> cells = new ArrayList<Cell>();

			Row firstRow = mySheet.getRow(0);

			for (Cell cell : firstRow) {
				if (cell.getStringCellValue().equals(column)) {
					columnNo = cell.getColumnIndex();
				}
			}

			if (columnNo != null) {
				for (Row row : mySheet) {
					if (row.getRowNum() == 0) {
						continue; // just skip the rows if row number is 0
					}
					Cell c = row.getCell(columnNo);
					String price = df.formatCellValue(c);
					StringBuilder sb = new StringBuilder(price);
					sb.deleteCharAt(0);
					String newPrice = sb.toString();
					int cost = Integer.parseInt(newPrice);
					requestCost.add(cost);					
				}
			}
			for (int i = 0; i < requestCost.size(); i++)
				requestService.addData(BigDecimal.valueOf((long) requestCost.get(i)));

			List<Request> completeRequestList = requestService.getRequestList();

			Row secondRow1 = mySheet1.getRow(1);
			Integer costColumn = null;
			Integer bundleColumn = null;

			int nurseId = 0;
			BigDecimal Cost = null;

			for (Cell cell : secondRow1) {

				if (cell.getStringCellValue().equals("Visit Bundle")) {
					bundleColumn = cell.getColumnIndex();
					if (bundleColumn != null) {
						for (Row row : mySheet1) {

							if (row.getRowNum() == 0) {
								continue; // just skip the row if row number is 0
							}
							if (row.getRowNum() == 1) {
								continue; // just skip the rows if row number is 1
							}
							Cell c = row.getCell(bundleColumn);
							String test = c.getStringCellValue();
							if (test != "") {
								String test1 = test.replaceAll("\\s", "");

								String[] parts = test1.split(",");
								
								ArrayList<Integer> ints = new ArrayList<Integer>();
								for (int i = 0; i < parts.length; i++) {									
									ints.add(Integer.parseInt(parts[i]));

								}
								listOfBundles.add(ints);
							}							

						}

					}
				}

			}
			System.out.println((listOfBundles));
			for (Cell cell : secondRow1) {

				if (cell.getStringCellValue().equals("Cost")) {
					List<BigDecimal> bundleCost = new ArrayList<BigDecimal>();
					costColumn = cell.getColumnIndex();
					if (costColumn != null) {

						for (Row row : mySheet1) {
							if (row.getRowNum() == 0) {
								continue; // just skip the rows if row number is 0
							}
							if (row.getRowNum() == 1) {
								continue; // just skip the rows if row number is 1
							}

							Cell c = row.getCell(costColumn);
							double cost = c.getNumericCellValue();
							Cost = new BigDecimal(cost);
							bundleCost.add(Cost);
						}
					}

					nurseId++;					
						
							for (int i = 0; i < bundleCost.size(); i++) {

							ArrayList<Integer> req = listOfBundles.get(i);
							List<Request> rlist = new ArrayList<Request>();
							for (int j = 0; j < req.size(); j++) {
								rlist.add(completeRequestList.get(req.get(j) - 1));
							}
							if (bundleCost.get(i).compareTo(BigDecimal.ZERO) != 0) {
								bundleService.addData(bundleCost.get(i), nurseId, rlist);
							}

						}
					
				}
			}

		}

		catch (Exception e) {
			e.printStackTrace();
		}
		/*
		 * List <Integer> requestCost = Arrays.asList(80 ,60 ,40 ,80 ,40 ,60 ,80
		 * ,80 ,60 ,80 ,80 ,80 ,60 ,60 ,60 );
		 */

		/*
		 * int[][] n1 = {{3, 2, 6 }, {1, 10} ,{ 13, 7, 14 } ,{ 13, 2, 7, 14 } ,{
		 * 13, 4, 7, 14 } ,{ 13, 8, 14 } ,{ 13, 8, 1, 14 } ,{ 13, 10, 14 } ,{
		 * 13, 8, 10, 14 } ,{ 13, 12, 14 } ,{ 13, 8, 12, 14 } ,{ 3, 2, 15} };
		 * 
		 * 
		 * 
		 * List<int[]> requestListN1 = Arrays.asList(n1); List<Double> costN1
		 * =Arrays.asList(156.88 ,126.88 , 182.51 , 219.42 , 220.37 , 162.58 ,
		 * 219.99 , 187.26 , 227.97 , 173.39 , 218.28 , 147.38 ); for(int i=0;
		 * i<requestListN1.size();i++){ int[] req = requestListN1.get(i);
		 * List<Request> rlist = new ArrayList<Request>(); for(int j=0;
		 * j<req.length; j++){ rlist.add(completeRequestList.get(req[j]-1)); }
		 * bundleService.addData(BigDecimal.valueOf(costN1.get(i)), 1, rlist);
		 * 
		 * } //bundleService.setAssigned(1);
		 * 
		 * 
		 * 
		 * 
		 * 
		 */

	}

}
