//package network.src.d0513.S;
//
//import java.io.*;
//import java.net.ServerSocket;
//import java.net.Socket;
//
//public class ServerMain {
//
//    public static void main(String[] args) {
//        try {
//            ServerSocket ss = new ServerSocket(5050);
//
//            while (true){
//                Socket sc = ss.accept();
//                Thread it = new OutputThread(sc);
//                it.start();
//            }
//
////            InputStream is = sc.getInputStream();
////            BufferedReader br = new BufferedReader(new InputStreamReader(is));
////
////            System.out.println(br.readLine());
////
////            //보내기
////            Scanner scan = new Scanner(System.in);
////
////            OutputStream os = sc.getOutputStream();
////            PrintWriter pw = new PrintWriter(os,true);
////
////            pw.println(scan.nextLine());
//        }
//        catch (IOException e){
//            e.printStackTrace();
//        }
//    }
//}
