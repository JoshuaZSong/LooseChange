import java.util.Scanner;

public class Main {


    //1.Menu
    public static void main(String[] args) {

        boolean loop = true;
        Scanner scanner = new Scanner(System.in);
        String key = "";
        do{
            System.out.println("==========Loose Change Menu==========");
            System.out.println("\t\t\t1 Balance");
            System.out.println("\t\t\t2 Profit ");
            System.out.println("\t\t\t3 Expense");
            System.out.println("\t\t\t4 Exit");

            System.out.println("Please enter 1-4:");
            key = scanner.next();

            //switch branch control;
            switch(key){
                case "1" :
                    System.out.println("1 Balance");
                    break;
                case "2" :
                    System.out.println("2 Profit");
                    break;
                case "3" :
                    System.out.println("3 Expense");
                    break;
                case "4" :
                    System.out.println("4 Exit");
                    loop = false;
                    break;
                default :
                    System.out.println("Please select from 1-4 ");
            }



        }while(loop);

        System.out.println("Exit Loose Change");
    }
}