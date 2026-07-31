import java.util.Scanner;
class CinemaShow{
    private String tital;
    private int seatAvailable;
    private final int capacity;
    private static int totalBook=0;

     CinemaShow(String tital,int capacity){
        this.tital=tital;
        this.capacity=capacity;
        seatAvailable=capacity;
    }
    CinemaShow(String tital){
        this(tital,100);
    }
    boolean book(int n){
           if(n<=seatAvailable){
            seatAvailable-=n;
            totalBook+=n;
            return true;
           }
           else{
            return false;
           }
    }
    void cancle(int n){
         seatAvailable+=n;
        if(capacity<seatAvailable)
        seatAvailable=capacity;
          
           
    }
    int getSeatAvailable(){
        return seatAvailable;
    }
    static int getTotalBook(){
        return totalBook;
    }

};
class prac2_2{
    public static void main(String []arg){
        Scanner sc=new Scanner(System.in);
        System.out.println("Enter The Tital Of CinemaShow");
        String tital=sc.nextLine();
         System.out.println("Enter The Capacity Of CinemaShow");
        int capacity=sc.nextInt();
       CinemaShow c= new CinemaShow(tital,capacity);
        
        while(true){
            System.out.println("Type For :"+"\n"+"1.Book Ticket "+"\n"+"2.Cancle Ticket"+"\n"+"3.Get Available Ticket"+"\n"+"4.Total Booked"+"\n"+"5.Exists");
        int a=sc.nextInt();
               switch(a){
            case 1:
                System.out.println("Enter Howmany Ticket You Want To Book");
                int n=sc.nextInt();
                if(c.book(n)){
                    System.out.println(true);
                     System.out.println("Your Ticket Booked Successfully");
                }
                else{
                     System.out.println(false);
                     System.out.println("Booking Failed");
                }
                 System.out.println("Available Tickets : "+c.getSeatAvailable());
                 break;

            case 2:
                 System.out.println("Enter Howmany Ticket You Want To Cancle");
                int b=sc.nextInt();
                c.cancle(b);
                     System.out.println("Your Ticket Cancle Successfully");
                
                 System.out.println("Available Tickets : "+c.getSeatAvailable());
                 break;
            case 3:
                 System.out.println("Available Tickets : "+c.getSeatAvailable());
                 break;
            case 4:
                 System.out.println("Total Booked : "+CinemaShow.getTotalBook());
                 break;
            case 5:
                 System.out.println("Exists . ThankYou ");
                 return; 
            default:
                 System.out.println("Invaid Choise");

        }

        }
       
    }
}