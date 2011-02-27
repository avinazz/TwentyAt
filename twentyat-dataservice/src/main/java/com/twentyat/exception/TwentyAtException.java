package com.twentyat.exception;

public interface TwentyAtException {
	public Throwable getCause();

	public String getFieldName();

	public Integer getElementNum();
}
