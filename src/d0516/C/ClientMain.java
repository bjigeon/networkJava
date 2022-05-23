//package network.src.d0516.C;
//
//import java.io.BufferedReader;
//import java.io.IOException;
//import java.io.InputStream;
//import java.io.InputStreamReader;
//import java.io.OutputStream;
//import java.io.PrintWriter;
//import java.net.Socket;
//import java.net.UnknownHostException;
//import java.util.Scanner;
//
//public class ClientMain {
//    public static void main(String[] args) {
//        try {
//
//            Socket sc = new Socket("10.80.162.99", 5000);
//
//            String nboolean ="NNG";
//            while(!nboolean.equals("NOK")) {
//                // NickName 설정
//
//                System.out.printf("닉네임을 설정하세요: ");
//                Scanner scan = new Scanner(System.in);
//
//                OutputStream os = null;
//                try {
//                    os = sc.getOutputStream();
//                } catch (IOException e) {
//                    // TODO Auto-generated catch block
//                    e.printStackTrace();
//                }
//                PrintWriter pw = new PrintWriter(os, true);
//
//                pw.println("N"+scan.nextLine());
//
//                InputStream is = null;
//                try {
//                    is = sc.getInputStream();
//                } catch (IOException e) {
//                    // TODO Auto-generated catch block
//                    e.printStackTrace();
//                }
//                BufferedReader br =
//                        new BufferedReader(new InputStreamReader(is));
//
//                try {
//                    nboolean = br.readLine();
//                } catch (IOException e) {
//                    // TODO Auto-generated catch block
//                    e.printStackTrace();
//                }
//            }
//
//            Thread ot = new outputThread(sc);
//            Thread it = new inputThread(sc);
//
//            ot.start();
//            it.start();
//
//            try {
//                ot.join();
//                it.join();
//            } catch (InterruptedException e) {
//                // TODO Auto-generated catch block
//                e.printStackTrace();
//            }
//
//
//        } catch (UnknownHostException e) {
//            // TODO Auto-generated catch block
//            e.printStackTrace();
//        } catch (IOException e) {
//            // TODO Auto-generated catch block
//            e.printStackTrace();
//        }
//    }
//}
