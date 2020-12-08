package step3;

import java.util.Scanner;

public class Step3 {
    private static String[][] left(Integer num, String[][] arr) {
        String temp1 = arr[num][0];
        String temp2 = arr[num][1];
        String temp3 = arr[num][2];
        for (int i=3; i<12; i++) {
            arr[num][i-3] = arr[num][i];
        }
        arr[num][9] =temp1;
        arr[num][10] =temp2;
        arr[num][11] = temp3;
        return arr;
    }
    private static String[][] right(Integer num, String[][] arr) {
        String temp1 = arr[num][9];
        String temp2 = arr[num][10];
        String temp3 = arr[num][11];

        for (int i=11; i>2; i--) {
            arr[num][i] =arr[num][i-3];
        }
        arr[num][0] = temp1;
        arr[num][1] = temp2;
        arr[num][2] = temp3;
        return arr;
    }
    private static String[][] up(Integer num1, Integer num2, String[][] arr) {
        String temp1 = arr[0][num1];
        String temp2 = arr[1][num1];
        String temp3 = arr[2][num1];
        String temp4 = arr[3][num2];
        String temp5 = arr[4][num2];
        String temp6 = arr[5][num2];
        for (int i=3; i<9; i++) {
            arr[i-3][num1] = arr[i][num1];
        }
        arr[3][num2] = temp3;
        arr[4][num2] = temp2;
        arr[5][num2] = temp1;
        arr[6][num1] = temp6;
        arr[7][num1] = temp5;
        arr[8][num1] = temp4;
        return arr;
    }

    public static String[][] rightRotate(Integer num1, Integer num2,String[][] arr) {
        String[][] B = new String[3][3];
        for(int i=0; i<3; i++){
            for(int j=0; j<3; j++){
                B[i][j] = arr[num2+3-j-1][num1+i];
            }
        }
        for (int i = 0; i<3; i++){
            for(int j=0; j<3; j++){
                arr[num2+i][num1+j]=B[i][j];
            }
        }
        for (String[] i : B) {
            for (String j : i) {
                System.out.printf("%s\t", j);
            }
            System.out.println();
        }
        System.out.println();
        return arr;
    }
    public static String[][] leftRotate(Integer num1, Integer num2,String[][] arr) {
        String[][] B = new String[3][3];
        for(int i=0; i<3; i++){
            for(int j=0; j<3; j++){
                B[i][j] = arr[num1+j][num2+3-i-1];
            }
        }
        for (int i = 0; i<3; i++){
            for(int j=0; j<3; j++){
                arr[num1+i][num2+j]=B[i][j];
            }
        }
//        for (String[] i : B) {
//            for (String j : i) {
//                System.out.printf("%s\t", j);
//            }
//            System.out.println();
//        }
//        System.out.println();
        return arr;
    }
    public static void main(String[] args) {
        String[][] cube = {
                {" "," "," ","B", "B", "B1"},
                {" "," "," ","B", "B", "B2"},
                {" "," "," ","B", "B", "B3"},
                {"W1", "W", "W", "O", "O", "O1", "G1", "G", "G", "Y1", "Y", "Y"},
                {"W", "W", "W", "O", "O", "O", "G", "G", "G", "Y2", "Y", "Y"},
                {"W", "W", "W", "O", "O", "O", "G", "G", "G", "Y3", "Y", "Y"},
                {" "," "," ","R", "R", "R1"},
                {" "," "," ","R", "R", "R"},
                {" "," "," ","R", "R", "R"}
        };
        for (String[] i : cube) {
            for (String j : i) {
                System.out.printf("%s\t", j);
            }
            System.out.println();
        }
        System.out.println();

        while (true) {
            Scanner sc = new Scanner(System.in);
            System.out.print("CUBE> ");
            String command = sc.nextLine();
            if (command.equals("Q")) {
                System.out.println("Bye~");
                return;
            }
            if (command.equals("U")) {
                left(3,cube);
                rightRotate(3,0,cube);
            }
            if (command.equals("U'")){
                right(3,cube);
                leftRotate(0,3,cube);
            }
            if (command.equals("D'")) {
                left(5,cube);
                leftRotate(6,3,cube);

            }
            if (command.equals("D")){
                right(5,cube);
                rightRotate(3,6,cube);
            }
            if (command.equals("R")) {
                up(5,9,cube);
                rightRotate(6,3,cube);
            }
            if (command.equals("L'")) {
                up(3,11,cube);
                leftRotate(3,0,cube);
            }



            for (String[] i : cube) {
                for (String j : i) {
                    System.out.printf("%s\t", j);
                }
                System.out.println();
            }
            System.out.println();
        }


        /*
         String temp = arr[num][0];
        for (int i=1; i<3; i++) {
            arr[num][i-1] =arr[num][i];
        }
        arr[num][2] = temp;
         */
    }

}
