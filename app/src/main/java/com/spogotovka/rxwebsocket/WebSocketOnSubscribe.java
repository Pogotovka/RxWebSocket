package com.spogotovka.rxwebsocket;

import com.spogotovka.rxwebsocket.entities.SocketEvent;

import java.util.concurrent.TimeUnit;

import io.reactivex.FlowableEmitter;
import io.reactivex.FlowableOnSubscribe;
import io.reactivex.annotations.NonNull;
import okhttp3.OkHttpClient;
import okhttp3.Request;

public class WebSocketOnSubscribe implements FlowableOnSubscribe<SocketEvent> {

    private final OkHttpClient client;
    private final Request request;

    public WebSocketOnSubscribe(@NonNull String url) {
        client = new OkHttpClient.Builder()
                .readTimeout(0, TimeUnit.MILLISECONDS)
                .build();

        request = new Request.Builder()
                .url(url)
                .build();
    }

    public WebSocketOnSubscribe(@NonNull OkHttpClient client, @NonNull String url) {
        this.client = client;
        request = new Request.Builder()
                .url(url)
                .build();
    }

    @Override
    public void subscribe(FlowableEmitter<SocketEvent> emitter) throws Exception {
        client.newWebSocket(request, new WebSocketEventRouter(emitter));
    }
}

