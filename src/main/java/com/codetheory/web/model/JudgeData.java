package com.codetheory.web.model;

public class JudgeData
{
    private String source_code;

    private String cpu_extra_time;

    private String language_id;

    private boolean enable_per_process_and_thread_time_limit;

    private String max_processes_and_or_threads;

    private String wall_time_limit;

    private String stdin;

    private String max_file_size;

    private String number_of_runs;

    private String memory_limit;

    private String cpu_time_limit;

    private String stack_limit;

    private String expected_output;

    private boolean enable_per_process_and_thread_memory_limit;


    public JudgeData(){

    }

    public JudgeData(Code code) {
        this.source_code = code.getcode();
        this.language_id = code.getlanguageid();
        this.number_of_runs = "1";
        this.stdin = "world";
        this.expected_output = "hello, world";
        this.cpu_time_limit = "2";
        this.cpu_extra_time = "0.5";
        this.wall_time_limit = "5";
        this.memory_limit = "128000";
        this.stack_limit = "64000";
        this.max_processes_and_or_threads = "30";
        this.enable_per_process_and_thread_time_limit = false;
        this.enable_per_process_and_thread_memory_limit = true;
        this.max_file_size = "1024";
    }

    public String getSource_code ()
    {
        return source_code;
    }

    public void setSource_code (String source_code)
    {
        this.source_code = source_code;
    }

    public String getCpu_extra_time ()
    {
        return cpu_extra_time;
    }

    public void setCpu_extra_time (String cpu_extra_time)
    {
        this.cpu_extra_time = cpu_extra_time;
    }

    public String getLanguage_id ()
    {
        return language_id;
    }

    public void setLanguage_id (String language_id)
    {
        this.language_id = language_id;
    }

    public boolean getEnable_per_process_and_thread_time_limit ()
    {
        return enable_per_process_and_thread_time_limit;
    }

    public void setEnable_per_process_and_thread_time_limit (boolean enable_per_process_and_thread_time_limit)
    {
        this.enable_per_process_and_thread_time_limit = enable_per_process_and_thread_time_limit;
    }

    public void setEnable_per_process_and_thread_time_limit (String enable_per_process_and_thread_time_limit)
    {
        this.enable_per_process_and_thread_time_limit = Boolean.parseBoolean(enable_per_process_and_thread_time_limit);
    }

    public String getMax_processes_and_or_threads ()
    {
        return max_processes_and_or_threads;
    }

    public void setMax_processes_and_or_threads (String max_processes_and_or_threads)
    {
        this.max_processes_and_or_threads = max_processes_and_or_threads;
    }

    public String getWall_time_limit ()
    {
        return wall_time_limit;
    }

    public void setWall_time_limit (String wall_time_limit)
    {
        this.wall_time_limit = wall_time_limit;
    }

    public String getStdin ()
    {
        return stdin;
    }

    public void setStdin (String stdin)
    {
        this.stdin = stdin;
    }

    public String getMax_file_size ()
    {
        return max_file_size;
    }

    public void setMax_file_size (String max_file_size)
    {
        this.max_file_size = max_file_size;
    }

    public String getNumber_of_runs ()
    {
        return number_of_runs;
    }

    public void setNumber_of_runs (String number_of_runs)
    {
        this.number_of_runs = number_of_runs;
    }

    public String getMemory_limit ()
    {
        return memory_limit;
    }

    public void setMemory_limit (String memory_limit)
    {
        this.memory_limit = memory_limit;
    }

    public String getCpu_time_limit ()
    {
        return cpu_time_limit;
    }

    public void setCpu_time_limit (String cpu_time_limit)
    {
        this.cpu_time_limit = cpu_time_limit;
    }

    public String getStack_limit ()
    {
        return stack_limit;
    }

    public void setStack_limit (String stack_limit)
    {
        this.stack_limit = stack_limit;
    }

    public String getExpected_output ()
    {
        return expected_output;
    }

    public void setExpected_output (String expected_output)
    {
        this.expected_output = expected_output;
    }

    public boolean getEnable_per_process_and_thread_memory_limit ()
    {
        return enable_per_process_and_thread_memory_limit;
    }

    public void setEnable_per_process_and_thread_memory_limit (String enable_per_process_and_thread_memory_limit)
    {
        this.enable_per_process_and_thread_memory_limit = Boolean.parseBoolean(enable_per_process_and_thread_memory_limit);
    }

    public void setEnable_per_process_and_thread_memory_limit (boolean enable_per_process_and_thread_memory_limit)
    {
        this.enable_per_process_and_thread_memory_limit = enable_per_process_and_thread_memory_limit;
    }

    @Override
    public String toString()
    {
        return "ClassPojo [source_code = "+source_code+", cpu_extra_time = "+cpu_extra_time+", language_id = "+language_id+", enable_per_process_and_thread_time_limit = "+enable_per_process_and_thread_time_limit+", max_processes_and_or_threads = "+max_processes_and_or_threads+", wall_time_limit = "+wall_time_limit+", stdin = "+stdin+", max_file_size = "+max_file_size+", number_of_runs = "+number_of_runs+", memory_limit = "+memory_limit+", cpu_time_limit = "+cpu_time_limit+", stack_limit = "+stack_limit+", expected_output = "+expected_output+", enable_per_process_and_thread_memory_limit = "+enable_per_process_and_thread_memory_limit+"]";
    }
}
