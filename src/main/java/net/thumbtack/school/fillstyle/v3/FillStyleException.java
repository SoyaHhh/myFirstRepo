package net.thumbtack.school.fillstyle.v3;

public class FillStyleException extends Exception {

    public FillStyleException() {
        super();
    }

    public FillStyleException(FillStyleErrorCode messageCode) {
        super(messageCode.getErrorString());
        this.messageCode = messageCode;
    }

    private FillStyleErrorCode messageCode;

    public void setMessageCode(FillStyleErrorCode messageCode) {
        this.messageCode = messageCode;
    }

    public FillStyleErrorCode getErrorCode() {
        return messageCode;
    }
}