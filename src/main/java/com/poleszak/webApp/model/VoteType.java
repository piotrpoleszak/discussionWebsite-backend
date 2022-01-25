package com.poleszak.webApp.model;

import com.poleszak.webApp.exceptions.SpringDiscussionwebsiteException;

import java.util.Arrays;

public enum VoteType
{
    UPVOTE(1), DOWNVOTE(-1);

    private int direction;

    VoteType(int direction) {}

    public static VoteType lookup(Integer direction)
    {
        return Arrays.stream(VoteType.values())
                .filter(value -> value.getDirection().equals(direction))
                .findAny()
                .orElseThrow(() -> new SpringDiscussionwebsiteException("Vote not found"));
    }

    public Integer getDirection()
    {
        return direction;
    }

}
