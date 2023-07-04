package com.example.task2

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import com.example.task2.databinding.FragmentMainBinding
import com.example.task2.databinding.FragmentProfileBinding

class MainFragment : Fragment(R.layout.fragment_main) {
    private var binding: FragmentMainBinding? = null

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding = FragmentMainBinding.bind(view)


        binding?.run {
            btnTo1.setOnClickListener{
                findNavController().navigate(R.id.action_mainFragment_to_test1Fragment)
            }
            btnTo2.setOnClickListener{
                findNavController().navigate(R.id.action_mainFragment_to_test2Fragment)
            }
        }
    }
    override fun onDestroyView() {
        super.onDestroyView()
        binding = null
    }
}