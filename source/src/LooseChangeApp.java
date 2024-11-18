import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

public class LooseChangeApp {

    //1.Menu
    //2.Balance
    //3.Income
    //4.Expense
    //5.Exit loop
    //6.Debug

    //1.Menu using do-while loop to display menu and exit
    boolean loop = true;
    Scanner scanner = new Scanner(System.in);
    String key = "";
    String input = "";


    //2.Balance
    String details = "----------Balance----------";

    //3.enter income and expense detail
    double money = 0;
    double balance = 0;
    Date date = null;
    SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm");

    //4.Expense
    String note = "";

    public void mainMenu(){
        do{//do-while loop for the main menu
            System.out.println("\n==========Loose Change Menu==========");
            System.out.println("\t\t\t1 Balance");
            System.out.println("\t\t\t2 Income");
            System.out.println("\t\t\t3 Expense");
            System.out.println("\t\t\t4 Exit");

            System.out.println("Please enter 1-4:");
            key = scanner.next();

            //switch branch control;
            switch(key){
                case "1" :
                    this.details();
                    break;
                case "2" :
                    this.income();
                    break;
                case "3" :
                    this.expense();
                    break;

                case "4" :
                    this.exit();
                    break;

                default :
                    System.out.println("Please select from 1-4 ");
            }
        }while(loop);
        System.out.println("Exit Loose Change App");

    }

    public void details(){
        System.out.println(details);
    }

    public void income(){

        boolean exit = false;
        //boolean exit for exit to main menu when enter "no"
        while(!exit){
            System.out.println("please enter income: (enter \"no\" to exit)\")");
            input = scanner.next();
            if(input.equalsIgnoreCase("no")){
                break;
            }

            try{
                money = Double.parseDouble(input);
                if(money < 0){
                    System.out.println("Invalid input. Please enter a valid number.");
                }else{
                    balance += money;
                    //put the balance to details
                    date = new Date();
                    details +="\nIncome\t+" + money + "\t" + sdf.format(date) + "\t" + balance;
                }
            }catch(NumberFormatException e){
                System.out.println("Invalid input. Please enter a valid number.");
                continue;
            }
        }
    }

    public void expense(){
        //loop to continuing ask for enter expenses
        boolean exit = false;
        //boolean exit for exit to main menu when enter "no"
        if(balance == 0) {
            System.out.println("No change to expense");
        }else{
            while(!exit) {
                System.out.println("please enter expense's note: (enter \"no\" to exit)");
                note = scanner.next();
                if(note.equalsIgnoreCase("no")){
                    break;
                }
                while (true) {
                    System.out.println("please enter expense's number: (enter \"no\" to exit)");
                    input = scanner.next();

                    if(input.equalsIgnoreCase("no")){
                        exit = true;
                        break;
                    }

                    try{
                        money = Double.parseDouble(input);
                        if (money > balance) {
                            System.out.println("Out of balance, you can not make this deal");
                        } else if(money <=0) {
                            System.out.println("Invalid input. Please enter a valid number.");
                        } else {
                            balance -= money;
                            date = new Date();
                            details += "\n" + note + ":\t-" + money + "\t" + sdf.format(date) + "\t" + balance;
                        }
                    }catch(NumberFormatException e){
                        System.out.println("Invalid input. Please enter a valid number.");
                        continue;
                    }
                }
            }
        }
    }

    public void exit(){
        //5.Exit loop
        String choice = "";
        do {
            System.out.println("Do you want to exit? y/n");
            choice = scanner.next();
        } while (!"y".equalsIgnoreCase(choice) && !"n".equalsIgnoreCase(choice));
        if(choice.equalsIgnoreCase("y")){
            loop = false;

        }
    }
}
