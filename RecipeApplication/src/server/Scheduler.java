package server;

import java.util.ArrayList;

public class Scheduler {

    private ServerThread runningThread = null;
    private ArrayList<ServerThread> waitingThreads = new ArrayList<>();
    private final Object lockObject = new Object();

    void enter() throws InterruptedException {
        ServerThread thisThread = (ServerThread) Thread.currentThread();
        synchronized (this) {
            if (runningThread == null) {
                runningThread = thisThread;
                return;
            }
            waitingThreads.add(thisThread);
        }
        
        synchronized (lockObject) {
            while (thisThread != runningThread) {
                lockObject.wait();
            }
        }
        
        synchronized (this) {
            int i = waitingThreads.indexOf(thisThread);
            waitingThreads.remove(i);
        }
    }

    void done() {
        if (runningThread != Thread.currentThread()) {
            throw new IllegalStateException("Wrong thread");
        }
        int waitCount = waitingThreads.size();
        if (waitCount <= 0) {
            runningThread = null;
        } else {
            runningThread = waitingThreads.get(0);
            waitingThreads.remove(0);
            synchronized (lockObject) {
                lockObject.notifyAll();
            }
        }
    }
}
