package com.software_engineering.joyontasahasumanarahmansupti.DisasterRescueChat.data.DB;

import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteException;

import com.software_engineering.joyontasahasumanarahmansupti.DisasterRescueChat.data.model.Chat;


import java.util.ArrayList;


//class to manipulate Chat related data
public class SQLChatDAO {

    //add chat details to the database
    public void addChat(Chat chat){
        SQLiteDatabase db = null;

        try {
            db = DBAccess.getWritableDatabase();
            ContentValues values = new ContentValues();
            values.put(DBAccess.CHAT_NAME, chat.getChat_name());
            values.put(DBAccess.CHAT_DATA, chat.getChat_data());

            db.insert(DBAccess.CHAT_TB, null, values);
        }catch (SQLiteException e) {
            e.printStackTrace();
        } finally {
            if (db != null) {
                db.close();
            }
        }
    }

    //get the all chatlists
    public ArrayList<Chat> getChatList() {
        ArrayList<Chat> chatList = new ArrayList<>();
        SQLiteDatabase db = null;
        Cursor cursor = null;
        try {
            db = DBAccess.getWritableDatabase();

            cursor = db.query(DBAccess.CHAT_TB,null,null,null,null,null,null);// Get all chat lists from the database

            if (cursor.moveToFirst()) {
                do {

                    Chat chat = new Chat(cursor.getString(1), cursor.getString(2));
                    chatList.add(chat);
                } while (cursor.moveToNext());
            }
        } catch (SQLiteException e) {
            e.printStackTrace();
        } finally {
            if (cursor != null) {
                cursor.close();
            }
            if (db != null) {
                db.close();
            }
        }
        return chatList;
    }

    //get specified name related chat details
    public ArrayList<Chat> getChat(String chatname){
        SQLiteDatabase db = null;
        Cursor cursor = null;
        ArrayList<Chat> chatList = new ArrayList<>();
        try {
            db = DBAccess.getWritableDatabase();

            cursor = db.query(DBAccess.CHAT_TB, null, DBAccess.CHAT_NAME + " = ?", new String[]{chatname}, null, null, null);
            if (cursor != null) {
                do {

                    Chat chat = new Chat(cursor.getString(1), cursor.getString(2));
                    chatList.add(chat);
                } while (cursor.moveToNext());

            }
        } catch (SQLiteException e) {
            e.printStackTrace();
        } finally {
            if (cursor != null) {
                cursor.close();
            }
            if (db != null) {
                db.close();
            }
        }
        return chatList;
    }

}
