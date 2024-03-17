package org.example;

object TicTacToe{
    /**
     * Given the state of a tic tac toe game, get the winner of the game if one exists.
     * 
     * Game state:
     *  The state of the tic tac toe game is represented by a list of 9 integers.
     *  0 signifies that no player has filled in the box, 1 signifies that player 1 has filled in the box, and 2 signifies that player 2 has filled in the box.
     * 
     * Approach used:
     *  The apprach used can be broken down into the following steps:
     *  1) Iterate through each column in the board, if a winner can be found from a column, add it to the list of winners
     *  2) Iterate through each row in the board, if a winner can be found from a row, add it to the list of winners
     *  3) Check the diagonal going from the top left corner to the bottom right corner for a winner, if a winner is found, add it to the list of winners
     *  4) Check the diagonal going from the bottom left corner to the top right corner for a winner, if a winner is found, add it to the list of winners
     *  5) After checking all of the possible ways a player can win the game, inspect the list of winners. 
     *      If there is more than 1 winner, throw an excpetion. There should only ever be one winner at a game of tic tac toe.
     *      If there is no winner return 0. This means no player has won the game in its current state.
     *      If there is 1 winner, return that player's number (either 1 or 2).
     *
     * @param boxValues the list of 9 integers which represent the game state
     * @returns the winning player if one exists. If a winning player does not exist, 0 will be returned.
     * @throws Exception if the input size is not equal to 9, if the input contains integers which are not 0, 1, or 2, or if there are multiple winners of the game.
     */
    fun getTicTacToeWinner(boxValues: List<Int>): Int{
    
        if(boxValues.count() != 9)
            throw Exception("There should be exactly 9 boxValues passed to this function, but ${boxValues.count()} were passed");
    
        if(boxValues.any { it !in 0..2 })
            throw Exception("the boxValues list should contain only the numbers 0, 1, and 2");
    
        val winners = mutableListOf<Int>();
    
        // check columns
        for (i in 0..2){
            val firstBoxValue = boxValues[i];
            val secondBoxValue = boxValues[i+3];
            val thirdBoxValue = boxValues[i+6];
    
            val boxValuesAreTheSame = (firstBoxValue == secondBoxValue) && (firstBoxValue == thirdBoxValue);
            val somePlayerFilledInFirstBox = firstBoxValue != 0;
    
            val columnRevealsWinningPlayer = boxValuesAreTheSame && somePlayerFilledInFirstBox; 
            if (columnRevealsWinningPlayer){
                val winningPlayerNumber = firstBoxValue;
                winners.addLast(winningPlayerNumber)
            }
        }
    
        // check rows
        for (i in 0..2){
            val firstBoxValue = boxValues[i*3];
            val secondBoxValue = boxValues[i*3+1];
            val thirdBoxValue = boxValues[i*3+2];
    
            val boxValuesAreTheSame = (firstBoxValue == secondBoxValue) && (firstBoxValue == thirdBoxValue);
            val somePlayerFilledInFirstBox = firstBoxValue != 0;
    
            val rowRevealsWinningPlayer = boxValuesAreTheSame && somePlayerFilledInFirstBox;
            if (rowRevealsWinningPlayer){
                val winningPlayerNumber = firstBoxValue;
                winners.addLast(winningPlayerNumber)
            }
        }
    
        // check top to bottom diagonal
        val topLeftBoxValue = boxValues[0];
        val somePlayerFilledTopLeftBox = topLeftBoxValue != 0;
        if(somePlayerFilledTopLeftBox){
            val middleBoxValue = boxValues[4];
            val bottomRightBoxValue = boxValues[8];
            val topToBottomDiagonalBoxesHaveTheSameValue = (topLeftBoxValue == middleBoxValue) && (topLeftBoxValue == bottomRightBoxValue);
            if(topToBottomDiagonalBoxesHaveTheSameValue){
                winners.addLast(topLeftBoxValue);
            }
        }
    
        // check bottom to top diagonal
        val bottomLeftBoxValue = boxValues[6];
        val somePlayerFilledBottomLeftBox = bottomLeftBoxValue != 0;
        if(somePlayerFilledBottomLeftBox){
            val middleBoxValue = boxValues[4];
            val topRightBoxValue = boxValues[2];
            val bottomToTopDiagonalBoxesHaveTheSameValue = (bottomLeftBoxValue == middleBoxValue) && (bottomLeftBoxValue == topRightBoxValue);
            if(bottomToTopDiagonalBoxesHaveTheSameValue){
                winners.addLast(bottomLeftBoxValue)
            }
        }
    
        val gameHasMoreThanOneWinner = winners.count() > 1;
        if(gameHasMoreThanOneWinner){
            throw Exception("there are multiple winners to the given tic tac toe game");
        }
    
        val gameHasNoWinners = winners.isEmpty()
        if(gameHasNoWinners){
            return 0;
        }
    
        return winners[0];
    }
}
