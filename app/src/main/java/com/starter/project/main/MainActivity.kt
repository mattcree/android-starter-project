package com.starter.project.main

import android.os.Bundle
import android.view.LayoutInflater
import com.starter.project.base.BaseActivity
import com.starter.project.databinding.ActivityMainBinding
import com.starter.project.main.model.MainViewModel
import javax.inject.Inject

class MainActivity : BaseActivity() {

    @Inject lateinit var viewModel: MainViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val layoutInflater = LayoutInflater.from(this)
        val binding = ActivityMainBinding.inflate(layoutInflater)
        binding.vm = viewModel

        setContentView(binding.root)
    }
}