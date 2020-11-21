package com.example.epoxy_recyclerview.model

import androidx.databinding.ViewDataBinding
import com.airbnb.epoxy.DataBindingEpoxyModel
import com.airbnb.epoxy.EpoxyAttribute
import com.airbnb.epoxy.EpoxyModelClass
import com.airbnb.epoxy.databinding.BR
import com.example.epoxy_recyclerview.R
import com.example.epoxy_recyclerview.data.Message

@EpoxyModelClass(layout = R.layout.view_holder_message_item)
abstract class MessageItemModel : DataBindingEpoxyModel() {

    @EpoxyAttribute
    lateinit var message: Message

    override fun setDataBindingVariables(binding: ViewDataBinding?) {
        binding?.setVariable(BR.message, message)
    }
}