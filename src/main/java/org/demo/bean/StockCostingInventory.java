/*
 * Created on 24 �ub 2016 ( Time 15:56:51 )
 * Generated by Telosys Tools Generator ( version 2.1.1 )
 */
package org.demo.bean;

import java.io.Serializable;

import javax.validation.constraints.*;

import java.util.Date;

public class StockCostingInventory implements Serializable {

    private static final long serialVersionUID = 1L;

    //----------------------------------------------------------------------
    // ENTITY PRIMARY KEY ( BASED ON A SINGLE FIELD )
    //----------------------------------------------------------------------
    @NotNull
    private Integer id;

    //----------------------------------------------------------------------
    // ENTITY DATA FIELDS 
    //----------------------------------------------------------------------    

    private Date date;


    private Double input;


    private Double remain;


    private Double price;


    private Double amount;


    private Integer costingId;


    private Integer stockId;


    private Integer depotId;



    //----------------------------------------------------------------------
    // GETTER & SETTER FOR THE KEY FIELD
    //----------------------------------------------------------------------
    public void setId( Integer id ) {
        this.id = id ;
    }

    public Integer getId() {
        return this.id;
    }


    //----------------------------------------------------------------------
    // GETTERS & SETTERS FOR FIELDS
    //----------------------------------------------------------------------
    public void setDate( Date date ) {
        this.date = date;
    }
    public Date getDate() {
        return this.date;
    }

    public void setInput( Double input ) {
        this.input = input;
    }
    public Double getInput() {
        return this.input;
    }

    public void setRemain( Double remain ) {
        this.remain = remain;
    }
    public Double getRemain() {
        return this.remain;
    }

    public void setPrice( Double price ) {
        this.price = price;
    }
    public Double getPrice() {
        return this.price;
    }

    public void setAmount( Double amount ) {
        this.amount = amount;
    }
    public Double getAmount() {
        return this.amount;
    }

    public void setCostingId( Integer costingId ) {
        this.costingId = costingId;
    }
    public Integer getCostingId() {
        return this.costingId;
    }

    public void setStockId( Integer stockId ) {
        this.stockId = stockId;
    }
    public Integer getStockId() {
        return this.stockId;
    }

    public void setDepotId( Integer depotId ) {
        this.depotId = depotId;
    }
    public Integer getDepotId() {
        return this.depotId;
    }


    //----------------------------------------------------------------------
    // toString METHOD
    //----------------------------------------------------------------------
 
        public String toString() { 
        StringBuffer sb = new StringBuffer(); 
        sb.append(id);
        sb.append("|");
        sb.append(date);
        sb.append("|");
        sb.append(input);
        sb.append("|");
        sb.append(remain);
        sb.append("|");
        sb.append(price);
        sb.append("|");
        sb.append(amount);
        sb.append("|");
        sb.append(costingId);
        sb.append("|");
        sb.append(stockId);
        sb.append("|");
        sb.append(depotId);
        return sb.toString(); 
    } 


}
