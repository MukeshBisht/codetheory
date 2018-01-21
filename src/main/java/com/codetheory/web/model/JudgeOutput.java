package com.codetheory.web.model;


public class JudgeOutput
{
    private String message;

    private String time;

    private String stdout;

    private Status status;

    private String token;

    private String compile_output;

    private String stderr;

    private int memory;


    public JudgeOutput(){
        status = new Status();
    }

    public String getMessage ()
    {
        return message;
    }

    public void setMessage (String message)
    {
        this.message = message;
    }

    public String getTime ()
    {
        return time;
    }

    public void setTime (String time)
    {
        this.time = time;
    }

    public String getStdout ()
    {
        return stdout;
    }

    public void setStdout (String stdout)
    {
        this.stdout = stdout;
    }

    public Status getStatus ()
    {
        return status;
    }

    public void setStatus (Status status)
    {
        this.status = status;
    }

    public String getToken ()
    {
        return token;
    }

    public void setToken (String token)
    {
        this.token = token;
    }

    public String getCompile_output ()
    {
        return compile_output;
    }

    public void setCompile_output (String compile_output)
    {
        this.compile_output = compile_output;
    }

    public String getStderr ()
    {
        return stderr;
    }

    public void setStderr (String stderr)
    {
        this.stderr = stderr;
    }

    public int getMemory ()
    {
        return memory;
    }

    public void setMemory (int memory)
    {
        this.memory = memory;
    }
}
