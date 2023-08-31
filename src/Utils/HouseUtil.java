package Utils;

import Models.House;

import java.util.ArrayList;
import java.util.List;

public class HouseUtil {
    public static List<House> getHouseList() {
        List<House> houses = new ArrayList<>();
        houses.add(new House(1,"one bedroom",200000,1 ));
        houses.add(new House(2,"Two bedroom",400000,1));
        houses.add(new House(3,"Three bedroom", 500000,1));
        return houses;
    }
    public static House getSingleHouse(List<House> houseList, int houseId){
        House singleHouse;
        singleHouse = houseList.get(houseId);
        return singleHouse;
    }

    public static void displayHouses(List<House> houseList){
        for (House chosenHouse : houseList) {
            System.out.println(chosenHouse.getHouseId() + ". " + chosenHouse.getHouseName() +
                    " (" + chosenHouse.getHousePrice() + "N) "+"Number of years payment would last = "+ chosenHouse.getExpirationDateForPayment());
        }
    }
}
