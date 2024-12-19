package com.wagner.europace.bowling_game.model;

import java.util.List;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Builder
public class FrameSet {
  private Frame frame1;
  private Frame frame2;
  private Frame frame3;
  private Frame frame4;
  private Frame frame5;
  private Frame frame6;
  private Frame frame7;
  private Frame frame8;
  private Frame frame9;
  private Frame frame10;

  public List<Frame> getFrames() {
    return List.of(frame1, frame2, frame3, frame4, frame5, frame6, frame7, frame8, frame9, frame10);
  }
  
  public String toString() {
    return String.format("[%s|%s|%s|%s|%s|%s|%s|%s|%s|%s]",
      frame1.toString(), frame2.toString(), frame3.toString(), frame4.toString(),
      frame5.toString(), frame6.toString(), frame7.toString(), frame8.toString(),
      frame9.toString(), frame10.toString()
    );
  }
}
