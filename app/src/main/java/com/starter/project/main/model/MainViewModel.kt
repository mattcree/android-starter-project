package com.starter.project.main.model

import androidx.databinding.ObservableField
import androidx.lifecycle.ViewModel
import com.starter.project.main.service.MainService
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import javax.inject.Inject

class MainViewModel @Inject constructor(
    private val mainService: MainService
) : ViewModel() {

    val word = ObservableField("old")

    fun nextWord() = GlobalScope.launch(Dispatchers.IO) {
        setNewWord(mainService.newWord())
    }

    private suspend fun setNewWord(newWord: String) = withContext(Dispatchers.Main) {
        word.set(newWord)
    }
}