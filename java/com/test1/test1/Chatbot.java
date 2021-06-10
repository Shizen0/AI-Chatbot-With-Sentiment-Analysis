package com.test1.test1;

import java.io.File;
import java.util.ArrayList;

import org.alicebot.ab.*;
import org.alicebot.ab.utils.*;
public class Chatbot {
	private static final boolean TRACE_MODE=false;
	String resourcepath=getpath();
	NaiveBayes nb = new NaiveBayes();
	wordClass wc = new wordClass();
	Bot b=new Bot("super",resourcepath);
	Chat chatsession=new Chat(b);
	String textline="";	
	String response(String text) {
		    MagicBooleans.trace_mode=TRACE_MODE;
		    String response=null;
		    try {
					System.out.println("YOU : ");				
					if(text==null || text.length()<1)
					{
						text=MagicStrings.null_input;
						
					}
					else if(text.equals("q"))
					{
						int overall=0;
						wc.results=nb.runNaiveBayes(wc);			
						for(int i =0;i<wc.results.size();i++) {
							response = wc.results.get(i);
							if(response.equals("positive"))
								overall++;
							else
								overall--;
							System.out.println(wc.results.get(i));
						}	
						if(overall>=0)
							System.out.println("Overall Sentiment is Positive according to conversation");
						else
							System.out.println("Overall Sentiment is Negative according to conversation");
						
						System.exit(0);
						
					}
					
					else if(text.equals("wq"))
					{
						b.writeQuit();
						System.exit(0);
					}
					
					else
					{
						System.out.println(wc.guitest);
						wc.guitest.add(text);
						String request=text;
						response=chatsession.multisentenceRespond(request);
						System.out.println("BOT :"+response);
						return response;
					}
	
			}
			catch (Exception e){
				
			}
			return null;
	
		
	}
	
	private static String getpath()
	{
		File currd=new File(".");
		String path=currd.getAbsolutePath();
		String resourcepath=path + File.separator +"src" + File.separator +"main" +File.separator +"resources";
		return resourcepath;
	}
}
