package com.wagner.europace.bowling_game;

import java.util.List;

import org.springframework.shell.standard.ShellComponent;
import org.springframework.shell.standard.ShellMethod;
import org.springframework.shell.standard.ShellOption;

import com.wagner.europace.bowling_game.model.Frame;
import com.wagner.europace.bowling_game.model.FrameSet;

@ShellComponent
public class ScoreCalculator {

  public static final String FRAME_SPLIT_SEPARATOR = ",";
  
  private FrameSet frameSet;

  @ShellMethod(value = "Calculate overall score for given frame set")
  public String calc (
      @ShellOption(help = "rolls score of frame 1. must be a comma separated pair e.g. 3,7") String frame1,
      @ShellOption(help = "rolls score of frame 2. must be a comma separated pair e.g. 3,7") String frame2,
      @ShellOption(help = "rolls score of frame 3. must be a comma separated pair e.g. 3,7") String frame3,
      @ShellOption(help = "rolls score of frame 4. must be a comma separated pair e.g. 3,7") String frame4,
      @ShellOption(help = "rolls score of frame 5. must be a comma separated pair e.g. 3,7") String frame5,
      @ShellOption(help = "rolls score of frame 6. must be a comma separated pair e.g. 3,7") String frame6,
      @ShellOption(help = "rolls score of frame 7. must be a comma separated pair e.g. 3,7") String frame7,
      @ShellOption(help = "rolls score of frame 8. must be a comma separated pair e.g. 3,7") String frame8,
      @ShellOption(help = "rolls score of frame 9. must be a comma separated pair e.g. 3,7") String frame9,
      @ShellOption(help = "rolls score of frame 10. must be a comma separated triple e.g. 3,7,3") String frame10
    ) 
  {
    frameSet = FrameSet.builder()
      .frame1(parseFrame(frame1, 1))
      .frame2(parseFrame(frame2, 2))
      .frame3(parseFrame(frame3, 3))
      .frame4(parseFrame(frame4, 4))
      .frame5(parseFrame(frame5, 5))
      .frame6(parseFrame(frame6, 6))
      .frame7(parseFrame(frame7, 7))
      .frame8(parseFrame(frame8, 8))
      .frame9(parseFrame(frame9, 9))
      .frame10(parseFrame(frame10, 10))
      .build();
    System.out.println(String.format("Need to calculate score for frame set %s", frameSet.toString()));
    Integer score = calcScore(frameSet);
    return "Calculated score is " + score;
  }

  private Frame parseFrame(String frameString, Integer frameNumber) {    
    String[] rolls = frameString.split(ScoreCalculator.FRAME_SPLIT_SEPARATOR);
    Frame frame = Frame.builder().number(frameNumber).build();
    frame.setFirstRoll(Integer.parseInt(rolls[0]));
    frame.setSecondRoll(Integer.parseInt(rolls[1]));
    if (rolls.length == 3) {
      frame.setThirdRoll(Integer.parseInt(rolls[2]));
    }
    return frame;
  }

  private Integer calcScore(FrameSet frameSet) {
    Integer baseScore = 0;
    Integer bonusScore = 0;
    List<Frame> frames = frameSet.getFrames();

    for (int i = 0; i < 10; i++) {
      Frame frame = frames.get(i);
      baseScore += frame.getFirstRoll();
      baseScore += frame.getSecondRoll();
      if (frame.isLast() && frame.getThirdRoll() != null) {
        baseScore += frame.getThirdRoll();
      }
      if (frame.isSpare() && !frame.isLast()) {
        bonusScore += frames.get(i+1).getFirstRoll();
      }
      if (frame.isStrike() && !frame.isLast()) {
        bonusScore += frames.get(i+1).getFirstRoll() + frames.get(i+1).getSecondRoll();
        if(frames.get(i+1).isStrike() && !frames.get(i+1).isLast()) {
          bonusScore += frames.get(i+2).getFirstRoll();
        }
      }
    }

    return baseScore + bonusScore;
  }
}
