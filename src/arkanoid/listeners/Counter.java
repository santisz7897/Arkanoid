package arkanoid.listeners;

/**
 * @author Santiago Szterenberg <santisz7897@gmail.com>
 * @version 1.
 * @since 18-04-2021
 */
public class Counter {

    private int counter;

    /**
     * the constructor of the number.
     * @param number the initial number of the counter.
     */
    public Counter(int number) {
        this.counter = number;
    }

    /**
     * add number to current count.
     * @param number the number to add.
     */
    public void increase(int number) {
        this.counter += number;
    }

    /**
     * subtract number from current count.
     * @param number the number to subtract.
     */
    //
    public void decrease(int number) {
        this.counter -= number;
    }

    /**
     *
     * @return current count.
     */
    public int getValue() {
        return this.counter;
    }

    /**
     *
     * @return the number of the count by string.
     */
    public String toString() {
        return String.valueOf(this.counter);
    }
}
