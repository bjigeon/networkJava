//package network.src.d0516.C;
//
//import java.io.BufferedReader;
//import java.io.IOException;
//import java.io.InputStream;
//import java.io.InputStreamReader;
//import java.net.Socket;
//
//public class inputThread extends Thread {
//	Socket sc = null;
//
//	public inputThread(Socket sc) {
//		this.sc = sc;
//	}
//
//	public void run() {
//		// �ޱ�
//		InputStream is = null;
//		try {
//			is = sc.getInputStream();
//		} catch (IOException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
//		BufferedReader br =
//				new BufferedReader(new InputStreamReader(is));
//
//		try {
//			while(true)
//				System.out.println(br.readLine());
//		} catch (IOException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
//	}
//}
