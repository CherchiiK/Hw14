package part1;

import java.util.ArrayList;

public class Main extends Thread {
    public static final ArrayList<Integer> list = new ArrayList<>();


    public static void main(String[] args) {
        Reader reader = new Reader(list);
        Writer writer = new Writer(list);

        reader.run();
        writer.run();
    }
}
