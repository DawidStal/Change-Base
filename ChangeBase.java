import java.util.Scanner;
public class ChangeBase {
    public static void main(String args[])
    {
        Scanner scan=new Scanner(System.in);
        System.out.println("Please enter base in which the number is represented");
        char baseone=scan.next().charAt(0);
        System.out.println("Please enter base to which the number should be transformed into");
        char basetwo=scan.next().charAt(0);
        System.out.println("Please enter the number");
        long num=scan.nextLong();
        scan.close();

        //for negative numbers
        boolean negative=false;
        if(num<0){
            negative=true;
            num=Math.abs(num);
        }

        String values="23456789abcdefghijklmnopqrstuvwxyz";
        int base1=values.indexOf(baseone)+2;
        //System.out.println("From Base: "+base1);

        int base2=values.indexOf(basetwo)+2;
        //System.out.println("To Base: "+base2);

        //base of numbers must be 2 or higher
        if(base1<2 || base2<2){
            System.out.println("Base value too low");
            System.exit(0);
        }
        else if(base1>32 || base2>32){
            System.out.println("Base value too high");
            System.exit(0);
        }

        //if number is 0
        if(num==0){
            System.out.println("Base "+base2+": 0");
            System.exit(0);
        }
        
        //convert base to decimal
        long decimal=0;
        int count=0;
        while(num>0)
        {
            decimal=decimal+num%10*(long)Math.pow(base1,count); // decimal=decimal + Nthdigit^(N-1)
            //System.out.println(num%10+" * "+(long)Math.pow(base1,count));
            num=num/10;
            count++;
        }
        String converted="";
        while(decimal>0)
        {

            //for numbers >= 10 to be converted to letter equivalents a, b, c etc.
            if(decimal%base2>=10){
                converted=values.charAt((int)(decimal%base2-2))+converted;
            }
            else{
                converted=decimal%base2+converted;
            }
            decimal=decimal/base2;
        }

        //add negative sign for negative numbers
        if(negative==true){
            converted="-"+converted;
        }

        System.out.println("Number in base "+base2+": "+converted);
    }    
}
