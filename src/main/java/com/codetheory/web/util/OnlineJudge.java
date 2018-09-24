package com.codetheory.web.util;

import com.codetheory.web.model.Test;

import java.io.IOException;
import java.util.List;
import com.codetheory.web.model.Code;
import com.codetheory.web.model.JudgeOutput;

public interface OnlineJudge {

    /**
     * compile and execute given test cases and calcute score
     * @param code code to judge
     * @param tests test cases to run
     * @param timelimit runtime limit for every program
     * @param memorylimit Limit address space of the program
     * @param score score is a reference parameter to get calculated score in % 
     * @return List of JudgeOutput output for each test case
     * @throws IOException
     */
    public List<JudgeOutput> judge(Code code, List<Test> tests, float timelimit, int memorylimit, Double score) throws IOException;

}