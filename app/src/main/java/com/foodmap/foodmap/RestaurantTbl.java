package com.foodmap.foodmap;

/**
 * Created by guoecho on 2016/4/26.
 */
public class RestaurantTbl {

    private String NAME;
    private String TELEPHONE;
    private String ADDRESS;
    private String imageUrl;
    private String POSTAL;

    public String getNAME() {
        return NAME;
    }

    public void setNAME(String NAME) {
        this.NAME = NAME;
    }

    public String getADDRESS() {
        return ADDRESS;
    }

    public void setADDRESS(String ADDRESS) {
        this.ADDRESS = ADDRESS;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }

    public String getPOSTAL() {
        return POSTAL;
    }

    public void setPOSTAL(String POSTAL) {
        this.POSTAL = POSTAL;
    }

    public String getTELEPHONE() {
        return TELEPHONE;
    }

    public void setTELEPHONE(String TELEPHONE) {
        this.TELEPHONE = TELEPHONE;
    }


    @Override
    public String toString() {
        return "RestaurantTbl{}";
    }

    public RestaurantTbl(String NAME, String TELEPHONE, String ADDRESS, String imageUrl, String POSTAL) {
        this.NAME = NAME;
        this.TELEPHONE = TELEPHONE;
        this.ADDRESS = ADDRESS;
        this.imageUrl = imageUrl;
        this.POSTAL = POSTAL;
    }

}
