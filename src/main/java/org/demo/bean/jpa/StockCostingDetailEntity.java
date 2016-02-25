/*
 * Created on 24 �ub 2016 ( Time 16:18:05 )
 * Generated by Telosys Tools Generator ( version 2.1.1 )
 */
// This Bean has a basic Primary Key (not composite) 

package org.demo.bean.jpa;

import java.io.Serializable;

//import javax.validation.constraints.* ;
//import org.hibernate.validator.constraints.* ;

import java.util.Date;

import javax.persistence.*;

/**
 * Persistent class for entity stored in table "stock_costing_detail"
 *
 * @author Telosys Tools Generator
 *
 */

@Entity
@Table(name="stock_costing_detail", catalog="seyhan" )
// Define named queries here
@NamedQueries ( {
  @NamedQuery ( name="StockCostingDetailEntity.countAll", query="SELECT COUNT(x) FROM StockCostingDetailEntity x" )
} )
public class StockCostingDetailEntity implements Serializable {

    private static final long serialVersionUID = 1L;

    //----------------------------------------------------------------------
    // ENTITY PRIMARY KEY ( BASED ON A SINGLE FIELD )
    //----------------------------------------------------------------------
    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    @Column(name="id", nullable=false)
    private Integer    id           ;


    //----------------------------------------------------------------------
    // ENTITY DATA FIELDS 
    //----------------------------------------------------------------------    
    @Temporal(TemporalType.DATE)
    @Column(name="sell_date", nullable=false)
    private Date       sellDate     ;

    @Column(name="sell_quantity")
    private Double     sellQuantity ;

    @Column(name="sell_cost_price")
    private Double     sellCostPrice ;

    @Column(name="sell_cost_amount")
    private Double     sellCostAmount ;

    @Column(name="buy_cost_price")
    private Double     buyCostPrice ;

    @Column(name="buy_cost_amount")
    private Double     buyCostAmount ;

    @Column(name="profit_loss_amount")
    private Double     profitLossAmount ;

    @Column(name="trans_year")
    private Integer    transYear    ;

    @Column(name="trans_month", length=7)
    private String     transMonth   ;

	// "costingId" (column "costing_id") is not defined by itself because used as FK in a link 
	// "stockId" (column "stock_id") is not defined by itself because used as FK in a link 


    //----------------------------------------------------------------------
    // ENTITY LINKS ( RELATIONSHIP )
    //----------------------------------------------------------------------
    @ManyToOne
    @JoinColumn(name="stock_id", referencedColumnName="id")
    private StockEntity stock       ;

    @ManyToOne
    @JoinColumn(name="costing_id", referencedColumnName="id")
    private StockCostingEntity stockCosting;


    //----------------------------------------------------------------------
    // CONSTRUCTOR(S)
    //----------------------------------------------------------------------
    public StockCostingDetailEntity() {
		super();
    }
    
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
    //--- DATABASE MAPPING : sell_date ( DATE ) 
    public void setSellDate( Date sellDate ) {
        this.sellDate = sellDate;
    }
    public Date getSellDate() {
        return this.sellDate;
    }

    //--- DATABASE MAPPING : sell_quantity ( DOUBLE ) 
    public void setSellQuantity( Double sellQuantity ) {
        this.sellQuantity = sellQuantity;
    }
    public Double getSellQuantity() {
        return this.sellQuantity;
    }

    //--- DATABASE MAPPING : sell_cost_price ( DOUBLE ) 
    public void setSellCostPrice( Double sellCostPrice ) {
        this.sellCostPrice = sellCostPrice;
    }
    public Double getSellCostPrice() {
        return this.sellCostPrice;
    }

    //--- DATABASE MAPPING : sell_cost_amount ( DOUBLE ) 
    public void setSellCostAmount( Double sellCostAmount ) {
        this.sellCostAmount = sellCostAmount;
    }
    public Double getSellCostAmount() {
        return this.sellCostAmount;
    }

    //--- DATABASE MAPPING : buy_cost_price ( DOUBLE ) 
    public void setBuyCostPrice( Double buyCostPrice ) {
        this.buyCostPrice = buyCostPrice;
    }
    public Double getBuyCostPrice() {
        return this.buyCostPrice;
    }

    //--- DATABASE MAPPING : buy_cost_amount ( DOUBLE ) 
    public void setBuyCostAmount( Double buyCostAmount ) {
        this.buyCostAmount = buyCostAmount;
    }
    public Double getBuyCostAmount() {
        return this.buyCostAmount;
    }

    //--- DATABASE MAPPING : profit_loss_amount ( DOUBLE ) 
    public void setProfitLossAmount( Double profitLossAmount ) {
        this.profitLossAmount = profitLossAmount;
    }
    public Double getProfitLossAmount() {
        return this.profitLossAmount;
    }

    //--- DATABASE MAPPING : trans_year ( INT ) 
    public void setTransYear( Integer transYear ) {
        this.transYear = transYear;
    }
    public Integer getTransYear() {
        return this.transYear;
    }

    //--- DATABASE MAPPING : trans_month ( VARCHAR ) 
    public void setTransMonth( String transMonth ) {
        this.transMonth = transMonth;
    }
    public String getTransMonth() {
        return this.transMonth;
    }


    //----------------------------------------------------------------------
    // GETTERS & SETTERS FOR LINKS
    //----------------------------------------------------------------------
    public void setStock( StockEntity stock ) {
        this.stock = stock;
    }
    public StockEntity getStock() {
        return this.stock;
    }

    public void setStockCosting( StockCostingEntity stockCosting ) {
        this.stockCosting = stockCosting;
    }
    public StockCostingEntity getStockCosting() {
        return this.stockCosting;
    }


    //----------------------------------------------------------------------
    // toString METHOD
    //----------------------------------------------------------------------
    public String toString() { 
        StringBuffer sb = new StringBuffer(); 
        sb.append("["); 
        sb.append(id);
        sb.append("]:"); 
        sb.append(sellDate);
        sb.append("|");
        sb.append(sellQuantity);
        sb.append("|");
        sb.append(sellCostPrice);
        sb.append("|");
        sb.append(sellCostAmount);
        sb.append("|");
        sb.append(buyCostPrice);
        sb.append("|");
        sb.append(buyCostAmount);
        sb.append("|");
        sb.append(profitLossAmount);
        sb.append("|");
        sb.append(transYear);
        sb.append("|");
        sb.append(transMonth);
        return sb.toString(); 
    } 

}