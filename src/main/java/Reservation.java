import java.util.Scanner;

public class Reservation {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);

        while (true) {
            System.out.println("Enter choice");
            int choice = sc.nextInt();

            switch (choice) {
                case 1:
                    System.out.println("Enter source , destination and ticket count");
                    char start = sc.next().charAt(0);
                    char end = sc.next().charAt(0);
                    int ticket = sc.nextInt();
                    if(ticket>Booker.totalTicket)
                    {
                        System.out.println("No Ticket available");
                    }
                    else {
                        Booker.bookTicket(start, end, ticket);
                    }
                    System.out.println("Total Ticket " +Booker.totalTicket);
                    break;
                case 2:
                    System.out.println("enter id to cancel");
                    int id=sc.nextInt();
                    if(!(Booker.idToTicketCount.containsKey(id))){
                    System.out.println("Invalid id");
                    return;
                }
                    Booker.cancelTicket(id);
                    System.out.println("Total Ticket " +Booker.totalTicket);
                    break;
                case 3:
                    Booker.displayTicket();
                    System.out.println("Displaying details");
                     break;

                default:
                    System.out.println("Thank you");
            }
        }
    }
}
