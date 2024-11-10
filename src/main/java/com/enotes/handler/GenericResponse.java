package com.enotes.handler;

import java.util.LinkedHashMap;
import java.util.Map;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.util.ObjectUtils;


public class GenericResponse {

    private HttpStatus responseStatuses;
    private String status;
    private String message;
    private Object data;

    // Private constructor to enforce Builder usage
    private GenericResponse(Builder builder) {
        this.responseStatuses = builder.responseStatuses;
        this.status = builder.status;
        this.message = builder.message;
        this.data = builder.data;
    }

    // Static method to initiate the Builder
    public static Builder builder() {
        return new Builder();
    }

    // Getters
    public HttpStatus getResponseStatuses() {
        return responseStatuses;
    }

    public String getStatus() {
        return status;
    }

    public String getMessage() {
        return message;
    }

    public Object getData() {
        return data;
    }

    // Method to create ResponseEntity based on GenericResponse properties
    public ResponseEntity<?> create() {
        Map<String, Object> map = new LinkedHashMap<>();
        map.put("status", status);
        map.put("message", message);
        if (!ObjectUtils.isEmpty(data)) {
            map.put("data", data);
        }
        return new ResponseEntity<>(map, responseStatuses);
    }

    // Static inner Builder class
    public static class Builder {
        private HttpStatus responseStatuses;
        private String status;
        private String message;
        private Object data;

        public Builder responseStatuses(HttpStatus responseStatuses) {
            this.responseStatuses = responseStatuses;
            return this;
        }

        public Builder status(String status) {
            this.status = status;
            return this;
        }

        public Builder message(String message) {
            this.message = message;
            return this;
        }

        public Builder data(Object data) {
            this.data = data;
            return this;
        }

        public GenericResponse build() {
            return new GenericResponse(this);
        }
    }
}