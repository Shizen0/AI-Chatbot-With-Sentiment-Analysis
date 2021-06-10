package com.test1.test1;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

public class wordClass {
	  ArrayList<ArrayList> reviews = new ArrayList<ArrayList>();
	  ArrayList<String> test = new ArrayList<String>();
	  ArrayList<String> guitest = new ArrayList<String>();
	  ArrayList<String> results = new ArrayList<String>();
	

	String goodWords [] = {"good", "excellent", "fabulous", "awesome", "nice","enthusiastic","thankful",
			  "curious","hopeful","impressed","Affectionate","invincible","proud","tempted",
			  "delighted","satisfied","confident","calm","energetic","fearless","fortunate"}; 
	  
	   String badWords [] = {"bad", "worse", "terrific", "horrible", "disgusting","worried","shy","bitter",
			   "homesick","threatened","furious","cheated","passed away","stressed","tense",
			   "left out","trapped","rebellious","puzzled","bored","sad","aggressive"
			   ,"disappointed","cowardly"," humiliated","stingy","stubborn","moody","miserable",
			   "selfish","rejected","upset","depressed","burdened","concerned","jealous"}; 
	   
	   String neutral [] = {"okay", "acceptable", "moderate", "sensible", "unbiased",
			   "uncertain","cautious","indecisive","doubtful","impatient","awkward","exhausted",
			   "anxious","shocked","uneasy","scared","self-conscious","lazy","withdrawn"}; 
	   
	   
	   void setDataSet() {
		   String filename="D:\\Eclipseworkspace 2020\\ChatbotApplication\\src\\main\\java\\com\\test1\\test1\\test.txt";
		   ArrayList<String> positiveSentences = new ArrayList<String>();
		   ArrayList<String> negativeSentences = new ArrayList<String>();
			
			BufferedReader br = null; 
			FileReader fr = null; 
			try { 
				fr = new FileReader(filename); 
				br = new BufferedReader(fr); 
			   String sLine;
			
			   br = new BufferedReader (new FileReader(filename)); 
			while ((sLine = br.readLine())!= null) { 
				if(sLine.charAt(0)=='1') {
					positiveSentences.add(sLine); 		
					
				}
				else if (sLine.charAt(0)=='0') {
					negativeSentences.add(sLine); 
					
				}
				
			    	
				   
			} 
			//System.out.println(positiveSentences);
	
			reviews.add(positiveSentences);
			reviews.add(negativeSentences);
		
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
	   void getTestData() {
		   String filename="D:\\Eclipseworkspace 2020\\ChatbotApplication\\src\\main\\java\\com\\test1\\test1\\test2.txt";
		   
			BufferedReader br = null; 
			FileReader fr = null; 
			try { 
				fr = new FileReader(filename); 
				br = new BufferedReader(fr); 
			   String sLine;
			
			   br = new BufferedReader (new FileReader(filename)); 
			while ((sLine = br.readLine())!= null) { 
					test.add(sLine); 				
			} 
		
			   
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
	   public static void main (String [] args) { 
		   wordClass wc = new wordClass();
		   wc.setDataSet();		   		   
	   }		 
}

