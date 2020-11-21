package com.example.epoxy_recyclerview

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.epoxy_recyclerview.controller.HomeController
import com.example.epoxy_recyclerview.controller.HomePagingController
import com.example.epoxy_recyclerview.data.Data
import com.example.epoxy_recyclerview.database.Messages
import kotlinx.android.synthetic.main.activity_main.*


class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        /**
         *  >>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>> Dynamic Epoxy RecyclerView code >>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>
         */

      /*  val controller = HomeController()
        messagesView.setController(controller)

        controller.allMessages = Data.messages
        controller.recentlyActive = Data.recentlyActive*/


        /**
         *  >>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>> Paging using Epoxy RecyclerView code >>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>
         */

         val pagingController = HomePagingController<Messages>()

        val recyclerView = findViewById<RecyclerView>(R.id.messagesView)
        recyclerView.layoutManager = LinearLayoutManager(this)
        recyclerView.adapter = pagingController.adapter


        val viewModel = ViewModelProviders.of(this).get(ActivityViewModel::class.java)
        viewModel.pagedList.observe(
            this,
            Observer {
                pagingController.submitList(it)
            }
        )
    }
}