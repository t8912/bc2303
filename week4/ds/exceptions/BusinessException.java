package week4.ds.exceptions;

public class BusinessException extends Exception {

//int code; // 200
//int status;//

  //BusinessException become a checked exception
  public BusinessException() {

  }

  public BusinessException(String message){
    super(message);
  }

  public BusinessException (String message, Throwable cause){
    super(message, cause);
  }

  public BusinessException (Throwable cause){
    super(cause);
  }
}
