package com.viafoura.unittest;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.json.JSONObject;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.mock.web.MockHttpServletResponse;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.RequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import com.viafoura.controller.AnagramController;
import com.viafoura.service.AnagramService;

/**
 * @author Ujju
 *
 */
@RunWith(SpringRunner.class)
@WebMvcTest(value = AnagramController.class)
public class AnagramControllerTest {
	
	/**
	 * 
	 */
	@Autowired
	private MockMvc mockMvc;
	
	@MockBean
	private AnagramService service;
	
	//Unit Test Scenario #1 400 REQUEST
	/**
	 * @throws Exception
	 */
	@Test
	public void areAnagramsTestCase1() throws Exception{
		testCaseSecenario("http://localhost:8080/anagrams/fund/demo12",2,400);
	}
	
	//Unit Test Scenario #1 400 REQUEST
	/**
	 * @throws Exception
	 */
	@Test
	public void areAnagramsTestCase2() throws Exception{
		testCaseSecenario("http://localhost:8080/anagrams/fund12/demo",2,400);
	}
	
	//Unit Test Scenario #1 400 REQUEST
	/**
	 * @throws Exception
	 */
	@Test
	public void areAnagramsTestCase3() throws Exception{
		testCaseSecenario("http://localhost:8080/anagrams/fund12/demo12",2,400);
	}
		
	//Unit Test Scenario #2 200 REQUEST - RETURNS TRUE
	/**
	 * @throws Exception
	 */
	@Test
	public void areAnagramsTestCase4() throws Exception{
		testCaseSecenario("http://localhost:8080/anagrams/fund/dunf",2,200);
	}
	
	//Unit Test Scenario #2 200 REQUEST - RETURNS FALSE
	/**
	 * @throws Exception
	 */
	@Test
	public void areAnagramsTestCase5() throws Exception{
		testCaseSecenario("http://localhost:8080/anagrams/fund/demo",2,200);
	}
	
	//Unit Test Scenario #2 200 REQUEST - RETURNS FALSE
	/**
	 * @throws Exception
	 */
	@Test
	public void areAnagramsTestCase6() throws Exception{
		testCaseSecenario("http://localhost:8080/anagrams/fund/fun",2,200);
	}
	
	//Unit Test Scenario #3 200 REQUEST
	/**
	 * @throws Exception
	 */
	@Test
	public void areAnagramsTestCase7() throws Exception{
		testCaseSecenario("http://localhost:8080/anagrams/fund",1,200);
	}
	
	//Unit Test Scenario #4 400 REQUEST
	/**
	 * @throws Exception
	 */
	@Test
	public void areAnagramsTestCase8() throws Exception{
		testCaseSecenario("http://localhost:8080/anagrams/fund12",1,400);
	}
	
	//Mock
	/**
	 * @param postURL
	 * @param noArguments
	 * @param expectedResult
	 * @throws Exception
	 */
	private void testCaseSecenario(String postURL,int noArguments,int expectedResult) throws Exception {
		RequestBuilder requestBuilder = MockMvcRequestBuilders
				.post(postURL)
				.accept(MediaType.APPLICATION_JSON_VALUE).content("")
				.contentType(MediaType.APPLICATION_FORM_URLENCODED_VALUE);
		
		JSONObject jsonobj=new JSONObject();
		jsonobj.put("mockTest", "success");
		if(noArguments == 2) {
		Mockito.when(
				service.areAnagrams(Mockito.anyString(),Mockito.anyString()))
				.thenReturn(jsonobj);
		}else {
			Mockito.when(
					service.areAnagrams(Mockito.anyString()))
					.thenReturn(jsonobj);
		}
		MvcResult result = mockMvc.perform(requestBuilder).andReturn();

		MockHttpServletResponse response = result.getResponse();
		
		switch(expectedResult) {
			case 200:
				assertEquals(HttpStatus.OK.value(), response.getStatus());
				break;
			case 400:
				assertEquals(HttpStatus.BAD_REQUEST.value(), response.getStatus());
				break;
		}
	}
}
