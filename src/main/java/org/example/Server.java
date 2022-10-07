package org.example;

import java.rmi.AlreadyBoundException;
import java.rmi.Remote;
import java.rmi.RemoteException;
import java.rmi.registry.Registry;
import java.rmi.registry.LocateRegistry;
import java.rmi.server.UnicastRemoteObject;

public class Server
{
    public static void main(String[] args) throws RemoteException, AlreadyBoundException
    {
        Message message = new Message();
        IMessage iMessage = (IMessage) UnicastRemoteObject.exportObject(message, 0);

        Registry registry = LocateRegistry.createRegistry(7727);

        registry.bind("Message", iMessage);

        System.out.println("Server was started");
    }
}

