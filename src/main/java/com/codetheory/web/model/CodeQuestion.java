package com.codetheory.web.model;

import java.util.ArrayList;

public class CodeQuestion extends Question
{

  private String details;
  private ArrayList<Test> tests;

  public String getDetails() { return this.details; }

  public void setDetails(String details) { this.details = details; }

  public ArrayList<Test> getTests() { return this.tests; }

  public void setTests(ArrayList<Test> tests) { this.tests = tests; }
}