
var editor;
$(document).ready(function () {

    var code = $(".codeMirror")[0];
    editor = CodeMirror.fromTextArea(code, {
        lineNumbers: true,
        matchBrackets: true, 
        smartIndent: true,
        mode: 'text/x-csrc',
        styleActiveLine: true,
        indentUnit: 4,
        indentWithTabs: true,
        autoCloseTags: true,
        autoCloseBrackets: true,
        matchTags: false,
        extraKeys: {
            "F11": function(cm) {
              cm.setOption("fullScreen", !cm.getOption("fullScreen"));
            },
            "Esc": function(cm) {
              if (cm.getOption("fullScreen")) cm.setOption("fullScreen", false);
            }
          }
    });
    editor.setValue("// Press F11 to edit in full screen\n#include<stdio.h>\nint main(){\n return 0;\n}");
});


function setMode (value){
    var m;
    if (value == 1){
        m = 'text/x-csrc';
    }
    else if (value == 2){
        m = 'text/x-c++src';
    }
    else if (value == 3){
        m = 'text/x-csharp';
    }
    else if (value == 4){
        m = 'text/x-java';
    }
    else if (value == 5){
        m = 'text/x-csrc';
    }
    else if (value == 6){
        m = 'text/x-csrc';
    }
    else if (value == 7){
        m = 'text/x-csrc';
    }
    else if (value == 8){
        m = 'text/x-csrc';
    }
    else if (value == 9){
        m = 'text/x-csrc';
    }
    else if (value == 10){
        m = 'text/x-csrc';
    }
    else if (value == 11){
        m = 'text/x-csrc';
    }

   editor.setOption("mode", m);
   console.log('language set to: ' + m);
}