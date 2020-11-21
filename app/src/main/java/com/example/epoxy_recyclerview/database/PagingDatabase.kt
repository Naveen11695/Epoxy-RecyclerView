package com.example.epoxy_recyclerview.database

import androidx.paging.DataSource
import androidx.room.*

@Database(entities = [Messages::class], version = 1)
abstract class PagingDatabase : RoomDatabase() {
    abstract fun messagesDao(): MessagesDao
}

@Entity
data class Messages(
    @PrimaryKey(autoGenerate = true)
    var uid: Int,

    @ColumnInfo(name = "username")
    var username: String,

    @ColumnInfo(name = "content")
    var content: String,

    @ColumnInfo(name = "profileUrl")
    var profileUrl: String
)

@Dao
interface MessagesDao {
    @get:Query("SELECT * FROM Messages")
    val dataSource: DataSource.Factory<Int, Messages>

    @get:Query("SELECT * FROM Messages")
    val all: List<Messages>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertAll(users: List<Messages>)

    @Delete
    fun delete(users: List<Messages>)
}