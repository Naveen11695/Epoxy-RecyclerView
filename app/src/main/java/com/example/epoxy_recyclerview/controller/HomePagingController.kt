package com.example.epoxy_recyclerview.controller

import com.airbnb.epoxy.EpoxyModel
import com.airbnb.epoxy.paging.PagedListEpoxyController
import com.example.epoxy_recyclerview.database.Messages
import com.example.epoxy_recyclerview.model.MessageListItemModel_

class HomePagingController<T> : PagedListEpoxyController<T>() {

    override fun buildItemModel(currentPosition: Int, item: T?): EpoxyModel<*> {
        return if (item == null) {
            MessageListItemModel_()
                .id(-currentPosition)
        } else {
            MessageListItemModel_()
                .id((item as Messages).uid)
                .message(item as Messages)
        }
    }

    init {
        isDebugLoggingEnabled = true
    }

    override fun onExceptionSwallowed(exception: RuntimeException) {
        throw exception
    }
}

