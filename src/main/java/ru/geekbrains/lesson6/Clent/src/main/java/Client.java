import java.io.*;
import java.net.Socket;
import java.util.Scanner;

public class Client {
    private static final String ADDRESS = "localhost";
    private static final int PORT = 8189;
    private static Socket socket;
    private static Scanner sc;
    private static DataInputStream in;
    private static DataOutputStream out;

    public static void main(String[] args) {

        try {
            socket = new Socket(ADDRESS, PORT);
            sc = new Scanner(System.in);
            in = new DataInputStream(socket.getInputStream());
            out = new DataOutputStream(socket.getOutputStream());

            Thread thread = new Thread(() -> {
                try {
                    while (true) {
                        System.out.println("Введите сообщение:");
                        String msg = sc.nextLine();
                        out.writeUTF(msg);
                    }
                } catch (IOException e) {
                    e.printStackTrace();
                }
            });
            thread.setDaemon(true);
            thread.start();

            while (true) {
                String msgServer = in.readUTF();
                if (msgServer.equals("/end")) {
                    out.writeUTF("/end");
                    break;
                }
                System.out.println("Server: " + msgServer);
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                socket.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}