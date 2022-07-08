//package network.src.d0523_2;
//
//import java.io.*;
//import java.net.ServerSocket;
//import java.net.Socket;
//
//public class FileCopyServer {
//
//    public static void main(String[] args) throws IOException {
////        ServerSocket ss = new ServerSocket(5234);
////        Socket sc = ss.accept();
////
////        InputStream is = sc.getInputStream();
////        BufferedInputStream bir = new BufferedInputStream(is);
////        DataInputStream dis = new DataInputStream(bir);
////
////        String filename = dis.readUTF();
////
////        FileOutputStream fos = new FileOutputStream("/Users/bjigeon/Desktop/img" + filename);
////
////
////        byte[] bytes = new byte[1024];
////        int readbit = 0;
////        while ((readbit = dis.read(bytes)) != -1){
////            fos.write(bytes,0,readbit);
////        }
////
////        System.out.println("파일 전송 성공");
//
//
//        // TODO Auto-generated method stub
//        ServerSocket ss= new ServerSocket(5234);
//        Socket sc = ss.accept();
//
//        InputStream is = sc.getInputStream();
//        BufferedInputStream bir = new BufferedInputStream(is);
//        DataInputStream dis = new DataInputStream(bir);
//
//        String filename = dis.readUTF();
//
////        FileOutputStream fos = new FileOutputStream("/Users/bjigeon/Desktop/dsalkfjsd" + filename);
//        FileOutputStream fos = new FileOutputStream("/Users/bjigeon/Desktop" + filename);
//
//        byte[] bytes = new byte[1024];
//        int readbit = 0;
//        while((readbit = dis.read(bytes)) != -1) {
//            fos.write(bytes, 0, readbit);
//        }
//        fos.flush();
//
//        System.out.println("파일전송 성공");
//    }
//}
