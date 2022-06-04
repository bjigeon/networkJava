package network.src.test;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.Scanner;

public class Server {
    public static void main(String[] args) {
        // TODO Auto-generated method stub
        try {
            Socket sc = new Socket("127.0.0.1",6755);
            OutputStream os = sc.getOutputStream();
            PrintWriter pw = new PrintWriter(os, true);

            pw.println("파일을 덮어쓰기겠습니까?");

            InputStream is = sc.getInputStream();		// 클라이언트 메시지 입력 받음
            BufferedReader br = new BufferedReader(new InputStreamReader(is));

            String answer = br.readLine();
            if (answer.equals("Y") || answer.equals("y")){
                System.out.println("yes");
            }else {
                System.out.println("NO");
            }

        } catch (UnknownHostException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }
}
