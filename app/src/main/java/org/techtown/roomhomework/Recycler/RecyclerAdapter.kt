package org.techtown.roomhomework.Recycler

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import org.techtown.roomhomework.MainActivity
import org.techtown.roomhomework.R
import org.techtown.roomhomework.databinding.ItemBinding
import org.techtown.roomhomework.db.Dao
import org.techtown.roomhomework.db.Post

class RecyclerAdapter(val context: Context): RecyclerView.Adapter<RecyclerAdapter.ViewHolder>(){
    var posts: List<Post> = ArrayList()
    class ViewHolder(val binding: ItemBinding): RecyclerView.ViewHolder(binding.root) {

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerAdapter.ViewHolder {
        return ViewHolder(ItemBinding.bind(LayoutInflater.from(parent.context).inflate(R.layout.item,parent,false)))
    }

    override fun onBindViewHolder(holder: RecyclerAdapter.ViewHolder, position: Int) {
        holder.binding.post = posts[position]
        holder.binding.mainVm = context as MainActivity
    }

    override fun getItemCount(): Int = posts.size
}