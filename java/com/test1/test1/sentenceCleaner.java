package com.test1.test1;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.util.ArrayList;

public class sentenceCleaner {

	public static void main(String[] args) throws FileNotFoundException {
		  String filename="D:\\Eclipseworkspace 2020\\test1\\src\\main\\java\\com\\test1\\test1\\sentiments1.txt";
		  File file = new File("D:\\Eclipseworkspace 2020\\test1\\\\src\\main\\\\java\\com\\\\test1\\test1\\sentimentsNew.txt");
			FileOutputStream fos = new FileOutputStream(file);		 
			BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(fos));
	
			BufferedReader br = null; 
			FileReader fr = null; 
			try { 
				fr = new FileReader(filename); 
				br = new BufferedReader(fr); 
			   String sLine;
			   br = new BufferedReader (new FileReader(filename)); 
					boolean result;  
					try{  
					result = file.createNewFile();  //creates a new file  
					if(result){  
						System.out.println("file created "+file.getCanonicalPath()); //returns the path string  
					}  
					else  {  
						System.out.println("File already exist at location: "+file.getCanonicalPath());  
					}  
					}   
					catch (IOException e){  
						e.printStackTrace();    //prints exception if any  
					}         
					
					while ((sLine = br.readLine())!= null) { 
						 fos=new FileOutputStream(file, true); 										     
						 bw.write(sLine);
						 bw.newLine();
						
					} 
					fos.close();     	
					
					
					
				
			//System.out.println(positiveSentences);
	
		
		
			} 
			catch (IOException e) 
			{
				e. printStackTrace ();
			} 
			finally { 
				try { 
					 if (br != null) 
						 br. close (); 
				     if (fr != null) 
				    	 fr. close (); 
				     } 
				catch (IOException e) 
				{
					e. printStackTrace ();
				} 
			}

	}

}
