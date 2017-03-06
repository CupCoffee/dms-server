package main.java;

import com.corundumstudio.socketio.Configuration;
import com.corundumstudio.socketio.SocketIOClient;
import com.corundumstudio.socketio.SocketIONamespace;
import com.corundumstudio.socketio.SocketIOServer;
import com.corundumstudio.socketio.listener.ConnectListener;

public class Main {
    public static void main(String[] args)
    {
        Configuration config = new Configuration();
        config.setPort(1337);

        SocketIOServer server = new SocketIOServer(config);
        
        SocketIONamespace namespace = server.addNamespace("chat");

        namespace.addConnectListener(new ConnectListener() {
            @Override
            public void onConnect(SocketIOClient socketIOClient) {
                System.out.println("Someone connected!");
            }
        });



        server.start();
    }
}