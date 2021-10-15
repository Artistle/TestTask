package com.example.test.fragments.enterRequest.ui.fragments

import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import com.example.test.App
import com.example.test.Screen
import com.example.test.databinding.QuestionFragmentBinding
import com.example.test.fragments.enterRequest.ui.items.QuestionItem
import com.example.test.fragments.enterRequest.viewmodel.EnterRequestViewModel
import com.github.terrakok.cicerone.Router
import com.mikepenz.fastadapter.FastAdapter
import com.mikepenz.fastadapter.adapters.ItemAdapter
import javax.inject.Inject

class EnterRequestFragment : Fragment() {

    @Inject
    lateinit var router: Router

    private val viewModel: EnterRequestViewModel by viewModels()

    private lateinit var binding: QuestionFragmentBinding

    private val itemAdapter = ItemAdapter<QuestionItem>()

    private val fastAdapter = FastAdapter.with(itemAdapter).apply {
        onPreClickListener = { _, _, item, _ ->
            router.navigateTo(Screen.answerScreen(item.model))
            true
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = QuestionFragmentBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onAttach(context: Context) {
        super.onAttach(context)
        App.appComponent.inject(this)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setUpClickSearch()
        setUpRecycler()
        viewModel.apply {
            responseLiveData.observe(viewLifecycleOwner) { response ->
                response.items.map {
                    itemAdapter.add(QuestionItem(it))
                }
            }
        }
    }

    private fun setUpRecycler() {
        binding.recyclerViewQuestion.adapter = fastAdapter
    }

    private fun setUpClickSearch() {
        binding.btnSearch.setOnClickListener {
            viewModel.load(binding.searchInputText.text.toString())
        }
        binding.apply {

        }
    }
}