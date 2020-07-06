package com.viafoura.service;

import org.apache.log4j.Logger;
import org.json.JSONException;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.viafoura.dao.AnagramDao;

/**
 * @author Ujju
 *
 */
/**
 * @author Ujju
 *
 */
/**
 * @author Ujju
 *
 */
@Service
public class AnagramService {
	
	/**
	 * 
	 */
	Logger logger = Logger.getLogger(this.getClass());
	
	/**
	 * 
	 */
	
	@Autowired
	private AnagramDao dao;
	
	public AnagramDao getDao() {
		return dao;
	}

	public void setDao(AnagramDao dao) {
		this.dao = dao;
	}

	/**
	 * @param firstParam
	 * @param secondParam
	 * @return
	 * @throws JSONException
	 */
	public JSONObject areAnagrams(String firstParam,String secondParam) throws JSONException{
		logger.info("Enter areAnagrams - firstParam = "+firstParam+" | secondParam = "+secondParam);
		JSONObject jsonobj=dao.areAnagrams(firstParam, secondParam);
		logger.info("Exit areAnagrams - "+jsonobj.toString()); 
		return jsonobj;
		
	}
	
	/**
	 * @param firstParam
	 * @return
	 * @throws JSONException
	 */
	public JSONObject areAnagrams(String firstParam) throws JSONException{
		logger.info("Enter areAnagrams - firstParam = "+firstParam);
		JSONObject jsonobj=dao.areAnagrams(firstParam);
		logger.info("Exit areAnagrams - "+jsonobj.toString()); 
		return jsonobj;
		
	}
}
