package com.alan.gamedesigncp5.ui.fragment

import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.alan.gamedesigncp5.databinding.FragmentFormBinding
import com.alan.gamedesigncp5.utils.OnTextChange

class FormFragment : Fragment() {

    private lateinit var binding: FragmentFormBinding
    private var onTextChange: OnTextChange? = null
    fun setOnTextChange(onTextChange: OnTextChange) {
        this.onTextChange = onTextChange
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        // Inflate the layout for this fragment
        binding = FragmentFormBinding.inflate(layoutInflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        editTextWatcher()
    }

    private fun editTextWatcher() {
        binding.edtName.addTextChangedListener(object : TextWatcher {
            override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {
            }
            override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {
            }
            override fun afterTextChanged(s: Editable?) {
                onTextChange?.visibleButtonNext(s.toString())
            }

        })
    }

}