package org.example;

import java.rmi.Remote;
import java.rmi.RemoteException;

public interface IMessage extends Remote
{
    String Ping() throws RemoteException;
    String GetSolve(double a, double b, double c) throws RemoteException;
}
