package me.lv.record.exception;

/**
 * @author lv
 */
public class ServiceException extends RuntimeException {
    private String errorMsg;

    private String errorCode;

    public ServiceException() {
        super();
    }

    @Override
    public synchronized Throwable fillInStackTrace() {
        return this;
    }

    public ServiceException(String message) {
        super(message);
    }

    public ServiceException(String message, String errorMsg) {
        super(message);
        this.errorMsg = errorMsg;
    }

    public ServiceException(String message, String errorMsg, String errorCode) {
        super(message);
        this.errorMsg = errorMsg;
        this.errorCode = errorCode;
    }

    public ServiceException(String message, Throwable cause) {
        super(message, cause);
    }


    public ServiceException(String message, Throwable cause, String errorMsg) {
        super(message, cause);
        this.errorMsg = errorMsg;
    }

    public ServiceException(Throwable cause) {
        super(cause);
    }

    protected ServiceException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }

    public String getErrorMsg() {
        return errorMsg;
    }

    public void setErrorMsg(String errorMsg) {
        this.errorMsg = errorMsg;
    }

    public String getErrorCode() {
        return errorCode;
    }

    public void setErrorCode(String errorCode) {
        this.errorCode = errorCode;
    }
}
