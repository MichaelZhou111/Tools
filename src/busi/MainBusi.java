package busi;

import java.io.IOException;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.Map;
import java.io.File;
import common.ReadConfigFile;
import common.WriteLogFile;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public  class MainBusi {
	int count=0;//define the count number
	File fo = new File("src/out.log");
	WriteLogFile wf = new WriteLogFile();
	StringBuffer sb = new StringBuffer();
	/**
	 * @throws IOException 
	 */
	public  void busi() throws IOException {
		/*String configPath = "F:\\workspace3\\StringFind\\src\\config\\config.txt";
		absolutely path,Ok*/
		
		/*String configPath = "src\\config\\config.txt";
		one method of relative path,ok*/
		
		String configPath = "src/config/config.txt";
		ReadConfigFile config = new ReadConfigFile();
		Map h= config.readByLine(configPath);
		File f = new File(h.get("path").toString());
		String reg = h.get("string").toString();
		match(f,reg);
		wf.writeFile(fo, sb.toString());
	}
	
	public  void match(File f,String reg) throws IOException{
		if(f!=null){
			if(f.isDirectory()){
				File fileArray[] =f.listFiles();
				if(fileArray !=null){
					for(int i=0;i<fileArray.length;i++){
						match(fileArray[i],reg);
					}
				}
			}
			else{
				InputStreamReader isr = new InputStreamReader(new FileInputStream(f), "UTF-8");
				BufferedReader in = new BufferedReader(isr);
				/*BufferedReader in = new BufferedReader(new FileReader(f));
				采用FileReader作为构造器时，会出现中文乱码*/
				String str= in.readLine();
				int linenum = 1; //define the line number
				while(str!=null){
					Pattern p=Pattern.compile(reg);
					Matcher m=p.matcher(str);
					while(m.find()){	
						count ++;
						String str1="The  "+ count +" matcher is as below";
						String str2="File name is: "+f.toString();
						String str3="The line is: "+str;
						String str4="The line number is: "+linenum;
						
						//print to console
						System.out.println("The  "+ count +" matcher is as below");
						System.out.println("File name is: "+f.toString());
						System.out.println("The line is: "+str);
						System.out.println("The line number is: "+linenum);
						//System.out.println(m.group());	
						sb.append(str1).append("\n").append(str2).append("\n").append(str3).append("\n").append(str4).append("\n");	
					}
					str = in.readLine();
					linenum ++;
				}	
			}
		}
	}
}
