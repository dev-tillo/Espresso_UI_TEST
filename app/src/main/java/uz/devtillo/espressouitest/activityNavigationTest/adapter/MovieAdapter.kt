package uz.devtillo.espressouitest.activityNavigationTest.adapter

import android.annotation.SuppressLint
import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import uz.devtillo.espressouitest.databinding.ItemMovieBinding
import uz.devtillo.espressouitest.model.Movie

class MovieAdapter(private var context: Context, private var listener: onItemClicked) :
    ListAdapter<Movie, MovieAdapter.Vh>(MyDiffUtil()) {

    class MyDiffUtil :
        DiffUtil.ItemCallback<Movie>() {
        override fun areItemsTheSame(
            oldItem: Movie,
            newItem: Movie,
        ): Boolean {
            return oldItem.id == newItem.id
        }

        @SuppressLint("DiffUtilEquals")
        override fun areContentsTheSame(
            oldItem: Movie,
            newItem: Movie,
        ): Boolean {
            return oldItem == newItem
        }
    }

    inner class Vh(var itemSubjectBinding: ItemMovieBinding) :
        RecyclerView.ViewHolder(itemSubjectBinding.root) {
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): Vh {
        return Vh(
            ItemMovieBinding.inflate(
                LayoutInflater.from(parent.context),
                parent,
                false
            )
        )
    }

    interface onItemClicked {
        fun onClicked(url: Movie, position: Int)
    }

    override fun onBindViewHolder(holder: Vh, position: Int) {
        val item = getItem(position)
        holder.itemSubjectBinding.apply {
            try {
                movieTitle.text = item.title
                item.star_actors?.let {
                    for (index in 0 until it.size) {
                        var appendValue: String = it[index]
                        if (index < (it.size - 1)) {
                            appendValue += ", "
                        }
                        movieStarActors.append(appendValue)
                    }
                }

                Glide.with(context)
                    .load(item.image)
                    .into(movieImage)

                movieImage.setOnClickListener {
                    listener.onClicked(item, position)
                }
            } catch (e: Exception) {
                e.printStackTrace()
            }
        }
    }
}