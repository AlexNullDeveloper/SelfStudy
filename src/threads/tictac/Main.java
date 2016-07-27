package threads.tictac;

/**
 * Created by a.talismanov on 05.07.2016.
 */
public class Main {
    public static void main(String[] args) throws InterruptedException{
        Data d = new Data();

        Worker1 w1 = new Worker1(1, d);
        Worker2 w2 = new Worker2(2, d);



//        w1.join();
        w2.join();
        //Thread.sleep(5000);
        System.out.println("end of main");
    }
}
