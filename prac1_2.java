
import java.util.Scanner;
record Vehical(String number,String type){}
class prac1_2{
    public static void main(String[] args) {
        int tollTotal=0;
        int bike=0;
        int car=0;
        int truck=0; 
        int i=0;
        Scanner sc=new Scanner(System.in);
         Vehical []v=new Vehical[100];
        while(true){
                System.out.println("Enter Vehical Number And Type And Enter Done to Exists");
                String number=sc.next();
               
                if(number.equalsIgnoreCase("done"))
                break;

                 String type=sc.next();
                
                    
                     v[i]=new Vehical(number,type);
           int toll=switch(v[i].type()){
            case "bike"->{
                bike++;
                yield 20;
                
            }
            case "car"->{
                car++;
                yield 50;
                
            }
            case "truck"->{
                truck++;
                yield 150;
                
            }
            default->0;

 };
             tollTotal+=toll;
 i++;
        }
        System.out.println("Total Toll : "+ tollTotal);
        if(bike>car&&bike>truck)
        System.out.println("Most frequent : Bike");
         if(bike<car&&car>truck)
        System.out.println("Most frequent : Car");
         if(truck>car&&bike<truck)
        System.out.println("Most frequent : Truck");
       
    }
}
