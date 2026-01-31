package view

import domain.GameString

class InputView {

    fun getInput(): GameString {
        while(true) {
            val inputWord = readln().trim()
            try {
                return GameString(inputWord)
            } catch (exception: Exception) {
                println(exception.message)
                continue
            }
        }
    }
}