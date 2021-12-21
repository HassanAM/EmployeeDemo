package com.example.employee.response;

public enum ErrorMessages {

    MISSING_REQUIRED_FIELD("Missing required field. Please check documentation for required fields"),
    AUTHENTICATION_FAILED("Authentication Failed, Please check documentation for required Authentication"),
    MISSING_REQUIRED_FIELD_SIZE("Length of required fields are not enough. Please check documentation for required fields length");

    private String errorMessage;

    ErrorMessages(String errorMessage) {
        this.errorMessage = errorMessage;
    }

    /**
     * @return the errorMessage
     */
    public String getErrorMessage() {
        return errorMessage;
    }

    /**
     * @param errorMessage the errorMessage to set
     */
    public void setErrorMessage(String errorMessage) {
        this.errorMessage = errorMessage;
    }
}
