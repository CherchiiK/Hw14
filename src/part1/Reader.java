package part1;

import java.util.ArrayList;
import java.util.Date;

public class Reader implements Runnable {

    ArrayList<Integer> list;

    public Reader(ArrayList<Integer> list) {
        this.list = list;
    }

    @Override
    public void run() {
        listReader();
    }

    private void listReader(){
        try {
            Thread.sleep(1000);
            if (list.isEmpty()) {
                Date date = new Date();
                System.out.println("The list is empty " + date.toString());
            } else {
                System.out.println(list.toString());
                list.clear();
            }
            listReader();
        } catch (InterruptedException ex) {
            ex.printStackTrace();
        }
    }

}
