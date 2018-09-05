package com.qaii.domain;

public class EmpInfo {
    private Integer id;

    private String eid;

    private String empNum;

    private String empName;

    private String empGender;

    private String empDept;

    private String empPosition;

    private String empHireStarttime;
    
    private String empstat;

    private String empIdcard;

    private String empIdcardEndtime;

    private String empEthnic;

    private String empPoliticallandscape;

    private String empMaritalstatus;

    private String empFirsteducation;

    private String empSecondeducation;

    private String empThirdeducation;

    private String empFirsteducationschool;

    private String empSecondeducationschool;

    private String empThirdeducationschool;

    private String empFirsteducationpro;

    private String empSecondeducationpro;

    private String empThirdeducationpro;

    private String empFirstgraduationtime;

    private String empSecondgraduationtime;

    private String empThirdgraduationtime;

    private String empJobtitle;

    private String empJobtitlelevel;

    private String empJobtitleobtaintime;

    private String empPhone;

    private String empEmergencycontactandphone;

    private String empFileaddress;

    private String empAccountaddress;

    private String empHomeaddress;

    private String empWorktype;

    private String empCompile;

    private String empInductiontime;
    

    private String empdepartureTime;

    private String empTryoutendtime;
    
    private String empTrystatus;
    

	private String empTitle;
    
    public String getEmpStat() {
		return empStat;
	}

	public void setEmpStat(String empStat) {
		this.empStat = empStat;
	}

	public String getEmpDepartureTime() {
		return empDepartureTime;
	}

	public void setEmpDepartureTime(String empDepartureTime) {
		this.empDepartureTime = empDepartureTime;
	}

	public String getEmpTryStatus() {
		return empTryStatus;
	}

	public void setEmpTryStatus(String empTryStatus) {
		this.empTryStatus = empTryStatus;
	}

	public String getEmpContractStatus() {
		return empContractStatus;
	}

	public void setEmpContractStatus(String empContractStatus) {
		this.empContractStatus = empContractStatus;
	}

	private String empStat;
    
    private String empDepartureTime;
    
    private String empTryStatus;
    
    private String empContractStatus;

    public String getEmpInductiontime() {
		return empInductiontime;
	}

	public void setEmpInductiontime(String empInductiontime) {
		this.empInductiontime = empInductiontime;
	}


    private String empContractendtime;
    
    private String empContractstatus;

    private Integer empContractsignednum;

    private String empReturnee;

    private String empForeign;

    private String empRemarks;

    private String empReviewstatus;
    
    private String url;
    
    private Integer count;

    public Integer getCount() {
		return count;
	}

	public void setCount(Integer count) {
		this.count = count;
	}

	public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getEid() {
        return eid;
    }

    public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	public void setEid(String eid) {
        this.eid = eid == null ? null : eid.trim();
    }

    public String getEmpNum() {
        return empNum;
    }

    public void setEmpNum(String empNum) {
        this.empNum = empNum == null ? null : empNum.trim();
    }

    public String getEmpName() {
        return empName;
    }

    public void setEmpName(String empName) {
        this.empName = empName == null ? null : empName.trim();
    }

    public String getEmpGender() {
        return empGender;
    }

    public void setEmpGender(String empGender) {
        this.empGender = empGender == null ? null : empGender.trim();
    }

    public String getEmpDept() {
        return empDept;
    }

    public void setEmpDept(String empDept) {
        this.empDept = empDept == null ? null : empDept.trim();
    }

    public String getEmpPosition() {
        return empPosition;
    }

    public void setEmpPosition(String empPosition) {
        this.empPosition = empPosition == null ? null : empPosition.trim();
    }

    public String getEmpHireStarttime() {
        return empHireStarttime;
    }

    public void setEmpHireStarttime(String empHireStarttime) {
        this.empHireStarttime = empHireStarttime == null ? null : empHireStarttime.trim();
    }

