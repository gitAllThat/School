package edu.gcccd.csis;

public class LazyCtor {
    // static members
    private static final int K = 30;
    private static final LazyCtor[] LA = new LazyCtor[K];
    private static int instanceCounter = 0;

    // instance variables
    private final int id;

    // only constructor is private
    private LazyCtor(final int id) {
        this.id = id;
        LazyCtor.instanceCounter++;
    }

    public static int getNumOfInstancesAllowed() {
        return LazyCtor.K;
    }

    public static int getNumOfInstancesCreated() {
        return LazyCtor.instanceCounter;
    }

    public static LazyCtor getInstance() {

        // First check to make sure the max number of instances haven't been reached
        if (getNumOfInstancesCreated() < getNumOfInstancesAllowed()) {
            // < 30 instances, so create
            LazyCtor x = new LazyCtor(instanceCounter);
            LA[instanceCounter] = x;
            return x;
        }
        else{
            // > 30 instances, return null
            return null;
        }
    }

    public int getId() {
        return this.id;
    }

    @Override
    public String toString() {
        return String.format("I'm the LazyCtor Object, with the id: %d", id);
    }
}
