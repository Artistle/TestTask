package com.example.test.fragments.answerFragment.ui.fragments

import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.bumptech.glide.Glide
import com.example.test.databinding.AnswerFragmentBinding
import com.example.test.fragments.answerFragment.ui.items.AnswerItem
import com.example.test.fragments.answerFragment.viewmodel.AnswerViewModel
import com.example.test.models.QuestionModel
import com.mikepenz.fastadapter.FastAdapter
import com.mikepenz.fastadapter.adapters.ItemAdapter
import android.content.Intent
import android.net.Uri
import com.example.test.App
import com.example.test.R
import com.example.test.base.BaseFragment
import com.example.test.base.InjectingSavedStateViewModelFactory
import javax.inject.Inject


class AnswerFragment :
    BaseFragment<AnswerViewModel>(AnswerViewModel::class, R.layout.answer_fragment) {

    @Inject
    override lateinit var abstractViewModelFactory: InjectingSavedStateViewModelFactory

    private lateinit var binding: AnswerFragmentBinding

    private val itemAdapter = ItemAdapter<AnswerItem>()

    private val fastAdapter = FastAdapter.with(itemAdapter)

    private lateinit var questionModel: QuestionModel

    override fun onAttach(context: Context) {
        super.onAttach(context)
        App.appComponent.inject(this)
    }

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
            setUpItems()
            answerLiveData.observe(viewLifecycleOwner) {
                it.models?.map { answer ->
                    itemAdapter.add(AnswerItem(answer))
                }
            }
            items.observe(viewLifecycleOwner) {
                bindView(it)
                questionModel = it
            }
        }
    }

    override fun onStart() {
        super.onStart()
        binding.answerAvatar.setOnClickListener {
            openUserProfile()
        }
    }

    private fun setUpRecycler() {
        binding.recyclerViewAnswer.adapter = fastAdapter
    }

    private fun openUserProfile() {
        val intent = Intent(Intent.ACTION_VIEW).apply {
            data = Uri.parse(questionModel.owner.link)
        }
        requireActivity().startActivity(intent)

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