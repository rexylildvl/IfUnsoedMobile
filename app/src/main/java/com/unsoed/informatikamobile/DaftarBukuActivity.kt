package com.unsoed.informatikamobile

import android.os.Bundle
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import com.unsoed.informatikamobile.ui.adapter.BookAdapter
import com.unsoed.informatikamobile.ui.adapter.OnBookClickListener
import com.unsoed.informatikamobile.databinding.ActivityDaftarBukuBinding
import com.unsoed.informatikamobile.viewmodel.MainViewModel
import com.unsoed.informatikamobile.data.model.BookDoc
import com.unsoed.informatikamobile.ui.fragment.BookDetailFragment

class DaftarBukuActivity : AppCompatActivity(), OnBookClickListener {

    private lateinit var binding: ActivityDaftarBukuBinding
    private val viewModel: MainViewModel by viewModels()
    private lateinit var adapter: BookAdapter // Jangan inisialisasi langsung di sini

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityDaftarBukuBinding.inflate(layoutInflater)
        setContentView(binding.root)

        // Inisialisasi adapter dengan listener
        adapter = BookAdapter(emptyList(), this) // Tambahkan 'this' sebagai listener

        binding.recyclerView.layoutManager = LinearLayoutManager(this)
        binding.recyclerView.adapter = adapter

        viewModel.books.observe(this) { books: List<BookDoc> ->
            adapter.setData(books)
        }

        viewModel.fetchBooks("kotlin programming")
    }

    override fun onBookClick(book: BookDoc) {
        book.let { b->
            BookDetailFragment(
                title = b.title ?: "-",
                author = b.authorName?.joinToString(", ") ?: "Unknown Author",
                year = "${b.firstPublishYear}",
                coverId = b.coverId ?: 0
            ).show(supportFragmentManager, BookDetailFragment::class.java.simpleName)
        }
    }
}