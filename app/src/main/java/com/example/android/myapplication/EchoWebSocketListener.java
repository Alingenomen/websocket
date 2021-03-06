package com.example.android.myapplication;

import android.util.Log;

import okhttp3.Response;
import okhttp3.WebSocket;
import okhttp3.WebSocketListener;
import okio.ByteString;

public final class EchoWebSocketListener extends WebSocketListener {
    private static final int NORMAL_CLOSURE_STATUS = 1000;

    @Override
    public void onOpen(WebSocket webSocket, Response response) {
        webSocket.send("");
        webSocket.close(NORMAL_CLOSURE_STATUS, "Goodbye !");
    }

    @Override
    public void onMessage(WebSocket webSocket, String text) {
        Log.d("Got string message! %s", text);
    }

    @Override
    public void onMessage(WebSocket webSocket, ByteString bytes) {
        Log.d("Receiving bytes : ",bytes.hex());
    }

    @Override
    public void onClosing(WebSocket webSocket, int code, String reason) {
        webSocket.close(NORMAL_CLOSURE_STATUS, null);
        Log.d("Closing : ", code + " / " + reason);
    }

    @Override
    public void onFailure(WebSocket webSocket, Throwable t, Response response) {
        Log.d("Error : ",t.getMessage());
    }
}