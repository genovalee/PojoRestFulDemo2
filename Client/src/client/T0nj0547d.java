package client;

import java.io.Serializable;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name = "t0nj0547d")
public class T0nj0547d implements Serializable{
    public T0nj0547d() {
        super();
    }
    @NotNull
    @Pattern(regexp="^[0-9]{8}$",message="統編長度須為數字8碼") 
    private String bussrfno;
    private String regofc;
    private String it;
    private String salit;
    private String salitcomt;

    public void setBussrfno(String bussrfno) {
        this.bussrfno = bussrfno;
    }

    public String getBussrfno() {
        return bussrfno;
    }

    public void setRegofc(String regofc) {
        this.regofc = regofc;
    }

    public String getRegofc() {
        return regofc;
    }

    public void setIt(String it) {
        this.it = it;
    }

    public String getIt() {
        return it;
    }

    public void setSalit(String salit) {
        this.salit = salit;
    }

    public String getSalit() {
        return salit;
    }

    public void setSalitcomt(String salitcomt) {
        this.salitcomt = salitcomt;
    }

    public String getSalitcomt() {
        return salitcomt;
    }
}
