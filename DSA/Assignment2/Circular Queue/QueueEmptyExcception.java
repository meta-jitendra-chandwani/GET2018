package Assignment2.Session2;
/*
 * QueueEmptyException - handling run time exception related to empty queue
 */
class QueueEmptyException extends RuntimeException {

    private static final long serialVersionUID = 1L;

    public QueueEmptyException() {
        super();
    }

    public QueueEmptyException(String message) {
        super(message);
    }
}