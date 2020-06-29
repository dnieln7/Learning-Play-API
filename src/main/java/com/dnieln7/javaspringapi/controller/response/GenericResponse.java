package com.dnieln7.javaspringapi.controller.response;

/**
 * Helper class to wrap response objects and give extra information.
 *
 * @param <T> Response object class type
 * @author dnieln7
 */
public class GenericResponse<T> {
    /**
     * Response code; 1 if successful; 0 otherwise.
     */
    public int code;
    /**
     * A short description, useful in case of error.
     */
    public String description;
    /**
     * Response object.
     */
    public T result;

    public GenericResponse() {
    }

    public GenericResponse(int code, String description, T result) {
        this.code = code;
        this.description = description;
        this.result = result;
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public T getResult() {
        return result;
    }

    public void setResult(T result) {
        this.result = result;
    }
}
