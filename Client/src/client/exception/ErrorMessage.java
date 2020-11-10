package client.exception;

import javax.ws.rs.core.Response;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name = "message")
public class ErrorMessage {
    @XmlElement
    public String code;
    @XmlElement
    public String description;
    @XmlElement
    public Response.Status status;

    public ErrorMessage() {
        super();
    }

    public ErrorMessage(String code, String description, Response.Status status) {
        this.code = code;
        this.description = description;
        this.status = status;
    }
}
