package com.test.viewmodel

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.lifecycle.ViewModelProviders
import com.test.viewmodel.repository.MainRepository
import com.test.viewmodel.ui.main.MainFragment
import com.test.viewmodel.ui.main.MainViewModel
import kotlinx.android.synthetic.main.main_activity.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.main_activity)

        MainRepository.prepare()

        val viewModel = ViewModelProviders.of(this).get(MainViewModel::class.java)
        viewModel.connectRepositoryObserver(this)

        button_1.setOnClickListener{ v ->
            MainRepository.getInstance().fetchData(1)
        }
        button_2.setOnClickListener{ v ->
            MainRepository.getInstance().fetchData(2)
        }
        button_3.setOnClickListener{ v ->
            MainRepository.getInstance().fetchData(3)
        }
    }

    override fun onDestroy() {
        super.onDestroy()
        MainRepository.release()
    }
}