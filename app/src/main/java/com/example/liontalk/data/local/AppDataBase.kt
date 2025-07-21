package com.example.liontalk.data.local

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import androidx.room.TypeConverters
import com.example.liontalk.data.local.converter.Converter
import com.example.liontalk.data.local.dao.ChatMessageDao
import com.example.liontalk.data.local.dao.ChatRoomDao
import com.example.liontalk.data.local.entity.ChatMessageEntity
import com.example.liontalk.data.local.entity.ChatRoomEntity

@TypeConverters(Converter::class)
@Database(entities = [ChatRoomEntity::class, ChatMessageEntity::class], version = 1)
abstract class AppDataBase: RoomDatabase() {
    abstract fun chatRoomDao(): ChatRoomDao
    abstract fun chatMessageDao(): ChatMessageDao
    companion object {
        fun create(content : Context) : AppDataBase = Room.databaseBuilder(
            content.applicationContext,
            AppDataBase:: class.java,
            "chat_db"
        ).fallbackToDestructiveMigration().build()
    }
}