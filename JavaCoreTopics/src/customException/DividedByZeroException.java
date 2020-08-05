package customException;

public class DividedByZeroException extends BaseException{

	public DividedByZeroException(int errorCode, String errorMsg) {
		super(errorCode, errorMsg);
		
		BaseException b = new BaseException(errorCode, errorMsg);
		// TODO Auto-generated constructor stub
	}

}
