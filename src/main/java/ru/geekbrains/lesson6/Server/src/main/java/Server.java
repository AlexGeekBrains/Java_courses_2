import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;

public class Server {
    private static ServerSocket server;
    private static Socket socket;
    private static final int PORT = 8189;
    private static Scanner scWrite;
    private static DataInputStream in;
    private static DataOutputStream out;

    public static void main(String[] args) {

        try {
            server = new ServerSocket(PORT);
            System.out.println("Server started!");
            socket = server.accept();
            System.out.println("Client connected!");
            scWrite = new Scanner(System.in);
            in = new DataInputStream(socket.getInputStream());
            out = new DataOutputStream(socket.getOutputStream());

            Thread thread = new Thread(() -> {
                try {
                    while (true) {
                        System.out.println("Введите сообщение:");
                        String msg = scWrite.nextLine();
                        out.writeUTF(msg);
                    }
                } catch (IOException e) {
                    e.printStackTrace();
                }
            });
            thread.setDaemon(true);
            thread.start();


            while (true) {
                String msgClient = in.readUTF();
                if (msgClient.equals("/end")) {
                    out.writeUTF("/end");
                    break;
                }
                System.out.println("Client: " + msgClient);
            }

        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            System.out.println("Client disconnect!");
            try {
                socket.close();
                server.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}