package com.example.finalspace.ui.character

import android.os.Bundle
import android.util.Log
import android.view.View
import androidx.appcompat.widget.SearchView
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.Observer
import com.example.finalspace.R
import com.example.finalspace.core.Result
import com.example.finalspace.data.remote.CharacterDataSource
import com.example.finalspace.databinding.FragmentCharacterBinding
import com.example.finalspace.presentation.CharacterViewModel
import com.example.finalspace.presentation.CharacterViewModelFactory
import com.example.finalspace.repository.CharacterRepositoryImpl
import com.example.finalspace.repository.RetrofitClient
import com.example.finalspace.ui.adapter.CharacterAdapter
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class CharacterFragment : Fragment(R.layout.fragment_character) {
    private lateinit var binding: FragmentCharacterBinding
    private val viewModel by viewModels<CharacterViewModel> {
        CharacterViewModelFactory(CharacterRepositoryImpl(CharacterDataSource(RetrofitClient.apiService)))
    }

    private lateinit var characterAdapter: CharacterAdapter
    private var currentSearchQuery: String? = null

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding = FragmentCharacterBinding.bind(view)
        characterAdapter = CharacterAdapter()
        binding.rvCharacter.adapter = characterAdapter

        binding.searchView.setOnQueryTextListener(object : SearchView.OnQueryTextListener {
            override fun onQueryTextSubmit(query: String?): Boolean {
                if (!query.isNullOrEmpty()) {
                    currentSearchQuery = query

                }

                return false
            }


            override fun onQueryTextChange(newText: String?): Boolean {
                return false
            }

        })





        viewModel.fetchAllCharacter().observe(viewLifecycleOwner, Observer { result ->
            when (result) {
                is Result.Loading -> {
                    binding.progressBar.visibility = View.VISIBLE
                    Log.d("livedata", "Loading...")
                }

                is Result.Success -> {
                    binding.progressBar.visibility = View.GONE
                    val characterList = result.data
                    characterAdapter.setData(characterList)
                    Log.d("livedata", "${result.data}")

                }

                is Result.Failure -> {
                    binding.progressBar.visibility = View.GONE
                    Log.d("Error", "${result.exception}")
                }
            }

        })

        viewModel.fetchCharacterByName().observe(viewLifecycleOwner, Observer { result ->
            when (result) {
                is Result.Loading -> {
                    binding.progressBar.visibility = View.VISIBLE
                    Log.d("livedata", "Loading...")
                }

                is Result.Success -> {
                    binding.progressBar.visibility = View.GONE
                    val characterList = result.data
                    characterAdapter.setData(characterList)
                    Log.d("livedata", "${result.data}")

                }

                is Result.Failure -> {
                    binding.progressBar.visibility = View.GONE
                    Log.d("Error", "${result.exception}")
                }
            }

        })
    }
}



