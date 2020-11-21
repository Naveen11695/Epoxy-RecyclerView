package com.example.epoxy_recyclerview

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.paging.LivePagedListBuilder
import androidx.paging.PagedList
import androidx.room.Room
import com.example.epoxy_recyclerview.data.Data
import com.example.epoxy_recyclerview.database.Messages
import com.example.epoxy_recyclerview.database.PagingDatabase
import kotlinx.coroutines.*

class ActivityViewModel(app: Application) : AndroidViewModel(app) {
    private val context = getApplication<Application>().applicationContext

    val db by lazy {
        Room.inMemoryDatabaseBuilder(app, PagingDatabase::class.java).build()
    }
    val pagedList: LiveData<PagedList<Messages>> by lazy {
        LivePagedListBuilder<Int, Messages>(
            db.messagesDao().dataSource, 100
        ).build()
    }

    init {
        GlobalScope.launch {
            Data.jsonData(context).groupBy {
                    it.uid / 20
                }.forEach { group ->
                    withContext(Dispatchers.Default) {
                        delay(group.key.toLong())
                        db.messagesDao().insertAll(group.value)
                    }
                }
            }
    }
}