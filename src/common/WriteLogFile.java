package common;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.io.UnsupportedEncodingException;

public class WriteLogFile {
	
	public void writeFile(File fo,String s) throws IOException{
	if(!fo.exists()){
		System.out.println("out.log is not exist , will create a new log file");
		fo.createNewFile();
	}
	OutputStreamWriter osr = new OutputStreamWriter(new FileOutputStream(fo),"UTF-8");
	BufferedWriter out = new BufferedWriter(osr);
/*	out.write(s);
	out.newLine();
	out.flush();
	--the code above just truncate the log file ,
	then write the new string s*/
	out.write(s);
	out.newLine();
	out.flush();
	out.close();
	}
}
