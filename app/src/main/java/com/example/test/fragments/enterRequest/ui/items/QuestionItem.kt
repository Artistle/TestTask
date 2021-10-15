package com.example.test.fragments.enterRequest.ui.items

import android.view.View
import android.widget.ImageView
import android.widget.TextView
import com.bumptech.glide.Glide
import com.example.test.R
import com.example.test.models.QuestionModel
import com.mikepenz.fastadapter.FastAdapter
import com.mikepenz.fastadapter.items.ModelAbstractItem

class QuestionItem(request: QuestionModel) : ModelAbstractItem<QuestionModel, QuestionItem.ViewHolder>(request) {

    override val layoutRes: Int = R.layout.question_item

    override val type: Int = layoutRes

    override fun getViewHolder(v: View): ViewHolder = ViewHolder(v)

    class ViewHolder(view: View) : FastAdapter.ViewHolder<QuestionItem>(view) {

        private val imgAvatar: ImageView = itemView.findViewById(R.id.questionAvatar)
        private val textViewUsername: TextView = itemView.findViewById(R.id.questionUsername)
        private val textViewCreationDate: TextView = itemView.findViewById(R.id.questionDateCreation)
        private val textViewHeader: TextView = itemView.findViewById(R.id.questionHeader)
        private val textViewQuantity: TextView = itemView.findViewById(R.id.questionQuantityAnswer)

        override fun bindView(item: QuestionItem, payloads: List<Any>) {
            with(item.model) {
                bindUsername(owner.display_name)
                bindAvatar(owner.profile_image)
                bindDate(creation_date)
                bindHeader(title)
                bindQuantity(answer_count)
            }
        }

        override fun unbindView(item: QuestionItem) {

        }

        private fun bindUsername(username: String) {
            with(textViewUsername) {
                text = username
            }
        }

        private fun bindAvatar(url: String) {
            with(imgAvatar) {
                Glide.with(this)
                    .load(url)
                    .into(this)
            }
        }

        private fun bindHeader(header: String) {
            with(textViewHeader) {
                text = header
            }
        }

        private fun bindQuantity(quantity: Int) {
            with(textViewQuantity) {
                text = quantity.toString()
            }
        }

        private fun bindDate(date: Int) {
            with(textViewCreationDate) {
                text = date.toString()
            }
        }

    }
}