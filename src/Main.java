import java.util.ArrayList;
import java.util.List;

public class Main {

    public static void main(String[] args) {
        //Testing requirements for Task 1
        List<Integer> numbers = new ArrayList<>();
        Reader reader = new Reader(numbers);
        Writter writter = new Writter(numbers);
        Thread t1 = new Thread(reader);
        Thread t2 = new Thread(writter);
        t1.start();
        t2.start();


        //Testing requirements for Task 2
        // Fill array with multithreading

        String[] array = new String[20000000];
        long beginTime = System.currentTimeMillis();
        StringArrayHelper stringArrayHelper3 = new StringArrayHelper(array, 0, 5000000);
        StringArrayHelper stringArrayHelper4 = new StringArrayHelper(array, 5000001, 10000000);
        StringArrayHelper stringArrayHelper5 = new StringArrayHelper(array, 10000001, 20000000);
        Thread t3 = new Thread(stringArrayHelper3);
        Thread t4 = new Thread(stringArrayHelper4);
        Thread t5 = new Thread(stringArrayHelper5);
        t3.start();
        t4.start();
        t5.start();
        try {
            t3.join();
            t4.join();
            t5.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        long endTime = System.currentTimeMillis();
        long fullTimeForMultithreading = endTime - beginTime;
        System.out.println("Multithreading time = " + fullTimeForMultithreading);

        // Fill array without multithreading
        String[] arrayTwo = new String[20000000];
        long beginTimeTwo = System.currentTimeMillis();
        StringArrayHelper stringArrayHelper6 = new StringArrayHelper(arrayTwo, 0, 20000000);
        Thread t6 = new Thread(stringArrayHelper6);
        t6.start();
        try {
            t6.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        long endTimeTwo = System.currentTimeMillis();
        long fullTimeWithoutMultithreading = endTimeTwo - beginTimeTwo;
        System.out.println("Time for one thread operation = " + fullTimeWithoutMultithreading);
        System.out.println("Time diff : " + (fullTimeWithoutMultithreading - fullTimeForMultithreading));

    }
}