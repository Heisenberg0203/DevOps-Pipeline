import java.util.Scanner;

public class Driver {
    public static void main(String[] args) {
        Scanner scan  = new Scanner(System.in);
        while(true){
            printOption();
            try{
                int option = scan.nextInt();
                if(option==1){
                    System.out.println("Enter Number:");
                    float num = scan.nextFloat();
                    float ans = findsquareRoot(num);
                    System.out.println("SquareRoot of "+num+" is "+ans);
                }
                if(option==2){
                    System.out.println("Enter Number:");
                    int num = scan.nextInt();
                    double ans = findfactorial(num);
                    System.out.println("factoial of "+ num +" is "+ ans );
                }
                if(option==3){
                    System.out.println("Enter Number:");
                    float num = scan.nextFloat();
                    double ans = findlog(num);
                    System.out.println("Log of "+ num +" is "+ ans );
                }
                if(option==4){
                    System.out.println("Enter 2 Numbers:");
                    float a = scan.nextInt();
                    float b = scan.nextInt();
                    double ans = findpower(a,b);
                    System.out.println(a+" raise to "+ b +" is "+ ans );
                }
                else if(option==5){
                    break;
                }
                else{
                    throw new Exception();
                }
            }
            catch (Exception ex){
                System.out.println("Exception occured: "+ex.toString());
            }
        }

    }

    public static void printOption(){
        System.out.println("Enter the appropriate option");
        System.out.println("1: SquareRoot");
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
