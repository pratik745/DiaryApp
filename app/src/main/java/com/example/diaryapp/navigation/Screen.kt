package com.example.diaryapp.navigation

import com.example.diaryapp.utils.Constants.WRITE_SCREEN_ARGUMENT_KEY

sealed class Screen(val route:String){
    object Authentication: Screen("authentication_screen")
    object Home: Screen("home_screen")
    object Write: Screen("write_screen?$WRITE_SCREEN_ARGUMENT_KEY={$WRITE_SCREEN_ARGUMENT_KEY}"){
        fun passDiaryId(diaryId: String) = "write_screen?$WRITE_SCREEN_ARGUMENT_KEY=$diaryId"
    }
}
