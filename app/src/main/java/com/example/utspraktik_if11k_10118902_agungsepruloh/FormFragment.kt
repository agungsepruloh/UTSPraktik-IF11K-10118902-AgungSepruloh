package com.example.utspraktik_if11k_10118902_agungsepruloh

import androidx.lifecycle.ViewModelProvider
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import com.example.utspraktik_if11k_10118902_agungsepruloh.databinding.FormFragmentBinding

class FormFragment : Fragment() {
    private lateinit var viewModel: FormViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?,
    ): View? {
        val binding = DataBindingUtil.inflate<FormFragmentBinding>(inflater,
            R.layout.form_fragment, container, false)
        viewModel = ViewModelProvider(this).get(FormViewModel::class.java)
        return binding.root
    }
}