package com.poleszak.webApp.exceptions;

public class SpringDiscussionwebsiteException extends RuntimeException
{
    public SpringDiscussionwebsiteException(String exMessage, Exception e)
    {
        super(exMessage, e);
    }

    public SpringDiscussionwebsiteException(String exMessage)
    {
        super(exMessage);
    }
}
