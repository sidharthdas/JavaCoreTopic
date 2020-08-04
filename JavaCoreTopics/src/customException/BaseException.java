package customException;

public class BaseException extends Exception {

	protected int errorCode;
	protected String errorMsg;

	public BaseException(int errorCode, String errorMsg) {

		this.errorCode = errorCode;
		this.errorMsg = errorMsg;
	}
	
	
	public String getErrorMessage() {
		return "Error code: "+errorCode+" and Error message: "+errorMsg;
	}
	
	

}
