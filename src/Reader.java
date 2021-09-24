import java.util.Date;
import java.util.List;

public class Reader implements Runnable {

    private final List<Integer> numbers;

    public Reader(List<Integer> numbers) {
        this.numbers = numbers;
    }

    @Override
    public void run() {
        while (true) {
            try {
                Thread.sleep(1000);

                if (numbers.isEmpty()) {
                    Date date = new Date();
                    System.out.println(date.toString() + " The list is empty");
                }
                System.out.println(numbers.toString());
                numbers.clear();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

    }

}
