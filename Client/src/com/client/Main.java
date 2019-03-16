package com.client;

import java.io.IOException;
import java.util.Scanner;
import java.net.Socket;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.io.BufferedReader;


public class Main {

	public static void main(String[] args) {
		
		 System.out.println("Entering into try block ");
		try(Socket socket = new Socket("localhost",5000)){
			BufferedReader echoes = new BufferedReader(
					new InputStreamReader(socket.getInputStream()));
			PrintWriter stringToEcho = new PrintWriter(socket.getOutputStream(), true);

            Scanner scanner = new Scanner(System.in);
            String echoString;
            String response;

            do {
                System.out.println("Enter string to be echoed: ");
                echoString = scanner.nextLine();

                stringToEcho.println(echoString);
                if(!echoString.equals("exit")) {
                    response = echoes.readLine();
                    System.out.println(response);
                }
            } while(!echoString.equals("exit"));

        } catch (IOException e) {
            System.out.println("Client Error: " + e.getMessage());

        }
    }
}
