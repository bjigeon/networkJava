//package network.src.d0624;
//
//import java.io.IOException;
//import java.net.*;
//
//public class ClientMain {
//    public static void main(String[] args) throws IOException {
//
//        InetAddress inetaddr = InetAddress.getByName("255.255.255.255");
//
//        DatagramSocket ds = new DatagramSocket();
//
//        for (int i = 1; i <= 1000; i ++){
//            String j = Integer.toString(i);
//            DatagramPacket sendPacket = new DatagramPacket(j.getBytes(), j.getBytes().length, inetaddr, 9999);
//
//            ds.send(sendPacket);
//        }
//
////        String j = "";
////        DatagramPacket sendPacket = new DatagramPacket(j.getBytes(), j.getBytes().length, inetaddr, 9999);
////        ds.send(sendPacket);
//
//        System.out.println("전송 끝");
//    }
//}
