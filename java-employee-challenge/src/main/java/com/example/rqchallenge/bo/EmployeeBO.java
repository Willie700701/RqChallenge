package com.example.rqchallenge.bo;

import java.io.IOException;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import com.example.rqchallenge.dto.EmployeeAssistDTO;
import com.example.rqchallenge.exception.EmployeeServiceException;
import com.example.rqchallenge.util.HelperFunction;
import com.example.rqchallenge.vo.EmployeeVO;

@Component
public class EmployeeBO {
	
	private static final Logger logger = LoggerFactory.getLogger(EmployeeBO.class);
			
	/**
	 * Gather all Employee records
	 * @return
	 * @throws IOException
	 */
	public List<EmployeeVO> getAllEmployees() throws IOException {
		logger.info("Beginning BO getAllEmployees method");
		List<EmployeeVO> emplList = null;
		EmployeeAssistDTO emplDTO = new EmployeeAssistDTO();
		emplList = emplDTO.getAllEmpl();
		
		//Verify data was provided
		if((emplList == null) ||(emplList.isEmpty())) {
			logger.info("Returning List of Employees is NULL");
			return null;
		}else {
			logger.info("Returning List of Employees");
			return emplList;
		}
		
	}

	/**
	 * Return all Employees that match the Name field
	 * @param _searchString
	 * @return
	 * @throws EmployeeServiceException
	 */
	public List<EmployeeVO> getEmployeesByNameSearch(String _searchString) throws EmployeeServiceException {
		logger.info("Beginning BO getEmployeesByNameSearch method");
		if(HelperFunction.isEmpty(_searchString, false))
			throw new EmployeeServiceException(EmployeeServiceException.INVALID_DATA_CDE, "Name Search parameter is Empty");
		
		EmployeeAssistDTO emplDTO = new EmployeeAssistDTO(); 
		
		logger.info("Returning List of Employee by Name");
		return emplDTO.getEmployeesByNameSearch(_searchString);
	}

	/**
	 * Return an individual Employee by Id field
	 * @param _id
	 * @return
	 * @throws EmployeeServiceException
	 */
	public EmployeeVO getEmployeeById(String _id) throws EmployeeServiceException {
		logger.info("Beginning BO getEmployeeById method");
		
		if(HelperFunction.isEmpty(_id, false))
			throw new EmployeeServiceException(EmployeeServiceException.INVALID_DATA_CDE, "Id Search parameter is Empty");
		
		EmployeeAssistDTO emplDTO = new EmployeeAssistDTO();
		EmployeeVO emplVO = emplDTO.getEmployeeById(_id);
		
		logger.info("End getEmployeeById method");
		return emplVO;
	}

	/**
	 * Determine highest paid Employee
	 * @return
	 */
	public EmployeeVO getHighestSalaryOfEmployees() throws EmployeeServiceException {
		logger.info("Beginning BO getHighestSalaryOfEmployees method");
		EmployeeAssistDTO emplDTO = new EmployeeAssistDTO();
		logger.info("End getHighestSalaryOfEmployees method");
		
		return emplDTO.getHighestSalaryOfEmployees();
	}

	/**
	 * Gather the top 10 highest paid Employees
	 * @return
	 */
	public List<String> getTopTenHighestEarningEmployeeNames() throws EmployeeServiceException {
		logger.info("Beginning BO getTopTenHighestEarningEmployeeNames method");
		EmployeeAssistDTO emplDTO = new EmployeeAssistDTO();
		
		logger.info("End getTopTenHighestEarningEmployeeNames method");
		
		return emplDTO.getTopTenHighestEarningEmployeeNames();
	}

	/**
	 * Add a new Employee record
	 * @param _emplVO
	 * @return
	 */
	public EmployeeVO createEmployee(EmployeeVO _emplVO) throws EmployeeServiceException {
		logger.info("Beginning BO createEmployee method");
		if(_emplVO == null)
			throw new EmployeeServiceException(EmployeeServiceException.INVALID_DATA_CDE, "Employee Object is NULL");
		String message = new String();
		
		//Validate Name is provide
		if(HelperFunction.isEmpty(_emplVO.getEmplName(), false))
			message = "Employee Name not provide ";
		
		//Verify employee meets age requirements 
		if((_emplVO.getEmplAge() < 15) || (_emplVO.getEmplAge() > 100))
			message = message + " / Employee Age is not valid";
		
		//Verify employee meets age requirements 
		if(_emplVO.getEmplSalary() < 1.0) 
			message = message + " / Employee Salary is not valid";
		
		if(!HelperFunction.isEmpty(message, true))
			throw new EmployeeServiceException(EmployeeServiceException.INVALID_DATA_CDE, message);
	
		EmployeeAssistDTO emplDTO = new EmployeeAssistDTO();
		EmployeeVO emplVO = emplDTO.createEmployee(_emplVO);
		
		logger.info("End  method");
		return _emplVO;
	}

	/**
	 * Remove an existing Employee
	 * @param id
	 * @return
	 */
	public String deleteEmployeeById(String _id) throws EmployeeServiceException {
		logger.info("Beginning BO deleteEmployeeById method");
		if(HelperFunction.isEmpty(_id, false))
			throw new EmployeeServiceException(EmployeeServiceException.INVALID_DATA_CDE, "Id parameter is Empty");
	
		EmployeeAssistDTO emplDTO = new EmployeeAssistDTO();
		boolean recDeleted = emplDTO.deleteEmployeeById(_id);
		logger.info("End  method");
		
		return recDeleted? "Record Sucessfuly Deleted" : "Record NOT Deleted";
	}
}//end EmployeeBO
