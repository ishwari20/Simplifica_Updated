package com.aia05.simplifica.service;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Map.Entry;

import org.springframework.stereotype.Service;

@Service
public class CareerSelector {
	private Map<String, String> featureToCareer = new HashMap<String, String>();
	
	public CareerSelector() {
		featureToCareer.put("Research Work", "Engineering");
		featureToCareer.put("Administrative Task", "Business Administration");
		featureToCareer.put("Logical Thinking", "Design");
		featureToCareer.put("Welfare", "Medical");
		featureToCareer.put("Empathy", "Medical");
		featureToCareer.put("Justice", "Law");
		featureToCareer.put("Creativity", "Design");
		featureToCareer.put("Persuasiveness", "Business Administration");
		featureToCareer.put("Technical Skills", "Engineering");
		featureToCareer.put("Debating Skills", "Law");
		featureToCareer.put("Consulting", "Business Administration");
		featureToCareer.put("Courage", "Medical");
	}
	
	public ArrayList<String> doConversion(ArrayList<String> choicesList) {
		ArrayList<String> careerList = new ArrayList<String>();
		for (String choice: choicesList) {
			careerList.add(featureToCareer.get(choice));
		}
		
		//Sort the careerList according to number of occurrences (Descending Order)
		Map<String, Integer> frequencyMap = new LinkedHashMap<String, Integer>();
		
		for (String career: careerList) {
			if (frequencyMap.containsKey(career)) {
				int temp = frequencyMap.get(career);
				frequencyMap.replace(career, temp+1);
			}
			else {
				frequencyMap.put(career, 1);
			}
		}
		
		ArrayList<Entry<String, Integer>> careerEntryList = new ArrayList<Entry<String, Integer>>(frequencyMap.entrySet());
		Collections.sort(careerEntryList, new Comparator<Entry<String, Integer>>()
				{
					@Override
					public int compare(Entry<String, Integer> o1, Entry<String, Integer> o2) {
						return (o2.getValue()).compareTo(o1.getValue());
					}
				});
		
		ArrayList<String> sortedCareerList = new ArrayList<String>();
		
		for(int i=0; i<1; i++) {
			sortedCareerList.add(careerEntryList.get(i).getKey());
		}
		
		return sortedCareerList;
	}
	
}
