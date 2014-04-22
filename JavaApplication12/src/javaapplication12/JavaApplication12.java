package javaapplication12;
import java.io.*;
import java.util.*;

public class JavaApplication12 {
private static Scanner scan = new Scanner(System.in);
private static int option;
private static String option2;
private static boolean Escape = false;
    public static void main(String[] args) {
     while (Escape== false)
     {
     UserOption();
     }

    }
    private static void UserOption()
    {
     System.out.println("Press the number of the option you want to perform");
     System.out.println("1. New account");
     System.out.println("2. Login");
     System.out.println("3. Exit");
     option2 = scan.nextLine();
     option = Integer.parseInt(option2);
        if(option == 1)
        {
            Account a = new Account();
            a.NewAccount();
        }
        else if(option == 2)
        {
           AccountDatabase a = new AccountDatabase();
           a.LogIn();
        }
        else if(option == 3)
        {
            Escape = true;
            System.out.println("Goodbye");
        }
        else if(option == 99)
        {
           AccountDatabase a = new AccountDatabase();
           a.newDatabase();
           a.retrieveDatabase();
        }
        else
        {
           System.out.println(" Invalid option"); 
        }
    }
}
