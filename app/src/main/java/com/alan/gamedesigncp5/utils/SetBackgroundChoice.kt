package com.alan.gamedesigncp5.utils

import android.os.Build
import androidx.annotation.RequiresApi
import com.alan.gamedesigncp5.ui.MainActivity
import com.alan.gamedesigncp5.utils.Utils.PAPER
import com.alan.gamedesigncp5.utils.Utils.ROCK
import com.alan.gamedesigncp5.utils.Utils.SCISSORS
import com.alan.gamedesigncp5.utils.Utils.colorBgChoice
import com.alan.gamedesigncp5.utils.Utils.resetBgChoice

class SetBackgroundChoice(
    private val activity: MainActivity
) {

    @RequiresApi(Build.VERSION_CODES.M)
    fun backgroundChoicePlayer1(player1: String) {
        if (player1 == SCISSORS) {
            activity.binding.imgGunting.colorBgChoice()
            activity.binding.imgBatu.resetBgChoice()
            activity.binding.imgKertas.resetBgChoice()
        } else if (player1 == ROCK) {
            activity.binding.imgGunting.resetBgChoice()
            activity.binding.imgBatu.colorBgChoice()
            activity.binding.imgKertas.resetBgChoice()
        } else if (player1 == PAPER) {
            activity.binding.imgKertas.colorBgChoice()
            activity.binding.imgBatu.resetBgChoice()
            activity.binding.imgGunting.resetBgChoice()
        }
    }

    @RequiresApi(Build.VERSION_CODES.M)
    fun backgroundChoicePlayer2(player2: String) {
        if (player2 == SCISSORS) {
            activity.binding.imgComGunting.colorBgChoice()
            activity.binding.imgComBatu.resetBgChoice()
            activity.binding.imgComKertas.resetBgChoice()
        } else if (player2 == ROCK) {
            activity.binding.imgComGunting.resetBgChoice()
            activity.binding.imgComBatu.colorBgChoice()
            activity.binding.imgComKertas.resetBgChoice()
        } else if (player2 == PAPER) {
            activity.binding.imgComKertas.colorBgChoice()
            activity.binding.imgComBatu.resetBgChoice()
            activity.binding.imgComGunting.resetBgChoice()
        }
    }

    @RequiresApi(Build.VERSION_CODES.M)
    fun backgroundChoiceCom(com: String) {
        if (com == SCISSORS) {
            activity.binding.imgComGunting.colorBgChoice()
            activity.binding.imgComBatu.resetBgChoice()
            activity.binding.imgComKertas.resetBgChoice()
        } else if (com == ROCK) {
            activity.binding.imgComGunting.resetBgChoice()
            activity.binding.imgComBatu.colorBgChoice()
            activity.binding.imgComKertas.resetBgChoice()
        } else if (com == PAPER) {
            activity.binding.imgComBatu.resetBgChoice()
            activity.binding.imgComGunting.resetBgChoice()
            activity.binding.imgComKertas.colorBgChoice()
        }
    }

    fun resetBackgroundChoice() {
        activity.binding.imgGunting.resetBgChoice()
        activity.binding.imgBatu.resetBgChoice()
        activity.binding.imgKertas.resetBgChoice()
        activity.binding.imgComGunting.resetBgChoice()
        activity.binding.imgComBatu.resetBgChoice()
        activity.binding.imgComKertas.resetBgChoice()
    }
}