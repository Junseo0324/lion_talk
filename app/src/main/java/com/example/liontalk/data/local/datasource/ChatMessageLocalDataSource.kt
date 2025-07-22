package com.example.liontalk.data.local.datasource

import android.content.Context
import androidx.lifecycle.LiveData
import com.example.liontalk.data.local.AppDataBase
import com.example.liontalk.data.local.entity.ChatMessageEntity

class ChatMessageLocalDataSource(context: Context) {
    private val dao = AppDataBase.create(context).chatMessageDao()

    suspend fun clear() {
        dao.clear()
    }

    suspend fun insert(message: ChatMessageEntity) {
        dao.insert(message)
    }

    fun getMessageForRoom(roomId: Int) : LiveData<List<ChatMessageEntity>> {
        return dao.getMessageForRoom(roomId)
    }

    suspend fun getMessages(roomId: Int) : List<ChatMessageEntity> {
        return dao.getMessages(roomId)
    }
}