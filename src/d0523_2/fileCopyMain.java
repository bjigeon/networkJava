//package network.src.d0523_2;
//
//import java.io.*;
//
//public class fileCopyMain {
//
//    public static void main(String[] args) throws IOException {
//        File f1 = new File("/Users/bjigeon/Desktop/IMG.jpeg");
//        FileInputStream fis = new FileInputStream(f1);
//
//        FileOutputStream fos = new FileOutputStream("/Users/bjigeon/Desktop/b.jpeg");
//
//        byte[] bytes = new byte[1024];
//
//        int readbit = 0;
//        while ((readbit = fis.read(bytes)) != -1){
//            fos.write(bytes);
//        }
//    }
//}
