package com.codetheory.web.model;

import java.util.List;

public class OnlineJudgeResult {

    private String stderr;
    private String compile_output;
    private List<Status> status;

    /**
     * @return the stderr
     */
    public String getStderr() {
        return stderr;
    }

    /**
     * @return the status
     */
    public List<Status> getStatus() {
        return status;
    }

    /**
     * @param status the status to set
     */
    public void setStatus(List<Status> status) {
        this.status = status;
    }

    /**
     * @return the compile_output
     */
    public String getCompile_output() {
        return compile_output;
    }

    /**
     * @param compile_output the compile_output to set
     */
    public void setCompile_output(String compile_output) {
        this.compile_output = compile_output;
    }

    /**
     * @param stderr the stderr to set
     */
    public void setStderr(String stderr) {
        this.stderr = stderr;
    }
}