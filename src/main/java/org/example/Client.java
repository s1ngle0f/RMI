package org.example;

import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.util.Scanner;

public class Client
{
    public static void main(String[] args) throws RemoteException, NotBoundException
    {
        Registry registry = LocateRegistry.getRegistry(7727);
        IMessage message = (IMessage) registry.lookup("Message");
        System.out.println(message.Ping());
        Scanner in = new Scanner(System.in);
        System.out.print("Input a, b, c: ");
        double a = in.nextDouble();
        double b = in.nextDouble();
        double c = in.nextDouble();
        System.out.println(message.GetSolve(a, b, c));
    }
}
