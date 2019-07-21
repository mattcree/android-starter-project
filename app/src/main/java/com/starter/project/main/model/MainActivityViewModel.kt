package com.starter.project.main.model

import androidx.databinding.ObservableField
import androidx.lifecycle.ViewModel
import com.starter.project.main.service.MainActivityService
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import javax.inject.Inject

class MainActivityViewModel @Inject constructor(
    private val mainService: MainActivityService
) : ViewModel() {

    val word = ObservableField("old")

    fun nextWord() = GlobalScope.launch(Dispatchers.IO) {
        try {
            setNewWord(mainService.newWord())
        } catch (e: MainActivityService.Exception) {
            e.printStackTrace()
        }
    }

    private suspend fun setNewWord(newWord: String) = withContext(Dispatchers.Main) {
        word.set(newWord)
    }
}