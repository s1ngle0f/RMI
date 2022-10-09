package tests;

import java.util.Scanner;

public class Main
{
    public static void main(String[] args)
    {
        Runnable runnable = new Runnable()
        {
            @Override
            public void run()
            {
                try
                {
                    while (true)
                    {
                        System.out.println("Message");
                        Thread.sleep(500);
                    }
                } catch (InterruptedException e)
                {
                    throw new RuntimeException(e);
                }
            }
        };
        Thread thread = new Thread(runnable);
        thread.start();

        Scanner scanner = new Scanner(System.in);

        while (true)
        {
            System.out.print("Enter something: ");
            System.out.println(scanner.nextLine());
            if(!scanner.hasNextLine())
                break;
        }

        scanner.close();
    }
}
