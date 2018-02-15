package com.epam.lab.utils.xml;

import com.epam.lab.models.MessageModel;
import com.epam.lab.models.UserModel;
import com.epam.lab.utils.xml.messages.MessageUnmarshaller;
import com.epam.lab.utils.xml.users.UserDataUnmarshaller;

import java.util.List;

public class XMLData {
    public Object[][] getGmailData() {
        List<UserModel> userModels = new UserDataUnmarshaller().createObjectsUserData();
        List<MessageModel> messages = new MessageUnmarshaller().createObjectsMessage();
        Object[][] gmailData = new Object[userModels.size()][2];
        for (int i = 0,j=0; i < userModels.size(); i++,j++) {
            gmailData[i][0] = userModels.get(i);
            gmailData[j][1] = messages.get(j);
        }
        return gmailData;
    }

}
