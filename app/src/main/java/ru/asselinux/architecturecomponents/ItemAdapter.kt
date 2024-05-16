package ru.asselinux.architecturecomponents

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.like.LikeButton
import ru.asselinux.architecturecomponents.data.Item


class ItemAdapter(private val context: Context) : RecyclerView.Adapter<ItemAdapter.ItemViewHolder>() {
    private val items: ArrayList<Item> = ArrayList()
    private var listener: OnItemClickListener? = null
    override fun onCreateViewHolder(
        parent: ViewGroup, viewType: Int): ItemViewHolder {
        val itemView: View = LayoutInflater.from(parent.context)
            .inflate(R.layout.list_item, parent, false)
        return ItemViewHolder(itemView)
    }

    override fun onBindViewHolder(
        holder: ItemViewHolder, position: Int
    ) {

        val currentPost = items[position]
        Glide.with(context).load(currentPost.urlImage).into(holder.image)
        holder.header.text=currentPost.header
        holder.full_text.text=currentPost.preview_text
        holder.theme_1.text=currentPost.theme_1
        holder.theme_2.text=currentPost.theme_2
        holder.theme_3.text=currentPost.theme_3
        holder.author.text=currentPost.author
        holder.timeOfCreation.text=currentPost.time_of_creation
        holder.likes.text=currentPost.count_of_likes.toString()
    }

    override fun getItemCount(): Int {
        return items.size
    }

    fun setItems(items: List<Item>) {
        this.items.clear()
        this.items.addAll(items)
        notifyDataSetChanged()
    }

    fun getItemAt(position: Int): Item {
        return items[position]
    }

    inner class ItemViewHolder(itemView: View) :
        RecyclerView.ViewHolder(itemView) {
        val likeButton:LikeButton=itemView.findViewById(R.id.favorite)
        val image: ImageView = itemView.findViewById(R.id.image_theme)
        val header: TextView = itemView.findViewById(R.id.post_header)
        val full_text: TextView = itemView.findViewById(R.id.full_text)
        val likes:TextView=itemView.findViewById(R.id.count_of_likes)
        val theme_1: TextView = itemView.findViewById(R.id.theme_1)
        val theme_2: TextView = itemView.findViewById(R.id.theme_2)
        val theme_3: TextView = itemView.findViewById(R.id.theme_3)
        val author: TextView = itemView.findViewById(R.id.authors_of_post)
        val timeOfCreation:TextView=itemView.findViewById(R.id.timeOfCreation)


        init {
            itemView.setOnClickListener(View.OnClickListener {
                listener?.let { listener ->
                    val position: Int = adapterPosition
                    if (position in 0..itemCount) {
                        listener.onItemClick(items[position])
                    }
                }
            })
        }
    }

    fun setOnItemClickListener(listener: OnItemClickListener) {
        this.listener = listener
    }



    interface OnItemClickListener {
        fun onItemClick(item: Item?)
    }
}