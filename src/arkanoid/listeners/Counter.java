package arkanoid.listeners;

/**
 * @author ido grossman <idoddii@gmail.com>
 * @version 1.
 * @since 20-05-2021
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
