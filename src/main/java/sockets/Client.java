package sockets;

import java.io.IOException;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.Scanner;

public class Client
{
    public static void main(String[] args) throws IOException
    {
        Socket socket = new Socket("localhost", 7567);

        Scanner in = new Scanner(socket.getInputStream());
        PrintWriter out = new PrintWriter(socket.getOutputStream());

        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter ur name: ");
        String name = scanner.nextLine();

        while (true){
            System.out.print(name + ": ");
            if(!scanner.hasNextLine())
                break;
            out.println(scanner.nextLine());
            out.flush();
            System.out.println(in.nextLine());
        }

        out.close();
        in.close();
        socket.close();
    }
}
