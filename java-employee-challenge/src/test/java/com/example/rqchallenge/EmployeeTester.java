package com.example.rqchallenge;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import com.example.rqchallenge.bo.EmployeeBO;
import com.example.rqchallenge.eo.EmployeeEO;
import com.example.rqchallenge.vo.EmployeeVO;

@SpringBootTest
@ExtendWith(SpringExtension.class)
public class EmployeeTester {
	private static final Logger logger = LoggerFactory.getLogger(EmployeeTester.class);
	@Autowired 
	private EmployeeBO emplBO;
	
	@Test
	public void testRetrieveAllEmpl() throws Exception {
		
		logger.info("Beginning getAllEmployees method");
		try {
			List<EmployeeVO> emplList = emplBO.getAllEmployees();
			if(emplList != null) {
				for (EmployeeVO tempVo : emplList) {
					tempVo.printObject();						
				}
			}
				
		}catch(Exception exc) {
			logger.info("No data returned for getAllEmployees method");
		}
			
		logger.info("End getAllEmployees method");
	}
	
	@Test
	public void testRetrieveEmplById() throws Exception {
		
		logger.info("Beginning testRetrieveEmplById method");
		try {
			EmployeeVO tempVo = emplBO.getEmployeeById("10");
			if(tempVo != null) {
				 
					tempVo.printObject();						
				 
			}
				
		}catch(Exception exc) {
			logger.info("No data returned for testRetrieveEmplById method");
		}
			
		logger.info("End testRetrieveEmplById method");
	}
	
	@Test
	public void testRetrieveEmplByName() throws Exception {
		logger.info("Beginning testRetrieveEmplByName method");
		
		try {
			List<EmployeeVO> emplList = emplBO.getEmployeesByNameSearch("Lisa Mona");
			if(emplList != null) {
				for (EmployeeVO tempVo : emplList) {
					tempVo.printObject();						
				}
			}
				
		}catch(Exception exc) {
			logger.info("No data returned for testRetrieveEmplByName method");
		}
			
		logger.info("End testRetrieveEmplByName method");
		
	}
	
	@Test
	public void testRetrieveTopSalaryList() throws Exception {
		logger.info("Beginning testRetrieveTopSalaryList method");
		
		try {
			List<String> emplList = emplBO.getTopTenHighestEarningEmployeeNames();
			if(emplList != null) {
				for (String empName : emplList) {
					System.out.println("Employee Name " +empName);						
				}
			}
				
		}catch(Exception exc) {
			logger.info("No data returned for testRetrieveTopSalaryList method");
		}
			
		logger.info("End testRetrieveTopSalaryList method");
		
	}
	
	@Test
	public void testRetrieveTopEmplSalary() throws Exception {
		
		logger.info("Beginning testRetrieveTopEmplSalary method");
		try {
			EmployeeVO tempVo = emplBO.getHighestSalaryOfEmployees();
			if(tempVo != null) {
				 
					tempVo.printObject();						
				 
			}
				
		}catch(Exception exc) {
			logger.info("No data returned for testRetrieveTopEmplSalary method");
		}
			
		logger.info("End testRetrieveTopEmplSalary method");
	}
	
	@Test
	public void testCreateEmpl() throws Exception {
		
		logger.info("Beginning testCreateEmpl method");
		try {
			EmployeeVO tempVo = new EmployeeVO();
			tempVo.setEmplName("Michael Thomas");
			tempVo.setEmplAge(56);
			tempVo.setEmplSalary(50000);
			
			tempVo = emplBO.createEmployee(tempVo);
			if(tempVo != null) {
				 
					tempVo.printObject();						
				 
			}
				
		}catch(Exception exc) {
			logger.info("No data returned for testCreateEmpl method");
		}
			
		logger.info("End testCreateEmpl method");
	}
	
	@Test
	public void testDeleteEmpl() throws Exception {
		
		logger.info("Beginning testDeleteEmpl method");
		try {
			
			String message = emplBO.deleteEmployeeById("20");
			System.out.println("Status of Delete: " + message);
				
		}catch(Exception exc) {
			logger.info("No data returned for testCreateEmpl method");
		}
			
		logger.info("End testCreateEmpl method");
	}
}//end EmployeeTester
