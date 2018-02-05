package com.epam.lab.propmodel;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class GmailData {
    private Properties prop = new Properties();

    public GmailData() {
        FileInputStream input = null;
        try {
            input = new FileInputStream("src/resources/gmailData.properties");
            prop.load(input);
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                if (input != null) {
                    input.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    public String getGmailLink() {
        return prop.getProperty("mailLink");
    }

    public String getUserMail() {
        return prop.getProperty("mail");
    }

    public String getUserPassword() {
        return prop.getProperty("mailPassword");
    }

    public String getMailTo() {
        return prop.getProperty("mailTo");
    }

    public String getMailSubject() {
        return prop.getProperty("mailSubject");
    }

    public String getMailMessage() {
        return prop.getProperty("mailMessage");
    }
}
