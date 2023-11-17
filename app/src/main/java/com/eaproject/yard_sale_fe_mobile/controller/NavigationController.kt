package com.eaproject.yard_sale_fe_mobile.controller

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.eaproject.yard_sale_fe_mobile.controller.utils.ScreenNav
import com.eaproject.yard_sale_fe_mobile.core.Username
import com.eaproject.yard_sale_fe_mobile.layout.loginPage
import com.eaproject.yard_sale_fe_mobile.layout.homePage

@Composable
fun navigationTest(navController: NavHostController, viewModel: Username) {
//    NavHost(
//        navController = navController,
//        startDestination = ScreenNav.Login.name
//    ) {
//        composable(ScreenNav.Login.name) {
//            loginPage(viewModel) {
//                navController.navigate(ScreenNav.Homepage.name)
//            }
//        }
//        composable(ScreenNav.Homepage.name) {
//            homePage(viewModel) {
//                navController.navigate(ScreenNav.Login.name)
//            }
//        }
//    }
}