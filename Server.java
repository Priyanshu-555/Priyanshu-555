import java.net.*;
import java.io.*;

class Server 
{
    ServerSocket server;
    Socket socket;

    BufferedReader br;
    PrintWriter out;

    //constructor
    public Server()
    {
        try 
        {
             server = new ServerSocket(7777);
             System.out.println("server started ...");
             System.out.println("waiting ...");
             socket = server.accept();
             
             //java have unidirectional stream .it dont have bidirectional stream 
             //byte -> char ,char -> buffer
             br = new BufferedReader (new InputStreamReader(socket.
             getInputStream()));

             out = new PrintWriter(socket.getOutputStream());

             startReading();
             startWriting();


        }
        catch (Exception e) 
        {
           e.printStackTrace();
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
                            System.out.println("server terminated ");
                            break;
                        }
                        System.out.println("server : " + msg);
                        
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

    

    public static void main(String[] args) 
    {
        System.out.println("server going to start");
        new Server();
    }
}
