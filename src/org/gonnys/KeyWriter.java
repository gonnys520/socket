package org.gonnys;

import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.OutputStream;

public class KeyWriter {

    //bad code
    public static void main(String[] args)throws Exception {
        InputStream in = System.in;
        OutputStream out = new FileOutputStream("C:\\zzz\\test.txt");

        System.out.println("가나다라마바사아자차카타파하");
        for(int i = 0; i < 100; i++){
            int data = in.read();
            System.out.println(data);
            out.write(data);
        }

    }
}
