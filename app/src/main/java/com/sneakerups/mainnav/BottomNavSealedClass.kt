package com.sneakerups.mainnav

import com.sneakerups.R

sealed class BottomNavSealedClass(
        val route: String,
        val title: String,
        val icon: Int,
        val iconFocused: Int
) {

        //Home
        data object Home: BottomNavSealedClass(
                route = "home",
                title = "Home",
                icon = R.mipmap.deposit_ic,
                iconFocused = R.mipmap.deposit_ic
        )

        //Calendar
        data object Calendar: BottomNavSealedClass(
                route = "calendar",
                title = "Calendar ",
                icon = R.mipmap.deposit_ic,
                iconFocused = R.mipmap.deposit_ic
        )

        //Rank
        data object Rank: BottomNavSealedClass(
                route = "rank",
                title = "Rank",
                icon = R.mipmap.deposit_ic,
                iconFocused = R.mipmap.deposit_ic
        )

        //Profile
        data object Profile: BottomNavSealedClass(
                route = "profile",
                title = "Profile",
                icon = R.mipmap.deposit_ic,
                iconFocused = R.mipmap.deposit_ic
        )


}