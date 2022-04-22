package network.src.d0422;

public class Thread4 implements Runnable{
    public void run(){
        for (int i = 0; i < 500; i++) {
            System.out.println("t4 Thread: " + i);
        }
        System.out.println("Thread4 종료");
    }
}
