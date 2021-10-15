package com.example.test

import androidx.core.os.bundleOf
import com.example.test.fragments.answerFragment.ui.fragments.AnswerFragment
import com.example.test.fragments.enterRequest.ui.fragments.EnterRequestFragment
import com.example.test.models.QuestionModel
import com.github.terrakok.cicerone.androidx.FragmentScreen

object Screen {

    fun enterRequestScreen() = FragmentScreen { EnterRequestFragment() }

    fun answerScreen(item: QuestionModel) = FragmentScreen {
        AnswerFragment().apply {
            arguments = bundleOf("ITEMS" to item)
        }
    }
}