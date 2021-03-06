

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class bankAccount {
   private String firstName;
   private String surname;
   private double balance;
   private double interestRate;
    Scanner sc;
    ArrayList<transaction> transactionList;

    

public bankAccount(String firstName, String surname, double balance){
    this.firstName = firstName;
    this.surname = surname;
    this.balance = balance;
    interestRate = 0.05;
    transactionList = new ArrayList<transaction>();
}
    
public void setFirstName (String firstName){
    this.firstName = firstName;
}
public String getFirstName (){
    return firstName;
}
public void setSurname (String surname){
    this.surname = surname;
}
public String getSurname(){
    return surname;
}
public void setBalance (double balance){
    this.balance = balance;
}
public double getBalance(){
    return balance;
}
public void setInterestRate (double interestrate){
    this.interestRate = interestrate;
}
public double getInterestRate (){
    return interestRate;
}

public void showMenu(){
    while(true){
        System.out.println("============================================= \nWhat service would you like to use today? \n Enter D for deposit \n Enter 'w' for withdrawals \n Enter 'C' to check balance \n Enter 'I' to check accrued interest \n Enter 'P' to check last 5 transactions \n Enter 'Q' to quit\n============================================= ");
        
        Scanner sc = new Scanner(System.in);
        char input = sc.next().charAt(0);
        
        switch(input){
            case 'D':
            case 'd':
                System.out.println("Enter amount you wish to deposit:");
                double depositAmount = sc.nextDouble();
                deposit(depositAmount);
                break;
            case 'W':
            case 'w':
                System.out.println("Enter amount you wish to withdraw:");
                double withdrawAmount = sc.nextDouble();
                withdraw(withdrawAmount);
                break;
            case 'C':
            case 'c':
                checkBalance();
                break;
            case 'I':
            case 'i':
                System.out.println("Enter amount of years to calculate interest for:");
                double interestYear = sc.nextDouble();
                interestCalc(interestYear);
                break;
            case 'P':
            case 'p':
                prevTransaction(); 
            case 'Q':
            case 'q':
            sc.close();
                System.exit(0);
                break;
            default:
                System.out.println("Unavailable selection, Please try again...");
            
        }
    }
}
public void deposit(double depositAmount){
    if(depositAmount>0){
    transaction deposit = new transaction("deposit", depositAmount);
    transactionList.add(deposit);
    balance += depositAmount;
    System.out.println("Your funds have been deposited, current balance is: "+ getBalance());
    }
}

public void withdraw(double withdrawAmount){
    if ((balance - withdrawAmount) > 0){
    transaction withdraw = new transaction("withdraw", withdrawAmount);
    transactionList.add(withdraw);
    balance -= getBalance();
    System.out.println("Your funds have been withdrawn, current balance is: "+ getBalance());
    }
}
public void interestCalc(double interestYear){
    if (interestYear > 0 && balance > 0){
        System.out.println("Your total balance with "+interestYear+" years of interest at a rate of "+interestRate+" would be: "+ (balance + Math.pow((balance*interestRate), interestYear)));
    }
}
public void checkBalance(){
    System.out.println("Your current account balance is: "+getBalance());
}
public void prevTransaction(){
    if (transactionList.size()<=5){
    for(transaction element:transactionList){
        System.out.println(element);
    }
}
    else {
        List<transaction> last5List = transactionList.subList(transactionList.size()-6, transactionList.size());
        for(transaction tr:last5List){
            System.out.println(tr);
        }
    }
}
}
