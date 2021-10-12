package com.alan.gamedesigncp5.ui.fragment

import android.annotation.SuppressLint
import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.DialogFragment
import com.alan.gamedesigncp5.databinding.FragmentDialogBinding
import com.alan.gamedesigncp5.ui.MainActivity
import com.alan.gamedesigncp5.ui.MenuActivity
import com.alan.gamedesigncp5.utils.SetBackgroundChoice
import com.alan.gamedesigncp5.utils.Utils.showLogInfo

class DialogFragment(
    private val name: String,
    private val result: String)
    : DialogFragment() {

    private lateinit var binding: FragmentDialogBinding
    companion object{
        const val TAG = "DialogFragment"
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        // Inflate the layout for this fragment
        binding = FragmentDialogBinding.inflate(layoutInflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        showLogInfo(TAG, "onViewCreated...")
        setOnClickListener()
    }

    private fun setOnClickListener() {
        binding.btnResumeGame.setOnClickListener {
            val setBgChoice = SetBackgroundChoice(requireContext() as MainActivity)
            setBgChoice.resetBackgroundChoice()
            startActivity(requireActivity().intent)
            dismiss()
        }

        binding.btnBackMenu.setOnClickListener {
            val intent = Intent(requireActivity(), MenuActivity::class.java)
            intent.putExtra(MenuActivity.KEY_NAME_FROM_DIALOG, name)
            startActivity(intent)
        }
    }

    @SuppressLint("SetTextI18n")
    override fun onStart() {
        super.onStart()
        showLogInfo(TAG, "onStart...")
        binding.tvResultGame.text = "$name $result!"
    }

    override fun onResume() {
        showLogInfo(TAG, "onResume...")
        super.onResume()
        dialog?.window?.setBackgroundDrawableResource(android.R.color.transparent)
        dialog?.window?.setLayout(
            ViewGroup.LayoutParams.MATCH_PARENT,
            ViewGroup.LayoutParams.WRAP_CONTENT
        )
    }
}