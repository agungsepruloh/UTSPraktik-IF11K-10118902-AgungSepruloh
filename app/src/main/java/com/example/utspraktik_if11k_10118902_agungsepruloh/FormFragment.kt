package com.example.utspraktik_if11k_10118902_agungsepruloh

import androidx.lifecycle.ViewModelProvider
import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.RadioButton
import android.widget.Toast
import androidx.databinding.DataBindingUtil
import androidx.navigation.Navigation
import androidx.navigation.findNavController
import com.example.utspraktik_if11k_10118902_agungsepruloh.databinding.FormFragmentBinding

class FormFragment : Fragment() {
    private lateinit var viewModel: FormViewModel
    private lateinit var binding: FormFragmentBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?,
    ): View? {
        binding = DataBindingUtil.inflate<FormFragmentBinding>(inflater,
            R.layout.form_fragment, container, false)
        viewModel = ViewModelProvider(this).get(FormViewModel::class.java)

        binding.nextBtn.setOnClickListener{ view: View ->
            if (!isValid()) showError()
            else navigate(view)
        }

        return binding.root
    }

    private fun isValid(): Boolean {
        binding.apply {
            return nikInput.text.isNotEmpty() and
                    nameInput.text.isNotEmpty() and
                    birthDateInput.text.isNotEmpty() and
                    (genderGroup.checkedRadioButtonId != -1) and
                    (relationGroup.checkedRadioButtonId != -1)
        }
    }

    private fun showError() {
        Toast
            .makeText(context, resources.getString(R.string.error_message), Toast.LENGTH_SHORT)
            .show()
    }

    private fun navigate(view: View) {
        view.findNavController()
            .navigate(FormFragmentDirections.actionFormFragmentToFormValidationFragment(
                binding.nikInput.text.toString(),
                binding.nameInput.text.toString(),
                binding.birthDateInput.text.toString(),
                binding.root.findViewById<RadioButton>(binding.genderGroup.checkedRadioButtonId)?.text.toString(),
                binding.root.findViewById<RadioButton>(binding.relationGroup.checkedRadioButtonId)?.text.toString(),
            ))
    }
}