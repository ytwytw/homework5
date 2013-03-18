package Ex5;
import java.util.ArrayList;
import java.util.Scanner;
/**
 *
 * @author YtwYtw
 */
public class Lab5 {
        
      private static String commands;
      private static int commandInt;
      private static Account currentUser;
      private static ArrayList<Account> ABC = new ArrayList<Account>();
      
      private static int[] array = new int[10000];
      
      private static void displayOperation() {
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
      
      private static String userInput(){
        Scanner user_input = new Scanner(System.in); 
        commands = user_input.next();
//      System.out.print("This is what Test1 is :" + commands);
        return commands; 
      }
      
      private static int userInputInt(){
        Scanner user_input = new Scanner(System.in); 
        commandInt = user_input.nextInt();
//      System.out.print("This is what Test1 is :" + commands);
        return commandInt; 
      }

      private static void logout(){
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
      
      private static int searchAccount(String Name) {
            int i = 0; String temp;
            for (i=0; i<(ABC.size());i++) {
                temp = ABC.get(i).name;
                if (Name.equalsIgnoreCase(temp)) {
                    return i;
                }
            }
            System.err.println("Cannot Find Account with Name: " + Name);
            return -1;
        }
    
    public static void main(String[] args) {
        System.out.println("Welcome to ABC Bank!");
        String temp1, temp2,temp10,temp20;
        int temp3, temp4,temp30, temp40;
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
        String tmp1, tmp2, tmp3;
        int tmp10, tmp20, tmp30;
        System.out.println("Hi " + currentUser.name );
        while(true) {
            displayOperation();
            commands = userInput();
            if (commands.equalsIgnoreCase("logout")) {
                break;
            }
            if (commands.equalsIgnoreCase("createCheqOnlyCustomer")) {
                tmp1=null; tmp2=null; tmp10=-1;
                System.out.println("Enter New Customer Name: ");
                tmp1 = userInput();
                System.out.println("Enter New Password: ");
                tmp2 = userInput();
                System.out.println("Enter amount to Cheq: ");
                tmp10 = userInputInt();
                if ((tmp1 != null) && (tmp2 != null) && (tmp10 > 19)) {
                    ABC.add(new CheqOnlyCustomer(tmp1, tmp2, 1, tmp10));
                    array[searchAccount(tmp1)] = tmp10;
                    System.out.println("CheqOnlyCustomer Created");
                } else {
                    System.err.println("IllegalArgumentException");
                }
            }
            
            if (commands.equalsIgnoreCase("CreateCheqSavCustomer")) {
                tmp1=null; tmp2=null; tmp10=-1;
                System.out.println("Enter New Customer Name: ");
                tmp1 = userInput();
                System.out.println("Enter New Password: ");
                tmp2 = userInput();
                System.out.println("Enter amount to Cheq: ");
                tmp10 = userInputInt();
                System.out.println("Enter amount to Saving: ");
                tmp20 = userInputInt();
                
                if ((tmp1 != null) && (tmp2 != null) 
                        && (tmp10 > 19) && (tmp20 > 19)) {
                    ABC.add(new CheqSavCustomer(tmp1, tmp2, 2, tmp10, tmp20));
                    array[searchAccount(tmp1)] = tmp10;
                    array[searchAccount(tmp1)*10] = tmp20;
                    System.out.println("CheqSavCustomer Created");
                } else {
                    System.err.println("IllegalArgumentException");
                }
            }
            
            if (commands.equalsIgnoreCase("DeleteCustomer")) {
                tmp1 = null; tmp10 = -1;
                System.out.println("Enter New Customer Name: ");
                tmp1 = userInput();
                tmp10 = searchAccount(tmp1);
                if (tmp10 != -1) {
                    if (ABC.get(tmp10).accountType==2){
                        array[tmp10*10] = 0;
                    }
                    ABC.remove(tmp10);
                    array[tmp10] = 0;
                    
                    System.out.println("Removed! ");
                } else {
                    System.err.println("Remove Fail ");
                }
            } 
        }
    }

    private static void cheqonlyOperation() {
        String tmp1, tmp2, tmp3;
        int tmp10, tmp20, tmp30;
        System.out.println("Hi " + currentUser.name );
        while(true) {
            displayOperation();
            commands = userInput();
            if (commands.equalsIgnoreCase("logout")) {
                // TODO Save Data
                break;
            }
            if (commands.equalsIgnoreCase("DepositCheq")) {
                tmp10=0;
                System.out.println("Enter Amount: ");
                tmp10 = userInputInt();
                if (tmp10 > 0) {
                    //TODO Deposit
                    array[searchAccount(currentUser.name)] += tmp10;
                } else {
                    System.err.println("IllegalArgumentException");
                }
            }
            
            if (commands.equalsIgnoreCase("WithdrawCheq")) {
                tmp10=0;
                System.out.println("Enter Amount");
                tmp10 = userInputInt();
                if (tmp10 > 0 ) { //TODO Negative Balance Check
                    //TODO Withdraw
                    array[searchAccount(currentUser.name)] -= tmp10;
                } else {
                    System.err.println("IllegalArgumentException");
                }
            } 
            
            if (commands.equalsIgnoreCase("checkBalance")) {
                //TODO checkBalance
                System.out.println(" ");
                System.out.println("Current Balance: " + array[searchAccount(currentUser.name)]);
            }
     
        }
    }
   

    private static void cheqsavOperation() {
        String tmp1, tmp2, tmp3;
        int tmp10, tmp20, tmp30;
        System.out.println("Hi " + currentUser.name );
        while(true) {
            displayOperation();
            commands = userInput();
            if (commands.equalsIgnoreCase("logout")) {
                // TODO Save Data
                break;
            }
            if (commands.equalsIgnoreCase("Deposit2Cheq")) {
                tmp10=0;
                System.out.println("Enter Amount: ");
                tmp10 = userInputInt();
                if (tmp10 > 0) {
                    //TODO Deposit
                    array[searchAccount(currentUser.name)] += tmp10;
                } else {
                    System.err.println("IllegalArgumentException");
                }
            }
            
            if (commands.equalsIgnoreCase("WithdrawCheq")) {
                tmp10=0;
                System.out.println("Enter Amount: ");
                tmp10 = userInputInt();
                if (tmp10 > 0 ) { //TODO Negative Balance Check
                    //TODO Withdraw
                    array[searchAccount(currentUser.name)] -= tmp10;
                } else {
                    System.err.println("IllegalArgumentException");
                }
            }
            
            if (commands.equalsIgnoreCase("checkBalance")) {
                //TODO checkBalance
                System.out.println(" ");
                System.out.println("Current CheqBalance: " + array[searchAccount(currentUser.name)]);
                System.out.println("Current SavBalance: " + array[searchAccount(currentUser.name)*10]);
            }
            
             if (commands.equalsIgnoreCase("Deposit2Sav")) {
                tmp10=0;
                System.out.println("Enter Amount");
                tmp10 = userInputInt();
                if (tmp10 > 0) {
                    //TODO Deposit
                    array[searchAccount(currentUser.name)*10] += tmp10;
                } else {
                    System.err.println("IllegalArgumentException");
                }
            }
            
            if (commands.equalsIgnoreCase("WithdrawSav")) {
                tmp10=0;
                System.out.println("Enter Amount");
                tmp10 = userInputInt();
                if (tmp10 > 0 ) { //TODO Negative Balance Check
                    //TODO Withdraw
                    array[searchAccount(currentUser.name)*10] -= tmp10;
                } else {
                    System.err.println("IllegalArgumentException");
                }
            }
            
             if (commands.equalsIgnoreCase("Cheq2Sav")) {
                tmp10=0;
                System.out.println("Enter Amount");
                tmp10 = userInputInt();
                if (tmp10 > 0) {
                    //TODO Deposit
                    array[searchAccount(currentUser.name)] -= tmp10;
                    array[searchAccount(currentUser.name)*10] += tmp10;
                } else {
                    System.err.println("IllegalArgumentException");
                }
            }
            
            if (commands.equalsIgnoreCase("Sav2Cheq")) {
                tmp10=0;
                System.out.println("Enter Amount");
                tmp10 = userInputInt();
                if (tmp10 > 0 ) { //TODO Negative Balance Check
                    //TODO Withdraw
                    array[searchAccount(currentUser.name)] += tmp10;
                    array[searchAccount(currentUser.name)*10] -= tmp10;
                } else {
                    System.err.println("IllegalArgumentException");
                }
            }
     
        }
    }
    
    
    
}
