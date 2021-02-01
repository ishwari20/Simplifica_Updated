package com.aia05.simplifica.web;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.aia05.simplifica.service.CareerSelector;

@RestController
public class Controller {
	
	@Autowired
	public CareerSelector careerSelector;
	
	@RequestMapping("/convert")
	public ArrayList<String> doConversion(@RequestParam("one") String one,
			@RequestParam("two") String two,
			@RequestParam("three") String three,
			@RequestParam("four") String four,
			@RequestParam("five") String five,
			@RequestParam("six") String six) {
		
		ArrayList<String> choiceList = new ArrayList<String>();
		choiceList.add(one);
		choiceList.add(two);
		choiceList.add(three);
		choiceList.add(four);
		choiceList.add(five);
		choiceList.add(six);
		return careerSelector.doConversion(choiceList);
	}
	
}