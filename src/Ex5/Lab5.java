package Ex5;
import java.util.ArrayList;
import java.util.Scanner;
/**
 *
 * @author YtwYtw
 */
public class Lab5 {
        
      public static String commands;
      public static Account currentUser;
      static ArrayList<Account> ABC = new ArrayList<Account>();
      
      public static void displayOperation() {
          System.out.println(" ");
          System.out.println("You have the following operations");
          if (currentUser.accountType == 0) {
              System.out.println("CreateCheqOnlyCustomer");
              System.out.println("CreateCheqSavCustomer");
              System.out.println("DeleteCustomer");
          }
          
          if (currentUser.accountType == 1) {
              System.out.println("DepositCheq");
              System.out.println("WithdrawCheq");
              System.out.println("CheckBalance");
          }
          
          if (currentUser.accountType == 2) {
              System.out.println("Deposit2Cheq");
              System.out.println("Deposit2Sav");
              System.out.println("Cheq2Sav");
              System.out.println("WithdrawCheq");
              System.out.println("WithdrawSav");
              System.out.println("Sav2Cheq");
              System.out.println("CheckBalance");
          }
          System.out.println(" ");
          System.out.print("Enter Command: ");
          
      }
      
      public static String userInput(){
        Scanner user_input = new Scanner(System.in); 
        commands = user_input.next();
//      System.out.print("This is what Test1 is :" + commands);
        return commands; 
      }

      public static void logout(){
          System.out.println("Bye " + currentUser.name);
          currentUser = null;
      }
      
    private static boolean LoginAuth(String temp1, String temp2) {
        int i = searchAccount(temp1);
        if (i != -1) {
            if (temp2.equalsIgnoreCase(ABC.get(i).password)){
                return true;
            }
        }
        return false;
    }
      
      public static int searchAccount(String Name) {
            int i = 0; String temp;
            for (i=0; i<(ABC.size());i++) {
                temp = ABC.get(i).name;
                if (Name.equalsIgnoreCase(temp)) {
                    return i;
                }
            }
            System.err.println("Cannot Find Account with Name" + Name);
            return -1;
        }
    
    public static void main(String[] args) {
        System.out.println("Welcome to ABC Bank!");
        String temp1, temp2;
        int temp3, temp4;
        ABC.add(new Manager("admin", "admin", 0));
        
        while (true) {
            System.out.println("Enter Username to log in :");
            temp1 = userInput();
            System.out.println("Enter Password :");      
            temp2 = userInput();
            if(LoginAuth(temp1, temp2)) {
                currentUser = ABC.get(searchAccount(temp1));
                if (currentUser.accountType == 0) {
                    managerOperation();
                }
                
                if (currentUser.accountType == 1) {
                    cheqonlyOperation();
                }
                
                if (currentUser.accountType == 2) {
                    cheqsavOperation();
                }
            }
            
        
        
        }
    }

    private static void managerOperation() {
        System.out.println("Hi " + currentUser.name );
        while(true) {
            displayOperation();
            
        }
    }

    private static void cheqonlyOperation() {
        throw new UnsupportedOperationException("Not yet implemented");
    }

    private static void cheqsavOperation() {
        throw new UnsupportedOperationException("Not yet implemented");
    }
    
    
    
}
