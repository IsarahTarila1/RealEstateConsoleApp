package Utils;

import Models.House;

import java.util.List;
import java.util.Scanner;

import static Utils.HouseUtil.displayHouses;
import static Utils.HouseUtil.getHouseList;

public class BuySellTransactionUtil {
    public static void buyHouse(){
        List<House> houses=getHouseList();
        MessageUtil.messageToUser("Welcome to Isarah's real estate enterprise\n");

        Scanner takeInput = new Scanner(System.in);
        MessageUtil.messageToUser("Input N to go to the next page");
        String nextPage = takeInput.nextLine().toUpperCase();
        if (nextPage.equals("N"));
        MessageUtil.messageToUser("These are the house available\nPlease choose a house by the index number");
        displayHouses(getHouseList());
        int index = takeInput.nextInt();
        checkAndPrintElementAtIndex(houses,index);
        userPayment(houses, index);

    }
    public static void userPayment(List<House> houseList, int index){
        Scanner takeInput = new Scanner(System.in);
        // Check the index and call the printElementAtIndex function
        MessageUtil.messageToUser("Would you like to proceed to payment? YES/NO");
        String userPaymentChoice = takeInput.nextLine();
        if (userPaymentChoice.equalsIgnoreCase("yes")){
            MessageUtil.messageToUser("You have successfully purchased ");
            checkAndPrintElementAtIndex(houseList, index);
        }else if (userPaymentChoice.equalsIgnoreCase("no")){
            MessageUtil.messageToUser("Thank you, please come again");
        }else {
            userPayment(houseList, index);
        }
    }

    // Function to check the index and print the element
    public static void checkAndPrintElementAtIndex(List<House> houseList, int index) {
        if (index >= 0 && index < houseList.size()) {
            House chosenHouse = houseList.get(index);
            printHouse(chosenHouse, index);
        } else {
            System.out.println("Invalid index. Index should be between 0 and " + (houseList.size() - 1));
        }
    }

    // Function to print a house
    public static void printHouse(House house, int index) {
        System.out.println( index + ": " + house.getHouseName() +
                " (" + house.getHousePrice() + "N) " + "Number of years payment would last = " + house.getExpirationDateForPayment());
    }
    public static void sellHouse(List<House> houseList) {
        Scanner takeInput = new Scanner(System.in);
        // Get house details from the user
        System.out.print("Enter the name of the house: ");
        String houseName = takeInput.nextLine();
        System.out.print("Enter the price of the house: ");
        int housePrice = takeInput.nextInt();
        System.out.print("Enter the expiration date for payment (in years): ");
        int expirationDate = takeInput.nextInt();

        // Generate a unique ID for the new house
        int houseId = houseList.size();

        // Create the new house and add it to the list
        House houses = new House(houseId+1, houseName, housePrice, expirationDate);
        houseList.add(houses);
        House currentHouse = HouseUtil.getSingleHouse(houseList, houseId);
        MessageUtil.giveUserFeedback(currentHouse.getHouseName(), currentHouse.getHousePrice(), true);
        for (House house : houseList) {
            System.out.println(house.getHouseName());
            System.out.println("House added successfully!");
        }
    }
    private static void checkNextDecision(List<House> houseList) {
        Scanner takeDecision = new Scanner(System.in);
        MessageUtil.messageToUser("Want to perform another transaction? [Y/N]");
        boolean isNotLastTransaction = takeDecision.next().equalsIgnoreCase("Y");
        boolean isLastTransaction = takeDecision.next().equalsIgnoreCase("N");
        if (isNotLastTransaction){
            MessageUtil.messageToUser("Choose B-Buy or S-Sell");
            boolean isBuying = takeDecision.next().equalsIgnoreCase("B");
            if (isBuying){
                buyHouse();
            }else {
                sellHouse(houseList);
            }
        }else if (isLastTransaction){
            MessageUtil.messageToUser("Thank you for your business! See you later!");
        }
    }
    public static void startTransaction(List<House>houseList){
        Scanner selectUserType = new Scanner(System.in);
        String userType;

        MessageUtil.messageToUser("Are you a seller or Buyer [B-Buyer/S-Seller]");
        userType = selectUserType.nextLine().toUpperCase();

        if (!userType.equals("")){
            if (userType.equals("B")){
                buyHouse();
            } else if (userType.equals("S")) {
                sellHouse(houseList);
                BuySellTransactionUtil.checkNextDecision(houseList);
            }else {
                MessageUtil.messageToUser("Wrong Input, please select one option above");
                startTransaction(houseList);
            }
        }else {
            MessageUtil.messageToUser("Cannot have empty string. Exiting...");
        }
    }
}

