package com.deora.kroomnotetakenav

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.get
import com.deora.kroomnotetakenav.database.NoteDatabase
import com.deora.kroomnotetakenav.databinding.ActivityMainBinding
import com.deora.kroomnotetakenav.repository.NoteRepository
import com.deora.kroomnotetakenav.viewmodel.NoteViewModel
import com.deora.kroomnotetakenav.viewmodel.NoteViewModelFactory

class MainActivity : AppCompatActivity() {
     lateinit var noteViewModel :NoteViewModel
     lateinit var binding: ActivityMainBinding


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding=ActivityMainBinding.inflate(layoutInflater)

        setContentView(binding.root)
        setUpViewModel()



    }

    private fun setUpViewModel() {
        val noteRepository=NoteRepository(NoteDatabase(this))

        val  viewModelProviderFactory=NoteViewModelFactory(application,noteRepository)


        noteViewModel= ViewModelProvider(
            this,
            viewModelProviderFactory).get(NoteViewModel::class.java)

    }
}