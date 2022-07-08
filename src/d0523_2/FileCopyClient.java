//package network.src.d0523_2;
//
//import java.io.*;
//import java.net.Socket;
//
//public class FileCopyClient {
//
//    public static void main(String[] args) throws IOException {
////        Socket sc = new Socket("127.0.0.1",5234);
////        OutputStream os = sc.getOutputStream();
////        BufferedOutputStream bor = new BufferedOutputStream(os);
////        DataOutputStream dos = new DataOutputStream(bor);
////
////        File f1 = new File("/Users/bjigeon/Desktop/IMG.jpeg");
////        FileInputStream fis = new FileInputStream(f1);
////
////        byte[] bytes = new byte[1024];
////
////        int readbit = 0;
////
////        dos.writeUTF(f1.getName());
////
////        while ((readbit = fis.read(bytes)) != -1){
////            dos.write(bytes,0,readbit);
////            //fos.write(bytes,0,readbit);
////            //byte에 저장된
////        }
//
//        // TODO Auto-generated method stub
//        Socket sc = new Socket("127.0.0.1",5234);
//        OutputStream os = sc.getOutputStream();
//        BufferedOutputStream bor = new BufferedOutputStream(os);
//        DataOutputStream dos = new DataOutputStream(bor);
//
//
//
////        File fl = new File("D:\\testimage.png");
//        File fl = new File("/Users/bjigeon/Desktop/IMG.jpeg");
//        FileInputStream fis = new FileInputStream(fl);
//
//        byte[] bytes = new byte[1024];
//        int readbit = 0;
//
//        dos.writeUTF(fl.getName());
//
//        while((readbit = fis.read(bytes)) != -1)
//            dos.write(bytes,0,readbit);
//        dos.flush();
//        //fos.write(bytes,0,readbit);
//        // bytes 에 저장된 데이터 전송
//    }
//}
