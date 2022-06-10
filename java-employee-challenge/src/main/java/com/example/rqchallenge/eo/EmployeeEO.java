package com.example.rqchallenge.eo;


public class EmployeeEO {
	 
	private String emplName = null;
	private String emplId = null;
	private String emplSalary = null;
	private String emplAge = null;
	private String profileImg = null;
	
	public EmployeeEO() {
		super();
	}
	
	public EmployeeEO(String _id,String _name, String _salary, String _age, String _profileLink) {
		this.setEmplId(_id);
		this.setEmplName(_name);
		this.setEmplSalary(_salary);
		this.setEmplAge(_age);
		this.setProfileImg(_profileLink);
	}
	
	/**
	 * @return the emplName
	 */
	public String getEmplName() {
		return emplName;
	}
	
	/**
	 * @param emplName the emplName to set
	 */
	public void setEmplName(String emplName) {
		this.emplName = emplName;
	}
	
	/**
	 * @return the emplId
	 */
	public String getEmplId() {
		return emplId;
	}
	
	/**
	 * @param emplId the emplId to set
	 */
	public void setEmplId(String emplId) {
		this.emplId = emplId;
	}
	
	/**
	 * @return the emplSalary
	 */
	public String getEmplSalary() {
		return emplSalary;
	}
	
	/**
	 * @param emplSalary the emplSalary to set
	 */
	public void setEmplSalary(String emplSalary) {
		this.emplSalary = emplSalary;
	}
	
	/**
	 * @return the emplAge
	 */
	public String getEmplAge() {
		return emplAge;
	}
	
	/**
	 * @param emplAge the emplAge to set
	 */
	public void setEmplAge(String emplAge) {
		this.emplAge = emplAge;
	}
	
	/**
	 * @return the profileImg
	 */
	public String getProfileImg() {
		return profileImg;
	}
	
	/**
	 * @param profileImg the profileImg to set
	 */
	public void setProfileImg(String profileImg) {
		this.profileImg = profileImg;
	}
	
	
	
	
}// end EmployeeEO
