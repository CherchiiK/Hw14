package part1;

import java.util.ArrayList;
import java.util.Random;

public class Writer implements Runnable {
    ArrayList<Integer> list;

    public Writer(ArrayList<Integer> list) {
        this.list = list;
    }

    @Override
    public void run() {
        writeElement();
    }

    private void writeElement() {
        try {
            Thread.sleep(2500);
            list.add(new Random().nextInt());
            writeElement();
        } catch (InterruptedException ex) {
            ex.printStackTrace();
        }
    }
}
