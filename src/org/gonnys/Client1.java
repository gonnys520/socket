package org.gonnys;

import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.Socket;

public class Client1 {

    public static void main(String[] args) throws Exception {

        Socket socket = new Socket("10.10.10.93", 9705);
        System.out.println(socket);

        InputStream in = socket.getInputStream();
        OutputStream out = new FileOutputStream("C:\\zzz\\샘플사진.jpg");

        byte[] buffer = new byte[1024 * 8]; //1000배 더 빠르게 하는 코드, 1024*8은 General한 size.
        //buffer는 데이터를 임시적으로 저장하는 장치
        //권장되는 바가지의 사이즈는 8KB이다.
        //long start = System.currentTimeMillis(); //시간 체크

        //read - write 작업을 해준다
        //read는 1byte를 빨아들인다.

        while (true) {
            int count = in.read(buffer); //내부적으로 int로 값을 계산해주게끔 설계되어있기 때문.(buffer는 바가지, 빨대는 힘듬)
            //read();->1byte를 읽는다, read(byte[]); -> count를 의미, read(buffer) -> 5byte씩 읽는다.
            System.out.println("COUNT" + count);
            if (count == -1) {
                break;
            }// 끝까지 갔다는 뜻
            // out.write(buffer, 0, count);
            out.write(buffer, 0, count);
        }
        //long end = System.currentTimeMillis();


        in.close();
        out.close();

        socket.close(); //빨대를 뽑아줘야한다.
    }
}
