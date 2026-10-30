package tryouts.socket_programming;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintStream;
import java.net.ServerSocket;
import java.net.Socket;

public class ChatServer {
    public static void main(String[] args)  {
        try {
            ServerSocket ssobj = new ServerSocket(5100);
            System.out.println("Server is running at port 5100");
            Socket sobj = ssobj.accept();
            System.out.println("Client request gets accepted successfully");

            PrintStream pobj = new PrintStream(sobj.getOutputStream());
            BufferedReader bobj1 = new BufferedReader(new InputStreamReader(sobj.getInputStream()));
            BufferedReader bobj2 = new BufferedReader(new InputStreamReader(System.in));

            System.out.println("Marvellous server is running");
            String str1 = null, str2 = null;

            while ((str1 = bobj1.readLine()) != null) {
                System.out.println("Client says : " + str1);
                System.out.println("Enter message for client : ");
                str2 = bobj2.readLine();
                pobj.println(str2);
            }
            pobj.close();
            bobj1.close();
            bobj2.close();
            sobj.close();
            ssobj.close();
        } catch (Exception e) {
            System.out.println(e);
        }
    }
}