package com.example.global.RS;

public record RsData<T>(
        String resultCode,
        String message,
        T Data
)
{
    public RsData (String resultCode, String message){
        this(resultCode,message,null);
    }
}
