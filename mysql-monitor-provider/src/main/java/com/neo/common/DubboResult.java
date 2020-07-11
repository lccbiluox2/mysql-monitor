package com.neo.common;


import java.io.Serializable;

public class DubboResult<T> implements Serializable {
    private static final String SUCCESS_CODE = "0";
    private static final String ERROR_CODE = "500";
    private boolean success = true;
    private String message;
    private String code;
    private T content;
    private static final DubboResult<Boolean> SUCCESS;
    private static final DubboResult<Boolean> ERROR;

    public static DubboResult<Boolean> buildSuccessResult() {
        return SUCCESS;
    }

    public static DubboResult<Boolean> buildErrorResult() {
        return ERROR;
    }

    public static <T> DubboResult<T> buildSuccessResult(T result) {
        DubboResult dubboResult = new DubboResult();
        dubboResult.setCode("0");
        dubboResult.setContent(result);
        return dubboResult;
    }

    public static <T> DubboResult<T> buildErrorResult(String code, String message) {
        DubboResult dubboResult = new DubboResult();
        dubboResult.setCode(code);
        dubboResult.setMessage(message);
        dubboResult.setSuccess(false);
        return dubboResult;
    }

    public static <T> DubboResult<T> buildErrorResult(String message) {
        return buildErrorResult("500", message);
    }

    public boolean isSuccess() {
        return this.success && "0".equals(this.code);
    }

    public DubboResult() {
    }

    public String getMessage() {
        return this.message;
    }

    public String getCode() {
        return this.code;
    }

    public T getContent() {
        return this.content;
    }

    public void setSuccess(boolean success) {
        this.success = success;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public void setContent(T content) {
        this.content = content;
    }

    @Override
    public boolean equals(Object o) {
        if (o == this) {
            return true;
        } else if (!(o instanceof DubboResult)) {
            return false;
        } else {
            DubboResult<?> other = (DubboResult)o;
            if (!other.canEqual(this)) {
                return false;
            } else if (this.isSuccess() != other.isSuccess()) {
                return false;
            } else {
                label49: {
                    Object this$message = this.getMessage();
                    Object other$message = other.getMessage();
                    if (this$message == null) {
                        if (other$message == null) {
                            break label49;
                        }
                    } else if (this$message.equals(other$message)) {
                        break label49;
                    }

                    return false;
                }

                Object this$code = this.getCode();
                Object other$code = other.getCode();
                if (this$code == null) {
                    if (other$code != null) {
                        return false;
                    }
                } else if (!this$code.equals(other$code)) {
                    return false;
                }

                Object this$content = this.getContent();
                Object other$content = other.getContent();
                if (this$content == null) {
                    if (other$content != null) {
                        return false;
                    }
                } else if (!this$content.equals(other$content)) {
                    return false;
                }

                return true;
            }
        }
    }

    public boolean canEqual(Object other) {
        return other instanceof DubboResult;
    }



    @Override
    public String toString() {
        return "DubboResult(success=" + this.isSuccess() + ", message=" + this.getMessage() + ", code=" + this.getCode() + ", content=" + this.getContent() + ")";
    }

    static {
        new DubboResult();
        SUCCESS = buildSuccessResult(true);
        new DubboResult();
        ERROR = buildErrorResult("500", "系统错误");
    }
}
