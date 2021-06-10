package com.test1.test1;


import java.util.ArrayList;
import java.util.Arrays;

import de.daslaboratorium.machinelearning.classifier.bayes.BayesClassifier;
import de.daslaboratorium.machinelearning.classifier.Classifier;

public class NaiveBayes {

    ArrayList<String> runNaiveBayes(wordClass wc) {
        final Classifier<String, String> bayes = new BayesClassifier<String, String>();
       
		wc.setDataSet();

		
	for(int i=0;i<wc.reviews.get(0).size();i++) {	
		
			final String[] positiveText =  ((String) wc.reviews.get(0).get(i)).split("\\s");		
			bayes.learn("positive", Arrays.asList(positiveText));
		}
		for(int i=0;i<wc.reviews.get(1).size();i++) {
			
			final String[] negativeText = ((String) wc.reviews.get(1).get(i)).split("\\s");
			bayes.learn("negative", Arrays.asList(negativeText));
		}
 
       wc.getTestData();
   
       int counter=1;
        for(int i=0;i<wc.guitest.size();i++) {
        	
			final String[] testText = ((String) wc.guitest.get(i)).split("\\s");
        	
			System.out.println(bayes.classify(Arrays.asList(testText)).getCategory()+ " "+counter);
			counter++;
			wc.results.add(bayes.classify(Arrays.asList(testText)).getCategory());
			((BayesClassifier<String, String>) bayes).classifyDetailed(
	         		Arrays.asList(testText));
	        
		}
        System.out.println(wc.guitest.size());
        System.out.println(bayes.getCategories());
       
        bayes.setMemoryCapacity(1500); 
		return wc.results;
    }
}

