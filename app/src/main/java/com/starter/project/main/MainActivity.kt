package com.starter.project.main

import android.os.Bundle
import com.starter.project.base.BaseActivity
import com.starter.project.databinding.ActivityMainBinding
import com.starter.project.main.model.MainActivityViewModel
import javax.inject.Inject

class MainActivity : BaseActivity() {

    @Inject lateinit var viewModel: MainActivityViewModel
    @Inject lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding.vm = viewModel
        setContentView(binding.root)
    }
}