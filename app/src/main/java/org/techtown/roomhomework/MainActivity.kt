package org.techtown.roomhomework

import android.app.PictureInPictureParams
import android.os.Binder
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.databinding.DataBindingUtil
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import org.techtown.roomhomework.Recycler.RecyclerAdapter
import org.techtown.roomhomework.databinding.ActivityMainBinding
import org.techtown.roomhomework.db.AppDatabase
import org.techtown.roomhomework.db.Post

class MainActivity : AppCompatActivity() {
    private lateinit var contentList : List<Post>
    private lateinit var binding: ActivityMainBinding
    private lateinit var adapter: RecyclerAdapter
    private lateinit var db: AppDatabase
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this,R.layout.activity_main)
        binding.mainVm = this
        adapter = RecyclerAdapter(this)
        binding.Recycler.adapter = adapter
        db = AppDatabase.getInstance(applicationContext)!!
        loadData()
    }

    fun deleteData(index: Int){
        CoroutineScope(Dispatchers.IO
        ).launch {
            db.Dao().deleteDataIndex(index)
            loadData()
        }
    }

    fun uploadData(){
        val title = binding.titleEditText.text.toString()
        val content = binding.contentEditText.text.toString()
        CoroutineScope(Dispatchers.IO).launch {
            db.Dao().insertData(Post(title, content))
            loadData()
        }
    }

    fun loadData() {
        CoroutineScope(Dispatchers.IO).launch {
            contentList = db.Dao().getAllData()
            runOnUiThread {
                adapter.posts = contentList
                adapter.notifyDataSetChanged()
            }
        }
    }
}