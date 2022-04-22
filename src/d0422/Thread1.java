package network.src.d0422;

public class Thread1 implements Runnable{
    public String name;
    public void run(){
        for (int i = 0; i < 500; i++) {
            System.out.println(Thread.currentThread().getName() + ": " + i);
        }
        System.out.println(Thread.currentThread().getName() + " Thread 종료");
    }
}
