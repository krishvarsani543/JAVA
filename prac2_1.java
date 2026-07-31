import java.util.Scanner;
class thermostate{
    private String location;
    private int temp;
    private static final int MIN=16;
    private static final int MAX=30;
    private static int activeCount=0;

    thermostate(String location,int startTemp){
           this.location=location;
           if(startTemp<=30&&startTemp>=16){
            temp=startTemp;
           }
           else{
            temp=22;
           }
           activeCount++;
    }
    thermostate(String location){
        this(location,22);
    }
    void rais(){
        if(temp<MAX){
            temp++;
        }
        else{
            System.out.println("Already at maximum (30)");
        }
    }
    void lower(){
        if(temp>MIN){
            temp--;
        }
        else{
            System.out.println("Already at minimum (16)");
        }
    }
        void display() {
        System.out.println(location);
    }
    int getTemprature(){
        return temp;
    }
    static int getActiveCount(){
        return activeCount;
    }
};
class prac2_1{
    public static void main(String []arg){
        Scanner sc=new Scanner(System.in);
        System.out.println("Enter Location ");
        String location=sc.nextLine();
         System.out.println("Enter Temprature ");
        int temp=sc.nextInt();
        thermostate t=new thermostate(location,temp);
        thermostate t1=new thermostate(location,temp);
        for(int i=0;i<10;i++){
            t1.rais();
            System.out.println("Temprature : "+t1.getTemprature());
        }
        for(int i=0;i<20;i++){
            t1.lower();
            System.out.println("Temprature : "+t1.getTemprature());
        }

        System.out.println("Active Count : "+thermostate.getActiveCount());

    }
}