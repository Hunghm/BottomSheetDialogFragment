package com.example.bottomsheetdialogfragment.model;

import java.io.Serializable;
import java.util.List;

public class Order implements Serializable {
    private String price;
    private List<Product> listProduct;
    private String DeliveryAddress;

    public Order(String price, List<Product> listProduct, String deliveryAddress) {
        this.price = price;
        this.listProduct = listProduct;
        DeliveryAddress = deliveryAddress;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    public List<Product> getListProduct() {
        return listProduct;
    }

    public void setListProduct(List<Product> listProduct) {
        this.listProduct = listProduct;
    }

    public String getDeliveryAddress() {
        return DeliveryAddress;
    }

    public void setDeliveryAddress(String deliveryAddress) {
        DeliveryAddress = deliveryAddress;
    }

    public String getListProductName(){
        if (listProduct == null||listProduct.isEmpty()){
            return "";
        }
        StringBuilder stringBuilder = new StringBuilder();
        for (int i = 0; i < listProduct.size(); i++) {
            Product product = listProduct.get(i);
            if (stringBuilder.length()>0){
                stringBuilder.append("\n");
            }
            stringBuilder.append(product.getName());
        }
        return stringBuilder.toString();
    }

}
