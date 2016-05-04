package com.foodmap.foodmap;

/**
 * Created by guoecho on 2016/4/26.
 */
public class RestaurantTbl {

    private String name;
    private String address;
    private String postal;
    private String telephone;
    private String imageUrl;
    private String description;
    private String resKind;


    public String getName() {

        return name;
    }

    public void setName(String name) {

        this.name = name;
    }

    public String getAddress() {

        return address;
    }

    public void setAddress(String address) {

        this.address = address;
    }

    public String getImageUrl() {

        return imageUrl;
    }

    public void setImageUrl(String imageUrl) {

        this.imageUrl = imageUrl;
    }

    public String getPostal() {

        return postal;
    }

    public void setPostal(String postal) {

        this.postal = postal;
    }

    public String getTelephone() {

        return telephone;
    }

    public void setTelephone(String telephone) {

        this.telephone = telephone;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getResKind() {
        return resKind;
    }

    public void setResKind(String resKind) {
        this.resKind = resKind;
    }

    @Override
    public String toString() {
        return "RestaurantTbl{}";
    }

    public RestaurantTbl(String NAME, String telephone, String address, String imageUrl, String postal, String description, String resKind) {
        this.name = NAME;
        this.telephone = telephone;
        this.address = address;
        this.imageUrl = imageUrl;
        this.postal = postal;
        this.description = description;
        this.resKind = resKind;
    }

}
