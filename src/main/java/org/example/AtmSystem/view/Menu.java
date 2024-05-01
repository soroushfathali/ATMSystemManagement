package org.example.AtmSystem.view;


import org.example.AtmSystem.controller.AccountController;
import org.example.AtmSystem.controller.AuthController;
import org.example.AtmSystem.controller.UserController;
import org.example.AtmSystem.model.dtos.UserDto;
import org.example.AtmSystem.model.entity.Role;

import java.util.Random;
import java.util.Scanner;


public class Menu {

    private static final Scanner sc = new Scanner(System.in);

    private static final UserController userController = new UserController();

    private static final AuthController authController = new AuthController();
    private static final AccountController accountController = new AccountController();

    public static void MainMenu() {
        aa:
        while (true) {
            System.out.println("""
                    hello !
                    for login type 1
                    for forgot password type 2
                    for exit type exit
                    """);
            String inp = sc.next();
            switch (inp) {
                case "1":
                    Role role = login();
                    if (role != null) {
                        switch (role) {
                            case ADMIN -> adminMenu();
                            case CUSTOMER -> customerMenu();
                        }
                    }
                    break;
                case "2":
                    forgotPass();
                    break;
                case "exit":
                    System.out.println("""
                            goodbye,
                            have nice time                                                       
                                    """);
                    break aa;
                default:
                    System.out.println("""
                            please enter correct information
                            """);
            }
        }
    }

    private static void forgotPass() {
        System.out.println("""
                input data like sample
                numberCard,password,newPass
                """);
        String[] input = sc.next().split(",");
        authController.forgotPass(input[0], input[1], input[2]);
    }

    private static Role login() {
        System.out.println("""
                input data like sample
                nationalCode,password
                """);
        String[] input = sc.next().split(",");
        return authController.login(input[0], input[1]);
    }


    private static void adminMenu() {
        aa:
        while (true) {
            System.out.println("""
                    hi 
                    for register new customer input 1
                    for update customer input 2
                    for delete customer input 3
                    for show single customer input 4
                    for showAll customer input 5
                    for exit customer input exit
                    """);
            String input = sc.next();
            switch (input) {
                case "1":
                    register();
                    break;
                case "2":
                    update();
                    break;
                case "3":
                    delete();
                    break;
                case "4":
                    showOneCustomer();
                    break;
                case "5":
                    showAllCustomers();
                    break;
                case "exit":
                    System.out.println("""
                            good bye admin!
                            """);
                    break aa;

                default:
                    System.out.println("""
                            please enter correct data!!!
                            """);
            }
        }
    }

    private static void showAllCustomers() {
        System.out.println("all customers:");
        userController.finaAll().forEach(System.out::println);
    }

    private static void showOneCustomer() {
        userController.finaAll().forEach(System.out::println);
        System.out.println("""
                -------------------------------------
                enter customer id from above list
                """);
        long id = sc.nextLong();
        UserDto userDto = userController.findById(id);
        System.out.println(userDto);
    }

    private static void delete() {
        userController.finaAll().forEach(System.out::println);
        System.out.println("""
                ---------------------------------------
                enter user id from above list 
                """);
        long id = sc.nextLong();
        userController.delete(id);
    }

    private static void update() {
        userController.finaAll().forEach(System.out::println);
        System.out.println("""
                add new data like sample for update your info
                 nationalCode,firstName,lastName,password,role,id,numberCard
                """);
        String[] input = sc.next().split(",");
        UserDto dto = new UserDto();
        dto.setNationalCode(input[0]);
        dto.setFirstName(input[1]);
        dto.setLastName(input[2]);
        dto.setPassword(input[3]);
        dto.setRole(Role.valueOf(input[4]));
        dto.setId(Long.parseLong(input[5]));
        dto.setCardNumber(input[6]);
        userController.update(dto);

    }

    private static void register() {
        System.out.println("""
                please enter your data like sample
                nationalCode,firstName,lastName,password,role,cardNumber
                """);

        String[] input = sc.next().split(",");
        input[5] = generateRandomCardNumber();
        UserDto dto = new UserDto();
        dto.setNationalCode(input[0]);
        dto.setFirstName(input[1]);
        dto.setLastName(input[2]);
        dto.setPassword(input[3]);
        dto.setRole(Role.valueOf(input[4]));
        dto.setCardNumber(input[5]);
        authController.register(dto);
    }

    private static void customerMenu() {
        aa:
        while (true) {
            System.out.println("""
                     hello :)
                     for withdraw cash input 1
                     for transfer input 2
                     for see your 10 transaction input 3
                     
                     for change your password input 5
                     
                     for see your balance input 7
                     for exit input exit
                    """);
            String input = sc.next();
            switch (input) {
                case "1":
                    System.out.println("enter your account number");
                    String accountNumber = sc.next();
                    withdraw(accountController.balance(accountNumber));
                    break;
                case "2":
                    System.out.println("enter your account number");
                    String yourAccountNumber = sc.next();
                    System.out.println("enter the destination card number");
                    String destinationCardNumber = sc.next();
                    System.out.println("please enter the amount of money that you want to transfer");
                    double amount = sc.nextDouble();
                    transfer(yourAccountNumber, destinationCardNumber, amount);
                case "3":
                    //TODO: SEE TEN LATEST TRANSACTIONS
                    System.out.println("");
                    break;
                case "5":
                    //TODO: UPDATING PASSWORD
                    updatePassword();
                    //DONE
                    break;
                case "7":
                    //TODO: SEE BALANCE
                    finalBalance();
                    //DONE
                    break;
                case "exit":
                    System.out.println("Bye Bye!");
                    break aa;
                default:
                    System.out.println("INPUT CORRECTLY! ");
                    break;
            }
        }
    }

//    private static double finalBalance() {
//        accountController.balance();
//        return accountController.balance();
//    }

    private static void finalBalance(){
        System.out.println("YOUR BALANCE IS: " + accountController.balance());
    }

    private static void updatePassword() {
        System.out.println("""
                input data like sample
                numberCard,password,newPass
                """);
        String[] input = sc.next().split(",");
        authController.forgotPass(input[0], input[1], input[2]);
    }

    private static double transfer(String yourAccountNumber, String destinationCardNumber, double amount) {
        double yourBalance = accountController.balance(yourAccountNumber);
        double yourAmount = yourBalance - amount;
        double destinationBalance = accountController.balance(destinationCardNumber);
        double destinationAmount = destinationBalance + amount;
        return yourAmount;
    }


    private static double withdraw(double balance) {
        System.out.println("please enter the amount of money that you want to withdraw");
        double withdraw = sc.nextDouble();
        balance = balance - withdraw;
        return balance;
    }

    public static String generateRandomCardNumber() {
        Random random = new Random();
        StringBuilder accountNumber = new StringBuilder();
        int firstDigit = random.nextInt(9) + 1;
        accountNumber.append(firstDigit);
        for (int i = 1; i < 16; i++) {
            int digit = random.nextInt(10);
            accountNumber.append(digit);
        }
        return accountNumber.toString();
    }
}