package ru.urfu;

import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * Created by andrey on 16.10.16.
 */
public class Message  {

    @JsonProperty("Message")
    private String message;
    public Message(String message)
    {
        this.message = message;
    }
    public String getMessage()
    {
        return this.message;
    }

    @Override
    public boolean equals(Object o) {
        return ((Message)o).message.equals(this.message);
    }
    @Override
    public int hashCode() {
        return message.hashCode();
    }
}
