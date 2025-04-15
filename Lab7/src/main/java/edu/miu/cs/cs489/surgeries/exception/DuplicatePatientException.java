package edu.miu.cs.cs489.surgeries.exception;

public class DuplicatePatientException extends RuntimeException{
    public DuplicatePatientException(String message) {
        super(message);
    }
}
