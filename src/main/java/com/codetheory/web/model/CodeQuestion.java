package com.codetheory.web.model;

import java.util.ArrayList;

public class CodeQuestion extends Question
{

  private String details;
  private ArrayList<Test> tests;
  private float timeLimit;
  private int memoryLimit;

  public String getDetails() { return this.details; }

  /**
   * @return the memoryLimit
   */
  public int getMemoryLimit() {
    return memoryLimit;
  }

  /**
   * @param memoryLimit the memoryLimit to set
   */
  public void setMemoryLimit(int memoryLimit) {
    this.memoryLimit = memoryLimit;
  }

  /**
   * @return the timeLimit
   */
  public float getTimeLimit() {
    return timeLimit;
  }

  /**
   * @param timeLimit the timeLimit to set
   */
  public void setTimeLimit(float timeLimit) {
    this.timeLimit = timeLimit;
  }

  public void setDetails(String details) {
    this.details = details;
  }

  public ArrayList<Test> getTests() { return this.tests; }

  public void setTests(ArrayList<Test> tests) { this.tests = tests; }
}