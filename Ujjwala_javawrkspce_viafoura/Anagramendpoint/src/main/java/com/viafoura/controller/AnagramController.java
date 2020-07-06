package com.viafoura.controller;


import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.Logger;
import org.json.JSONException;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.viafoura.service.AnagramService;


/**
 * @author Ujju
 *
 */
@RestController
@RequestMapping("/")
public class AnagramController {
	
	/**
	 * 
	 */
	Logger logger = Logger.getLogger(this.getClass());
	
	/**
	 * 
	 */
	@Autowired
	private AnagramService service;
	
	public AnagramService getService() {
		return service;
	}

	public void setService(AnagramService service) {
		this.service = service;
	}

	//This EndPoint takes two string arguments and returns BAD request if status is 400
	// And returns true|false if status is 200.
	/**
	 * @param anagramstr1
	 * @param anagramstr2
	 * @return
	 * @throws JSONException
	 */
	@PostMapping(path = "/anagrams/{anagramstr1}/{anagramstr2}", produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_FORM_URLENCODED_VALUE)
	public ResponseEntity<?> areAnagrams(@PathVariable("anagramstr1") String anagramstr1,@PathVariable("anagramstr2") String anagramstr2) throws JSONException {
		logger.info("Enter areAnagrams - Path Variables = "+anagramstr1+" | "+anagramstr2);
		List<String> anagram=new ArrayList<String>();
		anagram.add(anagramstr1);
		anagram.add(anagramstr2);
		logger.info("Validating Path Variables");
		boolean val=checkvalidstrings(anagram);
		if(val){
			logger.info("Both strings are valid, calling service");
			JSONObject jsonobj=service.areAnagrams(anagramstr1, anagramstr2);
			return ResponseEntity.status(HttpStatus.OK).body(jsonobj.toString());
		}else{
			logger.info("Invalid String passed - returning HTTP BAD REQUEST");
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("{\"request\": \"bad request\"}");
		}
	}
	
	//This EndPoint takes a single string argument and returns BAD request if status is 400 
	//And returns an array of possible anagrams if status is 200.
	/**
	 * @param anagramstr1
	 * @return
	 * @throws JSONException
	 */
	@PostMapping(path = "/anagrams/{anagramstr1}", produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_FORM_URLENCODED_VALUE)
	public ResponseEntity<?> areAnagrams(@PathVariable("anagramstr1") String anagramstr1) throws JSONException {
		logger.info("Enter areAnagrams - Path Variable = "+anagramstr1);
		List<String> anagram=new ArrayList<String>();
		anagram.add(anagramstr1);
		logger.info("Validating Path Variable");
		boolean val=checkvalidstrings(anagram);
		if(val){
			logger.info("Valid String, calling service");
			JSONObject jsonobj=service.areAnagrams(anagramstr1);
			return ResponseEntity.status(HttpStatus.OK).body(jsonobj.toString());
		}else{
			logger.info("Invalid String passed - returning HTTP BAD REQUEST");
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("{\"request\": \"bad request\"}");
		}
	}

	//Function to validate the string
	/**
	 * @param anagrams
	 * @return
	 */
	private boolean checkvalidstrings(List<String> anagrams) {
		boolean val=false;
		for(String s:anagrams)
		{
			val= s!=null && s.matches("^[a-zA-Z]*$");
			if(val==false)
				break;
		}
		return val;
	}
}