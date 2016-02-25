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
 * Persistent class for entity stored in table "stock_trans_detail"
 *
 * @author Telosys Tools Generator
 *
 */

@Entity
@Table(name="stock_trans_detail", catalog="seyhan" )
// Define named queries here
@NamedQueries ( {
  @NamedQuery ( name="StockTransDetailEntity.countAll", query="SELECT COUNT(x) FROM StockTransDetailEntity x" )
} )
public class StockTransDetailEntity implements Serializable {

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
    @Column(name="receipt_no", nullable=false)
    private Integer    receiptNo    ;

    @Column(name="_right", nullable=false, length=50)
    private String     right        ;

    @Temporal(TemporalType.DATE)
    @Column(name="trans_date", nullable=false)
    private Date       transDate    ;

    @Temporal(TemporalType.DATE)
    @Column(name="delivery_date")
    private Date       deliveryDate ;

    @Column(name="trans_type", nullable=false, length=6)
    private String     transType    ;

    @Column(name="row_no")
    private Integer    rowNo        ;

    @Column(name="name", length=100)
    private String     name         ;

    @Column(name="quantity")
    private Double     quantity     ;

    @Column(name="unit", length=6)
    private String     unit         ;

    @Column(name="unit_ratio")
    private Double     unitRatio    ;

    @Column(name="base_price")
    private Double     basePrice    ;

    @Column(name="price")
    private Double     price        ;

    @Column(name="tax_rate")
    private Double     taxRate      ;

    @Column(name="tax_rate2")
    private Double     taxRate2     ;

    @Column(name="tax_rate3")
    private Double     taxRate3     ;

    @Column(name="discount_rate1")
    private Double     discountRate1 ;

    @Column(name="discount_rate2")
    private Double     discountRate2 ;

    @Column(name="discount_rate3")
    private Double     discountRate3 ;

    @Column(name="amount")
    private Double     amount       ;

    @Column(name="tax_amount")
    private Double     taxAmount    ;

    @Column(name="discount_amount")
    private Double     discountAmount ;

    @Column(name="total")
    private Double     total        ;

    @Column(name="description", length=100)
    private String     description  ;

    @Column(name="trans_year")
    private Integer    transYear    ;

    @Column(name="trans_month", length=7)
    private String     transMonth   ;

    @Column(name="unit1", length=6)
    private String     unit1        ;

    @Column(name="unit2", length=6)
    private String     unit2        ;

    @Column(name="unit3", length=6)
    private String     unit3        ;

    @Column(name="unit2ratio")
    private Double     unit2ratio   ;

    @Column(name="unit3ratio")
    private Double     unit3ratio   ;

    @Column(name="exc_code", length=3)
    private String     excCode      ;

    @Column(name="exc_rate")
    private Double     excRate      ;

    @Column(name="exc_equivalent")
    private Double     excEquivalent ;

    @Column(name="plus_factor_amount")
    private Double     plusFactorAmount ;

    @Column(name="minus_factor_amount")
    private Double     minusFactorAmount ;

    @Column(name="serial_no", length=100)
    private String     serialNo     ;

    @Column(name="input")
    private Double     input        ;

    @Column(name="output")
    private Double     output       ;

    @Column(name="in_total")
    private Double     inTotal      ;

    @Column(name="out_total")
    private Double     outTotal     ;

    @Column(name="is_return")
    private Boolean    isReturn     ;

    @Column(name="ret_input")
    private Double     retInput     ;

    @Column(name="ret_output")
    private Double     retOutput    ;

    @Column(name="ret_in_total")
    private Double     retInTotal   ;

    @Column(name="ret_out_total")
    private Double     retOutTotal  ;

    @Column(name="net_input")
    private Double     netInput     ;

    @Column(name="net_output")
    private Double     netOutput    ;

    @Column(name="net_in_total")
    private Double     netInTotal   ;

    @Column(name="net_out_total")
    private Double     netOutTotal  ;

    @Column(name="has_cost_effect")
    private Boolean    hasCostEffect ;

    @Column(name="workspace", nullable=false)
    private Integer    workspace    ;

	// "stockId" (column "stock_id") is not defined by itself because used as FK in a link 
	// "transId" (column "trans_id") is not defined by itself because used as FK in a link 
	// "depotId" (column "depot_id") is not defined by itself because used as FK in a link 
	// "contactId" (column "contact_id") is not defined by itself because used as FK in a link 
	// "sellerId" (column "seller_id") is not defined by itself because used as FK in a link 
	// "transSourceId" (column "trans_source_id") is not defined by itself because used as FK in a link 
	// "transPointId" (column "trans_point_id") is not defined by itself because used as FK in a link 
	// "privateCodeId" (column "private_code_id") is not defined by itself because used as FK in a link 


