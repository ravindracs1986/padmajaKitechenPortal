package com.padmaja.kitchen.util;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Image;
import com.itextpdf.text.pdf.PdfContentByte;
import com.itextpdf.text.pdf.PdfReader;
import com.itextpdf.text.pdf.PdfStamper;

public class PdfFileUpdate {

	static String FILE = "E:/TestDocSign/worker-medical-report_After_Sign.pdf";
	public static void main(String[] args) throws IOException, DocumentException {
	
		
		PdfReader reader = new PdfReader(FILE);
		PdfStamper stamper = new PdfStamper(reader, new FileOutputStream("E:/TestDocSign/ravindra.pdf"));
		PdfContentByte content = stamper.getOverContent(1);
		Image image = Image.getInstance("E:/TestDocSign/new-images/besti-logo-2.png");
		// scale the image to 50px height
		image.scaleAbsoluteHeight(50);
		image.scaleAbsoluteWidth((image.getWidth() * 50) / image.getHeight());
		image.setAbsolutePosition(100, 10);
		content.addImage(image);
		stamper.close();
		System.out.println("done appending");
		
		

	}

}
