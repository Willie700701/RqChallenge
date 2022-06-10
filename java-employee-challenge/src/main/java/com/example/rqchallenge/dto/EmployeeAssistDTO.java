package com.example.rqchallenge.dto;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.example.rqchallenge.eo.EmployeeEO;
import com.example.rqchallenge.util.DbUtil;
import com.example.rqchallenge.util.EmployeeMapper;
import com.example.rqchallenge.util.HelperFunction;
import com.example.rqchallenge.vo.EmployeeVO;

public class EmployeeAssistDTO {
	private static final Logger logger = LoggerFactory.getLogger(EmployeeAssistDTO.class);
	
	/**
	 * Get all Employee Records
	 * @return
	 */
	public List<EmployeeVO> getAllEmpl() {
		logger.info("Beginning DTO getAllEmpl method");
		List<EmployeeEO> eoList = (DbUtil.getInstance()).getEmplList();
		
		logger.info("End DTO getAllEmpl method");
		return EmployeeMapper.mapEmployeeList(eoList);
		
	}

	/**
	 * Retrieve an EmployeeEO record based on Name
	 * @param searchString
	 * @return
	 */
	public List<EmployeeVO> getEmployeesByNameSearch(String _searchString) {
		logger.info("Beginning DTO getEmployeesByNameSearch method");
		EmployeeVO emplVO = new EmployeeVO();
		emplVO.setEmplName(_searchString.trim());
		
		List<EmployeeEO> emplList = (DbUtil.getInstance()).getEmployee(emplVO);
		List<EmployeeVO> emplVOList = EmployeeMapper.mapEmployeeList(emplList);
		
		logger.info("End DTO getEmployeesByNameSearch method");
		return emplVOList;
	}

	/**
	 * Retrieve an EmployeeEO record based on id
	 * @param id
	 * @return
	 */
	public EmployeeVO getEmployeeById(String _id) {
		logger.info("Beginning DTO getEmployeeById method");
		EmployeeVO emplVO = new EmployeeVO();
		emplVO.setEmplId(_id.trim());
		
		List<EmployeeEO> emplList = (DbUtil.getInstance()).getEmployee(emplVO);
		emplVO = EmployeeMapper.mapEmployee(emplList.get(0));
		
		logger.info("End DTO getEmployeeById method");
		return emplVO;
	}

	/**
	 * Determines the highest paid Employee
	 * @return
	 */
	public EmployeeVO getHighestSalaryOfEmployees() {
		logger.info("Beginning DTO getHighestSalaryOfEmployees method");
		List<EmployeeVO> emplList = this.getAllEmpl();
		EmployeeVO emplVO = null;
		double tempSalary = 0.0;
		for (EmployeeVO tempVo : emplList) {
			if(tempSalary < tempVo.getEmplSalary()) {
				emplVO = tempVo;
				tempSalary = tempVo.getEmplSalary();
			}
				
		}
		
		logger.info("End DTO getHighestSalaryOfEmployees method");
		return emplVO;
	}

	/**
	 * Review Employee list and provides top 10 salary EmploeeVO
	 * @return
	 */
	public List<String> getTopTenHighestEarningEmployeeNames() {
		logger.info("Beginning DTO getTopTenHighestEarningEmployeeNames method");
		List empNameList = new ArrayList<String>(10);
		
		//Set loop threshold
		int indexStop = 0;
		
		List<EmployeeVO> emplList = this.getAllEmpl();
		emplList.sort(Comparator.comparing(EmployeeVO::getEmplSalary).reversed());
		if((emplList != null)) {
			if(emplList.size() > 10)
				indexStop = 10;
			else
				indexStop = emplList.size();
		}
			
		for(int index = 0;index < indexStop;index++) {
			empNameList.add((emplList.get(index)).getEmplName());
		}
						
		logger.info("End DTO getTopTenHighestEarningEmployeeNames method");
		return empNameList;
	}

	/**
	 * Add new Employee record into dB
	 * @param _emplVO
	 * @return
	 */
	public EmployeeVO createEmployee(EmployeeVO _emplVO) {
		logger.info("Beginning DTO createEmployee method");
		EmployeeEO newEmployeeEO = EmployeeMapper.mapEmployee(_emplVO);
		
		String newId = (DbUtil.getInstance()).createEmployee(newEmployeeEO);
		if(!HelperFunction.isEmpty(newId, true))
			_emplVO.setEmplId(newId);
		
		logger.info("End DTO createEmployee method with id: " + newId);
		return _emplVO;
	}

	/**
	 * Remove a Employee record using the id field
	 * @param id
	 * @return
	 */
	public boolean deleteEmployeeById(String id) {
		logger.info("Beginning DTO deleteEmployeeById method");
		
		boolean recDeleted = (DbUtil.getInstance()).deleteEmployee(id);
		if(recDeleted) {
			logger.info("End DTO deleteEmployeeById method " + recDeleted);
		}
		
		return recDeleted;
	}
	
}//end EmployeeAssistDTO
