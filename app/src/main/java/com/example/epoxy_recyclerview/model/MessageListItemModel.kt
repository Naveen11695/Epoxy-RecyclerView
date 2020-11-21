package com.example.epoxy_recyclerview.model

import androidx.databinding.ViewDataBinding
import com.airbnb.epoxy.*
import com.airbnb.epoxy.databinding.BR
import com.example.epoxy_recyclerview.R
import com.example.epoxy_recyclerview.database.Messages

@EpoxyModelClass(layout = R.layout.view_holder_message_list_item)
abstract class MessageListItemModel : DataBindingEpoxyModel() {

    @EpoxyAttribute
    lateinit var message: Messages

    override fun setDataBindingVariables(binding: ViewDataBinding?) {
        binding?.setVariable(BR.message, message)
    }
}