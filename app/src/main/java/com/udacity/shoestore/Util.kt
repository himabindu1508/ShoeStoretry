package com.udacity.shoestore

import android.os.Build
import android.text.Html
import android.text.Spanned
import com.udacity.shoestore.models.Shoe

fun formatShoes(shoes : List<Shoe>) : Spanned {
    val sb = StringBuilder()
    sb.apply {
        shoes.forEach { shoe ->
            append("\t\t ${shoe.name}<br>")
            append("\t\t ${shoe.size}<br>")
            append("\t\t ${shoe.company}<br>")
            append("\t\t ${shoe.description}<br><br><br>")
        }
    }
    if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.N)
    {
        return Html.fromHtml(sb.toString(), Html.FROM_HTML_MODE_LEGACY)
    }
    else
    {
        @Suppress("DEPRECATION")
        return Html.fromHtml(sb.toString())
    }
}