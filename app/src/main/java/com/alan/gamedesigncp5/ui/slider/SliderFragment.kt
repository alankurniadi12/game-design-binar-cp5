package com.alan.gamedesigncp5.ui.slider

import android.graphics.drawable.Drawable
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.alan.gamedesigncp5.databinding.FragmentSliderBinding

class SliderFragment(
    private val imageSlider: Drawable?,
    private val desc: String
) : Fragment() {

    private lateinit var binding: FragmentSliderBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        // Inflate the layout for this fragment
        binding = FragmentSliderBinding.inflate(layoutInflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.imgLandingPage.setImageDrawable(imageSlider)
        binding.tvDescription.text = desc
    }
}

