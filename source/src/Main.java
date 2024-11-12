import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

public class Main {


    //1.Menu
    //2.Balance
    //3.Income
    //4.Expense
    //5.Debug

    public static void main(String[] args) {

        //1.Menu using do-while loop to display menu and exit
        boolean loop = true;
        Scanner scanner = new Scanner(System.in);
        String key = "";

        //2.Balance
        String details = "----------Balance----------";

        //3.enter income and expense detail
        double money = 0;
        double balance = 0;
        Date date = null;
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm");

        //4.Expense
        String name = "";


        do{
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
                    System.out.println(details);
                    break;
                case "2" :
                    System.out.println("please enter income:");
                    money = scanner.nextDouble();
                    //money verify

                    balance += money;
                    //put the balance to details
                    date = new Date();
                    details +="\nIncome\t" + money + "\t" + sdf.format(date) + "\t" + balance;

                    break;
                case "3" :
                    System.out.println("lease enter expense's name:");
                    name = scanner.next();
                    System.out.println("lease enter expense's number:");
                    money = scanner.nextDouble();
                    if (money <= balance){
                        balance -= money;
                        date = new Date();
                        details +="\n" + name + ":\t" + money + "\t" + sdf.format(date) + "\t" + balance;
                    }else{
                        System.out.println("Out of balance, you can not make this deal");
                        System.out.println("lease enter expense's number:");
                        money = scanner.nextDouble();
                    }
                    break;
                case "4" :
                    System.out.println("4 Exit");
                    loop = false;
                    break;
                default :
                    System.out.println("Please select from 1-4 ");
            }



        }while(loop);

        System.out.println("Exit Loose Change App");
    }
}