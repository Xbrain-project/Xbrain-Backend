package com.Xbrain.BackendXbrain.dto;

import lombok.Data;

@Data
public class twhDTO {
    private String header ;
    private String data ;

    public String getHeader() {
        return header;
    }

    public void setHeader(String header) {
        this.header = header;
    }

    public String getData() {
        return data;
    }

    public void setData(String data) {
        this.data = data;
    }
}
