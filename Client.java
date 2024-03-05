import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;

public class Client {
    Socket socket;

    BufferedReader br;
    PrintWriter out;

    public Client()
    {
        try {
            System.out.println("sending request to server ");
            socket = new Socket("127.0.0.1",7777);
            System.out.println("connection done.");


             
             br = new BufferedReader (new InputStreamReader(socket.
             getInputStream()));

             out = new PrintWriter(socket.getOutputStream());

             startReading();
             startWriting();



        } catch (Exception e) {
        }

    }
    public void startReading()
    {
            //thread -read continuously read and send

            Runnable r1 = ()->
            {
                System.out.println("reader started ");

                while(true)
                {
                    try 
                    {
                        String msg = br.readLine();
                        if(msg.equals("exit"))
                        {
                            System.out.println("client terminated ");
                            break;
                        }
                        System.out.println("client : " + msg);
                        
                    } 
                    catch (Exception e) 
                    {
                       e.printStackTrace();
                    }
                   
                }

            };
            new Thread(r1).start();

        }
        public void startWriting()
        {
            //thread-write continuously get data from user and send it to the client
            Runnable r2 = ()->
            {
                System.out.println("writer started ");
                while (true) 
                {
                    try 
                    {
                        BufferedReader br1 = new BufferedReader
                        (new InputStreamReader(System.in));
                        String content = br1.readLine();
                        out.println(content);
                        out.flush();
                        
                    } 
                    catch (Exception e) 
                    {
                        e.printStackTrace();
                    }
                    
                }

            };
            new Thread(r2).start();

        }
    
    public static void main(String[] args) {
        System.out.println("client");
         new Client();
        
    }
}
