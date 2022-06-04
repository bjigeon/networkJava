//package network.src.d0425;
//
//public class CakeMain {
//
//    public static void main(String[] args) {
//        CakePlate cake = new CakePlate();
//        Thread_Maker t1 = new Thread_Maker(cake);
//        Thread_Eater t2 = new Thread_Eater(cake);
//
//        t1.start();
//        t2.start();
//
//        try {
//            t1.join();
//            t2.join();
//        }catch (InterruptedException e){}
//
//
//        System.out.println("모든 과정이 종료됨");
//    }
//}
