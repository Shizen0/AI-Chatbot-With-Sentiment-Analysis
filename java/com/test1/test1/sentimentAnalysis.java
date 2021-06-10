package com.test1.test1;
import java.io. *; 
public class sentimentAnalysis { 
private static final String filename="D:\\Eclipseworkspace 2020\\Chatbotexercise\\bin\\sentimentAnalysis\\opinions.txt"; 
	public static void main (String [] args) { 
		wordClass wordClass = new wordClass();
		
		BufferedReader br = null; 
		FileReader fr = null; 
		try { 
			fr = new FileReader(filename); 
			br = new BufferedReader(fr); 
		   String sLine;
		   int moderateOpinion=0; 
		   int positiveSentiment=0; 
		   int negativeSentiment=0; 
		   int totalSentiments=0; 
		   float polarity; 
		   br = new BufferedReader (new FileReader(filename)); 
		while ((sLine = br. readLine())!= null) { 
			for (int i=0; i<5; i++) { 
			        if(sLine.contains(wordClass.goodWords[i])){
			        	positiveSentiment++; 
			            totalSentiments++;
			            System.out.println(sLine);
			        } 
			        else if(sLine.contains(wordClass.badWords[i])){
			        	negativeSentiment++; 
			        	totalSentiments++;
			        	System.out.println(sLine);
			        } 
			        else if(sLine.contains(wordClass.neutral[i])){	
			        	moderateOpinion++; 
			            totalSentiments++;
			            System.out.println(sLine);
			        } 
			    }  
		} 
			
		    polarity = (float)positiveSentiment/totalSentiments; 
		  
		    System.out.println("-------Summary-------"); 
		    System.out.println("Positive Reviews : "+positiveSentiment); 
		    System.out.println("Negative Reviews : "+negativeSentiment); 
		    System.out.println("Neutral Reviews  : "+moderateOpinion); 
		    System.out.println("Total Reviews    : "+totalSentiments); 
		    System.out.println("Polarity         : "+polarity); 
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
