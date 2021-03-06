package com.example.epoxy_recyclerview.model

import android.view.View
import androidx.appcompat.widget.AppCompatTextView
import androidx.databinding.ViewDataBinding
import com.airbnb.epoxy.*
import com.airbnb.epoxy.databinding.BR
import com.example.epoxy_recyclerview.R

@EpoxyModelClass(layout = R.layout.view_holder_header_item)
abstract class HeaderItemModel : DataBindingEpoxyModel() {

    @EpoxyAttribute
    lateinit var title: String

    override fun setDataBindingVariables(binding: ViewDataBinding?) {
        binding?.setVariable(BR.header, title)
    }
}