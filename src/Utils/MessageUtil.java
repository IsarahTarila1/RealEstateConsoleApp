package Utils;

public class MessageUtil {
    public static void messageToUser(String welcome){
        System.out.println(welcome);
    }
    public static void giveUserFeedback(String selectedHouseName, int housePrice, boolean isListing){
        String transactionType = isListing ? "Listed" : "Purchased";
        System.out.println("You just " + transactionType + " "+ selectedHouseName + " at NGN " + housePrice);
    }
}