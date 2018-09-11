package task1;//*creates an Object to pass to sharedQueue


public class ObjectToPass {

    private long startTime;
    private int fib;


    public ObjectToPass(long startTime, int fib) {
        this.startTime = startTime;
        this.fib = fib;
    }

    public long getStartTime() {
        return startTime;
    }

    public void setStartTime(long startTime) {
        this.startTime = startTime;
    }

    public int getFib() {
        return fib;
    }

    public void setFib(int fib) {
        this.fib = fib;
    }
}
