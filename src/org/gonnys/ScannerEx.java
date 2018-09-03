package org.gonnys;

import java.util.Scanner;

public class ScannerEx {

    public static void main(String [] args) {

        Scanner scanner = new Scanner(System.in); //System.in은 inputStream

        System.out.println("숫자 입력 받기 ");

        int value = scanner.nextInt();
        scanner.nextLine(); // 이걸 써줘야 다음 String이 동작된다.

        System.out.println(value);
        System.out.println("문자 입력 받기 ");

        String str = scanner.nextLine(); //nextLine은 줄바꿈 데이터?

        System.out.println("-------------------------");
        System.out.println("STR: " + str);

    }
}
