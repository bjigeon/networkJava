package network.src.FTP.Server;

import FTP.S.ServerThread;

import java.io.IOException;
import java.net.ServerSocket;

public class ServerMain {
    public static void main(String args[]) throws IOException {
        ServerSocket serverSocket = new ServerSocket(7777);
        System.out.println("서버 시작");
        while (true) {
            new ServerThread(serverSocket.accept());
        }
    }
}
