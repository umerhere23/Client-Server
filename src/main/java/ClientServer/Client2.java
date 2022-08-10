/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package ClientServer;

/**
 *
 * @author HP
 */


import java.io.*;
import java.net.*;

class Client2 {

    public static void main(String args[])
            throws Exception {

        Socket s = new Socket("localhost", 888);

        DataOutputStream dos
                = new DataOutputStream(
                        s.getOutputStream());

        BufferedReader br
                = new BufferedReader(
                        new InputStreamReader(
                                s.getInputStream()));

        BufferedReader kb
                = new BufferedReader(
                        new InputStreamReader(System.in));
        String str, str1;
        System.out.println("This Is Client Side \n Send Message");
        while (!(str = kb.readLine()).equals("exit")) {

            dos.writeBytes(str + "\n");

            str1 = br.readLine();

            System.out.println("Server  : "+str1);
        }

        dos.close();
        br.close();
        kb.close();
        s.close();
    }
}
