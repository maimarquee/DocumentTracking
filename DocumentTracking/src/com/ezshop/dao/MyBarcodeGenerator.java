package com.ezshop.dao;


import java.awt.image.BufferedImage;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;

import org.krysalis.barcode4j.impl.code128.Code128Bean;
import org.krysalis.barcode4j.output.bitmap.BitmapCanvasProvider;
import org.krysalis.barcode4j.tools.UnitConv;

public class MyBarcodeGenerator {
	//technopal/workspace/barcode4j/WebContent/src
	//C:\personal file\technopal\workspace\DocuTracky\WebContent\common
	//"C:/personal file/technopal/workspace/barcode4j/WebContent/common/";
	private String barCodePath = "C:/Users/admin/workspace/DocuTracky3/WebContent/common/barcode/";
	String fileNames = "";
	public void createBarCode128(String fileNamezz) {
		//String fileName = StringUtil.getNumberToWords(fileNamezz);
		String fileNamet = "barcode";
		try {
			Code128Bean bean = new Code128Bean();
			final int dpi = 200;

			//Configure the barcode generator
			// bean.setModuleWidth(UnitConv.in2mm(2.8f / dpi));
			bean.setModuleWidth(UnitConv.in2mm(4.8f / dpi));
			bean.doQuietZone(false);
			//Open output file
			File outputFile = new File(barCodePath + fileNamezz + ".jpg");
			FileOutputStream out = new FileOutputStream(outputFile);
			BitmapCanvasProvider canvas = new BitmapCanvasProvider(out, "image/x-png", dpi, BufferedImage.TYPE_BYTE_BINARY, false, 0);
			//Generate the barcode
			bean.generateBarcode(canvas, fileNamezz);
			//Signal end of generation
			canvas.finish();
			out.close();
			System.out.println("Bar Code is generated successfully…");
		}
		catch (IOException ex) {
			ex.printStackTrace();
		}
	}
}