package com.test.viewmodel.ui.main

import androidx.lifecycle.ViewModelProviders
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.Observer
import com.test.viewmodel.databinding.MainFragmentBinding
import kotlinx.android.synthetic.main.main_fragment.*

class MainFragment : Fragment() {
    companion object {
        val TAG:String = "MainFragment"
    }

    private lateinit var mLayout: MainFragmentBinding
    private lateinit var viewModel: MainViewModel
    private var mViewData = MainViewData()

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View {

        mLayout = MainFragmentBinding.inflate(inflater)
        mLayout.data = mViewData

        mLayout.root.setBackgroundColor(0x7f0f0f0f)

        return mLayout.root
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)

        viewModel = ViewModelProviders.of(requireActivity()).get(MainViewModel::class.java)
        viewModel.connectViewModelObserver(viewLifecycleOwner, updateViewModelObserver)

        fragment_title.setText("Fragment 1")
    }

    val updateViewModelObserver = Observer<String> {
        mViewData.name = it
        mLayout.invalidateAll()
    }
}