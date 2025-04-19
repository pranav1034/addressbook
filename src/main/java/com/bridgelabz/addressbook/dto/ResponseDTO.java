package com.bridgelabz.addressbook.dto;

import lombok.Data;

@Data
public class ResponseDTO {
    String message;
    Object data;

    public ResponseDTO() {
    }

    public ResponseDTO(String message, Object data) {
        this.message = message;
        this.data = data;
    }
}
