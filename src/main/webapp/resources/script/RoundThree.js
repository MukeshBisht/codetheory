function runCode() {
    $.ajax({
        type: "POST",
        dataType: 'json',
        crossDomain: true,
        url: "https://api.judge0.com/submissions?X-Auth-Token=notoken&wait=true",
        data: {
            "source_code": "#include <stdio.h>\n\nint main(void) {\n  char name[10];\n  scanf(\"%s\", name);\n  printf(\"hello, %s\\n\", name);\n  return 0;\n}",
            "language_id": "4",
            "number_of_runs": "1",
            "stdin": "Judge0",
            "expected_output": "hello, Judge0",
            "cpu_time_limit": "2",
            "cpu_extra_time": "0.5",
            "wall_time_limit": "5",
            "memory_limit": "128000",
            "stack_limit": "64000",
            "max_processes_and_or_threads": "30",
            "enable_per_process_and_thread_time_limit": false,
            "enable_per_process_and_thread_memory_limit": true,
            "max_file_size": "1024"
        },
        success: function (response) {
            console.log(response);
        }

    });

}