package com.hdquan.util;

import java.io.*;

import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Text;

public class Readfile {
    public void readfile(Text text) throws IOException{
        File f=new File("images//2.txt");
        String s=null;
        if(f.isFile() &&  f.exists()){
            InputStream file = new FileInputStream(f);
            InputStreamReader read = new InputStreamReader(file,"GBK");
            BufferedReader bufferedReader = new BufferedReader(read);
                String lineTxt ="";
                while((bufferedReader.readLine()) != null){
                	lineTxt=lineTxt+bufferedReader.readLine();
                }
            	System.out.println(lineTxt);
            	text.setText(lineTxt);
                read.close();
        }else{
            System.out.print("this file is not exit");
        }
}
    public static void main(String args[])
    {
//    	Readfile Readfile=new Readfile();
//    	try {
//			Readfile.readfile();
//		} catch (IOException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
    }
}