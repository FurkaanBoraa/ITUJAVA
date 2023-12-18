package lab8;

import java.io.IOException;

public class MyException extends IOException {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public MyException() {
		// TODO Auto-generated constructor stub
	}

	public MyException(String message) {
		super(message);
		System.out.println("This is my error");
	}

	public MyException(Throwable cause) {
		super(cause);
		// TODO Auto-generated constructor stub
	}

	public MyException(String message, Throwable cause) {
		super(message, cause);
		// TODO Auto-generated constructor stub
	}

}
