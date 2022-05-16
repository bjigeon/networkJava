//package network.src.d0513.C;
//
//import java.io.*;
//import java.net.ServerSocket;
//import java.net.Socket;
//import java.net.UnknownHostException;
//import java.util.Scanner;
//
////import network.src.d0513.C.outPutThread;
////import network.src.d0513.C.inputPutThread;
//
//public class ClientMain {
//
//    public static void main(String[] args) {
//        try {
//            Socket sc = new Socket("10.80.162.208", 5050);
//
////            Thread ot = new outPutThread(sc);
////            Thread it = new inputPutThread(sc);
//
////            ot.start();
////            it.start();
////
////            try {
////                ot.join();
////                it.join();
////            }
////            catch (InterruptedException e){
////                e.printStackTrace();
////            }
//
//            Scanner scan = new Scanner(System.in);
//
//            OutputStream os = sc.getOutputStream();
//            PrintWriter pw = new PrintWriter(os,true);
//
//            pw.println(scan.nextLine());
//
//            InputStream is = sc.getInputStream();
//            BufferedReader br = new BufferedReader(new InputStreamReader(is));
//        }
//        catch (UnknownHostException e){
//            e.printStackTrace();
//        }
//        catch (IOException e){
//            e.printStackTrace();
//        }
//    }
//}
