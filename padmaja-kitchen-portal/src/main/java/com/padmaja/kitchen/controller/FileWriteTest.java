package com.padmaja.kitchen.controller;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.attribute.DosFileAttributeView;

import com.itextpdf.text.DocumentException;
import com.itextpdf.text.pdf.PRStream;
import com.itextpdf.text.pdf.PdfArray;
import com.itextpdf.text.pdf.PdfDictionary;
import com.itextpdf.text.pdf.PdfName;
import com.itextpdf.text.pdf.PdfObject;
import com.itextpdf.text.pdf.PdfReader;
import com.itextpdf.text.pdf.PdfStamper;

public class FileWriteTest {

	private static String DEST="E:/WorkSpaceISC/Doc_Signing/Doc_sign_Doc/UploadLocTemp/Medical_Report_2_after_Sign.pdf";
	
	public static final String SRC = "E:/WorkSpaceISC/Doc_Signing/Doc_sign_Doc/Medical_Report_1_Before_Sign.pdf";
	//public static final String DEST = "C:/tmp/244558-2.pdf";

	public static void main(String[] args) throws IOException, DocumentException {
	    File file = new File(DEST);
	    file.getParentFile().mkdirs();
	    new FileWriteTest().manipulatePdf(SRC, DEST);
	}

	public void manipulatePdf(String src, String dest) throws IOException, DocumentException {
	    PdfReader reader = new PdfReader(src);
	    PdfDictionary dict = reader.getPageN(1);
	    PdfObject object = dict.getDirectObject(PdfName.CONTENTS);
	    PdfArray refs = null;
	    if (dict.get(PdfName.CONTENTS).isArray()) {
	        refs = dict.getAsArray(PdfName.CONTENTS);
	    } else if (dict.get(PdfName.CONTENTS).isIndirect()) {
	        refs = new PdfArray(dict.get(PdfName.CONTENTS));
	    }
	    
	    for (int i = 0; i < refs.getArrayList().size(); i++) {
	        PRStream stream = (PRStream) refs.getDirectObject(i);
	        byte[] data = PdfReader.getStreamBytes(stream);
	        stream.setData(new String(data).replace("MALAYSIA", "INDIA").getBytes());
	    }
	    PdfStamper stamper = new PdfStamper(reader, new FileOutputStream(dest));
	    stamper.close();
	    reader.close();
	}


}
