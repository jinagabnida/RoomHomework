package org.techtown.roomhomework.db

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase

@Database(entities = [Post::class], version = 1)
abstract class AppDatabase : RoomDatabase() {
    abstract fun Dao() : Dao
    companion object{
        private var instance: AppDatabase? = null
        fun getInstance(context: Context): AppDatabase?{
            instance = Room.databaseBuilder(
                context,
                AppDatabase::class.java,
                "post_table"
            ).build()

            return instance
        }
    }

}