package com.unsoed.informatikamobile.ui.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.unsoed.informatikamobile.data.model.BookDoc
import com.unsoed.informatikamobile.databinding.ListBukuBinding

class BookAdapter(private var books: List<BookDoc>, private val onBookClickListener: OnBookClickListener) :
    RecyclerView.Adapter<BookAdapter.BookViewHolder>() {

    inner class BookViewHolder(val binding: ListBukuBinding) :
        RecyclerView.ViewHolder(binding.root)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): BookViewHolder {
        val binding = ListBukuBinding.inflate(
            LayoutInflater.from(parent.context),
            parent,
            false
        )
        return BookViewHolder(binding)
    }

    override fun getItemCount(): Int = books.size

    override fun onBindViewHolder(holder: BookViewHolder, position: Int) {
        val book = books[position]
        holder.binding.tvTitle.text = book.title ?: "No Title"
        holder.binding.tvAuthor.text = book.authorName?.joinToString(", ") ?: "Unknown Author"
        holder.binding.tvYear.text = book.firstPublishYear?.toString() ?: "-"

        holder.binding.root.setOnClickListener {
            onBookClickListener.onBookClick(book)
        }
    }

    fun setData(newBooks: List<BookDoc>) {
        books = newBooks
        notifyDataSetChanged()
    }
}

interface OnBookClickListener {
    fun onBookClick(book: BookDoc)
}