    public String getEmpstat() {
		return empstat;
	}

	public void setEmpstat(String empstat) {
		this.empstat = empstat;
	}

	public String getEmpIdcard() {
        return empIdcard;
    }

    public void setEmpIdcard(String empIdcard) {
        this.empIdcard = empIdcard == null ? null : empIdcard.trim();
    }

    public String getEmpIdcardEndtime() {
        return empIdcardEndtime;
    }

    public void setEmpIdcardEndtime(String empIdcardEndtime) {
        this.empIdcardEndtime = empIdcardEndtime == null ? null : empIdcardEndtime.trim();
    }

    public String getEmpEthnic() {
        return empEthnic;
    }

    public void setEmpEthnic(String empEthnic) {
        this.empEthnic = empEthnic == null ? null : empEthnic.trim();
    }

    public String getEmpPoliticallandscape() {
        return empPoliticallandscape;
    }

    public void setEmpPoliticallandscape(String empPoliticallandscape) {
        this.empPoliticallandscape = empPoliticallandscape == null ? null : empPoliticallandscape.trim();
    }

    public String getEmpMaritalstatus() {
        return empMaritalstatus;
    }

    public void setEmpMaritalstatus(String empMaritalstatus) {
        this.empMaritalstatus = empMaritalstatus == null ? null : empMaritalstatus.trim();
    }

    public String getEmpFirsteducation() {
        return empFirsteducation;
    }

    public void setEmpFirsteducation(String empFirsteducation) {
        this.empFirsteducation = empFirsteducation == null ? null : empFirsteducation.trim();
    }

    public String getEmpSecondeducation() {
        return empSecondeducation;
    }

    public void setEmpSecondeducation(String empSecondeducation) {
        this.empSecondeducation = empSecondeducation == null ? null : empSecondeducation.trim();
    }

    public String getEmpThirdeducation() {
        return empThirdeducation;
    }

    public void setEmpThirdeducation(String empThirdeducation) {
        this.empThirdeducation = empThirdeducation == null ? null : empThirdeducation.trim();
    }

    public String getEmpFirsteducationschool() {
        return empFirsteducationschool;
    }

    public void setEmpFirsteducationschool(String empFirsteducationschool) {
        this.empFirsteducationschool = empFirsteducationschool == null ? null : empFirsteducationschool.trim();
    }

    public String getEmpSecondeducationschool() {
        return empSecondeducationschool;
    }

    public void setEmpSecondeducationschool(String empSecondeducationschool) {
        this.empSecondeducationschool = empSecondeducationschool == null ? null : empSecondeducationschool.trim();
    }

    public String getEmpThirdeducationschool() {
        return empThirdeducationschool;
    }

    public void setEmpThirdeducationschool(String empThirdeducationschool) {
        this.empThirdeducationschool = empThirdeducationschool == null ? null : empThirdeducationschool.trim();
    }

    public String getEmpFirsteducationpro() {
        return empFirsteducationpro;
    }

    public void setEmpFirsteducationpro(String empFirsteducationpro) {
        this.empFirsteducationpro = empFirsteducationpro == null ? null : empFirsteducationpro.trim();
    }

    public String getEmpSecondeducationpro() {
        return empSecondeducationpro;
    }

    public void setEmpSecondeducationpro(String empSecondeducationpro) {
        this.empSecondeducationpro = empSecondeducationpro == null ? null : empSecondeducationpro.trim();
    }

    public String getEmpThirdeducationpro() {
        return empThirdeducationpro;
    }

    public void setEmpThirdeducationpro(String empThirdeducationpro) {
        this.empThirdeducationpro = empThirdeducationpro == null ? null : empThirdeducationpro.trim();
    }

    public String getEmpFirstgraduationtime() {
        return empFirstgraduationtime;
    }

    public void setEmpFirstgraduationtime(String empFirstgraduationtime) {
        this.empFirstgraduationtime = empFirstgraduationtime == null ? null : empFirstgraduationtime.trim();
    }

