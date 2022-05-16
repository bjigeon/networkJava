//package network.src.d0513.S;
//
//import java.io.BufferedReader;
//import java.io.IOException;
//import java.io.InputStream;
//import java.io.InputStreamReader;
//import java.net.Socket;
//
//public class inputThread extends Thread{
//    Socket sc = null;
//
//    public inputThread(Socket sc){
//        this.sc = sc;
//    }
//
//    public void run() {
//        InputStream is = null;
//        try {
//            is = sc.getInputStream();
//        }
//        catch (IOException e){
//            e.printStackTrace();
//        }
//        BufferedReader br = new BufferedReader(new InputStreamReader(is));
//
//        while (true) {
//            pw.println(scan.nextLine());
//        }
//    }
//}
