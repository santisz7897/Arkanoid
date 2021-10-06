package arkanoid.listeners;

/**
 * @author Santiago Szterenberg <santisz7897@gmail.com>
 * @version 1.
 * @since 18-04-2021
 */
public interface HitNotifier {

    /**
     *
     * @param hl Add hl as a listener to hit events.
     */
    void addHitListener(HitListener hl);

    /**
     *
     * @param hl Remove hl from the list of listeners to hit events.
     */
    void removeHitListener(HitListener hl);
}
