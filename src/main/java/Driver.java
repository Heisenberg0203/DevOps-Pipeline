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
                    SquareRoot sqrt = new SquareRoot();
                    float ans = sqrt.findsquareRoot(num);
                    System.out.println("SquareRoot of "+num+" is "+ans);
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
                System.exit(1);
            }
        }

    }

    public static void printOption(){
        System.out.println("Enter the appropriate option");
        System.out.println("1: SquareRoot");
        System.out.println("5: Exit");
    }
}
