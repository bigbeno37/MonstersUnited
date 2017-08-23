package io.github.monstersunited.monstergame.objects;

import java.io.Serializable;

public class Request implements Serializable{
    public RequestType type;
    public Object data;

    public Request(RequestType requestType, Object data) {
        this.type = requestType;
        this.data = data;
    }
}
