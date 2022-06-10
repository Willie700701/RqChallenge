package com.example.rqchallenge.util;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import com.example.rqchallenge.eo.EmployeeEO;
import com.example.rqchallenge.vo.EmployeeVO;

public class EmployeeMapper {

	/**
	 * Convert the EmployeeEO to an EmployeeVO
	 * @param _emplEO
	 * @return
	 */
	public static EmployeeVO mapEmployee(EmployeeEO _emplEO) {
		EmployeeVO emplVO = new EmployeeVO();
		if(_emplEO == null)
			return null;
		
		try {
			emplVO.setEmplAge(Integer.parseInt(_emplEO.getEmplAge()));
		}catch(Exception exc) {
			emplVO.setEmplAge(0);
		}
		
		emplVO.setEmplId(_emplEO.getEmplId());
		emplVO.setEmplName(_emplEO.getEmplName());
		
		try {
			emplVO.setEmplSalary(Integer.parseInt(_emplEO.getEmplSalary()));
		}catch(Exception exc) {
			emplVO.setEmplSalary(0);
		}
		
		emplVO.setProfileImg(_emplEO.getProfileImg());
		
		return emplVO;
	}
	
	/**
	 * Convert the EmployeeVO to an EmployeeEO
	 * @param _emplVO
	 * @return
	 */
	public static EmployeeEO mapEmployee(EmployeeVO _emplVO) {
		EmployeeEO newEmployeeEO = new EmployeeEO();
		 
		newEmployeeEO.setEmplAge(Integer.toString(_emplVO.getEmplAge()));
		newEmployeeEO.setEmplId(_emplVO.getEmplId());
		newEmployeeEO.setEmplName(_emplVO.getEmplName());
		newEmployeeEO.setEmplSalary(Integer.toString(_emplVO.getEmplSalary()));
		newEmployeeEO.setProfileImg(_emplVO.getProfileImg());
		
		return newEmployeeEO;
	}
	
	/**
	 * Create list of EmployeeVOs from a List of EmployeeEO
	 * @param _emplList
	 * @return
	 */
	public static List<EmployeeVO> mapEmployeeList(List<EmployeeEO> _emplList){
		if((_emplList == null) || (_emplList.isEmpty()))
			return null;
		
		List<EmployeeVO> emplVOList = new ArrayList(_emplList.size());
		for (EmployeeEO tempEo : _emplList) {
			emplVOList.add(EmployeeMapper.mapEmployee(tempEo));
		}
		
		return emplVOList;
	}
	
	/**
	 * Convert the EmployeeEO to an EmployeeVO
	 * @param _emplEO
	 * @return
	 */
	public static EmployeeVO mapEmployee(Map<String, Object> _employeeInput) {
		EmployeeVO emplVO = new EmployeeVO();
		if(_employeeInput == null)
			return null;
		
		try {
			emplVO.setEmplAge(Integer.parseInt((String)_employeeInput.get("age")));
		}catch(Exception exc) {
			emplVO.setEmplAge(0);
		}
		
		 
		emplVO.setEmplName((String)_employeeInput.get("name"));
		
		try {
			emplVO.setEmplSalary(Integer.parseInt((String)_employeeInput.get("salary")));
		}catch(Exception exc) {
			emplVO.setEmplSalary(0);
		}
		
		emplVO.setProfileImg("");
		
		return emplVO;
	}
}//end EmployeeMapper
