package org.example;

object TicTacToe{
    /**
     * In a game of tic-tac-toe, there are a total of 9 boxes.
     *
     *
     * 0 signifies that no player has filled in the box, 1 signifies that player 1 has filled in the box, and 2 signifies that player 2 has filled in the box.
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
