package com.example.test.fragments.answerFragment.ui.items

import android.view.View
import android.widget.TextView
import com.example.test.R
import com.example.test.models.AnswerModel
import com.mikepenz.fastadapter.FastAdapter
import com.mikepenz.fastadapter.items.ModelAbstractItem

class AnswerItem(answer : AnswerModel) : ModelAbstractItem<AnswerModel, AnswerItem.ViewHolder>(answer) {

    override val layoutRes: Int = R.layout.answer_item

    override val type: Int = layoutRes

    override fun getViewHolder(v: View): ViewHolder = ViewHolder(v)

    class ViewHolder(view : View) : FastAdapter.ViewHolder<AnswerItem>(view) {

        private val textViewUsername: TextView = itemView.findViewById(R.id.answerUsername)
        private val textViewRating: TextView = itemView.findViewById(R.id.answerRating)
        private val textViewCreationDate: TextView = itemView.findViewById(R.id.answerDateCreation)

        override fun bindView(item: AnswerItem, payloads: List<Any>) {
            with(item.model) {
                textViewCreationDate.text = creation_date.toString()
                textViewRating.text = score.toString()
                textViewUsername.text = owner.display_name
            }
        }

        override fun unbindView(item: AnswerItem) {

        }
    }
}