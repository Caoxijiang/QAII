package com.qaii.domain;

public class Trademark {
    private Integer id;

    private String tradmDept;

    private String tradmCode;

    private String tradmPngandexplain;

    private String tradmApplyper;

    private String tradmAgency;

    private String tradmType;

    private String tradmItem;

    private String tradmApplynum;

    private String tradmApplytime;

    private String tradmRegistertime;

    private String tradmValidtime;

    private String tradmCost;

    private String tradmInvoiceper;

    private String tradmStatusfollow;

    private String tradmUpdatetime;
    
    private Integer eid;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getTradmDept() {
        return tradmDept;
    }

    public void setTradmDept(String tradmDept) {
        this.tradmDept = tradmDept == null ? null : tradmDept.trim();
    }

    public String getTradmCode() {
        return tradmCode;
    }

    public void setTradmCode(String tradmCode) {
        this.tradmCode = tradmCode == null ? null : tradmCode.trim();
    }

    public String getTradmPngandexplain() {
        return tradmPngandexplain;
    }

    public void setTradmPngandexplain(String tradmPngandexplain) {
        this.tradmPngandexplain = tradmPngandexplain == null ? null : tradmPngandexplain.trim();
    }

    public String getTradmApplyper() {
        return tradmApplyper;
    }

    public void setTradmApplyper(String tradmApplyper) {
        this.tradmApplyper = tradmApplyper == null ? null : tradmApplyper.trim();
    }

    public String getTradmAgency() {
        return tradmAgency;
    }

    public void setTradmAgency(String tradmAgency) {
        this.tradmAgency = tradmAgency == null ? null : tradmAgency.trim();
    }

    public String getTradmType() {
        return tradmType;
    }

    public void setTradmType(String tradmType) {
        this.tradmType = tradmType == null ? null : tradmType.trim();
    }

    public String getTradmItem() {
        return tradmItem;
    }

    public void setTradmItem(String tradmItem) {
        this.tradmItem = tradmItem == null ? null : tradmItem.trim();
    }

    public String getTradmApplynum() {
        return tradmApplynum;
    }

    public void setTradmApplynum(String tradmApplynum) {
        this.tradmApplynum = tradmApplynum == null ? null : tradmApplynum.trim();
    }

    public String getTradmApplytime() {
        return tradmApplytime;
    }

    public void setTradmApplytime(String tradmApplytime) {
        this.tradmApplytime = tradmApplytime == null ? null : tradmApplytime.trim();
    }

    public String getTradmRegistertime() {
        return tradmRegistertime;
    }

    public void setTradmRegistertime(String tradmRegistertime) {
        this.tradmRegistertime = tradmRegistertime == null ? null : tradmRegistertime.trim();
    }

    public String getTradmValidtime() {
        return tradmValidtime;
    }

    public void setTradmValidtime(String tradmValidtime) {
        this.tradmValidtime = tradmValidtime == null ? null : tradmValidtime.trim();
    }

    public String getTradmCost() {
        return tradmCost;
    }

    public void setTradmCost(String tradmCost) {
        this.tradmCost = tradmCost == null ? null : tradmCost.trim();
    }

    public String getTradmInvoiceper() {
        return tradmInvoiceper;
    }

    public void setTradmInvoiceper(String tradmInvoiceper) {
        this.tradmInvoiceper = tradmInvoiceper == null ? null : tradmInvoiceper.trim();
    }

    public String getTradmStatusfollow() {
        return tradmStatusfollow;
    }

    public void setTradmStatusfollow(String tradmStatusfollow) {
        this.tradmStatusfollow = tradmStatusfollow == null ? null : tradmStatusfollow.trim();
    }

    public String getTradmUpdatetime() {
        return tradmUpdatetime;
    }

    public void setTradmUpdatetime(String tradmUpdatetime) {
        this.tradmUpdatetime = tradmUpdatetime == null ? null : tradmUpdatetime.trim();
    }

	public Integer getEid() {
		return eid;
	}

	public void setEid(Integer eid) {
		this.eid = eid;
	}
}