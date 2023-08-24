package com.social.learnkotlin.view.bottom_and_top_bars

import com.social.learnkotlin.R
import com.social.learnkotlin.navigation.Screens

sealed class BottomNavItem(var title: String, var icon: Int, var screenRoute: String) {

    object LearningScreen :
        BottomNavItem("Lessons", R.drawable.ic_learning, Screens.LessonsScreen.route)

    object CodesScreen :
        BottomNavItem("Codes", R.drawable.ic_editor, Screens.CodesScreen.route)

    object ProfileScreen : BottomNavItem("Profile", R.drawable.ic_profile, Screens.ProfileScreen.route)

}