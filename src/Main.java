import Models.House;
import Utils.BuySellTransactionUtil;
import Utils.HouseUtil;

import java.util.List;

public class Main {
    public static void main(String[] args) {
        List<House> houseList = HouseUtil.getHouseList();
        BuySellTransactionUtil.startTransaction(houseList);
    }
}