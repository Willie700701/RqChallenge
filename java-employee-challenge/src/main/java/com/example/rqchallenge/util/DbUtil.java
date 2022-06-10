package com.example.rqchallenge.util;

import java.util.ArrayList;
import java.util.List;

import com.example.rqchallenge.eo.EmployeeEO;
import com.example.rqchallenge.vo.EmployeeVO;

public class DbUtil {

	private static List<EmployeeEO> fakeData = new ArrayList(20);
	private static DbUtil dbUtil= null;
	
	private DbUtil() {
		EmployeeEO tempData = new EmployeeEO("10", "Joe Smith", "32000", "33", "none");
		fakeData.add(tempData);
		tempData = new EmployeeEO("11", "Lisa Mona", "44000", "50", "none");
		fakeData.add(tempData);
		tempData = new EmployeeEO("12", "Judy Smith", "32050", "20", "none");
		fakeData.add(tempData);
		tempData = new EmployeeEO("13", "Lisa Mona", "25000", "44", "none");
		fakeData.add(tempData);
		tempData = new EmployeeEO("14", "Mark Ford", "33000", "61", "none");
		fakeData.add(tempData);
		tempData = new EmployeeEO("15", "Kathy Love", "67000", "37", "none");
		fakeData.add(tempData);
		tempData = new EmployeeEO("16", "Ed Chase", "77000", "41", "none");
		fakeData.add(tempData);
		tempData = new EmployeeEO("17", "Fred Smith", "38000", "22", "none");
		fakeData.add(tempData);
		tempData = new EmployeeEO("18", "Chris Wilson", "22000", "90", "none");
		fakeData.add(tempData);
		tempData = new EmployeeEO("19", "Judy Garland", "45000", "34", "none");
		fakeData.add(tempData);
		tempData = new EmployeeEO("20", "Mike Joe", "12000", "40", "none");
		fakeData.add(tempData);
	}

	public static DbUtil getInstance() {
		if(dbUtil == null)
			dbUtil = new DbUtil();
		
		return dbUtil;
	}
	
	/**
	 * Get the full list
	 * 
	 * @return current fakaData List
	 */
	public List<EmployeeEO> getEmplList() {
		return DbUtil.getInstance().fakeData;
	}

	/**
	 * Retrieve an EmployeeEO based on imput data from EmployeeVO
	 * 
	 * @param _newEmpl
	 * @return EmployeeEO
	 */
	public List<EmployeeEO> getEmployee(EmployeeVO _newEmpl) {
		boolean useId = false;

		if (!HelperFunction.isEmpty(_newEmpl.getEmplId(), true))
			useId = true;
		
		List<EmployeeEO> emplList = new ArrayList();
		
		for (EmployeeEO tempEo : DbUtil.fakeData) {
			// Search by EmployeeId
			if (useId) {
				if (_newEmpl.getEmplId().equalsIgnoreCase(tempEo.getEmplId())) {
					emplList.add(tempEo);
					return emplList;
				}

			} else {
				// Search by Employee Name
				if (_newEmpl.getEmplName().trim().equalsIgnoreCase(tempEo.getEmplName().trim()))
					emplList.add(tempEo);
			}
		}

		return emplList;
	}

	public boolean deleteEmployee(String _id) {
		for (int index = 0; index < DbUtil.fakeData.size(); index++) {
			EmployeeEO tempEo = (EmployeeEO) DbUtil.fakeData.get(index);

			if (_id.equalsIgnoreCase(tempEo.getEmplId())) {
				fakeData.remove(index);
				return true;
			}
		} // end for loop

		return false;
	}

	/**
	 * Add a new Employee Record to the collection
	 * 
	 * @param _newEmpl
	 * @return boolean
	 */
	public String createEmployee(EmployeeEO _newEmpl) {
		// Get the new Id number
		int newIdNbr = DbUtil.getInstance().getNextId();

		// Verify a valid number was returned
		if (newIdNbr > 0) {
			String newIdString = (new Integer(newIdNbr)).toString();

			_newEmpl.setEmplId(newIdString.trim());

			if (DbUtil.fakeData.add(_newEmpl))
				return newIdString;
		}

		return null;

	}

	/**
	 * Create valid EmployeeId
	 * 
	 * @return
	 */
	private int getNextId() {
		int maxInt = 0;

		for (EmployeeEO tempEo : DbUtil.fakeData) {
			int tempInt = HelperFunction.getInteger(tempEo.getEmplId());
			if (maxInt < tempInt) {
				maxInt = tempInt;
			}
		}

		maxInt++;

		return maxInt;
	}
}// end DbUtil
