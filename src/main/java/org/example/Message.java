package org.example;

import java.rmi.RemoteException;

public class Message implements IMessage
{
    @Override
    public String Ping() throws RemoteException
    {
        System.out.println("Ping from client");
        return "Pong";
    }

    @Override
    public String GetSolve(double a, double b, double c) throws RemoteException
    {
        double d = b * b - 4 * a * c;
        if (d > 0) {
            double x1 = (-b - Math.sqrt(d)) / (2 * a);
            double x2 = (-b + Math.sqrt(d)) / (2 * a);
            return ("Корни уравнения: x1 = " + x1 + ", x2 = " + x2);
        } else if (d == 0) {
            double x;
            x = -b / (2 * a);
            return ("Уравнение имеет единственный корень: x = " + x);
        } else {
            return ("Уравнение не имеет действительных корней");
        }
    }
}
