package javaapplication12;

import java.util.*;
import java.io.*;
public class Account implements java.io.Serializable
{
    private transient Scanner scan = new Scanner(System.in);
    private String Username;
    private String Password;
    private int UID;
    private boolean IsSeller;
    private String Name;
    private String BillingAddress;
    
    public void NewAccount()
    {
          Account e = new Account();
          AccountDatabase a = new AccountDatabase();
          
          
        System.out.println("Enter your username");
        e.Username = scan.nextLine();
        System.out.println("Enter Your Password");
        e.Password = scan.nextLine();
        System.out.println("Enter your full name. Press enter when you are finished");
        e.Name = scan.nextLine();
        System.out.println("Enter your full address. Press enter when you are finished");
        e.BillingAddress = scan.nextLine();
        e.UID = 1;
        e.IsSeller = true;
      try
      {
         
         FileOutputStream fileOut =
         new FileOutputStream("accounts/" + e.Username +".ser");
         ObjectOutputStream out = new ObjectOutputStream(fileOut);
         out.writeObject(e);
         out.close();
         fileOut.close();
         System.out.println("Serialized data is saved in /accounts/" + e.Username +".ser");
      }catch(IOException i)
      {
          i.printStackTrace();
      }
      a.addAccountDBEntry(e.Username, e.Password);
   }
   
   public void RetrieveAccount(String aUsername, String aPassword)
   {
           Account e;          
      try
      {
         FileInputStream fileIn = new FileInputStream("accounts/" + aUsername +".ser");
         ObjectInputStream in = new ObjectInputStream(fileIn);
         e = (Account) in.readObject();
         in.close();
         fileIn.close();
      }catch(IOException i)
      {
         i.printStackTrace();
         return;
      }catch(ClassNotFoundException c)
      {
         System.out.println("Account not found");
         c.printStackTrace();
         return;
      }
      System.out.println("Deserialized Employee...");
      System.out.println("Username: " + e.Username);
      System.out.println("Password: " + e.Password);
      System.out.println("UID: " + e.UID);
      System.out.println("Is Seller: " + e.IsSeller);
      System.out.println("Name: " + e.Name);
      System.out.println("Billing Address: " + e.BillingAddress);
      
    }  
   }


