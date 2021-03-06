/*
 * Created on 24 �ub 2016 ( Time 15:56:46 )
 * Generated by Telosys Tools Generator ( version 2.1.1 )
 */
package org.demo.bean;

import java.io.Serializable;

import javax.validation.constraints.*;


public class AdminDocument implements Serializable {

    private static final long serialVersionUID = 1L;

    //----------------------------------------------------------------------
    // ENTITY PRIMARY KEY ( BASED ON A SINGLE FIELD )
    //----------------------------------------------------------------------
    @NotNull
    private Integer id;

    //----------------------------------------------------------------------
    // ENTITY DATA FIELDS 
    //----------------------------------------------------------------------    
    @NotNull
    @Size( min = 1, max = 10 )
    private String module;

    @Size( max = 20 )
    private String header;

    @NotNull
    @Size( min = 1, max = 50 )
    private String right;

    @NotNull
    @Size( min = 1, max = 20 )
    private String name;


    private Integer pageRows;


    private Integer reportTitleRows;


    private Integer pageTitleRows;


    private Integer detailRows;


    private Integer pageFooterRows;


    private Integer reportFooterRows;


    private Boolean reportTitleLabels;


    private Boolean pageTitleLabels;


    private Boolean detailLabels;


    private Boolean pageFooterLabels;


    private Boolean reportFooterLabels;


    private Integer leftMargin;


    private Integer topMargin;


    private Integer bottomMargin;


    private Boolean isSinglePage;


    private Boolean hasPaging;

    @Size( max = 7 )
    private String columnTitleType;

    @Size( max = 50 )
    private String carryingOverName;

    @Size( max = 30 )
    private String description;

    @Size( max = 65535 )
    private String templateRows;


    private Boolean isActive;


    private Integer version;



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

    public void setHeader( String header ) {
        this.header = header;
    }
    public String getHeader() {
        return this.header;
    }

    public void setRight( String right ) {
        this.right = right;
    }
    public String getRight() {
        return this.right;
    }

    public void setName( String name ) {
        this.name = name;
    }
    public String getName() {
        return this.name;
    }

    public void setPageRows( Integer pageRows ) {
        this.pageRows = pageRows;
    }
    public Integer getPageRows() {
        return this.pageRows;
    }

    public void setReportTitleRows( Integer reportTitleRows ) {
        this.reportTitleRows = reportTitleRows;
    }
    public Integer getReportTitleRows() {
        return this.reportTitleRows;
    }

    public void setPageTitleRows( Integer pageTitleRows ) {
        this.pageTitleRows = pageTitleRows;
    }
    public Integer getPageTitleRows() {
        return this.pageTitleRows;
    }

    public void setDetailRows( Integer detailRows ) {
        this.detailRows = detailRows;
    }
    public Integer getDetailRows() {
        return this.detailRows;
    }

    public void setPageFooterRows( Integer pageFooterRows ) {
        this.pageFooterRows = pageFooterRows;
    }
    public Integer getPageFooterRows() {
        return this.pageFooterRows;
    }

    public void setReportFooterRows( Integer reportFooterRows ) {
        this.reportFooterRows = reportFooterRows;
    }
    public Integer getReportFooterRows() {
        return this.reportFooterRows;
    }

    public void setReportTitleLabels( Boolean reportTitleLabels ) {
        this.reportTitleLabels = reportTitleLabels;
    }
    public Boolean getReportTitleLabels() {
        return this.reportTitleLabels;
    }

    public void setPageTitleLabels( Boolean pageTitleLabels ) {
        this.pageTitleLabels = pageTitleLabels;
    }
    public Boolean getPageTitleLabels() {
        return this.pageTitleLabels;
    }

    public void setDetailLabels( Boolean detailLabels ) {
        this.detailLabels = detailLabels;
    }
    public Boolean getDetailLabels() {
        return this.detailLabels;
    }

    public void setPageFooterLabels( Boolean pageFooterLabels ) {
        this.pageFooterLabels = pageFooterLabels;
    }
    public Boolean getPageFooterLabels() {
        return this.pageFooterLabels;
    }

    public void setReportFooterLabels( Boolean reportFooterLabels ) {
        this.reportFooterLabels = reportFooterLabels;
    }
    public Boolean getReportFooterLabels() {
        return this.reportFooterLabels;
    }

    public void setLeftMargin( Integer leftMargin ) {
        this.leftMargin = leftMargin;
    }
    public Integer getLeftMargin() {
        return this.leftMargin;
    }

    public void setTopMargin( Integer topMargin ) {
        this.topMargin = topMargin;
    }
    public Integer getTopMargin() {
        return this.topMargin;
    }

    public void setBottomMargin( Integer bottomMargin ) {
        this.bottomMargin = bottomMargin;
    }
    public Integer getBottomMargin() {
        return this.bottomMargin;
    }

    public void setIsSinglePage( Boolean isSinglePage ) {
        this.isSinglePage = isSinglePage;
    }
    public Boolean getIsSinglePage() {
        return this.isSinglePage;
    }

    public void setHasPaging( Boolean hasPaging ) {
        this.hasPaging = hasPaging;
    }
    public Boolean getHasPaging() {
        return this.hasPaging;
    }

    public void setColumnTitleType( String columnTitleType ) {
        this.columnTitleType = columnTitleType;
    }
    public String getColumnTitleType() {
        return this.columnTitleType;
    }

    public void setCarryingOverName( String carryingOverName ) {
        this.carryingOverName = carryingOverName;
    }
    public String getCarryingOverName() {
        return this.carryingOverName;
    }

    public void setDescription( String description ) {
        this.description = description;
    }
    public String getDescription() {
        return this.description;
    }

    public void setTemplateRows( String templateRows ) {
        this.templateRows = templateRows;
    }
    public String getTemplateRows() {
        return this.templateRows;
    }

    public void setIsActive( Boolean isActive ) {
        this.isActive = isActive;
    }
    public Boolean getIsActive() {
        return this.isActive;
    }

    public void setVersion( Integer version ) {
        this.version = version;
    }
    public Integer getVersion() {
        return this.version;
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
        sb.append(header);
        sb.append("|");
        sb.append(right);
        sb.append("|");
        sb.append(name);
        sb.append("|");
        sb.append(pageRows);
        sb.append("|");
        sb.append(reportTitleRows);
        sb.append("|");
        sb.append(pageTitleRows);
        sb.append("|");
        sb.append(detailRows);
        sb.append("|");
        sb.append(pageFooterRows);
        sb.append("|");
        sb.append(reportFooterRows);
        sb.append("|");
        sb.append(reportTitleLabels);
        sb.append("|");
        sb.append(pageTitleLabels);
        sb.append("|");
        sb.append(detailLabels);
        sb.append("|");
        sb.append(pageFooterLabels);
        sb.append("|");
        sb.append(reportFooterLabels);
        sb.append("|");
        sb.append(leftMargin);
        sb.append("|");
        sb.append(topMargin);
        sb.append("|");
        sb.append(bottomMargin);
        sb.append("|");
        sb.append(isSinglePage);
        sb.append("|");
        sb.append(hasPaging);
        sb.append("|");
        sb.append(columnTitleType);
        sb.append("|");
        sb.append(carryingOverName);
        sb.append("|");
        sb.append(description);
        // attribute 'templateRows' not usable (type = String Long Text)
        sb.append("|");
        sb.append(isActive);
        sb.append("|");
        sb.append(version);
        return sb.toString(); 
    } 


}
