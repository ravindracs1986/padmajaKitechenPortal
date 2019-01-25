package com.padmaja.kitchen.controller;

import java.io.FileOutputStream;
import java.io.IOException;
import java.net.MalformedURLException;

import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Image;
import com.itextpdf.text.pdf.PdfWriter;

public class AddImageAbsolutePosition {

	private static String DEST="E:/WorkSpaceISC/Doc_Signing/Doc_sign_Doc/UploadLocTemp/Medical_Report_2_after_Sign.pdf";

	public static void main(String[] args) throws DocumentException, MalformedURLException, IOException {
		Document document = new Document();
		PdfWriter.getInstance(document, new FileOutputStream(DEST));
		document.open();
		Image img = Image.getInstance("E:/WorkSpaceISC/Doc_Signing/Doc_sign_Doc/fwcms-logo.png");
		img.setAbsolutePosition(450f, 10f);
		document.add(img);
		document.close();
		System.out.println("Done");
	}

}
