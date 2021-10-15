package com.example.test.fragments.answerFragment.ui.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import com.bumptech.glide.Glide
import com.example.test.databinding.AnswerFragmentBinding
import com.example.test.fragments.answerFragment.ui.items.AnswerItem
import com.example.test.fragments.answerFragment.viewmodel.AnswerViewModel
import com.example.test.models.QuestionModel
import com.mikepenz.fastadapter.FastAdapter
import com.mikepenz.fastadapter.adapters.ItemAdapter

class AnswerFragment : Fragment() {

    private val viewModel: AnswerViewModel by viewModels()

    private lateinit var binding: AnswerFragmentBinding

    private val itemAdapter = ItemAdapter<AnswerItem>()

    private val fastAdapter = FastAdapter.with(itemAdapter)

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = AnswerFragmentBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setUpRecycler()
        viewModel.apply {
            setItem(arguments?.get("ITEMS") as QuestionModel)
            answerLiveData.observe(viewLifecycleOwner) {
                it.models?.map { answer ->
                    itemAdapter.add(AnswerItem(answer))
                }
            }
            items.observe(viewLifecycleOwner) {
                bindView(it)
            }
        }
    }

    private fun setUpRecycler() {
        binding.recyclerViewAnswer.adapter = fastAdapter
    }

    private fun bindView(item: QuestionModel) {
        binding.apply {
            answerUsername.text = item.owner.display_name
            answerHeader.text = item.title
            answerDateCreation.text = item.creation_date.toString()

            Glide.with(this@AnswerFragment)
                .load(item.owner.profile_image)
                .into(answerAvatar)
        }
    }
}