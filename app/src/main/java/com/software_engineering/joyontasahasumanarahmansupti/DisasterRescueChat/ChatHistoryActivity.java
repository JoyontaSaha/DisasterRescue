package com.software_engineering.joyontasahasumanarahmansupti.DisasterRescueChat;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import com.software_engineering.joyontasahasumanarahmansupti.DisasterRescueChat.data.DB.SQLChatDAO;
import com.software_engineering.joyontasahasumanarahmansupti.DisasterRescueChat.data.model.Chat;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;



//class to view avaialable chat names list
public class ChatHistoryActivity extends Activity{

    private ListView mainListView ;
    private ArrayAdapter<String> listAdapter ;
    SQLChatDAO sqlChatDAO;
    ArrayList<String> chatNameList;
    ArrayList<String> chatDataList;
    ArrayList<Chat> chatList;
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_chat_history);
        // Find the ListView resource.
        mainListView = (ListView) findViewById( R.id.chat_history );
        sqlChatDAO=new SQLChatDAO();
        chatList=sqlChatDAO.getChatList();
        chatNameList = new ArrayList<String>();
        for(Chat c:chatList){
            chatNameList.add(c.getChat_name());
        }
        Set<String> hs = new HashSet<>();
        hs.addAll(chatNameList);
        chatNameList.clear();
        chatNameList.addAll(hs);

        listAdapter = new ArrayAdapter<String>(this, R.layout.list_row, chatNameList);

        mainListView.setAdapter( listAdapter );//view list on ui

        mainListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {

            //Add click listner to get items
            @Override
            public void onItemClick(AdapterView<?> parent, View view,
                                    int position, long id) {
                String chatname=(mainListView.getItemAtPosition(position)).toString();
                chatDataList= new ArrayList<String>();
                for(Chat c:chatList){
                    if(chatname.equals(c.getChat_name())){
                        chatDataList.add(c.getChat_data());
                    }
                }
                Intent intent = new Intent(ChatHistoryActivity.this, HistoryViewActivity.class);
                intent.putExtra("chatname",chatname);
                intent.putStringArrayListExtra("chatdata",chatDataList);
                startActivity(intent);

            }
        });
    }

    }
