package com.example.studentportal

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

@Parcelize
data class Portal(
    val name: String,
    val url:  String
) : Parcelable {
    companion object {
        val PORTAL_NAMES = arrayOf(
            "HvA",
            "Rooster",
            "Vlo",
            "Sis"
        )
        val PORTAL_URLS = arrayOf(
            "https://hva.nl",
            "https://rooster.hva.nl",
            "https://vlo.informatica.hva.nl",
            "https://sis.hva.nl"
        )
    }
}