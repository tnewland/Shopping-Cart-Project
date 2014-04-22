
package javaapplication12;
import java.util.*;
import java.io.*;
import java.lang.*;

public class AccountDatabase implements java.io.Serializable {
private transient Scanner scan = new Scanner(System.in);
private Map <String,String> AccountDB= new HashMap();

public void newDatabase()
{
    //AccountDB.put("Beck", "Noir");
try 
{
        FileOutputStream fos = new FileOutputStream("AccountDatabase.ser");
        ObjectOutputStream oos = new ObjectOutputStream(fos);
        oos.writeObject(AccountDB);
        oos.close();
        System.out.println("Serialized data is saved in AccountDatabase.ser");
}
catch(IOException i)
{
          i.printStackTrace();
}
}

public void retrieveDatabase()
{
    Map anotherMap;
    try
    {
        FileInputStream fis = new FileInputStream("AccountDatabase.ser");
        ObjectInputStream ois = new ObjectInputStream(fis);
        anotherMap = (Map) ois.readObject();
        ois.close();
    }
catch(IOException i)
      {
         i.printStackTrace();
         return;
      }catch(ClassNotFoundException c)
      {
         System.out.println("Account not found");
         c.printStackTrace();
         return;
      }
    AccountDB = anotherMap;
  System.out.println(AccountDB);  
  
}

public void addAccountDBEntry(String Username, String Password)
{
    retrieveDatabase();
    AccountDB.put(Username, Password);
    newDatabase();
}

public void LogIn()
{
           String aUsername;
           String aPassword;
           System.out.println("Enter your username");
           aUsername = scan.nextLine();
           System.out.println("Enter Your Password");
           aPassword = scan.nextLine();
           retrieveDatabase();
           if(AccountDB.containsKey(aUsername))
           {
                if(aPassword.equals(AccountDB.get(aUsername)))
                {
                   Account a = new Account();
                   a.RetrieveAccount(aUsername, aPassword);
                }
                else
                {
                    System.out.println("Wrong Username or Password");
                }
           }
           else
           {
               System.out.println("Wrong Username or Password");
             }

          
}
}
