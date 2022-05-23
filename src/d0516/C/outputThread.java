//package network.src.d0516.C;
//
//import java.io.IOException;
//import java.io.OutputStream;
//import java.io.PrintWriter;
//import java.net.Socket;
//import java.util.Scanner;
//
//public class outputThread extends Thread {
//	Socket sc = null;
//
//	public outputThread(Socket sc) {
//		this.sc =sc;
//	}
//
//	public void run() {
//		// ������
//		Scanner scan = new Scanner(System.in);
//
//		OutputStream os = null;
//		try {
//			os = sc.getOutputStream();
//		} catch (IOException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
//		PrintWriter pw = new PrintWriter(os, true);
//
//		while(true)
//			pw.println(scan.nextLine());
//	}
//}
