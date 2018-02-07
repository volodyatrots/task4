package com.epam.lab.models.unmarsheller;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name = "user")
@XmlAccessorType(XmlAccessType.FIELD)
public class User {
    private String email;
    private String password;
    private String mailto;
    private String mailsubject;
    private String mailmessage;


    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getMailto() {
        return mailto;
    }

    public void setMailto(String mailto) {
        this.mailto = mailto;
    }

    public String getMailsubject() {
        return mailsubject;
    }

    public void setMailsubject(String mailsubject) {
        this.mailsubject = mailsubject;
    }

    public String getMailmessage() {
        return mailmessage;
    }

    public void setMailmessage(String mailmessage) {
        this.mailmessage = mailmessage;
    }

}
