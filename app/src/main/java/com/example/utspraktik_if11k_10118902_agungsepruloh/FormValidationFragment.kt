package com.example.utspraktik_if11k_10118902_agungsepruloh

import android.app.AlertDialog
import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.findNavController
import com.example.utspraktik_if11k_10118902_agungsepruloh.databinding.FormValidationFragmentBinding


class FormValidationFragment : Fragment() {
    private lateinit var viewModel: FormValidationViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?,
    ): View? {
        val binding = DataBindingUtil.inflate<FormValidationFragmentBinding>(inflater,
            R.layout.form_validation_fragment, container, false)
        viewModel = ViewModelProvider(this).get(FormValidationViewModel::class.java)

        val args = FormValidationFragmentArgs.fromBundle(requireArguments())

        binding.apply {
            nikTxt.text = args.nik
            nameTxt.text = args.name
            birthDateTxt.text = args.birthDate
            sexTxt.text = args.sex
            relationTxt.text = args.relation
        }

        binding.buttonSave.setOnClickListener {
            showDialog()
        }

        binding.buttonChange.setOnClickListener{ view ->
            view.findNavController().popBackStack()
        }

        return binding.root
    }

    private fun showDialog() {
        val alertDialog = AlertDialog.Builder(context)
        val factory = LayoutInflater.from(context)
        val view: View = factory.inflate(R.layout.sample, null)
        alertDialog.setView(view)
        alertDialog.setPositiveButton("Ok") { _, _ ->
            quitApp()
        }
        alertDialog.show()
    }

    private fun quitApp() {
        val intent = Intent(Intent.ACTION_MAIN)
        intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP)
        intent.addCategory(Intent.CATEGORY_HOME)
        startActivity(intent)
    }
}