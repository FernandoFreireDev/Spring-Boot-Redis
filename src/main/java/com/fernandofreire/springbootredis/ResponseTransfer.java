package com.fernandofreire.springbootredis;

public class ResponseTransfer {

    public ResponseTransfer(String s) {
        this.setText(s);
    }

    private String text;

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }
}