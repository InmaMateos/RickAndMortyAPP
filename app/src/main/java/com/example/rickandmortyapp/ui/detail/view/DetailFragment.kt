package com.example.rickandmortyapp.ui.detail.view

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.view.isVisible
import androidx.fragment.app.viewModels
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.lifecycleScope
import androidx.lifecycle.repeatOnLifecycle
import androidx.navigation.fragment.navArgs
import com.bumptech.glide.Glide
import com.example.rickandmortyapp.databinding.FragmentDetailBinding
import com.example.rickandmortyapp.ui.detail.viewmodel.CharacterDetailViewModel
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.launch


@AndroidEntryPoint
class DetailFragment : Fragment() {

    private val characterDetailViewModel : CharacterDetailViewModel by viewModels()

    private  var _binding : FragmentDetailBinding? = null
    private val binding get() = _binding!!

    private val args: DetailFragmentArgs by navArgs()



    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        characterDetailViewModel.getCharacterDetail(args.characterId)
        initUI()
    }

    private fun initUI() {
        lifecycleScope.launch{
            repeatOnLifecycle(Lifecycle.State.STARTED){
                characterDetailViewModel.state.collect{
                    when(it){
                        CharacterDetailState.Loading -> loadingState()
                        is CharacterDetailState.Success -> successState(it)
                        is CharacterDetailState.Error -> errorState()
                    }
                }

            }
        }

    }

    private fun errorState() {
        binding.pbar.isVisible = false
    }

    private fun successState(state: CharacterDetailState.Success) {
        binding.pbar.isVisible = false
        binding.tvCharacterName.text = state.name
        binding.tvCharacterStatus.text = state.status
        binding.tvCharacterSpecies.text = state.species
        Glide.with(binding.ivCharacterImage)
            .load(state.image)
            .into(binding.ivCharacterImage)


    }

    private fun loadingState() {
        binding.pbar.isVisible = true
    }


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentDetailBinding.inflate(inflater, container, false)
        return binding.root
    }

}