package application;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;
import java.util.logging.Level;
import java.util.logging.Logger;
import utilities.Recipe;

public class ServerThread extends Thread{
    Socket s;
    ObjectOutputStream os;
    ObjectInputStream is;
    
    public ServerThread(Socket s, ObjectInputStream is, ObjectOutputStream os) {
        this.s = s;
        this.is = is;
        this.os = os;
    }
    @Override
    public void run() {
        try {
            Recipe r = new Recipe("Foo.");
            Recipe r2;
            while ((r2 = (Recipe)is.readObject()) != null) {
                Server.notifyClients(r);
            }
            Server.removeClient(os);
            is.close();
            os.close();
            s.close();
        } catch (IOException ex) {
            Logger.getLogger(ServerThread.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(ServerThread.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
