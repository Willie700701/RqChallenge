package com.example.rqchallenge;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.awt.PageAttributes.MediaType;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.RequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import com.example.rqchallenge.employees.IEmployeeController;
import com.example.rqchallenge.vo.EmployeeVO;
import com.fasterxml.jackson.databind.ObjectMapper;

@SpringBootTest(classes = RqChallengeApplication.class)
@ExtendWith(SpringExtension.class)
@WebMvcTest(controllers = IEmployeeController.class)
class RqChallengeApplicationTests {

	@Autowired
	private MockMvc mockMvc;
    @Test
    void contextLoads() {
    }
 
    @Test
    public void testGetAllEmpl() {
    	try {
    	mockMvc.perform(get("/api/v1/employees")
    			.contentType("application/json"))
    			.andExpect(status().isOk());
    	}catch(Exception exc) {
    		exc.printStackTrace();
    	}
    }
    
    @Test
    public void testCreateEmpl() {
    	EmployeeVO empVo = new EmployeeVO();
    	empVo.setEmplName("Michael Thomas");
    	empVo.setEmplAge(56);
    	empVo.setEmplSalary(50000);
    	try {
    		String jsonReq = new ObjectMapper().writeValueAsString(empVo);
    	 
    		RequestBuilder reqBuilder = MockMvcRequestBuilders.post("/api/vi/create") 
				.accept("application/json")
    			.contentType("application/json")
    			.content(jsonReq);
    			
    		MvcResult mvcResult = mockMvc.perform(reqBuilder).andReturn();
    	}catch(Exception exc) {
    		exc.printStackTrace();
    	}
    }
}//end RqChallengeApplicationTests
