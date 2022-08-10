/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package ClientServer;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;
import java.util.Scanner;

/**
 *
 * @author HP
 */
public class ClientSide {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws IOException {
        System.out.println(" Number Guessing Game. \nChoose number between 1 to 15  ");
        Scanner keyboard = new Scanner(System.in);
        int attempt = 0;
        try {
            attempt = keyboard.nextInt();
            if (attempt < 1 || attempt > 9) {
                System.out.println("Your number is not correct, please make a guess between 1 to 15");
                attempt = keyboard.nextInt();
            }
        } catch (NumberFormatException nfe) {
            System.out.println("  numbers Please! Try again");
            attempt = keyboard.nextInt();
        }

        try {
            Socket server = new Socket("localhost", 1234);
            System.out.println("Connecting...");

            DataOutputStream out = new DataOutputStream(new BufferedOutputStream(server.getOutputStream()));
            DataInputStream in = new DataInputStream(new BufferedInputStream(server.getInputStream()));

            out.writeInt(attempt);
            out.flush();
            System.out.println("Server is Running");
            String result = in.readUTF();
            boolean correct = in.readBoolean();
            System.out.println(result);
            while (!correct) {
                attempt = keyboard.nextInt();
                out.writeInt(attempt);
                out.flush();
                System.out.println("Server is Running");
                result = in.readUTF();
                System.out.println(result);
                correct = in.readBoolean();
            }

            server.close();
            keyboard.close();
            System.out.println("Finish. Thank you");
            System.exit(0);

        } catch (IOException ioe) {
            System.err.println(ioe);
        }
    }
}
