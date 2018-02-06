package com.codetheory.web.model;

import java.util.ArrayList;

public class CodeQuestion
{
  private int id;
  private int level;
  private String question;
  private String details;
  private ArrayList<Test> tests;

  public int getId() { return this.id; }

  public void setId(int id) { this.id = id; }

  public int getLevel() { return this.level; }

  public void setLevel(int level) { this.level = level; }

  public String getQuestion() { return this.question; }

  public void setQuestion(String question) { this.question = question; }

  public String getDetails() { return this.details; }

  public void setDetails(String details) { this.details = details; }

  public ArrayList<Test> getTests() { return this.tests; }

  public void setTests(ArrayList<Test> tests) { this.tests = tests; }
}