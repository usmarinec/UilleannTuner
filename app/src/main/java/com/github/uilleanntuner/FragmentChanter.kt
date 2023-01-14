package com.github.uilleanntuner

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import androidx.navigation.fragment.findNavController
import com.github.uilleanntuner.databinding.FragmentChanterBinding
import com.github.uilleanntuner.databinding.ContentMainBinding

/**
 * A simple [Fragment] subclass as the default destination in the navigation.
 */
class FragmentChanter : Fragment() {

    private var _binding: FragmentChanterBinding? = null

    // This property is only valid between onCreateView and
    // onDestroyView.
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        _binding = FragmentChanterBinding.inflate(inflater, container, false)
        return binding.root

    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
//        this.tuningComponent = CHANTER
//        setNavButtons()
//        view.findViewById<Button>(R.id.button_drones).setOnClickListener {
//            findNavController().navigate(R.id.action_ChanterFragment_to_DronesFragment)
//        }
        binding.buttonFirst.setOnClickListener {
            findNavController().navigate(R.id.action_ChanterFragment_to_DronesFragment)
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}