package com.alan.gamedesigncp5.utils

import com.alan.gamedesigncp5.R
import com.alan.gamedesigncp5.ui.MainActivity
import com.alan.gamedesigncp5.utils.Utils.DRAW
import com.alan.gamedesigncp5.utils.Utils.PAPER
import com.alan.gamedesigncp5.utils.Utils.ROCK
import com.alan.gamedesigncp5.utils.Utils.SCISSORS
import com.alan.gamedesigncp5.utils.Utils.YOU_LOSE
import com.alan.gamedesigncp5.utils.Utils.YOU_WIN
import com.alan.gamedesigncp5.utils.Utils.openDialogResult
import com.alan.gamedesigncp5.utils.Utils.showLogInfo
import com.alan.gamedesigncp5.utils.Utils.showToast

open class ResultGameVsPlayer(private val activity: MainActivity) {

    private val setBgChoice = SetBackgroundChoice(activity)

    open fun playerChoice(
        namePlayer1: String,
        choicePlayer1: String,
        choicePlayer2: String
    ) {
        //DRAW
        if (choicePlayer1 == ROCK && choicePlayer2 == ROCK) {
            setBgChoice.backgroundChoicePlayer1(ROCK)
            setBgChoice.backgroundChoicePlayer2(ROCK)
            activity.binding.imgVs.setImageResource(R.drawable.draw)
            openDialogResult(activity, namePlayer1, DRAW)
            showToast(activity, "${activity.player2} Memilih $ROCK")
            showLogInfo("MainActivity", "$namePlayer1: $ROCK, Player2: $ROCK")

        } else if (choicePlayer1 == PAPER && choicePlayer2 == PAPER) {
            setBgChoice.backgroundChoicePlayer1(PAPER)
            setBgChoice.backgroundChoicePlayer2(PAPER)
            activity.binding.imgVs.setImageResource(R.drawable.draw)
            openDialogResult(activity, namePlayer1, DRAW)
            showToast(activity, "Pemain 2 Memilih $PAPER")
            showLogInfo("MainActivity", "$namePlayer1: $PAPER, Player2: $PAPER")

        } else if (choicePlayer1 == SCISSORS && choicePlayer2 == SCISSORS) {
            setBgChoice.backgroundChoicePlayer1(SCISSORS)
            setBgChoice.backgroundChoicePlayer2(SCISSORS)
            activity.binding.imgVs.setImageResource(R.drawable.draw)
            openDialogResult(activity, namePlayer1, DRAW)
            showToast(activity, "Pemain 2 Memilih $SCISSORS")
            showLogInfo("MainActivity", "$namePlayer1: $SCISSORS, Player2: $SCISSORS")
        }

        //PLAYER 1 WINNER
        if (choicePlayer1 == ROCK && choicePlayer2 == SCISSORS) {
            setBgChoice.backgroundChoicePlayer1(ROCK)
            setBgChoice.backgroundChoicePlayer2(SCISSORS)
            activity.binding.imgVs.setImageResource(R.drawable.you_win)
            openDialogResult(activity, namePlayer1, YOU_WIN)
            showToast(activity, "Pemain 2 Memilih $SCISSORS")
            showLogInfo("MainActivity", "$namePlayer1: $ROCK, Player2: $SCISSORS")

        } else if (choicePlayer1 == PAPER && choicePlayer2 == ROCK) {
            setBgChoice.backgroundChoicePlayer1(PAPER)
            setBgChoice.backgroundChoicePlayer2(ROCK)
            activity.binding.imgVs.setImageResource(R.drawable.you_win)
            openDialogResult(activity, namePlayer1, YOU_WIN)
            showToast(activity, "Pemain 2 Memilih $ROCK")
            showLogInfo("MainActivity", "$namePlayer1: $PAPER, Player2: $ROCK")

        } else if (choicePlayer1 == SCISSORS && choicePlayer2 == PAPER) {
            setBgChoice.backgroundChoicePlayer1(SCISSORS)
            setBgChoice.backgroundChoicePlayer2(PAPER)
            activity.binding.imgVs.setImageResource(R.drawable.you_win)
            openDialogResult(activity, namePlayer1, YOU_WIN)
            showToast(activity, "Pemain 2 Memilih $PAPER")
            showLogInfo("MainActivity", "$namePlayer1: $SCISSORS, Player2: $PAPER")
        }

        //PLAYER 2 WINNER
        if (choicePlayer1 == ROCK && choicePlayer2 == PAPER) {
            setBgChoice.backgroundChoicePlayer1(ROCK)
            setBgChoice.backgroundChoicePlayer2(PAPER)
            activity.binding.imgVs.setImageResource(R.drawable.com_win)
            openDialogResult(activity, namePlayer1, YOU_LOSE)
            showToast(activity, "Pemain 2 Memilih $PAPER")
            showLogInfo("MainActivity", "$namePlayer1: $ROCK, Player2: $PAPER")

        } else if (choicePlayer1 == PAPER && choicePlayer2 == SCISSORS) {
            setBgChoice.backgroundChoicePlayer1(PAPER)
            setBgChoice.backgroundChoicePlayer2(SCISSORS)
            activity.binding.imgVs.setImageResource(R.drawable.com_win)
            openDialogResult(activity, namePlayer1, YOU_LOSE)
            showToast(activity, "Pemain 2 Memilih $SCISSORS")
            showLogInfo("MainActivity", "$namePlayer1: $PAPER, Player2: $SCISSORS")

        } else if (choicePlayer1 == SCISSORS && choicePlayer2 == ROCK) {
            setBgChoice.backgroundChoicePlayer1(SCISSORS)
            setBgChoice.backgroundChoicePlayer2(ROCK)
            activity.binding.imgVs.setImageResource(R.drawable.com_win)
            openDialogResult(activity, namePlayer1, YOU_LOSE)
            showToast(activity, "Pemain 2 Memilih $ROCK")
            showLogInfo("MainActivity", "$namePlayer1: $SCISSORS, Player2: $ROCK")
        }
    }
}