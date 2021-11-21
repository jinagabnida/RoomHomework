package org.techtown.roomhomework.db

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import androidx.room.Update

@Dao
interface Dao {
    @Query("SELECT * FROM Post")
    fun getAllData() : List<Post>

    @Insert
    fun insertData(vararg post: Post)

    @Update
    fun updateData(post: Post)

    @Query("DELETE FROM Post WHERE id= :id")
    fun deleteDataIndex(id: Int)
}