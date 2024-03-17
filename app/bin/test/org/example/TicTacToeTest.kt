package org.example

import org.example.TicTacToe
import kotlin.test.Test
import kotlin.test.*

class TicTacToeTest {
    @Test fun getTicTacToeWinnerDetectsColumnWinner() {
        val input = listOf(0, 1, 0, 0, 1, 0, 0, 1, 0);

        val expected = 1;
        val actual = TicTacToe.getTicTacToeWinner(input);

        assertEquals(expected, actual);
    }

    @Test fun getTicTacToeWinnerReturns0OnEmptyBoard() {
        val input = listOf(0, 0, 0, 0, 0, 0, 0, 0, 0);

        val expected = 0;
        val actual = TicTacToe.getTicTacToeWinner(input);

        assertEquals(expected, actual);
    }

    @Test fun getTicTacToeWinnerDetectsRowWinner() {
        val input = listOf(0, 2, 0, 2, 2, 2, 0, 1, 0);

        val expected = 2;
        val actual = TicTacToe.getTicTacToeWinner(input);

        assertEquals(expected, actual);
    }

    @Test fun getTicTacToeWinnerReturns0WhenNoPlayerWon() {
        val input = listOf(0, 1, 0, 2, 0, 1, 0, 0, 2);

        val expected = 0;
        val actual = TicTacToe.getTicTacToeWinner(input);

        assertEquals(expected, actual);
    }

    @Test fun getTicTacToeWinnerReturnsDetectsDiagonalFromTopLeftToBottomRight() {
        val input = listOf(1, 1, 0, 2, 1, 1, 0, 0, 1);

        val expected = 1;
        val actual = TicTacToe.getTicTacToeWinner(input);

        assertEquals(expected, actual);
    }

    @Test fun getTicTacToeWinnerReturnsDetectsDiagonalFromBottomLeftToTopRight() {
        val input = listOf(0, 0, 1, 0, 1, 0, 1, 0, 0);

        val expected = 1;
        val actual = TicTacToe.getTicTacToeWinner(input);

        assertEquals(expected, actual);
    }
}