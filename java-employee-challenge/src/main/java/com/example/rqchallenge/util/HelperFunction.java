package com.example.rqchallenge.util;

public class HelperFunction {

	/**
	 * Determine if a String contains values
	 * @param _value
	 * @param _trim
	 * @return True if the _value is empty
	 */
	public static boolean isEmpty(String _value, boolean _trim) {
		if(_value == null)
			return true;
		if(_trim) {
			_value = _value.trim();
		}
		
		return ("".equalsIgnoreCase(_value)) ? true : false;
	}
	
	/**
	 * Convert String to an int value
	 * @param _tempString
	 * @return
	 */
	public static int getInteger(String _tempString) {
		try {
			return new Integer(_tempString);
			
		}catch (NumberFormatException nfe ) {
			System.out.println("Unable to convert String to int: " + _tempString);
			return -9;
		}
		
	}
}//end HelperFunction
