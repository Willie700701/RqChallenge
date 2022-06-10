package com.example.rqchallenge.exception;

public class EmployeeServiceException extends Exception {

	/**
	 * Generic SerialUID for Java VM
	 */
	private static final long serialVersionUID = 1L;
	
	public static String INVALID_DATA_CDE = "100";
	private String errorCode = null;
	private String message = null;
	
	public EmployeeServiceException() {
		
	}
	
	public EmployeeServiceException(String _code, String _message) {
		this.errorCode = _code;
		this.message = _message;
	}
	
	/**
	 * @return the errorCode
	 */
	public String getErrorCode() {
		return errorCode;
	}
	/**
	 * @param errorCode the errorCode to set
	 */
	public void setErrorCode(String errorCode) {
		this.errorCode = errorCode;
	}
	/**
	 * @return the message
	 */
	public String getMessage() {
		return message;
	}
	/**
	 * @param message the message to set
	 */
	public void setMessage(String message) {
		this.message = message;
	}
	
}//end EmployeeServiceException
