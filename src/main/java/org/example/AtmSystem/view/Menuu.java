package org.example.AtmSystem.view;

import org.example.AtmSystem.controller.UserController;

import java.util.Scanner;

public class Menuu {
    private static final Scanner sc = new Scanner(System.in);
    private static final UserController usercontroller = new UserController();

    public static void MainMeu(){
        aa:
        while (true){
            int input = sc.nextInt();
            switch (input){
                case 1:
                    break;
                case 2:
                    break;
                case 3:
                    System.out.println("exit");
                    break aa;
                default:
                    break;
            }
        }
    }
}
