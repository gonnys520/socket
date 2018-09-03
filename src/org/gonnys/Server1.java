package org.gonnys;

import java.io.FileInputStream;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;

public class Server1 {

    //bad cord
    public static void main(String[] args) throws Exception {

        NameFinder finder = new NameFinder();

        //문을 만들어서 열어주는 작업
        ServerSocket serverSocket = new ServerSocket(7777);
        System.out.println(serverSocket);


        while (true) {
            try {
                //손님 받는 작업
                Socket client = serverSocket.accept();
                System.out.println(client); //브라우저에 "localhost:포트번호" 입력해야함.

                //파일을 보내는 작업
                OutputStream out = client.getOutputStream();
                String fileName = finder.getName();
                System.out.println("FILENAME: " + fileName);

                InputStream fin = new FileInputStream("C:\\zzz\\img\\" + fileName); //파일을 읽어들여야 하기 때문

                byte[] buffer = new byte[1024 * 8];

                while (true) {
                    int count = fin.read(buffer);
                    if (count == -1) {
                        break;
                    }
                    out.write(buffer, 0, count);
                }
                fin.close();
                out.close();
            } catch (Exception e) {
                System.out.println(e.getMessage());
            }
        }

    }
}

