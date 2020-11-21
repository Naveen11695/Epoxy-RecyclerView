package com.example.epoxy_recyclerview.model

import android.view.View
import android.widget.ImageView
import androidx.appcompat.widget.AppCompatTextView
import androidx.databinding.ViewDataBinding
import com.airbnb.epoxy.*
import com.airbnb.epoxy.databinding.BR
import com.example.epoxy_recyclerview.R
import com.example.epoxy_recyclerview.data.Profile

@EpoxyModelClass(layout = R.layout.view_holder_recently_active_item)
abstract class RecentlyActiveItemModel : DataBindingEpoxyModel() {

    @EpoxyAttribute
    lateinit var profile: Profile

    override fun setDataBindingVariables(binding: ViewDataBinding?) {
        binding?.setVariable(BR.profile, profile)
    }
}