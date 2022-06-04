package network.src.test;

import java.io.*;
import java.net.Socket;
import java.util.Scanner;

public class Client {
    static Client ftpClient = new Client();

    static File filePath = new File("");
    String fileName = "";

    String stringFilePath = "";
    static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
        System.out.println("클라이언트 시작");
        Socket socket = new Socket("127.0.0.1",7565);


    }

}
