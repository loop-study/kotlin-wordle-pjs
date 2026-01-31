package controller

import domain.Constant
import domain.GameString
import domain.WordleGame
import view.InputView
import view.ResultView

class RetryableGame(val wordleGame: WordleGame, val resultView: ResultView, val inputView: InputView) {
    fun run(answer: GameString) {
        repeat (Constant.MAX_GAME_TRY_COUNT) {
            val inputWord = inputView.getInput()
            val gameResult = wordleGame.logic(inputWord, answer)

            resultView.printResult(gameResult)
            if (gameResult.isSuccess) {
                return
            }
        }
    }
}