    public String getEmpSecondgraduationtime() {
        return empSecondgraduationtime;
    }

    public void setEmpSecondgraduationtime(String empSecondgraduationtime) {
        this.empSecondgraduationtime = empSecondgraduationtime == null ? null : empSecondgraduationtime.trim();
    }

    public String getEmpThirdgraduationtime() {
        return empThirdgraduationtime;
    }

    public void setEmpThirdgraduationtime(String empThirdgraduationtime) {
        this.empThirdgraduationtime = empThirdgraduationtime == null ? null : empThirdgraduationtime.trim();
    }

    public String getEmpJobtitle() {
        return empJobtitle;
    }

    public void setEmpJobtitle(String empJobtitle) {
        this.empJobtitle = empJobtitle == null ? null : empJobtitle.trim();
    }

    public String getEmpJobtitlelevel() {
        return empJobtitlelevel;
    }

    public void setEmpJobtitlelevel(String empJobtitlelevel) {
        this.empJobtitlelevel = empJobtitlelevel == null ? null : empJobtitlelevel.trim();
    }

    public String getEmpJobtitleobtaintime() {
        return empJobtitleobtaintime;
    }

    public void setEmpJobtitleobtaintime(String empJobtitleobtaintime) {
        this.empJobtitleobtaintime = empJobtitleobtaintime == null ? null : empJobtitleobtaintime.trim();
    }

    public String getEmpPhone() {
        return empPhone;
    }

    public void setEmpPhone(String empPhone) {
        this.empPhone = empPhone == null ? null : empPhone.trim();
    }

    public String getEmpEmergencycontactandphone() {
        return empEmergencycontactandphone;
    }

    public void setEmpEmergencycontactandphone(String empEmergencycontactandphone) {
        this.empEmergencycontactandphone = empEmergencycontactandphone == null ? null : empEmergencycontactandphone.trim();
    }

    public String getEmpFileaddress() {
        return empFileaddress;
    }

    public void setEmpFileaddress(String empFileaddress) {
        this.empFileaddress = empFileaddress == null ? null : empFileaddress.trim();
    }

    public String getEmpAccountaddress() {
        return empAccountaddress;
    }

    public void setEmpAccountaddress(String empAccountaddress) {
        this.empAccountaddress = empAccountaddress == null ? null : empAccountaddress.trim();
    }

    public String getEmpHomeaddress() {
        return empHomeaddress;
    }

    public void setEmpHomeaddress(String empHomeaddress) {
        this.empHomeaddress = empHomeaddress == null ? null : empHomeaddress.trim();
    }

    public String getEmpWorktype() {
        return empWorktype;
    }

    public void setEmpWorktype(String empWorktype) {
        this.empWorktype = empWorktype == null ? null : empWorktype.trim();
    }

    public String getEmpCompile() {
        return empCompile;
    }

    public void setEmpCompile(String empCompile) {
        this.empCompile = empCompile == null ? null : empCompile.trim();
    }



    public String getEmpdepartureTime() {
		return empdepartureTime;
	}

	public void setEmpdepartureTime(String empdepartureTime) {
		this.empdepartureTime = empdepartureTime;
	}

	public String getEmpTryoutendtime() {
        return empTryoutendtime;
    }

    public void setEmpTryoutendtime(String empTryoutendtime) {
        this.empTryoutendtime = empTryoutendtime == null ? null : empTryoutendtime.trim();
    }

    public String getEmpTrystatus() {
		return empTrystatus;
	}

	public void setEmpTrystatus(String empTrystatus) {
		this.empTrystatus = empTrystatus;
	}

	public String getEmpContractendtime() {
        return empContractendtime;
    }

    public void setEmpContractendtime(String empContractendtime) {
        this.empContractendtime = empContractendtime == null ? null : empContractendtime.trim();
    }

