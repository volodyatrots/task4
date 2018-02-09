package com.epam.lab.models.unmarsheller;

import com.epam.lab.models.ConfigProperty;
import com.epam.lab.models.MessageModel;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Unmarshaller;
import java.io.File;
import java.util.List;

public class MessageUnmarshaller {

    public List<Message> createObjectsMessage() {
        try {
            ConfigProperty configProperty = new ConfigProperty();
            JAXBContext context = JAXBContext.newInstance(MessageModel.class);
            Unmarshaller un = context.createUnmarshaller();
            MessageModel messageModel = (MessageModel) un.unmarshal(new File(configProperty.getPathMessage()));
            return messageModel.getMessages();
        } catch (JAXBException e) {
            e.printStackTrace();
        }
        return null;
    }
}
