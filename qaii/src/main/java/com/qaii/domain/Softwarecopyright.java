package com.qaii.domain;

import java.util.List;

public class Softwarecopyright {
    private Integer id;

    private String softDept;

    private String softCode;

    private String softName;

    private String softWriter;

    private String softAuthor;

    private String softAgency;

    private String softDevelopendtime;

    private String softFirstpublishtime;

    private String softNum;

    private String softCertificatetime;

    private String softCost;

    private String softInvoiceper;

    private String softUpdatetime;

    private String softRemark;
    
    private List<Softcopyrightfile> softFile;

	@Override
	public String toString() {
		return "Softwarecopyright [id=" + id + ", softDept=" + softDept + ", softCode=" + softCode + ", softName="
				+ softName + ", softWriter=" + softWriter + ", softAuthor=" + softAuthor + ", softAgency=" + softAgency
				+ ", softDevelopendtime=" + softDevelopendtime + ", softFirstpublishtime=" + softFirstpublishtime
				+ ", softNum=" + softNum + ", softCertificatetime=" + softCertificatetime + ", softCost=" + softCost
				+ ", softInvoiceper=" + softInvoiceper + ", softUpdatetime=" + softUpdatetime + ", softRemark="
				+ softRemark + ", softFile=" + softFile + "]";
	}

	public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getSoftDept() {
        return softDept;
    }

    public void setSoftDept(String softDept) {
        this.softDept = softDept == null ? null : softDept.trim();
    }

    public String getSoftCode() {
        return softCode;
    }

    public void setSoftCode(String softCode) {
        this.softCode = softCode == null ? null : softCode.trim();
    }

    public String getSoftName() {
        return softName;
    }

    public void setSoftName(String softName) {
        this.softName = softName == null ? null : softName.trim();
    }

    public String getSoftWriter() {
        return softWriter;
    }

    public void setSoftWriter(String softWriter) {
        this.softWriter = softWriter == null ? null : softWriter.trim();
    }

    public String getSoftAuthor() {
        return softAuthor;
    }

    public void setSoftAuthor(String softAuthor) {
        this.softAuthor = softAuthor == null ? null : softAuthor.trim();
    }

    public String getSoftAgency() {
        return softAgency;
    }

    public void setSoftAgency(String softAgency) {
        this.softAgency = softAgency == null ? null : softAgency.trim();
    }

    public String getSoftDevelopendtime() {
        return softDevelopendtime;
    }

    public void setSoftDevelopendtime(String softDevelopendtime) {
        this.softDevelopendtime = softDevelopendtime == null ? null : softDevelopendtime.trim();
    }

    public String getSoftFirstpublishtime() {
        return softFirstpublishtime;
    }

    public void setSoftFirstpublishtime(String softFirstpublishtime) {
        this.softFirstpublishtime = softFirstpublishtime == null ? null : softFirstpublishtime.trim();
    }

    public String getSoftNum() {
        return softNum;
    }

    public void setSoftNum(String softNum) {
        this.softNum = softNum == null ? null : softNum.trim();
    }

    public String getSoftCertificatetime() {
        return softCertificatetime;
    }

    public void setSoftCertificatetime(String softCertificatetime) {
        this.softCertificatetime = softCertificatetime == null ? null : softCertificatetime.trim();
    }

    public String getSoftCost() {
        return softCost;
    }

    public void setSoftCost(String softCost) {
        this.softCost = softCost == null ? null : softCost.trim();
    }

    public String getSoftInvoiceper() {
        return softInvoiceper;
    }

    public void setSoftInvoiceper(String softInvoiceper) {
        this.softInvoiceper = softInvoiceper == null ? null : softInvoiceper.trim();
    }

    public String getSoftUpdatetime() {
        return softUpdatetime;
    }

    public void setSoftUpdatetime(String softUpdatetime) {
        this.softUpdatetime = softUpdatetime == null ? null : softUpdatetime.trim();
    }

    public String getSoftRemark() {
        return softRemark;
    }

    public void setSoftRemark(String softRemark) {
        this.softRemark = softRemark == null ? null : softRemark.trim();
    }

	public List<Softcopyrightfile> getSoftFile() {
		return softFile;
	}

	public void setSoftFile(List<Softcopyrightfile> softFile) {
		this.softFile = softFile;
	}
    
    
}