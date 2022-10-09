package sockets;

import java.io.IOException;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;

public class Server
{
    public static void main(String[] args) throws IOException
    {
        ServerSocket serverSocket = new ServerSocket(7567);
        System.out.println("Starting server on " + serverSocket.getLocalPort());
        InputSocket inputSocket = new InputSocket(serverSocket);
        inputSocket.run();
//        Socket client = serverSocket.accept();
//        //Input socket
//
//        Scanner scanner = new Scanner(client.getInputStream());
//        while (scanner.hasNext()){
//            System.out.println(scanner.nextLine());
//        }
//
//        scanner.close();

        //Output socket
//        PrintWriter out = new PrintWriter(client.getOutputStream());
//        out.println("Hello World!");
//        out.flush();
//
//        System.out.println("Finished server on " + serverSocket.getLocalPort());
//
//        out.close();

//        client.close();
        serverSocket.close();
    }
}
