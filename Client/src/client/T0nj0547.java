package client;

import java.io.Serializable;

import java.util.List;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;  

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name = "t0nj0547")
public class T0nj0547 implements Serializable{
    public T0nj0547() {
        super();
    }
    @NotNull
    @Pattern(regexp="^[0-9]{8}$",message="length must be 8") 
    private String bussrfno;
    private String bussnm;
    @Pattern(regexp="^[a-zA-Z0-9]{2}",message="length must be 2")  
    private String costsid;
    private String costsidcomt;
    private String regofc;
    private String regofccomt;
    private String busslocation;
    private List<T0nj0547d> t0nj0547d;

    public void setBussrfno(String bussrfno) {
        this.bussrfno = bussrfno;
    }

    public String getBussrfno() {
        return bussrfno;
    }

    public void setBussnm(String bussnm) {
        this.bussnm = bussnm;
    }

    public String getBussnm() {
        return bussnm;
    }

    public void setCostsid(String costsid) {
        this.costsid = costsid;
    }

    public String getCostsid() {
        return costsid;
    }

    public void setCostsidcomt(String costsidcomt) {
        this.costsidcomt = costsidcomt;
    }

    public String getCostsidcomt() {
        return costsidcomt;
    }

    public void setRegofc(String regofc) {
        this.regofc = regofc;
    }

    public String getRegofc() {
        return regofc;
    }

    public void setRegofccomt(String regofccomt) {
        this.regofccomt = regofccomt;
    }

    public String getRegofccomt() {
        return regofccomt;
    }

    public void setBusslocation(String busslocation) {
        this.busslocation = busslocation;
    }

    public String getBusslocation() {
        return busslocation;
    }

    public void setT0nj0547d(List<T0nj0547d> t0nj0547d) {
        this.t0nj0547d = t0nj0547d;
    }

    public List<T0nj0547d> getT0nj0547d() {
        return t0nj0547d;
    }


}
