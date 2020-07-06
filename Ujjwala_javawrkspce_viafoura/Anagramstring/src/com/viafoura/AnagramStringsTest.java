package com.viafoura;

import static org.junit.Assert.*;


import org.junit.Test;

/**
 * @author Ujju
 *
 */
public class AnagramStringsTest {

	    /**
	     * Test case scenario for anagrams
	     * 
	     * 
	     * In the Test class assertTrue and assertfalse calls the method checkAnagram in the Anagram_Strings class and 
	     * checks whether the passed strings are anagrams of each other
	     * 
	     */
	    @Test
	    public void isAnagram() {
	    
	    		assertTrue(Anagram_Strings.checkAnagram("word", "wrdo")); 
	    		assertFalse(Anagram_Strings.checkAnagram("bbb", "b"));
	    		assertFalse(Anagram_Strings.checkAnagram("ccc", "ccccccc"));
	    		assertTrue(Anagram_Strings.checkAnagram("a", "a"));
	    		assertFalse(Anagram_Strings.checkAnagram("sleep", "slep"));
	    		assertTrue(Anagram_Strings.checkAnagram("boat", "btoa"));
	    		assertFalse(Anagram_Strings.checkAnagram("pure", "in"));
	    		assertFalse(Anagram_Strings.checkAnagram("fill", "fil"));
	    		assertTrue(Anagram_Strings.checkAnagram("cinema", "iceman"));
	 

	    }
	    
	   
	}


