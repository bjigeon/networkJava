//package network.src.d0513.C;
//
//import com.sun.xml.internal.ws.api.ha.StickyFeature;
//
//import java.io.*;
//import java.net.Socket;
//import java.util.ArrayList;
//import java.util.Collections;
//import java.util.List;
//
//public class inputThread extends Thread{
//
//    private static List<inputThread> ClientList =
//            Collections.synchronizedList(new ArrayList<inputThread>());
//
//    Socket sc = null;
//
//    public inputThread(Socket sc){
//        this.sc = sc;
//        ClientList.add(this);
//
//        OutputStream os = null;
//        try {
//            os = sc.getOutputStream();
//        }
//        catch (IOException e){
//            e.printStackTrace();
//        }
//    }
//
//    public void msgPringln(String msg){
//
//    }
//
//    public void run() {
//        InputStream is = null;
//        try {
//            is = sc.getInputStream();
//
//        }
//        catch (IOException e){
//            e.printStackTrace();
//        }
//        BufferedReader br = new BufferedReader(new InputStreamReader(is));
//
//        try {
//            while (true) {
////                System.out.println(br.readLine());
//
//                String msg = br.readLine();
//
//                for (inputThread tmpit : ClientList){
//                    tmpit
//                }
//            }
//        }
//        catch (IOException e){
//            e.printStackTrace();
//        }
//    }
//}
