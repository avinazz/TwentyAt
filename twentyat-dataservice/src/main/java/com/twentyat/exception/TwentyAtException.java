package com.twentyat.exception;

/**
 * Base interface for TwentyAt Exception
 * 
 * @author Bipin Sutariya
 *
 */
public interface TwentyAtException {
	public Throwable getCause();

	public String getFieldName();

	public Integer getElementNum();
}
