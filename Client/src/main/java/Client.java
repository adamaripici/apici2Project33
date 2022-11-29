import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.net.Socket;
import java.util.function.Consumer;

public class Client extends Thread{


    Socket socketClient;

    ObjectOutputStream out;
    ObjectInputStream in;
    int port;
    String ip;
    private Consumer<Serializable> callback;

    Client(Consumer<Serializable> call, int port,String ip){

        callback = call;
        this.port = port;
        this.ip = ip;
    }

    public void run() {

        try {
            socketClient= new Socket(ip,port);
            out = new ObjectOutputStream(socketClient.getOutputStream());
            in = new ObjectInputStream(socketClient.getInputStream());
            socketClient.setTcpNoDelay(true);
        }
        catch(Exception e) {}

        while(true) {

            try {
                CFourInfo info;
                info = (CFourInfo)in.readObject();
                callback.accept(info);
            }
            catch(Exception e) {}
        }

    }

    public void send(CFourInfo data) {

        try {
            out.writeObject(data);
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }


}