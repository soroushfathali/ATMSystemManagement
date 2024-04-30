import java.util.Random;
import java.util.Scanner;

public class Testing {
    public static Scanner sc = new Scanner(System.in);
    public static void balance(){
        System.out.println("enter money to your balance");
        double balance = sc.nextDouble();
        double changedBalance = balance + 0;
//        double currentBalacne = b
        aa:
        while (true){
            System.out.println("1 for see balance\n" +
                    "2 for deposit into balance\n" +
                    "3 for withdraw balance\n" +
                    "4 exit");
            int input = sc.nextInt();
            switch (input){
                case 1:
                    System.out.println(balance);
                    break;
                case 2:
                    System.out.print("enter your deposit: ");
                    double deposit = sc.nextDouble();
                    changedBalance = balance + deposit;
                    System.out.println("Current Balance: " + changedBalance);
                    break;
                case 3:
                    System.out.print("enter your withdraw: ");
                    double withdraw = sc.nextDouble();
                    double withdrawBalance = changedBalance - withdraw;
                    System.out.println("current Balance: " + withdrawBalance);
                    break ;
                case 4:
                    System.out.println("Exiting");
                    break aa;
                default:
                    System.out.println("enter correctly");
                    break;
            }
        }
    }
    public static void Card(){
        Random rand = new Random();
        long min = 1000000000000000l;
        long max = 10000000000000000l;
        long cardnum = rand.nextLong(((max-min)+min)+1);
        System.out.println(min);
        System.out.println(max);
        System.out.println(cardnum);
    }
}
