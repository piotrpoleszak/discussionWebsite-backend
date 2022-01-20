package com.poleszak.webApp.exceptions;

public class SubpostNotFoundException extends RuntimeException
{
    public SubpostNotFoundException(String message)
    {
        super(message);
    }
}