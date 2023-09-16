package com.social.learnkotlin.view.bottom_and_top_bars

import com.social.learnkotlin.R
import com.social.learnkotlin.navigation.Screens

sealed class BottomNavItem(
    var title: String,
    var icon: Int,
    var screenRoute: String,
    var outlinedIcon: Int
) {

    object LearningScreen :
        BottomNavItem(
            title = "Lessons",
            icon = R.drawable.ic_lessons,
            outlinedIcon = R.drawable.ic_lessons_outlined,
            screenRoute = Screens.LessonsScreen.route
        )

    object CodesScreen :
        BottomNavItem(
            title = "Codes",
            icon = R.drawable.ic_editor,
            outlinedIcon = R.drawable.ic_editor_outlined,
            screenRoute = Screens.CodesScreen.route
        )

    object ProfileScreen :
        BottomNavItem(
            title = "Profile",
            icon = R.drawable.ic_profile,
            outlinedIcon = R.drawable.ic_profile_outlined,
            screenRoute = Screens.ProfileScreen.route
        )

}