package network.src.d0415.thread;

public class Thread1 extends Thread{
	//작업 구현
	public void run() {
		for(int i =0; i<500;i++) {
			System.out.printf("t2 Thread :; %d \n",i);
		}
	}
}
