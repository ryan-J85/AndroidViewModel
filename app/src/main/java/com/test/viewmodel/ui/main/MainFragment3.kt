package com.test.viewmodel.ui.main

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import com.test.viewmodel.R
import kotlinx.android.synthetic.main.main_fragment.*

class MainFragment3 : Fragment() {
    companion object {
        val TAG:String = "MainFragment3"
    }

    private lateinit var viewModel: MainViewModel

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View {
        val view:View = inflater.inflate(R.layout.main_fragment, container, false)
        view.setBackgroundColor(0x7aff2f77)
        return view
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)

        viewModel = ViewModelProviders.of(requireActivity()).get(MainViewModel::class.java)
        viewModel.connectViewModelObserver(viewLifecycleOwner, updateViewModelObserver)

        fragment_title.setText("Fragment 3")
    }

    val updateViewModelObserver = Observer<String> {
        fragment_value.setText("${it}")
    }
}