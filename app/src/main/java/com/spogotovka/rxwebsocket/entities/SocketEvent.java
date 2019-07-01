package com.spogotovka.rxwebsocket.entities;

import com.spogotovka.rxwebsocket.SocketEventTypeEnum;

public class SocketEvent {

    private final SocketEventTypeEnum type;

    public SocketEvent(SocketEventTypeEnum type) {
        this.type = type;
    }

    public SocketEventTypeEnum getType() {
        return type;
    }

    @Override
    public String toString() {
        return "SocketEvent{" +
                "type=" + type +
                '}';
    }
}
