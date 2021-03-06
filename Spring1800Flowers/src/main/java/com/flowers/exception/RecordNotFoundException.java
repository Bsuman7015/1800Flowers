package com.flowers.exception;

public class RecordNotFoundException extends Exception{

	private static final long serialVersionUID = 1L;
	private String message;
	
public RecordNotFoundException(String message) {
	super(message);
	this.message=message;
	
}

public String getMessage() {
	return message;
}

public void setMessage(String message) {
	this.message = message;
}

public static long getSerialversionuid() {
	return serialVersionUID;
}

@Override
public String toString() {
	return "RecordNotFoundException [message=" + message + "]";
}

}
