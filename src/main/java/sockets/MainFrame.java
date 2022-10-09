package sockets;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.Scanner;

public class MainFrame extends JFrame
{
    private JPanel panel1;
    private JLabel UserName;
    private JTextField userTextField;
    private JTextArea textArea1;
    private JButton changeNameButton;
    private JTextField textField2;
    private JButton sendButton;
    Socket socket;
    Scanner in;
    PrintWriter out;
    String name = "user";

    public MainFrame(String title) throws HeadlessException, IOException
    {
        super(title);

        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setContentPane(panel1);
        this.pack();

        socket = new Socket("localhost", 7567);

        in = new Scanner(socket.getInputStream());
        out = new PrintWriter(socket.getOutputStream());

        Runnable appendTextInArea = new Runnable()
        {
            @Override
            public void run()
            {
                while (in.hasNextLine())
                    textArea1.append(in.nextLine() + "\n");
            }
        };
        Thread chat = new Thread(appendTextInArea);
        chat.start();

        sendButton.addActionListener(new ActionListener()
        {
            @Override
            public void actionPerformed(ActionEvent e)
            {
                out.println(name + ": " + textField2.getText());
                out.flush();
            }
        });

        changeNameButton.addActionListener(new ActionListener()
        {
            @Override
            public void actionPerformed(ActionEvent e)
            {
                name = userTextField.getText();
            }
        });
    }

    public static void main(String[] args) throws IOException
    {
        JFrame frame = new MainFrame("Chat");
        frame.setVisible(true);
    }
}
