package com.starter.project.main.model

import androidx.databinding.ObservableField
import androidx.lifecycle.ViewModel
import com.starter.project.main.service.MainService
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import java.lang.Exception
import javax.inject.Inject

class MainViewModel @Inject constructor(
    private val wordUpService: MainService
) : ViewModel() {

    val word = ObservableField("old")

    fun nextWord() = GlobalScope.launch(Dispatchers.IO) {
        try {
            val newWord = wordUpService.getWord()
            setNewWord(newWord)
        } catch (e: Exception) {
            e.printStackTrace()
        }
    }

    private suspend fun setNewWord(newWord: String) = withContext(Dispatchers.Main) {
        word.set(newWord)
    }
}