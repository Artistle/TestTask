package com.example.test.models

data class AnswerModel(
    val answer_id: Int,
    val content_license: String,
    val creation_date: Int,
    val is_accepted: Boolean,
    val last_activity_date: Int,
    val last_edit_date: Int,
    val owner: AnswerOwner,
    val question_id: Int,
    val score: Int
)

data class Answer(
    val has_more: Boolean,
    val models: List<AnswerModel>? = null,
    val quota_max: Int = 0,
    val quota_remaining: Int = 0
)

data class AnswerOwner(
    val account_id: Int,
    val display_name: String,
    val link: String,
    val profile_image: String,
    val reputation: Int,
    val user_id: Int,
    val user_type: String
)