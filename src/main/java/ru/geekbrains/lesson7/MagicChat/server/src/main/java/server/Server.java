package server;

import org.omg.CORBA.PUBLIC_MEMBER;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.List;
import java.util.Scanner;
import java.util.concurrent.CopyOnWriteArrayList;

public class Server {
    private ServerSocket server;
    private Socket socket;
    private final int PORT = 8189;

    private List<ClientHandler> clients;
    private AuthService authService;

    public Server() {
        clients = new CopyOnWriteArrayList<>();
        authService = new SimpleAuthService();

        try {
            server = new ServerSocket(PORT);
            System.out.println("Server started!");

            while (true) {
                socket = server.accept();
                System.out.println("Client connected: " + socket.getRemoteSocketAddress());
                new ClientHandler(this, socket);
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            System.out.println("Server stop");
            try {
                server.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    public void subscribe(ClientHandler clientHandler) {
        clients.add(clientHandler);
    }

    public void unsubscribe(ClientHandler clientHandler) {
        clients.remove(clientHandler);
    }

    public void broadcastMsg(ClientHandler sender, String msg) {
        String message = String.format("[ %s ]: %s", sender.getNickname(), msg);
        for (ClientHandler c : clients) {
            c.sendMsg(message);
        }
    }

    /* Реализовать личные сообщения, если клиент пишет «/w nick3 Привет, как дела», то только клиенту с ником nick3
    и отправителю должно прийти сообщение «Привет, как дела» */

    public void privateMsg(ClientHandler sender, String to, String msg) {

        for (ClientHandler client : clients) {
            if (client.getNickname().equals(to)) {
                client.sendMsg("[privat message from: " + sender.getNickname() + "] " + msg);
                sender.sendMsg("[privat message to: " + to + "] " + msg);
                return;
            }
        }
        sender.sendMsg("User with nickname " + to + " not found");
    }

    public AuthService getAuthService() {
        return authService;
    }
}
