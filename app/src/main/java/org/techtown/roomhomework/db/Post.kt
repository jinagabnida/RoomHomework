package org.techtown.roomhomework.db

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
class Post (
    var title: String,
    var content: String
    ){
    @PrimaryKey(autoGenerate = true)
    var id : Int = 0;
}