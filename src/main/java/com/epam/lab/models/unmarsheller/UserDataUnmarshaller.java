package com.epam.lab.models.unmarsheller;

import com.epam.lab.models.UsersModel;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Unmarshaller;
import java.io.File;
import java.util.List;

public class UserDataUnmarshaller {

    public List<User> createObjectsUserData() {
        try {
            JAXBContext context = JAXBContext.newInstance(UsersModel.class);
            Unmarshaller un = context.createUnmarshaller();
            UsersModel usersModel = (UsersModel) un.unmarshal(new File("src/resources/usersdata.xml"));
            return usersModel.getUsers();
        } catch (JAXBException e) {
            e.printStackTrace();
        }
        return null;
    }
}