    public String getEmpContractstatus() {
		return empContractstatus;
	}

	public void setEmpContractstatus(String empContractstatus) {
		this.empContractstatus = empContractstatus;
	}


	public void setEmpContractsignednum(Integer empContractsignednum) {
		this.empContractsignednum = empContractsignednum;
	}

	public Integer getEmpContractsignednum() {
		return empContractsignednum;
	}

	public String getEmpReturnee() {
        return empReturnee;
    }

    public void setEmpReturnee(String empReturnee) {
        this.empReturnee = empReturnee == null ? null : empReturnee.trim();
    }

    public String getEmpForeign() {
        return empForeign;
    }

    public void setEmpForeign(String empForeign) {
        this.empForeign = empForeign == null ? null : empForeign.trim();
    }

    public String getEmpRemarks() {
        return empRemarks;
    }

    public void setEmpRemarks(String empRemarks) {
        this.empRemarks = empRemarks == null ? null : empRemarks.trim();
    }

    public String getEmpReviewstatus() {
        return empReviewstatus;
    }

    public void setEmpReviewstatus(String empReviewstatus) {
        this.empReviewstatus = empReviewstatus == null ? null : empReviewstatus.trim();
    }

	public String getEmpTitle() {
		return empTitle;
	}

	public void setEmpTitle(String empTitle) {
		this.empTitle = empTitle;
	}

	@Override
	public String toString() {
		return "EmpInfo [id=" + id + ", eid=" + eid + ", empNum=" + empNum + ", empName=" + empName + ", empGender="
				+ empGender + ", empDept=" + empDept + ", empPosition=" + empPosition + ", empHireStarttime="
				+ empHireStarttime + ", empstat=" + empstat + ", empIdcard=" + empIdcard + ", empIdcardEndtime="
				+ empIdcardEndtime + ", empEthnic=" + empEthnic + ", empPoliticallandscape=" + empPoliticallandscape
				+ ", empMaritalstatus=" + empMaritalstatus + ", empFirsteducation=" + empFirsteducation
				+ ", empSecondeducation=" + empSecondeducation + ", empThirdeducation=" + empThirdeducation
				+ ", empFirsteducationschool=" + empFirsteducationschool + ", empSecondeducationschool="
				+ empSecondeducationschool + ", empThirdeducationschool=" + empThirdeducationschool
				+ ", empFirsteducationpro=" + empFirsteducationpro + ", empSecondeducationpro=" + empSecondeducationpro
				+ ", empThirdeducationpro=" + empThirdeducationpro + ", empFirstgraduationtime="
				+ empFirstgraduationtime + ", empSecondgraduationtime=" + empSecondgraduationtime
				+ ", empThirdgraduationtime=" + empThirdgraduationtime + ", empJobtitle=" + empJobtitle
				+ ", empJobtitlelevel=" + empJobtitlelevel + ", empJobtitleobtaintime=" + empJobtitleobtaintime
				+ ", empPhone=" + empPhone + ", empEmergencycontactandphone=" + empEmergencycontactandphone
				+ ", empFileaddress=" + empFileaddress + ", empAccountaddress=" + empAccountaddress
				+ ", empHomeaddress=" + empHomeaddress + ", empWorktype=" + empWorktype + ", empCompile=" + empCompile
				+ ", empInductiontime=" + empInductiontime + ", empdepartureTime=" + empdepartureTime
				+ ", empTryoutendtime=" + empTryoutendtime + ", empTrystatus=" + empTrystatus + ", empContractendtime="
				+ empContractendtime + ", empContractstatus=" + empContractstatus + ", empContractsignednum="
				+ empContractsignednum + ", empReturnee=" + empReturnee + ", empForeign=" + empForeign + ", empRemarks="
				+ empRemarks + ", empReviewstatus=" + empReviewstatus + ", empTitle=" + empTitle + "]";
	}

}