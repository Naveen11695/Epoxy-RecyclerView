package com.example.epoxy_recyclerview.data

import android.content.Context
import com.example.epoxy_recyclerview.database.Messages
import com.google.gson.Gson
import java.io.ByteArrayOutputStream
import java.io.IOException
import java.io.InputStream


object Data {

    fun jsonData(context: Context): List<Messages> {
        val inputStream: InputStream = context.resources.openRawResource(com.example.epoxy_recyclerview.R.raw.data)
        val jsonString: String = readTextFile(inputStream)

        val gson = Gson()
        return gson.fromJson(jsonString, Array<Messages>::class.java).toList()
    }

    private fun readTextFile(inputStream: InputStream): String {
        val outputStream = ByteArrayOutputStream()

        val buf = ByteArray(1024)
        var len: Int
        try {
            while (inputStream.read(buf).also { len = it } != -1) {
                outputStream.write(buf, 0, len)
            }
            outputStream.close()
            inputStream.close()
        } catch (e: IOException) {
        }
        return outputStream.toString()
    }

    val messages = listOf(
        Message(
            0,
            "Bella",
            "Seals are dumb right?",
            "https://i0.wp.com/www.engage-innovate.com/wp-content/uploads/2019/01/Jolene-Foo-Profile-Square.jpg?ssl=1"
        ),
        Message(
            1,
            "Marcus",
            "Excited for TGA. You?",
            "https://images.squarespace-cdn.com/content/v1/59e69a32b078695e0a01bd01/1562349702947-57ENGZU6AKQ82Z7S6H4T/ke17ZwdGBToddI8pDm48kC4EXbe1lHngxuPXFcJdZF57gQa3H78H3Y0txjaiv_0fDoOvxcdMmMKkDsyUqMSsMWxHk725yiiHCCLfrh8O1z5QPOohDIaIeljMHgDF5CVlOqpeNLcJ80NK65_fV7S1UcN16mDF27kuwLc8zh_1BUDBOQ46HaP-qJ8HsER-o3kDi8k3Sy4pRENMTFdprkci1g/profile_square.jpg"
        ),
        Message(
            2,
            "Veronica",
            "We should catch up sometime.",
            "https://www.classicaloasis.com/wp-content/uploads/2014/03/profile-square.jpg"
        ),
        Message(
            3,
            "Chris O’Sullivan",
            "I'm an Irish designer now working for Spotify.",
            "https://s3.amazonaws.com/cms-assets.tutsplus.com/uploads/users/810/profiles/19338/profileImage/profile-square-extra-small.png"
        ),
        Message(
            4,
            "Dawn Reed",
            "I am Co-Director of the Red Cedar Writing Project at Michigan State University, where she supports professional development work and coordinates research and training as part of the National Writing Project.",
            "https://elireview.com/wp-content/uploads/2016/12/reed-profile-square.jpg"
        ),
        Message(
            5,
            "opulent",
            "We should catch up sometime.",
            "https://i2.wp.com/worldbusinessfitness.com/wp-content/uploads/2018/01/opulent-profile-square-07.jpg?w=300&ssl=1"
        ),
        Message(
            6,
            "Carla Silva",
            "Professor, Clinical, Institutional and Hospital Psychopedagogue; Mediator of the PEI (Instrumental Enrichment Program) by NDPC Israel; Screener - enabled by the Eye Hospital Dr. Ricardo Guimarães, Belo Horizonte - for the evaluation of Irlen Syndrome (Learning Difficulty related to vision).",
            "https://cdn.shortpixel.ai/client/to_webp,q_glossy,ret_img,w_300/https://oficinadainteligencia.com.br/wp-content/uploads/2019/07/opulent-profile-square-05.jpg"
        )
    )

    val recentlyActive = listOf(
        Profile(
            0,
            "Veronica",
            "https://www.classicaloasis.com/wp-content/uploads/2014/03/profile-square.jpg",
            "2 min ago"
        ),
        Profile(
            1,
            "Marcus",
            "https://images.squarespace-cdn.com/content/v1/59e69a32b078695e0a01bd01/1562349702947-57ENGZU6AKQ82Z7S6H4T/ke17ZwdGBToddI8pDm48kC4EXbe1lHngxuPXFcJdZF57gQa3H78H3Y0txjaiv_0fDoOvxcdMmMKkDsyUqMSsMWxHk725yiiHCCLfrh8O1z5QPOohDIaIeljMHgDF5CVlOqpeNLcJ80NK65_fV7S1UcN16mDF27kuwLc8zh_1BUDBOQ46HaP-qJ8HsER-o3kDi8k3Sy4pRENMTFdprkci1g/profile_square.jpg",
            "16 min ago"
        ),
        Profile(
            2,
            "Dawn Reed",
            "https://elireview.com/wp-content/uploads/2016/12/reed-profile-square.jpg",
            "21 min ago"
        ),
        Profile(
            3,
            "Carla Silva",
            "https://cdn.shortpixel.ai/client/to_webp,q_glossy,ret_img,w_300/https://oficinadainteligencia.com.br/wp-content/uploads/2019/07/opulent-profile-square-05.jpg",
            "2 min ago"
        ),
        Profile(
            4,
            "Veronica",
            "https://www.classicaloasis.com/wp-content/uploads/2014/03/profile-square.jpg",
            "16 min ago"
        ),
    )
}