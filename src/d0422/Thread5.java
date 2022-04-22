package network.src.d0422;

public class Thread5 implements Runnable{
    public void run(){
        for (int i = 0; i < 500; i++) {
            System.out.println("t5 Thread: " + i);
        }
        System.out.println("Thread5 종료");
    }
}
