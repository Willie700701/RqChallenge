package com.example.rqchallenge.vo;


public class EmployeeVO {

	private String emplName = null;
	private String emplId = null;
	private int emplSalary = -9;
	private int emplAge = -9;
	private String profileImg = null;
	private String status = null;
	
	/**
	 * Provide the employee name 
	 * @return emplName
	 */
	public String getEmplName() {
		return emplName;
	}
	
	/**
	 * Set the employee name
	 * @param _emplName
	 */
	public void setEmplName(String _emplName) {
		this.emplName = _emplName;
	}
	
	/**
	 * Provide the employee id 
	 * @return emplId
	 */
	public String getEmplId() {
		return emplId;
	}
	
	/**
	 * Set the employee Id
	 * @param _emplId
	 */
	public void setEmplId(String _emplId) {		
		this.emplId = _emplId;
	}
	
	/**
	 * Provide the employee yearly salary 
	 * @return emplSalary
	 */
	public int getEmplSalary() {
		return emplSalary;
	}
	
	/**
	 * Set the employee Salary
	 * @param emplSalary
	 */
	public void setEmplSalary(int emplSalary) {
		this.emplSalary = emplSalary;
	}
	
	/**
	 * Provide the employee age 
	 * @return emplAge
	 */
	public int getEmplAge() {
		return emplAge;
	}
	
	/**
	 * Set the employee age
	 * @param emplAge
	 */
	public void setEmplAge(int emplAge) {
		this.emplAge = emplAge;
	}
	
	/**
	 * Provide the employee profile image  
	 * @return profileImg
	 */
	public String getProfileImg() {
		return profileImg;
	}
	
	/**
	 * Set the profile image for the employee
	 * @param profileImg
	 */
	public void setProfileImg(String profileImg) {
		this.profileImg = profileImg;
	}
	
	public void printObject() {
		System.out.println("EmpolyeeId " + emplId);
		System.out.println("EmployeeName: " + emplName);
		System.out.println("EmployeeAge: " + emplAge);
		System.out.println("EmployeeSalary: " + emplSalary);
		System.out.println("EmployeeProfile: " + profileImg);
	}
}//end EmployeeVO class
