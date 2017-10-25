package g.y.v.anew.Models;

/**
 * Created by galqayeva on 25.10.2017.
 */

public class Category {

    private String clothesText,cosmeticsText,entertainText,medicineText,restauranText,birthdayText,marketText,transportText;
    private String jewelleryText,otherText;
    private int clothesM,cosmeticsM,entertainM,medicineM,restauranM,birthdayM,marketTextM,transportTextM;
    private int jewelleryM,otherM;
    private int startDate;

    public Category(String birthdayText, String otherText) {
        this.birthdayText = birthdayText;
        this.otherText = otherText;
    }

    public int getStartDate() {
        return startDate;
    }

    public void setStartDate(int startDate) {
        this.startDate = startDate;
    }


    public String getClothesText() {
        return clothesText;
    }

    public void setClothesText(String clothesText) {
        this.clothesText = clothesText;
    }

    public String getCosmeticsText() {
        return cosmeticsText;
    }

    public void setCosmeticsText(String cosmeticsText) {
        this.cosmeticsText = cosmeticsText;
    }

    public String getEntertainText() {
        return entertainText;
    }

    public void setEntertainText(String entertainText) {
        this.entertainText = entertainText;
    }

    public String getMedicineText() {
        return medicineText;
    }

    public void setMedicineText(String medicineText) {
        this.medicineText = medicineText;
    }

    public String getRestauranText() {
        return restauranText;
    }

    public void setRestauranText(String restauranText) {
        this.restauranText = restauranText;
    }

    public String getBirthdayText() {
        return birthdayText;
    }

    public void setBirthdayText(String birthdayText) {
        this.birthdayText = birthdayText;
    }

    public String getMarketText() {
        return marketText;
    }

    public void setMarketText(String marketText) {
        this.marketText = marketText;
    }

    public String getTransportText() {
        return transportText;
    }

    public void setTransportText(String transportText) {
        this.transportText = transportText;
    }

    public String getJewelleryText() {
        return jewelleryText;
    }

    public void setJewelleryText(String jewelleryText) {
        this.jewelleryText = jewelleryText;
    }

    public String getOtherText() {
        return otherText;
    }

    public void setOtherText(String otherText) {
        this.otherText = otherText;
    }

    public int getClothesM() {
        return clothesM;
    }

    public void setClothesM(int clothesM) {
        this.clothesM = clothesM;
    }

    public int getCosmeticsM() {
        return cosmeticsM;
    }

    public void setCosmeticsM(int cosmeticsM) {
        this.cosmeticsM = cosmeticsM;
    }

    public int getEntertainM() {
        return entertainM;
    }

    public void setEntertainM(int entertainM) {
        this.entertainM = entertainM;
    }

    public int getMedicineM() {
        return medicineM;
    }

    public void setMedicineM(int medicineM) {
        this.medicineM = medicineM;
    }

    public int getRestauranM() {
        return restauranM;
    }

    public void setRestauranM(int restauranM) {
        this.restauranM = restauranM;
    }

    public int getBirthdayM() {
        return birthdayM;
    }

    public void setBirthdayM(int birthdayM) {
        this.birthdayM = birthdayM;
    }

    public int getMarketTextM() {
        return marketTextM;
    }

    public void setMarketTextM(int marketTextM) {
        this.marketTextM = marketTextM;
    }

    public int getTransportTextM() {
        return transportTextM;
    }

    public void setTransportTextM(int transportTextM) {
        this.transportTextM = transportTextM;
    }



    public int getJewelleryM() {
        return jewelleryM;
    }

    public void setJewelleryM(int jewelleryM) {
        this.jewelleryM = jewelleryM;
    }

    public int getOtherM() {
        return otherM;
    }

    public void setOtherM(int otherM) {
        this.otherM = otherM;
    }
}
