package com.hdquan;

import java.io.FileOutputStream;

import com.sun.image.codec.jpeg.JPEGCodec;
import com.sun.image.codec.jpeg.JPEGImageEncoder;

public class JPG {
	public static void main(String ars[])
	{
		try {
			JPEGImageEncoder encoder=JPEGCodec.createJPEGEncoder(new FileOutputStream("src//geometry.jpg"));
			  PaintCanvas canvas=new PaintCanvas(); 
		       encoder.encode(canvas.getImage());
		    }
		    catch(Exception ee) {}

	}
}