package com.viafoura.dao;

import org.apache.log4j.Logger;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import org.springframework.stereotype.Repository;

import com.fasterxml.jackson.databind.annotation.JsonSerialize;

/**
 * @author Ujju
 *
 */

@Repository
@JsonSerialize
public class AnagramDao {
	
	/**
	 * 
	 */
	Logger logger = Logger.getLogger(this.getClass());
	/**
	 * 
	 */
	JSONArray jsonarr=new JSONArray(); 
	
	//This function takes two strings and returns true if the strings are anagrams of each other
	/**
	 * @param anagramstr1
	 * @param anagramstr2
	 * @return
	 * @throws JSONException
	 */
	public JSONObject areAnagrams(String anagramstr1,String anagramstr2) throws JSONException
	{
		logger.info("Enter areAnagrams - "+anagramstr1+ " | "+anagramstr2);
		JSONObject jsonobj=new JSONObject();
		if(anagramstr1.length() == anagramstr2.length()) {
			logger.info("Both string are equal in length, calculating anagrams");
			char[] characters = anagramstr1.toCharArray();
			StringBuilder sbSecond = new StringBuilder(anagramstr2);
			for(char ch : characters)
			{
				int index = sbSecond.indexOf("" + ch);
				if(index != -1){
					sbSecond.deleteCharAt(index);
				}
				
				try {
					jsonobj=sbSecond.length()==0 ? jsonobj.put("areAnagrams","true"):jsonobj.put("areAnagrams","false");
					logger.info("jsonobj - "+jsonobj);
				} catch (JSONException e) {
					logger.error("JSONException - "+e.getMessage());
					e.printStackTrace();
				}
			}
		}else {
			logger.info("Both string are different in length, returning false");
			jsonobj.put("areAnagrams","false");
		}
		logger.info("Exit areAnagrams - "+jsonobj);
		return jsonobj;
	}	
	
	//This function takes a string and returns all possible anagrams of the string
	/**
	 * @param anagramstr1
	 * @return
	 * @throws JSONException
	 */
	public JSONObject areAnagrams(String anagramstr1) throws JSONException
	{
		logger.info("DAO : Enter areAnagrams - "+anagramstr1);
		JSONObject jsonobj=new JSONObject(); 
		int n=anagramstr1.length();
		logger.info("Calling permute");
		jsonobj=permute(anagramstr1,0,n-1,jsonobj);
		logger.info("DAO : Exit areAnagrams - "+jsonobj);
		return jsonobj;
	}

  /**
 * @param str
 * @param l
 * @param r
 * @param jsonobj
 * @return
 * @throws JSONException
 */
private JSONObject permute(String str, int l, int r,JSONObject jsonobj) throws JSONException 
    { 
	 
    if (l == r) 
    {
        jsonarr.put(str);
    }
    else
    { 
        for (int i = l; i <= r; i++) 
        { 
            str = swap(str,l,i); 
            permute(str, l+1, r,jsonobj); 
            str = swap(str,l,i); 
        } 
    }
    jsonobj.put("anagrams", jsonarr);
    return jsonobj;
} 
/** 
 * Swap Characters at position 
 * @param a string value 
 * @param i position 1 
 * @param j position 2 
 * @return swapped string 
 */
public String swap(String a, int i, int j) 
{ 
    char temp; 
    char[] charArray = a.toCharArray(); 
    temp = charArray[i] ; 
    charArray[i] = charArray[j]; 
    charArray[j] = temp; 
    return String.valueOf(charArray); 
} 

	
}