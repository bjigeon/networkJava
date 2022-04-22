package network.src.d0422;

public class Thread3 implements Runnable{
    public void run(){
        for (int i = 0; i < 500; i++) {
            System.out.println("t3 Thread: " + i);
        }
        System.out.println("Thread3 종료");
    }
}
