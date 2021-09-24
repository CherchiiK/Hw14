public class StringArrayHelper implements Runnable {

    private final String[] array;
    private final int startingIndex;
    private final int endingIndex;

    public StringArrayHelper(String[] array, int startingIndex, int endingIndex) {
        this.array = array;
        this.startingIndex = startingIndex;
        this.endingIndex = endingIndex;
    }

    @Override
    public void run() {
        for (int i = startingIndex; i < endingIndex; i++) {
            if (i % 3 == 0 && i % 5 == 0) {
                array[i] = "FizzBuzz";
            } else if (i % 3 == 0) {
                array[i] = "Fizz";
            } else if (i % 5 == 0) {
                array[i] = "Buzz";
            } else {
                array[i] = String.valueOf(i);
            }
        }
    }
}

