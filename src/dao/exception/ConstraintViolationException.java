package dao.exception;

import java.util.*;

public class ConstraintViolationException extends Exception{
    private List<ConstraintViolation> fieldViolation = Collections.emptyList();

    public ConstraintViolationException() {
    }

    public ConstraintViolationException(String message) {
        super(message);
    }

    public ConstraintViolationException(String message, Throwable cause) {
        super(message, cause);
    }

    public ConstraintViolationException(Throwable cause) {
        super(cause);
    }

    public ConstraintViolationException(List<ConstraintViolation> fieldViolation) {
        this.fieldViolation = fieldViolation;
    }

    public ConstraintViolationException(String message, List<ConstraintViolation> fieldViolation) {
        super(message);
        this.fieldViolation = fieldViolation;
    }

    public ConstraintViolationException(String message, Throwable cause, List<ConstraintViolation> fieldViolation) {
        super(message, cause);
        this.fieldViolation = fieldViolation;
    }

    public ConstraintViolationException(Throwable cause, List<ConstraintViolation> fieldViolation) {
        super(cause);
        this.fieldViolation = fieldViolation;
    }

    public List<ConstraintViolation> getFieldViolations() {
        return fieldViolation;
    }

    public void setFieldViolation(List<ConstraintViolation> fieldViolation) {
        this.fieldViolation = fieldViolation;
    }



    @Override
    public String toString() {
        return new StringJoiner(", ", ConstraintViolationException.class.getSimpleName() + "[", "]")
                .add("fieldViolation=" + fieldViolation)
                .add("message='" + getMessage() + "'")
                .add("cause=" + getCause())
                .add("stackTrace=" + super.getStackTrace())
                .toString();
    }
}
