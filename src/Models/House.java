package Models;

public class House {
    int houseId;
    String houseName;
    int housePrice, expirationDateForPayment;
    public House(int houseId, String houseName,  int housePrice, int expirationDateForPayment) {
        this.houseId = houseId;
        this.houseName = houseName;
        this.housePrice = housePrice;
        this.expirationDateForPayment = expirationDateForPayment;
    }
    public int getHouseId() {
        return houseId;
    }
    public void setHouseId(int houseId) {
        this.houseId = houseId;
    }
    public String getHouseName() {
        return houseName;
    }

    public void setHouseName(String houseName) {
        this.houseName = houseName;
    }
    public int getHousePrice() {
        return housePrice;
    }

    public void setHousePrice(int housePrice) {
        this.housePrice = housePrice;
    }
    public void setExpirationDateForPayment(int expirationDateForPayment){
        this.expirationDateForPayment=expirationDateForPayment;
    }
    public int getExpirationDateForPayment(){
        return expirationDateForPayment;
    }
}
