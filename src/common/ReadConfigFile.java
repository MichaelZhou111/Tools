package common;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public class ReadConfigFile {
	
/*	 read specific file(lines are separated by "=")
	 return a map , keys are strings before "=",values are strings after "="*/
	 
	public Map readByLine(String file) throws IOException{
		File f = new File(file);
		Map m =new HashMap();
		if(!f.exists()){
			System.out.println("the input file is not available, please check the path property in config file");
		}
		else{
			BufferedReader in= new BufferedReader(new FileReader(file));
			String line = in.readLine();
			while (line != null) {
				String temp[]=line.split("=");
				m.put(temp[0], temp[1]);
				line = in.readLine();
		}	
			in.close();	   
	}
		 return m;
}
}
	
