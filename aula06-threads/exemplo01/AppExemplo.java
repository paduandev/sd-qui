package exemplo01;

public class AppExemplo {
    public static void main(String[] args) {
        MinhaThread t1 = new MinhaThread("Thread 1");
        MinhaThread t2 = new MinhaThread("Thread 2");
        MinhaThread t3 = new MinhaThread("Thread 3");

        t1.start();
        t2.start();
        t3.start();
    }
    
}