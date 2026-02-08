package com.example.storeappjetpack.ui.navigation

sealed class Screen(val route: String) {

    data object Splash : Screen("splash_screen")
    data object Home : Screen("home_screen")
    data object Category : Screen("Category_screen")
    data object Basket : Screen("Basket_screen")
    data object Profile : Screen("Profile_screen")
    data object WebView : Screen("web_view")
    data object CheckOutScreen : Screen("CheckOutScreen")
    data object ConfirmPurchase : Screen("ConfirmPurchase")
    data object ProductDetail : Screen("ProductDetail")
    data object ProductDescription : Screen("ProductDescription")
    data object ProductTechnicalFeatures : Screen("ProductTechnicalFeatures")
    data object NewCommentScreen : Screen("NewCommentScreen")
    data object AllCommentScreen : Screen("AllCommentScreen")
    data object ProductPriceChartScreen : Screen("ProductPriceChartScreen")
    data object Setting : Screen("Setting")
    data object UserAccount : Screen("UserAccount")
    data object FavoriteList : Screen("FavoriteList")
    data object ShowAddressScreen : Screen("ShowAddressScreen")
    data object AddAddressScreen : Screen("AddAddressScreen")
    data object OrderTabLayoutScreen : Screen("OrderTabLayoutScreen")
    data object Magnet : Screen("MagnetScreen")
    data object ShowStory : Screen("ShowStoryScreen")
    data object SubCategoryScreen:Screen("SubCategoryScreen")

    fun withArgs(vararg arg: Any): String {
        return buildString {
            append(route)
            arg.forEach {
                append("/$it")
            }
        }
    }


}