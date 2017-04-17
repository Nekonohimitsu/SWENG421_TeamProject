package server;

import java.util.ArrayList;

public class Scheduler {
    private ArrayList<ServerThread> waitingThreads;
    private ArrayList<MessageAbs> waitingRequests;
    private static Scheduler instance = null;
    
    private Scheduler() {}
    static Scheduler getInstance() {
        if (instance == null) {
            instance = new Scheduler();
        }
        return instance;
    }
    
    void enter(MessageAbs m) {
        
    }
    
    void done() {
        
    }
}
