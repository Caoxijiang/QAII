package com.qaii.domain;

public class Copyright {
    private Integer id;

    private String copyPicture;

    private String copyName;

    private String copyCode;

    private String copyAuthor;

    private String copyCopyrightperson;

    private String copyAgency;

    private String copyEndtime;

    private String copyPublishtime;

    private String copyRegisttime;

    private String copyCost;

    private String copyInvoiceper;

    private String copyStatus;

    private Integer eid;
    
    private String url;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getCopyPicture() {
        return copyPicture;
    }

    public void setCopyPicture(String copyPicture) {
        this.copyPicture = copyPicture == null ? null : copyPicture.trim();
    }

    public String getCopyName() {
        return copyName;
    }

    public void setCopyName(String copyName) {
        this.copyName = copyName == null ? null : copyName.trim();
    }

    public String getCopyCode() {
        return copyCode;
    }

    public void setCopyCode(String copyCode) {
        this.copyCode = copyCode == null ? null : copyCode.trim();
    }

    public String getCopyAuthor() {
        return copyAuthor;
    }

    public void setCopyAuthor(String copyAuthor) {
        this.copyAuthor = copyAuthor == null ? null : copyAuthor.trim();
    }

    public String getCopyCopyrightperson() {
        return copyCopyrightperson;
    }

    public void setCopyCopyrightperson(String copyCopyrightperson) {
        this.copyCopyrightperson = copyCopyrightperson == null ? null : copyCopyrightperson.trim();
    }

    public String getCopyAgency() {
        return copyAgency;
    }

    public void setCopyAgency(String copyAgency) {
        this.copyAgency = copyAgency == null ? null : copyAgency.trim();
    }

    public String getCopyEndtime() {
        return copyEndtime;
    }

    public void setCopyEndtime(String copyEndtime) {
        this.copyEndtime = copyEndtime == null ? null : copyEndtime.trim();
    }

    public String getCopyPublishtime() {
        return copyPublishtime;
    }

    public void setCopyPublishtime(String copyPublishtime) {
        this.copyPublishtime = copyPublishtime == null ? null : copyPublishtime.trim();
    }

    public String getCopyRegisttime() {
        return copyRegisttime;
    }

    public void setCopyRegisttime(String copyRegisttime) {
        this.copyRegisttime = copyRegisttime == null ? null : copyRegisttime.trim();
    }

    public String getCopyCost() {
        return copyCost;
    }

    public void setCopyCost(String copyCost) {
        this.copyCost = copyCost == null ? null : copyCost.trim();
    }

    public String getCopyInvoiceper() {
        return copyInvoiceper;
    }

    public void setCopyInvoiceper(String copyInvoiceper) {
        this.copyInvoiceper = copyInvoiceper == null ? null : copyInvoiceper.trim();
    }

    public String getCopyStatus() {
        return copyStatus;
    }

    public void setCopyStatus(String copyStatus) {
        this.copyStatus = copyStatus == null ? null : copyStatus.trim();
    }

    public Integer getEid() {
        return eid;
    }

    public void setEid(Integer eid) {
        this.eid = eid;
    }

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}
    
}