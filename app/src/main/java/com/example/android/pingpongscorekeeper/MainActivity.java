package com.example.android.pingpongscorekeeper;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    int playerOneScore = 0;
    int playerTwoScore = 0;
    int gamesWonByPlayerOne = 0;
    int gamesWonByPlayerTwo = 0;
    int currentGame = 1;

    String gameWinner;
    String matchWinner;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void playerOneScoresAPoint(View view) {
        playerOneScore = playerOneScore + 1;
        displayPlayerOneScore(playerOneScore);
        if (isWinner(playerOneScore)) {
            gamesWonByPlayerOne = gamesWonByPlayerOne + 1;
            displayGamesWonByPlayerOne(gamesWonByPlayerOne);
            currentGame = currentGame + 1;
            if (isMatchWinner(gamesWonByPlayerOne)) {
                matchWinner = "Player 1";
                displayMatchWinMessage(matchWinner);
            }
            else {
                displayCurrentGame(currentGame);
                resetPlayerScores();
            }
        }
    }

    public void playerTwoScoresAPoint(View view) {
        playerTwoScore = playerTwoScore + 1;
        displayPlayerTwoScore(playerTwoScore);
        if (isWinner(playerTwoScore)) {
            gamesWonByPlayerTwo = gamesWonByPlayerTwo + 1;
            displayGamesWonByPlayerTwo(gamesWonByPlayerTwo);
            currentGame = currentGame + 1;
            if (isMatchWinner(gamesWonByPlayerTwo)) {
                matchWinner = "Player 2";
                displayMatchWinMessage(matchWinner);
            }
            else {
                displayCurrentGame(currentGame);
                resetPlayerScores();
            }
        }
    }
    private void displayPlayerOneScore(int playerOneScore) {
        TextView scoreView = findViewById(R.id.player_one_score);
        scoreView.setText(String.valueOf(playerOneScore));
    }

    private void displayPlayerTwoScore(int playerTwoScore) {
        TextView scoreView = findViewById(R.id.player_two_score);
        scoreView.setText(String.valueOf(playerTwoScore));
    }

    private boolean isWinner(int score) {
        return ((score >= 11) && ((playerOneScore - playerTwoScore >=2) || (playerOneScore - playerTwoScore <= -2)));
    }

    private void displayGamesWonByPlayerOne(int gamesWonByPlayerOne) {
        TextView scoreView = findViewById(R.id.player_one_games_won);
        scoreView.setText(String.valueOf(gamesWonByPlayerOne));
    }

    private void displayGamesWonByPlayerTwo(int gamesWonByPlayerTwo) {
        TextView scoreView = findViewById(R.id.player_two_games_won);
        scoreView.setText(String.valueOf(gamesWonByPlayerTwo));
    }

    private boolean isMatchWinner(int gamesWonByPlayer) {
        return (gamesWonByPlayer == 3);
    }

    private void displayMatchWinMessage(String matchWinner) {
        TextView messageView = findViewById(R.id.winner_message);
        messageView.setText(String.valueOf(matchWinner + " wins the match!!!"));
    }

    private void resetPlayerScores() {
        playerOneScore = 0;
        playerTwoScore = 0;
        displayPlayerOneScore(playerOneScore);
        displayPlayerTwoScore(playerTwoScore);
    }

    private void displayCurrentGame(int currentGame) {
        TextView gameView = findViewById(R.id.current_game_number);
        gameView.setText(String.valueOf(currentGame));
        TextView playerOneGameView = findViewById(R.id.player_one_game_number);
        playerOneGameView.setText(String.valueOf(currentGame));
        TextView playerTwoGameView = findViewById(R.id.player_two_game_number);
        playerTwoGameView.setText(String.valueOf(currentGame));
    }
}
