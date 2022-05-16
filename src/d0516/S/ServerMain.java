package network.src.d0516.S;

import java.net.ServerSocket;
import java.net.Socket;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.PrintWriter;

public class ServerMain {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		try {
			ServerSocket ss = new ServerSocket(5000);
			String nboolean = "";
			while(true) {
				String msg ="";
				Socket sc = ss.accept();

				do {
					// NickName 설정
					InputStream is = null;
					try {
						is = sc.getInputStream();
					} catch (IOException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
					BufferedReader br =
							new BufferedReader(new InputStreamReader(is));

					msg=br.readLine().substring(1);

					nboolean = "NOK";
					for(inputThread tmpit: inputThread.ClientList) {
						if(tmpit.nickname.equals(msg)){
							nboolean = "NNG";
						}
					}

					OutputStream os = null;
					try {
						os = sc.getOutputStream();
					} catch (IOException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
					PrintWriter pw = new PrintWriter(os, true);

					pw.println(nboolean);

					System.out.println(nboolean + ":" + msg);
				} while(nboolean !="NOK");

				Thread it = new inputThread(msg, sc);
				it.start();
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}