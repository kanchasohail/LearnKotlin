package com.social.learnkotlin.view.bottom_and_top_bars

import com.social.learnkotlin.R
import com.social.learnkotlin.navigation.Screens

sealed class BottomNavItem(var title: String, var icon: Int, var screen_route: String) {

    object LearningScreen :
        BottomNavItem("Lessons", R.drawable.ic_learning, Screens.LessonsScreen.route)

    object EditorScreen :
        BottomNavItem("Editor", R.drawable.ic_editor, Screens.EditorScreen.route)

    object ProfileScreen : BottomNavItem("Profile", R.drawable.ic_profile, Screens.ProfileScreen.route)

}