package com.eaproject.yard_sale_fe_mobile.controller

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.eaproject.yard_sale_fe_mobile.controller.utils.ScreenNav
import com.eaproject.yard_sale_fe_mobile.core.Username
import com.eaproject.yard_sale_fe_mobile.layout.compOne
import com.eaproject.yard_sale_fe_mobile.layout.compTwo

@Composable
fun navigationTest(navController: NavHostController, viewModel: Username) {
    NavHost(
        navController = navController,
        startDestination = ScreenNav.PageOne.name
    ) {
        composable(ScreenNav.PageOne.name) {
            compOne(viewModel) {
                navController.navigate(ScreenNav.PageTwo.name)
            }
        }
        composable(ScreenNav.PageTwo.name) {
            compTwo(viewModel) {
                navController.navigate(ScreenNav.PageOne.name)
            }
        }
    }
}