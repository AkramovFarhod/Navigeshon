package com.example.mynavigation.navigation

import androidx.annotation.DrawableRes
import com.example.mynavigation.R


sealed class Screens(val title: String, val route: String, @DrawableRes val icons: Int) {
    object Home:Screens(
        title = "Home",
        route = "home_route",
        icons = R.drawable.ic_baseline_home_24
    )
    object Favorite:Screens(
        title = "Favorite",
        route = "bookmarks_route",
        icons = R.drawable.ic_baseline_bookmarks_24
    )
    object Add:Screens(
        title = "Add",
        route = "person_route",
        icons = R.drawable.ic_baseline_person_add_24
    )
}
