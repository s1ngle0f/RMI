package sockets;

import java.io.IOException;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class InputSocket extends Thread
{
    public static ServerSocket serverSocket;
    public static List<Socket> inputSockets = new ArrayList<>();
    private Socket inputSocket;

    public InputSocket(ServerSocket serverSocket)
    {
//        if (serverSocket == null)
        this.serverSocket = serverSocket;
    }

    @Override
    public void run()
    {
        try
        {
            inputSocket = serverSocket.accept();
            Scanner in = new Scanner(inputSocket.getInputStream());
            PrintWriter out = new PrintWriter(inputSocket.getOutputStream());
            inputSockets.add(inputSocket);

            Thread newInputSocket = new InputSocket(serverSocket);
            newInputSocket.start();

            while(in.hasNextLine()){
                String msg = in.nextLine();
                System.out.println(msg);
//                out.println(msg);
//                out.flush();
                for (Socket socket: inputSockets)
                {
                    PrintWriter curOut = new PrintWriter(socket.getOutputStream());
                    curOut.println(msg);
                    curOut.flush();
                }
            }
        } catch (IOException e)
        {
            throw new RuntimeException(e);
        }
    }
}


