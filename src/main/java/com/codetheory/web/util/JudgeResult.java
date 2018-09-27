package com.codetheory.web.util;

import java.util.ArrayList;
import java.util.List;

import com.codetheory.web.model.JudgeOutput;

public class JudgeResult {

    private double score;

    private List<JudgeOutput> results;

    public JudgeResult() {      
        results = new ArrayList<JudgeOutput>();
    }

    /**
     * @return the score
     */
    public double getScore() {
        return score;
    }

    /**
     * @return the results
     */
    public List<JudgeOutput> getResults() {
        return results;
    }

    /**
     * @param results the results to set
     */
    public void setResults(List<JudgeOutput> results) {
        this.results = results;
    }

    /**
     * @param score the score to set
     */
    public void setScore(double score) {
        this.score = score;
    }

    public void addResult(JudgeOutput output){
        results.add(output);
    }
}