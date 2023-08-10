package com.social.learnkotlin.view.report_problem_screen

import android.content.Context
import android.widget.Toast
import androidx.lifecycle.ViewModel
import androidx.navigation.NavController
import com.social.learnkotlin.navigation.Screens

class ReportProblemViewModel : ViewModel() {

    val TECHNICAL_ISSUE: String = "Technical Issue"
    val BAD_EXPERIENCCE: String = "Bad Experience"
    val SUGGESTION: String = "Suggestion"
    val OTHER: String = "Other"


    fun onIssueSelect(issue: String, navController: NavController) {
        navController.navigate(Screens.IssueDescribingScreen.withArgs(issue))
    }


    fun submitReport(
        issue: String,
        reportMessage: String,
        navController: NavController,
        context: Context
    ) {
        when (issue) {
            TECHNICAL_ISSUE -> {
                //Todo save in the desired category
            }

            BAD_EXPERIENCCE -> {
                //Todo save in the desired category

            }

            SUGGESTION -> {
                //Todo save in the desired category

            }

            OTHER -> {
                //Todo save in the desired category

            }
        }

        Toast.makeText(context, issue, Toast.LENGTH_LONG).show()
    }
}