package com.wagner.europace.bowling_game.model;

import com.wagner.europace.bowling_game.ScoreCalculator;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Builder
public class Frame {
  private Integer firstRoll;
  private Integer secondRoll;
  private Integer thirdRoll; // only needed if number = 10 and fristRoll + secondRoll is 10
  private Integer number;

  public String toString() {
    if (number.equals(10)) {
      return firstRoll + ScoreCalculator.FRAME_SPLIT_SEPARATOR + secondRoll + ScoreCalculator.FRAME_SPLIT_SEPARATOR + thirdRoll;
    } else {
      return firstRoll + ScoreCalculator.FRAME_SPLIT_SEPARATOR + secondRoll;
    }
  }

  public Boolean isStrike() {
    return firstRoll.equals(10); 
  }

  public Boolean isSpare() {
    return firstRoll < 10 && (firstRoll + secondRoll) == 10;
  }

  public Boolean isLast() {
    return number.equals(10);
  }
}
