package com.twentyat.exception;

public class TwentyAtIllegalArgumentException extends Exception implements
		TwentyAtException {
	private String fieldName;
	private Integer elementNum;

	private static final long serialVersionUID = -6958163263179699509L;

	public TwentyAtIllegalArgumentException() {
		super();
	}

	public TwentyAtIllegalArgumentException(String message, Throwable cause) {
		super(message, cause);
	}

	public TwentyAtIllegalArgumentException(String message) {
		super(message);
	}

	public TwentyAtIllegalArgumentException(Throwable cause) {
		super(cause);
	}

	public TwentyAtIllegalArgumentException(String message, Throwable cause,
			String fieldName) {
		super(message, cause);
		this.fieldName = fieldName;
	}

	public TwentyAtIllegalArgumentException(String message, Throwable cause,
			String fieldName, Integer elementNum) {
		super(message, cause);
		this.fieldName = fieldName;
		this.elementNum = elementNum;
	}

	public TwentyAtIllegalArgumentException(String message, String fieldName) {
		super(message);
		this.fieldName = fieldName;
	}

	public TwentyAtIllegalArgumentException(String message, String fieldName,
			Integer elementNum) {
		super(message);
		this.fieldName = fieldName;
		this.elementNum = elementNum;
	}

	public TwentyAtIllegalArgumentException(Throwable cause, String fieldName) {
		super(cause);
		this.fieldName = fieldName;
	}

	public TwentyAtIllegalArgumentException(Throwable cause, String fieldName,
			Integer elementNum) {
		super(cause);
		this.fieldName = fieldName;
		this.elementNum = elementNum;
	}

	public String getFieldName() {
		return fieldName;
	}

	public void setFieldName(String fieldName) {
		this.fieldName = fieldName;
	}

	public Integer getElementNum() {
		return elementNum;
	}

	public void setElementNum(Integer elementNum) {
		this.elementNum = elementNum;
	}
}
