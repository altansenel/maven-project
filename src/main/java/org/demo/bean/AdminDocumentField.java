/*
 * Created on 24 �ub 2016 ( Time 15:56:46 )
 * Generated by Telosys Tools Generator ( version 2.1.1 )
 */
package org.demo.bean;

import java.io.Serializable;

import javax.validation.constraints.*;


public class AdminDocumentField implements Serializable {

    private static final long serialVersionUID = 1L;

    //----------------------------------------------------------------------
    // ENTITY PRIMARY KEY ( BASED ON A SINGLE FIELD )
    //----------------------------------------------------------------------
    @NotNull
    private Integer id;

    //----------------------------------------------------------------------
    // ENTITY DATA FIELDS 
    //----------------------------------------------------------------------    
    @Size( max = 10 )
    private String module;

    @Size( max = 12 )
    private String band;

    @Size( max = 20 )
    private String type;

    @Size( max = 100 )
    private String name;

    @Size( max = 100 )
    private String nickName;

    @Size( max = 100 )
    private String hiddenField;

    @Size( max = 70 )
    private String label;

    @Size( max = 70 )
    private String originalLabel;


    private Integer labelWidth;

    @Size( max = 5 )
    private String labelAlign;


    private Integer width;


    private Integer row;


    private Integer column;

    @Size( max = 30 )
    private String format;

    @Size( max = 5 )
    private String prefix;

    @Size( max = 5 )
    private String suffix;

    @Size( max = 70 )
    private String value;

    @Size( max = 30 )
    private String msgPrefix;

    @Size( max = 50 )
    private String defauld;


    private Boolean isDbField;

    @Size( max = 10 )
    private String tableType;


    private Integer reportTitleDocId;


    private Integer pageTitleDocId;


    private Integer detailDocId;


    private Integer pageFooterDocId;


    private Integer reportFooterDocId;



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
    public void setModule( String module ) {
        this.module = module;
    }
    public String getModule() {
        return this.module;
    }

    public void setBand( String band ) {
        this.band = band;
    }
    public String getBand() {
        return this.band;
    }

    public void setType( String type ) {
        this.type = type;
    }
    public String getType() {
        return this.type;
    }

    public void setName( String name ) {
        this.name = name;
    }
    public String getName() {
        return this.name;
    }

    public void setNickName( String nickName ) {
        this.nickName = nickName;
    }
    public String getNickName() {
        return this.nickName;
    }

    public void setHiddenField( String hiddenField ) {
        this.hiddenField = hiddenField;
    }
    public String getHiddenField() {
        return this.hiddenField;
    }

    public void setLabel( String label ) {
        this.label = label;
    }
    public String getLabel() {
        return this.label;
    }

    public void setOriginalLabel( String originalLabel ) {
        this.originalLabel = originalLabel;
    }
    public String getOriginalLabel() {
        return this.originalLabel;
    }

    public void setLabelWidth( Integer labelWidth ) {
        this.labelWidth = labelWidth;
    }
    public Integer getLabelWidth() {
        return this.labelWidth;
    }

    public void setLabelAlign( String labelAlign ) {
        this.labelAlign = labelAlign;
    }
    public String getLabelAlign() {
        return this.labelAlign;
    }

    public void setWidth( Integer width ) {
        this.width = width;
    }
    public Integer getWidth() {
        return this.width;
    }

    public void setRow( Integer row ) {
        this.row = row;
    }
    public Integer getRow() {
        return this.row;
    }

    public void setColumn( Integer column ) {
        this.column = column;
    }
    public Integer getColumn() {
        return this.column;
    }

    public void setFormat( String format ) {
        this.format = format;
    }
    public String getFormat() {
        return this.format;
    }

    public void setPrefix( String prefix ) {
        this.prefix = prefix;
    }
    public String getPrefix() {
        return this.prefix;
    }

    public void setSuffix( String suffix ) {
        this.suffix = suffix;
    }
    public String getSuffix() {
        return this.suffix;
    }

    public void setValue( String value ) {
        this.value = value;
    }
    public String getValue() {
        return this.value;
    }

    public void setMsgPrefix( String msgPrefix ) {
        this.msgPrefix = msgPrefix;
    }
    public String getMsgPrefix() {
        return this.msgPrefix;
    }

    public void setDefauld( String defauld ) {
        this.defauld = defauld;
    }
    public String getDefauld() {
        return this.defauld;
    }

    public void setIsDbField( Boolean isDbField ) {
        this.isDbField = isDbField;
    }
    public Boolean getIsDbField() {
        return this.isDbField;
    }

    public void setTableType( String tableType ) {
        this.tableType = tableType;
    }
    public String getTableType() {
        return this.tableType;
    }

    public void setReportTitleDocId( Integer reportTitleDocId ) {
        this.reportTitleDocId = reportTitleDocId;
    }
    public Integer getReportTitleDocId() {
        return this.reportTitleDocId;
    }

    public void setPageTitleDocId( Integer pageTitleDocId ) {
        this.pageTitleDocId = pageTitleDocId;
    }
    public Integer getPageTitleDocId() {
        return this.pageTitleDocId;
    }

    public void setDetailDocId( Integer detailDocId ) {
        this.detailDocId = detailDocId;
    }
    public Integer getDetailDocId() {
        return this.detailDocId;
    }

    public void setPageFooterDocId( Integer pageFooterDocId ) {
        this.pageFooterDocId = pageFooterDocId;
    }
    public Integer getPageFooterDocId() {
        return this.pageFooterDocId;
    }

    public void setReportFooterDocId( Integer reportFooterDocId ) {
        this.reportFooterDocId = reportFooterDocId;
    }
    public Integer getReportFooterDocId() {
        return this.reportFooterDocId;
    }


    //----------------------------------------------------------------------
    // toString METHOD
    //----------------------------------------------------------------------
 
        public String toString() { 
        StringBuffer sb = new StringBuffer(); 
        sb.append(id);
        sb.append("|");
        sb.append(module);
        sb.append("|");
        sb.append(band);
        sb.append("|");
        sb.append(type);
        sb.append("|");
        sb.append(name);
        sb.append("|");
        sb.append(nickName);
        sb.append("|");
        sb.append(hiddenField);
        sb.append("|");
        sb.append(label);
        sb.append("|");
        sb.append(originalLabel);
        sb.append("|");
        sb.append(labelWidth);
        sb.append("|");
        sb.append(labelAlign);
        sb.append("|");
        sb.append(width);
        sb.append("|");
        sb.append(row);
        sb.append("|");
        sb.append(column);
        sb.append("|");
        sb.append(format);
        sb.append("|");
        sb.append(prefix);
        sb.append("|");
        sb.append(suffix);
        sb.append("|");
        sb.append(value);
        sb.append("|");
        sb.append(msgPrefix);
        sb.append("|");
        sb.append(defauld);
        sb.append("|");
        sb.append(isDbField);
        sb.append("|");
        sb.append(tableType);
        sb.append("|");
        sb.append(reportTitleDocId);
        sb.append("|");
        sb.append(pageTitleDocId);
        sb.append("|");
        sb.append(detailDocId);
        sb.append("|");
        sb.append(pageFooterDocId);
        sb.append("|");
        sb.append(reportFooterDocId);
        return sb.toString(); 
    } 


}
