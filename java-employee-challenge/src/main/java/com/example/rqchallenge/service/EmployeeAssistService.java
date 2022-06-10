package com.example.rqchallenge.service;

import java.io.IOException;
import java.util.List;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import com.example.rqchallenge.bo.EmployeeBO;
import com.example.rqchallenge.employees.IEmployeeController;
import com.example.rqchallenge.exception.EmployeeServiceException;
import com.example.rqchallenge.util.EmployeeMapper;
import com.example.rqchallenge.util.HelperFunction;
import com.example.rqchallenge.vo.EmployeeVO;

public class EmployeeAssistService implements IEmployeeController{
	private static final Logger logger = LoggerFactory.getLogger(EmployeeAssistService.class);
	
	@Autowired 
	private EmployeeBO emplBO;
			
	@Override
	public ResponseEntity<List<EmployeeVO>> getAllEmployees() throws IOException {
		logger.info("Beginning getAllEmployees method");
		ResponseEntity<List<EmployeeVO>> resp = null;
		
		try {
			List<EmployeeVO> emplList = emplBO.getAllEmployees();
			if(emplList != null)
				resp = new ResponseEntity<>(emplList, HttpStatus.OK);
			else
				resp = new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
		}catch(Exception exc) {
			resp = new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
		}
			
		logger.info("End getAllEmployees method");
		return resp;
	}

	@Override
	public ResponseEntity<List<EmployeeVO>> getEmployeesByNameSearch(String _searchString) {
		logger.info("Beginning getEmployeesByNameSearch method");
		
		ResponseEntity<List<EmployeeVO>> resp = null;
		try {
			List<EmployeeVO> emplList = emplBO.getEmployeesByNameSearch(_searchString);
			if(emplList != null)
				resp = new ResponseEntity<>(emplList, HttpStatus.OK);
			else
				resp = new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
		}catch(EmployeeServiceException exc) {
			resp = new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
		}
		
		logger.info("End getEmployeesByNameSearch method");
		return null;
	}

	@Override
	public ResponseEntity<EmployeeVO> getEmployeeById(String _id) {
		logger.info("Beginning getEmployeeById method");
		ResponseEntity<EmployeeVO> resp = null;
		
		try {
			EmployeeVO emplVO = emplBO.getEmployeeById(_id);
			if(emplVO != null)
				resp = new ResponseEntity<>(emplVO, HttpStatus.OK);
			else
				resp = new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
		}catch(EmployeeServiceException exc) {
			resp = new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
		}
		logger.info("End getEmployeeById method");
		return null;
	}

	@Override
	public ResponseEntity<Integer> getHighestSalaryOfEmployees() {
		logger.info("Beginning getHighestSalaryOfEmployees method");
		ResponseEntity<Integer> resp = null;
		
		try {
			EmployeeVO emplVO =  emplBO.getHighestSalaryOfEmployees();
			if(emplVO != null) {
				Integer tempInt = new Integer(emplVO.getEmplSalary()); 
				resp = new ResponseEntity<>(tempInt, HttpStatus.OK);
			}else {
				resp = new ResponseEntity<>(0, HttpStatus.NOT_FOUND);
			}
		}catch(EmployeeServiceException exc) {
			resp = new ResponseEntity<>(0, HttpStatus.NOT_FOUND);
		}
		
		logger.info("End getHighestSalaryOfEmployees method");
		return resp;
	}

	@Override
	public ResponseEntity<List<String>> getTopTenHighestEarningEmployeeNames() {
		logger.info("Beginning getTopTenHighestEarningEmployeeNames method");
		
		ResponseEntity<List<String>> resp = null;
		
		try {
			List<String> emplList = emplBO.getTopTenHighestEarningEmployeeNames();
			if(emplList != null)
				resp = new ResponseEntity<>(emplList, HttpStatus.OK);
			else
				resp = new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
		}catch(EmployeeServiceException exc) {
			resp = new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
		}
		logger.info("End getTopTenHighestEarningEmployeeNames method");
		return resp;
	}

	@Override
	public ResponseEntity<EmployeeVO> createEmployee(Map<String, Object> _employeeInput) {
		logger.info("Beginning createEmployee method");
		ResponseEntity<EmployeeVO> resp = null;
		EmployeeVO emplVO = EmployeeMapper.mapEmployee(_employeeInput);
		 
		try {
			emplVO = emplBO.createEmployee(emplVO);
			if((emplVO != null) && (!HelperFunction.isEmpty(emplVO.getEmplId(), false)))
				resp = new ResponseEntity<>(emplVO, HttpStatus.OK);
			else
				resp = new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
		}catch(EmployeeServiceException exc) {
			resp = new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
		}
		
		logger.info("End createEmployee method");
		return resp;
	}

	@Override
	public ResponseEntity<String> deleteEmployeeById(String _id) {
		logger.info("Beginning deleteEmployeeById method");
		
		ResponseEntity<String> resp = null;
		String deleteStatus = null;
		 
		try {
			deleteStatus = emplBO.deleteEmployeeById(_id);
			 
			resp = new ResponseEntity<>(deleteStatus, HttpStatus.OK);
			 
		}catch(EmployeeServiceException exc) {
			resp = new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
		}
		
		logger.info("End deleteEmployeeById method");
		return resp;
	}

}//end EmployeeAssistService