    //----------------------------------------------------------------------
    // ENTITY LINKS ( RELATIONSHIP )
    //----------------------------------------------------------------------
    @ManyToOne
    @JoinColumn(name="trans_id", referencedColumnName="id")
    private StockTransEntity stockTrans  ;

    @ManyToOne
    @JoinColumn(name="trans_source_id", referencedColumnName="id")
    private StockTransSourceEntity stockTransSource;

    @ManyToOne
    @JoinColumn(name="depot_id", referencedColumnName="id")
    private StockDepotEntity stockDepot  ;

    @ManyToOne
    @JoinColumn(name="private_code_id", referencedColumnName="id")
    private GlobalPrivateCodeEntity globalPrivateCode;

    @ManyToOne
    @JoinColumn(name="seller_id", referencedColumnName="id")
    private SaleSellerEntity saleSeller  ;

    @ManyToOne
    @JoinColumn(name="stock_id", referencedColumnName="id")
    private StockEntity stock       ;

    @ManyToOne
    @JoinColumn(name="trans_point_id", referencedColumnName="id")
    private GlobalTransPointEntity globalTransPoint;

    @ManyToOne
    @JoinColumn(name="contact_id", referencedColumnName="id")
    private ContactEntity contact     ;


    //----------------------------------------------------------------------
    // CONSTRUCTOR(S)
    //----------------------------------------------------------------------
    public StockTransDetailEntity() {
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
    //--- DATABASE MAPPING : receipt_no ( INT ) 
    public void setReceiptNo( Integer receiptNo ) {
        this.receiptNo = receiptNo;
    }
    public Integer getReceiptNo() {
        return this.receiptNo;
    }

    //--- DATABASE MAPPING : _right ( VARCHAR ) 
    public void setRight( String right ) {
        this.right = right;
    }
    public String getRight() {
        return this.right;
    }

    //--- DATABASE MAPPING : trans_date ( DATE ) 
    public void setTransDate( Date transDate ) {
        this.transDate = transDate;
    }
    public Date getTransDate() {
        return this.transDate;
    }

    //--- DATABASE MAPPING : delivery_date ( DATE ) 
    public void setDeliveryDate( Date deliveryDate ) {
        this.deliveryDate = deliveryDate;
    }
    public Date getDeliveryDate() {
        return this.deliveryDate;
    }

    //--- DATABASE MAPPING : trans_type ( VARCHAR ) 
    public void setTransType( String transType ) {
        this.transType = transType;
    }
    public String getTransType() {
        return this.transType;
    }

    //--- DATABASE MAPPING : row_no ( INT ) 
    public void setRowNo( Integer rowNo ) {
        this.rowNo = rowNo;
    }
    public Integer getRowNo() {
        return this.rowNo;
    }

    //--- DATABASE MAPPING : name ( VARCHAR ) 
    public void setName( String name ) {
        this.name = name;
    }
    public String getName() {
        return this.name;
    }

    //--- DATABASE MAPPING : quantity ( DOUBLE ) 
    public void setQuantity( Double quantity ) {
        this.quantity = quantity;
    }
    public Double getQuantity() {
        return this.quantity;
    }

    //--- DATABASE MAPPING : unit ( VARCHAR ) 
    public void setUnit( String unit ) {
        this.unit = unit;
    }
    public String getUnit() {
        return this.unit;
    }

    //--- DATABASE MAPPING : unit_ratio ( DOUBLE ) 
    public void setUnitRatio( Double unitRatio ) {
        this.unitRatio = unitRatio;
    }
    public Double getUnitRatio() {
        return this.unitRatio;
    }

    //--- DATABASE MAPPING : base_price ( DOUBLE ) 
    public void setBasePrice( Double basePrice ) {
        this.basePrice = basePrice;
    }
    public Double getBasePrice() {
        return this.basePrice;
    }

    //--- DATABASE MAPPING : price ( DOUBLE ) 
    public void setPrice( Double price ) {
        this.price = price;
    }
    public Double getPrice() {
        return this.price;
    }

    //--- DATABASE MAPPING : tax_rate ( DOUBLE ) 
    public void setTaxRate( Double taxRate ) {
        this.taxRate = taxRate;
    }
    public Double getTaxRate() {
        return this.taxRate;
    }

    //--- DATABASE MAPPING : tax_rate2 ( DOUBLE ) 
    public void setTaxRate2( Double taxRate2 ) {
        this.taxRate2 = taxRate2;
    }
    public Double getTaxRate2() {
        return this.taxRate2;
    }

    //--- DATABASE MAPPING : tax_rate3 ( DOUBLE ) 
    public void setTaxRate3( Double taxRate3 ) {
        this.taxRate3 = taxRate3;
    }
    public Double getTaxRate3() {
        return this.taxRate3;
    }

    //--- DATABASE MAPPING : discount_rate1 ( DOUBLE ) 
    public void setDiscountRate1( Double discountRate1 ) {
        this.discountRate1 = discountRate1;
    }
    public Double getDiscountRate1() {
        return this.discountRate1;
    }

    //--- DATABASE MAPPING : discount_rate2 ( DOUBLE ) 
    public void setDiscountRate2( Double discountRate2 ) {
        this.discountRate2 = discountRate2;
    }
    public Double getDiscountRate2() {
        return this.discountRate2;
    }

    //--- DATABASE MAPPING : discount_rate3 ( DOUBLE ) 
    public void setDiscountRate3( Double discountRate3 ) {
        this.discountRate3 = discountRate3;
    }
    public Double getDiscountRate3() {
        return this.discountRate3;
    }

    //--- DATABASE MAPPING : amount ( DOUBLE ) 
    public void setAmount( Double amount ) {
        this.amount = amount;
    }
    public Double getAmount() {
        return this.amount;
    }

    //--- DATABASE MAPPING : tax_amount ( DOUBLE ) 
    public void setTaxAmount( Double taxAmount ) {
        this.taxAmount = taxAmount;
    }
    public Double getTaxAmount() {
        return this.taxAmount;
    }

    //--- DATABASE MAPPING : discount_amount ( DOUBLE ) 
    public void setDiscountAmount( Double discountAmount ) {
        this.discountAmount = discountAmount;
    }
    public Double getDiscountAmount() {
        return this.discountAmount;
    }

    //--- DATABASE MAPPING : total ( DOUBLE ) 
    public void setTotal( Double total ) {
        this.total = total;
    }
    public Double getTotal() {
        return this.total;
    }

    //--- DATABASE MAPPING : description ( VARCHAR ) 
    public void setDescription( String description ) {
        this.description = description;
    }
    public String getDescription() {
        return this.description;
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

    //--- DATABASE MAPPING : unit1 ( VARCHAR ) 
    public void setUnit1( String unit1 ) {
        this.unit1 = unit1;
    }
    public String getUnit1() {
        return this.unit1;
    }

    //--- DATABASE MAPPING : unit2 ( VARCHAR ) 
    public void setUnit2( String unit2 ) {
        this.unit2 = unit2;
    }
    public String getUnit2() {
        return this.unit2;
    }

    //--- DATABASE MAPPING : unit3 ( VARCHAR ) 
    public void setUnit3( String unit3 ) {
        this.unit3 = unit3;
    }
    public String getUnit3() {
        return this.unit3;
    }

    //--- DATABASE MAPPING : unit2ratio ( DOUBLE ) 
    public void setUnit2ratio( Double unit2ratio ) {
        this.unit2ratio = unit2ratio;
    }
    public Double getUnit2ratio() {
        return this.unit2ratio;
    }

    //--- DATABASE MAPPING : unit3ratio ( DOUBLE ) 
    public void setUnit3ratio( Double unit3ratio ) {
        this.unit3ratio = unit3ratio;
    }
    public Double getUnit3ratio() {
        return this.unit3ratio;
    }

    //--- DATABASE MAPPING : exc_code ( VARCHAR ) 
    public void setExcCode( String excCode ) {
        this.excCode = excCode;
    }
    public String getExcCode() {
        return this.excCode;
    }

    //--- DATABASE MAPPING : exc_rate ( DOUBLE ) 
    public void setExcRate( Double excRate ) {
        this.excRate = excRate;
    }
    public Double getExcRate() {
        return this.excRate;
    }

    //--- DATABASE MAPPING : exc_equivalent ( DOUBLE ) 
    public void setExcEquivalent( Double excEquivalent ) {
        this.excEquivalent = excEquivalent;
    }
    public Double getExcEquivalent() {
        return this.excEquivalent;
    }

    //--- DATABASE MAPPING : plus_factor_amount ( DOUBLE ) 
    public void setPlusFactorAmount( Double plusFactorAmount ) {
        this.plusFactorAmount = plusFactorAmount;
    }
    public Double getPlusFactorAmount() {
        return this.plusFactorAmount;
    }

    //--- DATABASE MAPPING : minus_factor_amount ( DOUBLE ) 
    public void setMinusFactorAmount( Double minusFactorAmount ) {
        this.minusFactorAmount = minusFactorAmount;
    }
    public Double getMinusFactorAmount() {
        return this.minusFactorAmount;
    }

    //--- DATABASE MAPPING : serial_no ( VARCHAR ) 
    public void setSerialNo( String serialNo ) {
        this.serialNo = serialNo;
    }
    public String getSerialNo() {
        return this.serialNo;
    }

    //--- DATABASE MAPPING : input ( DOUBLE ) 
    public void setInput( Double input ) {
        this.input = input;
    }
    public Double getInput() {
        return this.input;
    }

    //--- DATABASE MAPPING : output ( DOUBLE ) 
    public void setOutput( Double output ) {
        this.output = output;
    }
    public Double getOutput() {
        return this.output;
    }

    //--- DATABASE MAPPING : in_total ( DOUBLE ) 
    public void setInTotal( Double inTotal ) {
        this.inTotal = inTotal;
    }
    public Double getInTotal() {
        return this.inTotal;
    }

    //--- DATABASE MAPPING : out_total ( DOUBLE ) 
    public void setOutTotal( Double outTotal ) {
        this.outTotal = outTotal;
    }
    public Double getOutTotal() {
        return this.outTotal;
    }

    //--- DATABASE MAPPING : is_return ( BIT ) 
    public void setIsReturn( Boolean isReturn ) {
        this.isReturn = isReturn;
    }
    public Boolean getIsReturn() {
        return this.isReturn;
    }

    //--- DATABASE MAPPING : ret_input ( DOUBLE ) 
    public void setRetInput( Double retInput ) {
        this.retInput = retInput;
    }
    public Double getRetInput() {
        return this.retInput;
    }

    //--- DATABASE MAPPING : ret_output ( DOUBLE ) 
    public void setRetOutput( Double retOutput ) {
        this.retOutput = retOutput;
    }
    public Double getRetOutput() {
        return this.retOutput;
    }

    //--- DATABASE MAPPING : ret_in_total ( DOUBLE ) 
    public void setRetInTotal( Double retInTotal ) {
        this.retInTotal = retInTotal;
    }
    public Double getRetInTotal() {
        return this.retInTotal;
    }

    //--- DATABASE MAPPING : ret_out_total ( DOUBLE ) 
    public void setRetOutTotal( Double retOutTotal ) {
        this.retOutTotal = retOutTotal;
    }
    public Double getRetOutTotal() {
        return this.retOutTotal;
    }

    //--- DATABASE MAPPING : net_input ( DOUBLE ) 
    public void setNetInput( Double netInput ) {
        this.netInput = netInput;
    }
    public Double getNetInput() {
        return this.netInput;
    }

    //--- DATABASE MAPPING : net_output ( DOUBLE ) 
    public void setNetOutput( Double netOutput ) {
        this.netOutput = netOutput;
    }
    public Double getNetOutput() {
        return this.netOutput;
    }

    //--- DATABASE MAPPING : net_in_total ( DOUBLE ) 
    public void setNetInTotal( Double netInTotal ) {
        this.netInTotal = netInTotal;
    }
    public Double getNetInTotal() {
        return this.netInTotal;
    }

    //--- DATABASE MAPPING : net_out_total ( DOUBLE ) 
    public void setNetOutTotal( Double netOutTotal ) {
        this.netOutTotal = netOutTotal;
    }
    public Double getNetOutTotal() {
        return this.netOutTotal;
    }

    //--- DATABASE MAPPING : has_cost_effect ( BIT ) 
    public void setHasCostEffect( Boolean hasCostEffect ) {
        this.hasCostEffect = hasCostEffect;
    }
    public Boolean getHasCostEffect() {
        return this.hasCostEffect;
    }

    //--- DATABASE MAPPING : workspace ( INT ) 
    public void setWorkspace( Integer workspace ) {
        this.workspace = workspace;
    }
    public Integer getWorkspace() {
        return this.workspace;
    }


    //----------------------------------------------------------------------
    // GETTERS & SETTERS FOR LINKS
    //----------------------------------------------------------------------
    public void setStockTrans( StockTransEntity stockTrans ) {
        this.stockTrans = stockTrans;
    }
    public StockTransEntity getStockTrans() {
        return this.stockTrans;
    }

    public void setStockTransSource( StockTransSourceEntity stockTransSource ) {
        this.stockTransSource = stockTransSource;
    }
    public StockTransSourceEntity getStockTransSource() {
        return this.stockTransSource;
    }

    public void setStockDepot( StockDepotEntity stockDepot ) {
        this.stockDepot = stockDepot;
    }
    public StockDepotEntity getStockDepot() {
        return this.stockDepot;
    }

    public void setGlobalPrivateCode( GlobalPrivateCodeEntity globalPrivateCode ) {
        this.globalPrivateCode = globalPrivateCode;
    }
    public GlobalPrivateCodeEntity getGlobalPrivateCode() {
        return this.globalPrivateCode;
    }

    public void setSaleSeller( SaleSellerEntity saleSeller ) {
        this.saleSeller = saleSeller;
    }
    public SaleSellerEntity getSaleSeller() {
        return this.saleSeller;
    }

    public void setStock( StockEntity stock ) {
        this.stock = stock;
    }
    public StockEntity getStock() {
        return this.stock;
    }

    public void setGlobalTransPoint( GlobalTransPointEntity globalTransPoint ) {
        this.globalTransPoint = globalTransPoint;
    }
    public GlobalTransPointEntity getGlobalTransPoint() {
        return this.globalTransPoint;
    }

    public void setContact( ContactEntity contact ) {
        this.contact = contact;
    }
    public ContactEntity getContact() {
        return this.contact;
    }


    //----------------------------------------------------------------------
    // toString METHOD
    //----------------------------------------------------------------------
    public String toString() { 
        StringBuffer sb = new StringBuffer(); 
        sb.append("["); 
        sb.append(id);
        sb.append("]:"); 
        sb.append(receiptNo);
        sb.append("|");
        sb.append(right);
        sb.append("|");
        sb.append(transDate);
        sb.append("|");
        sb.append(deliveryDate);
        sb.append("|");
        sb.append(transType);
        sb.append("|");
        sb.append(rowNo);
        sb.append("|");
        sb.append(name);
        sb.append("|");
        sb.append(quantity);
        sb.append("|");
        sb.append(unit);
        sb.append("|");
        sb.append(unitRatio);
        sb.append("|");
        sb.append(basePrice);
        sb.append("|");
        sb.append(price);
        sb.append("|");
        sb.append(taxRate);
        sb.append("|");
        sb.append(taxRate2);
        sb.append("|");
        sb.append(taxRate3);
        sb.append("|");
        sb.append(discountRate1);
        sb.append("|");
        sb.append(discountRate2);
        sb.append("|");
        sb.append(discountRate3);
        sb.append("|");
        sb.append(amount);
        sb.append("|");
        sb.append(taxAmount);
        sb.append("|");
        sb.append(discountAmount);
        sb.append("|");
        sb.append(total);
        sb.append("|");
        sb.append(description);
        sb.append("|");
        sb.append(transYear);
        sb.append("|");
        sb.append(transMonth);
        sb.append("|");
        sb.append(unit1);
        sb.append("|");
        sb.append(unit2);
        sb.append("|");
        sb.append(unit3);
        sb.append("|");
        sb.append(unit2ratio);
        sb.append("|");
        sb.append(unit3ratio);
        sb.append("|");
        sb.append(excCode);
        sb.append("|");
        sb.append(excRate);
        sb.append("|");
        sb.append(excEquivalent);
        sb.append("|");
        sb.append(plusFactorAmount);
        sb.append("|");
        sb.append(minusFactorAmount);
        sb.append("|");
        sb.append(serialNo);
        sb.append("|");
        sb.append(input);
        sb.append("|");
        sb.append(output);
        sb.append("|");
        sb.append(inTotal);
        sb.append("|");
        sb.append(outTotal);
        sb.append("|");
        sb.append(isReturn);
        sb.append("|");
        sb.append(retInput);
        sb.append("|");
        sb.append(retOutput);
        sb.append("|");
        sb.append(retInTotal);
        sb.append("|");
        sb.append(retOutTotal);
        sb.append("|");
        sb.append(netInput);
        sb.append("|");
        sb.append(netOutput);
        sb.append("|");
        sb.append(netInTotal);
        sb.append("|");
        sb.append(netOutTotal);
        sb.append("|");
        sb.append(hasCostEffect);
        sb.append("|");
        sb.append(workspace);
        return sb.toString(); 
    } 

}
