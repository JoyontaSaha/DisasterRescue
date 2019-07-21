package com.software_engineering.joyontasahasumanarahmansupti.DisasterRescueChat;

import com.software_engineering.joyontasahasumanarahmansupti.DisasterRescueChat.data.model.Chat;

import org.junit.Test;
import static org.junit.Assert.assertTrue;

public class ChatModelTest {

    @Test
    public void getChatNameTest() {
        Chat chat=new Chat("Chat Room","Hello ! How are u?");
        assertTrue(chat.getChat_name().equals("Chat Room"));

    }
    @Test
    public void getChatDataTest() {
        Chat chat=new Chat("Chat Room","Hello ! How are u?");
        assertTrue(chat.getChat_data().equals("Hello ! How are u?"));

    }
}
