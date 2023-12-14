package com.example.rickandmortyapp.ui.List.view

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.lifecycleScope
import androidx.lifecycle.repeatOnLifecycle
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.GridLayoutManager
import com.example.rickandmortyapp.databinding.FragmentCharacterListBinding
import com.example.rickandmortyapp.ui.List.adapter.CharacterListAdapter
import com.example.rickandmortyapp.ui.List.viewmodel.CharacterListViewModel
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.launch



@AndroidEntryPoint
class CharacterListFragment : Fragment() {

    private val characterListViewModel by viewModels<CharacterListViewModel>()

    private lateinit var characterListAdapter: CharacterListAdapter

    private var _binding: FragmentCharacterListBinding? = null
    private val binding get() = _binding!!



    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        initUI()
    }

    private fun initUI() {
        characterListViewModel.getCharacters()
        characterListAdapter = CharacterListAdapter(emptyList(), onItemSelected = {
           findNavController().navigate(CharacterListFragmentDirections.actionCharacterListFragmentToDetailFragment2(it.id))
       })
        lifecycleScope.launch {
           repeatOnLifecycle(Lifecycle.State.STARTED){
               characterListViewModel.characters.collect{
                   characterListAdapter.updateList(it)
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

