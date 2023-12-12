package com.example.rickandmortyapp.ui.List

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.lifecycleScope
import androidx.recyclerview.widget.GridLayoutManager
import com.example.rickandmortyapp.databinding.FragmentCharacterListBinding
import com.example.rickandmortyapp.network.NetworkModule
import com.example.rickandmortyapp.network.RickAndMortyApiService
import com.example.rickandmortyapp.network.response.RickAndMortyResponse
import com.example.rickandmortyapp.ui.List.adapter.CharacterListAdapter
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import retrofit2.Retrofit


@AndroidEntryPoint
class CharacterListFragment : Fragment() {

    private lateinit var characterListAdapter: CharacterListAdapter

    private var _binding: FragmentCharacterListBinding? = null
    private val binding get() = _binding!!

   private  lateinit var retrofit: Retrofit


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initUI()
    }

    private fun initUI() {
        retrofit = NetworkModule.provideRetrofit()
        characterListAdapter = CharacterListAdapter(emptyList())
        lifecycleScope.launch {
            val characterList = retrofit.create(RickAndMortyApiService::class.java).getCharacters()
            if (characterList.isSuccessful) {
                val response : RickAndMortyResponse? = characterList.body()
                if (response != null) {
                    withContext(Dispatchers.Main) {
                        characterListAdapter.updateList(response.characters)
                    }
                }
            }
        }
        binding.rvCharacterList.apply {
            layoutManager = GridLayoutManager(context, 2)
            adapter = characterListAdapter
        }
    }


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentCharacterListBinding.inflate(layoutInflater, container, false)
        return binding.root
    }
}

