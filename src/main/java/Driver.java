import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.Scanner;


public class Driver {
    private static final Logger logger = LogManager.getLogger(Driver.class.getName());
    public static void main(String[] args) {
        Scanner scan  = new Scanner(System.in);

        while(true){
            printOption();
            try{
                int option = scan.nextInt();
                if(option==1){
                    System.out.println("Enter Number:");
                    try{
                        float num = scan.nextFloat();
                        float ans = findsquareRoot(num);
                        System.out.println("SquareRoot of "+num+" is "+ans);
                        logger.info("SquareRoot input= "+num+" output= "+ans);
                    }
                    catch (Exception ex){
                        System.out.println("Exception occured: "+ex.toString());
                        logger.error("exception Invalid input");

                    }
                }
                else if(option==2){
                    System.out.println("Enter Number:");
                    try{
                        int num = scan.nextInt();
                        double ans = findfactorial(num);
                        System.out.println("factoial of "+ num +" is "+ ans );
                        logger.info("Factorial input= "+num+" output= "+ans);
                    }
                    catch (Exception ex){
                        System.out.println("Exception occured: "+ex.toString());
                        logger.error("exception Invalid input");
                    }
                }
                else if(option==3){
                    System.out.println("Enter Number:");
                    try {
                        float num = scan.nextFloat();
                        double ans = findlog(num);
                        System.out.println("Log of "+ num +" is "+ ans );
                        logger.info("Logarithm input= "+num+" output= "+ans);
                    }
                    catch (Exception ex){
                        System.out.println("Exception occured: "+ex.toString());
                        logger.error("exception Invalid input");
                    }
                }
                else if(option==4){
                    System.out.println("Enter 2 Numbers:");
                    try {
                        float a = scan.nextInt();
                        float b = scan.nextInt();
                        double ans = findpower(a,b);
                        System.out.println(a+" raise to "+ b +" is "+ ans );
                        logger.info("Power input= "+a+","+b+" output= "+ans);
                    }
                    catch (Exception ex){
                        System.out.println("Exception occured: "+ex.toString());
                        logger.error("exception Invalid input");
                    }
                }
                else if(option==5){
                    logger.info("exit status=0");
                    break;
                }
                else{
                    logger.error("Invalid_Option invalid option chosen");
                    throw new Exception();
                }
            }
            catch (Exception ex){
                logger.error("exception  Invalid option");
                System.out.println("Exception occured: "+ex.toString());
            }
            scan.nextLine();
        }

    }

    public static void printOption(){
        System.out.println("Enter the appropriate option");
        System.out.println("1: SquareRoot");
        System.out.println("2: Factorial");
        System.out.println("3: log");
        System.out.println("4: power");
        System.out.println("5: Exit");
    }

    public static float findsquareRoot(float x){
        return (float) Math.sqrt(x);
    }
    public static double findfactorial(int x){
        double ans=1;
        for(int i=1;i<=x;i++)
            ans=ans*i;
        return ans;
    }
    public static double findlog(float x){
        return Math.log1p(x);
    }
    public static double findpower(float a, float b){
        return Math.pow(a,b);
    }
}
