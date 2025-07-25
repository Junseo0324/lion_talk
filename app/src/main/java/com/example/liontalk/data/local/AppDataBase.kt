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
@Database(entities = [ChatRoomEntity::class, ChatMessageEntity::class], version = 18)
abstract class AppDataBase: RoomDatabase() {
    abstract fun chatRoomDao(): ChatRoomDao
    abstract fun chatMessageDaod(): ChatMessageDao

    companion object {
        private var _instance: AppDataBase? = null
        fun getInstance(context: Context): AppDataBase {
            return _instance ?: synchronized(this) {
                _instance ?: Room.databaseBuilder(
                    context.applicationContext,
                    AppDataBase::class.java,
                    "chat_db"
                ).fallbackToDestructiveMigration()
                    .build()
                    .also { _instance = it }
            }
        }
    }
//    companion object {
//        fun create(content : Context) : AppDataBase = Room.databaseBuilder(
//            content.applicationContext,
//            AppDataBase:: class.java,
//            "chat_db"
//        ).fallbackToDestructiveMigration().build()
//    }
}