import java.util.HashMap;

public class Booker {
    private final int ticket;
    private final char end;
    private final char start;
    static int  totalTicket = 8;
    static int[] arr = new int[5];
    static int id = 1;
    static HashMap<Integer, Integer> idToTicketCount = new HashMap<>();

    static {
        for (int i = 0; i < arr.length; i++) {
            arr[i] = 8; // Initialize all elements of arr to 8
        }
    }

    public Booker(char start, char end, int ticket) {
        this.start = start;
        this.end = end;
        this.ticket = ticket;
    }

    public static void bookTicket(char start, char end, int ticket) {
        int first = start - 'a';
        int last = end - 'a';
        totalTicket-=ticket;
        if (arr[first] >= ticket && arr[last] >= ticket) {
            for (int i = 0; i < ticket; i++) {
                arr[first]--;
                arr[last]--;
            }
            idToTicketCount.put(id++, ticket);

            System.out.println("Your ticket is booked");
        } else {
            System.out.println("No ticket is available");
        }
    }



    public static void displayTicket() {
        for(int id:idToTicketCount.keySet())
        {
            System.out.print("id " +id + "->");
            System.out.print("ticketCount " +idToTicketCount.get(id));
            System.out.println(" ");
        }
    }
    public static void cancelTicket(int id) {
        int ticket = idToTicketCount.get(id);
        idToTicketCount.remove(id);
        totalTicket += ticket;
        System.out.println("Ticket with ID " + id + " is cancelled");
    }

}
