package com.ymm.ShiroCacheSessionDemo.Domain;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.io.Serializable;

/**
 * Created by James on 7/31/2017.
 */
@Entity
public class ItemObject implements Serializable{
    private static final long serialVersionUID = -3928153147951640081L;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long itemId;

    private String itemName;

    private double itemPrice;

    public Long getItemId() {
        return itemId;
    }

    public void setItemId(Long itemId) {
        this.itemId = itemId;
    }

    public String getItemName() {
        return itemName;
    }

    public void setItemName(String itemName) {
        this.itemName = itemName;
    }

    public double getItemPrice() {
        return itemPrice;
    }

    public void setItemPrice(double itemPrice) {
        this.itemPrice = itemPrice;
    }

    @Override
    public String toString(){
        return String.format("ItemObject[orderId = %s, orderName = %s, price = %s]", itemId, itemName, itemPrice);
    }
}
