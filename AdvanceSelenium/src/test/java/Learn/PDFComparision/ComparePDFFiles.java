package Learn.PDFComparision;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Properties;
import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

import de.redsix.pdfcompare.PdfComparator;

public class ComparePDFFiles {

	public static void main(String[] args) throws EncryptedDocumentException, IOException {
		
		FileReader reader=new FileReader("inputData.txt");  
	     
		   Properties p=new Properties();  
		   p.load(reader);  
		   

		   String l1=p.getProperty("ExpFileLocation").trim();
		   
		   String l2=p.getProperty("ActFileLocation").trim();
		   
		   String l3=p.getProperty("OutputFileLocation").trim();
		   
		   File outl3=new File(l3);
		  
		   
		   if (!outl3.exists()) {
		   	
		   	
		   	outl3.mkdir();
		   	
		   	
		   	
		}
		   
		   //String actFile=p.getProperty("ExpFileID").trim();
		   String actFile="";
		   String expFile="";
		   
		   String ExcelExpFileName="";
		   String ExcelActFileName="";
		   
		  // FileInputStream excelFilePath=new FileInputStream(p.getProperty("ExcelFileInputPath"));
		   
		   FileInputStream excelFilePath=new FileInputStream("PDFCompareToolData/inputData.xlsx");
		  // Workbook ExcelWorkbook=new Workbook(excelFilePath);
		   Workbook ExcelWorkbook=WorkbookFactory.create(excelFilePath); 
		   Sheet sh= ExcelWorkbook.getSheetAt(0);
		   int ExcelRowcount=sh.getLastRowNum();
		   
		   for (int i = 1; i <=ExcelRowcount; i++) {
		   	
		   	if (sh.getRow(i)!=null) {
		   	
		   	if (sh.getRow(i).getCell(0)!=null) {
		   	
		   	if (sh.getRow(i).getCell(0).getCellType()==CellType.NUMERIC) {
		   	int datInt1=(int) sh.getRow(i).getCell(0).getNumericCellValue();
		   	
		   	ExcelExpFileName=Integer.toString(datInt1).trim().toLowerCase();
		}
		   	
		   	if (sh.getRow(i).getCell(0).getCellType()==CellType.STRING) {
		   	ExcelExpFileName=sh.getRow(i).getCell(0).getStringCellValue().trim().toLowerCase();

		}
		   	
		   	
		   	

		}
		   	
		   	expFile=ExcelExpFileName;
		   	
		   	
		       if (sh.getRow(i).getCell(1)!=null) {
		   	
		   	if (sh.getRow(i).getCell(1).getCellType()==CellType.NUMERIC) {
		   	int datInt1=(int) sh.getRow(i).getCell(1).getNumericCellValue();
		   	
		   	ExcelActFileName=Integer.toString(datInt1).trim().toLowerCase();
		}
		   	
		   	if (sh.getRow(i).getCell(1).getCellType()==CellType.STRING) {
		   	ExcelActFileName=sh.getRow(i).getCell(1).getStringCellValue().trim().toLowerCase();

		}
		   	
		   	
		   	

		}
		   	
		   	
		   	
		   	actFile=ExcelActFileName;
		   	
		   	

		   	   
		   	   String all="YES";
		   	   
		   	   String alldir="YES";
		   	   
		   	   String idContains="NO";
		   	   
		   	   ArrayList<String> V=new ArrayList<String>();
		   	   ArrayList<String> Vrsult=new ArrayList<String>();
		   	   
		   	   
		   	   File f3=new File(l3);
		   	  
		   	   if (!f3.exists()) {
		   	   	
		   	   	f3.mkdir();
		   	   	
		   	}
		   	  
		   	String expFileName="";
		   	String actFileName="";
		   	
		   	File f1=new File(l1);
		   	File f2=new File(l2);
		   	
		           File[] filesList = null;
		   	
		   	if (f1.exists()) {
		   	
		   	all="NO";
		   	
		   	V.add("Y");
		   	filesList=f1.listFiles();
		   	
		   	
		   	if (filesList!=null) {
		   	
		   	for (File file : filesList) {
		   	
		   	if (file.isFile()) {
		   	
		   	alldir="NO";
		   	V.add("Y");
		   	
		   	String fileName=file.getName();
		   	
		   	if (fileName.toLowerCase().equalsIgnoreCase(expFile+".pdf")) {
		   	idContains="YES";
		   	V.add("Y");
		   	expFileName=fileName;
		   	
		   	
		   	break;
		   	}
		   	
		   	}
		   	
		   	}
		   	
		   	if (idContains.equalsIgnoreCase("NO")) {
		   	V.add("N");
		   	System.out.println(expFile+" : Containing FileName is not Available in the Directory   "+ l1);
		   	Vrsult.add(expFile+" : Containing FileName is not Available in the Directory   "+ l1);
		   	
		   	
		   	}	

		   	if (alldir.equalsIgnoreCase("YES")) {
		   	V.add("N");
		   	System.out.println(l1+" : Directory contains only Folders");
		   	Vrsult.add(l1+" : Directory contains only Folders");
		   	
		   	
		   	}
		   	
		   	
		   	
		   	}else {
		   	
		   	V.add("N");
		   	System.out.println(l1+" : In this Directory Files or Folders are Not Available");
		   	Vrsult.add(l1+" : In this Directory Files or Folders are Not Available");
		   	}
		   	
		   	
		   	
		   	}else {
		   	V.add("N");
		   	
		   	System.out.println(l1+" : Directory Not Available");
		   	Vrsult.add(l1+" : Directory Not Available");
		   	}
		   	

		   	
		   	
		   	alldir="YES";
		   	idContains="NO";
		   	all="YES";
		   	
		   	File[] filesList2 = null;
		   	
		   	
		   	if (f2.exists()) {
		   	V.add("Y");
		   	all="NO";
		   	
		   	filesList2=f2.listFiles();
		   	
		   	if (filesList2!=null) {
		   	V.add("Y");
		   	
		   	for (File file : filesList2) {
		   	
		   	if (file.isFile()) {
		   	alldir="NO";
		   	V.add("Y");
		   	String fileName=file.getName();
		   	
		   	
		   	if (fileName.toLowerCase().equalsIgnoreCase(actFile+".pdf")) {
		   	idContains="YES";
		   	V.add("Y");
		   	
		   	actFileName=fileName;
		   	break;
		   	
		   	}
		   	
		   	}
		   	
		   	}
		   	
		   	
		   	
		   	if (idContains.equalsIgnoreCase("NO")) {
		   	V.add("N");
		   	System.out.println(actFile+" : Containing FileName is not Available in the Directory   "+ l2);
		   	Vrsult.add(actFile+" : Containing FileName is not Available in the Directory   "+ l2);
		   	}
		   	

		   	if (alldir.equalsIgnoreCase("YES")) {
		   	V.add("N");
		   	System.out.println(l1+" : Directory contains only Folders");
		   	Vrsult.add(l1+" : Directory contains only Folders");
		   	}
		   	
		   	}else {
		   	V.add("N");
		   	
		   	System.out.println(l2+" : In this Directory Files or Folders are Not Available");
		   	
		   	Vrsult.add(l2+" : In this Directory Files or Folders are Not Available");
		   	}
		   	
		   	
		   	
		   	}else {
		   	
		   	V.add("N");
		   	
		   	System.out.println(l2+" : Directory Not Available");
		   	Vrsult.add(l2+" : Directory Not Available");
		   	}
		   	

		   	sh.getRow(i).createCell(2).setCellValue(Vrsult.toString().substring(1, Vrsult.toString().length()-1));
		   
		   	
		   	if (!V.contains("N")) 
		   	
		   	{
		   	
		   	boolean isEqual=new PdfComparator(l1+"/"+expFileName, l2+"/"+actFileName).compare().writeTo(l3+"/"+actFile+"_outputFile");
		   	
		   	
		   	
		   	if (isEqual==true) {
		   	System.out.println(" ************ RESULT ************\n");
		   	
		   	System.out.println("No Differences found!\n");
		   	
		   	Vrsult.add("No Differences found");
		   	System.out.println(" **********************************");
		   	
		   	}else {
		   	
		   	System.out.println(" ************ RESULT ************\n");
		   	
		   	System.out.println("Differences found!\n");
		   	
		   	Vrsult.add("Differences found");
		   	System.out.println(" **********************************");
		   	}
		   	
		   	}
		   	
		   	
		   	
		   	
		   	
		   	
		   	sh.getRow(i).createCell(2).setCellValue(Vrsult.toString().substring(1, Vrsult.toString().length()-1));
		       	
		       	
		       	
		   	
		   	   	
		   	
		   	

		}
		   	
		   	FileOutputStream fo=new FileOutputStream(p.getProperty("ExcelFileOutputPath"));
		ExcelWorkbook.write(fo);

		   	
		   	
		   	
		   	

		}

		   

	}

}
