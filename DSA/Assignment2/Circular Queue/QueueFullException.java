package Assignment2.Session2;
/*
 * QueueFullException - handling run time exception related to full queue.
 */
class QueueFullException extends RuntimeException {

    private static final long serialVersionUID = 1L;

    public QueueFullException() {
        super();
    }

    public QueueFullException(String message) {
        super(message);
    }

}