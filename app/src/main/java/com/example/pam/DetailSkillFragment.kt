package com.example.pam

import androidx.lifecycle.ViewModelProvider
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.navArgs
import com.example.pam.databinding.FragmentDetailSkillBinding

class DetailSkillFragment : Fragment() {

    private var _binding: FragmentDetailSkillBinding? = null

    private val binding get() = _binding!!

    companion object{
        var EXTRA_NAME = "extra_name"
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentDetailSkillBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        if (arguments != null){
            val name = arguments?.getString(EXTRA_NAME)
            binding.tvName.text = name
        }
    }

}