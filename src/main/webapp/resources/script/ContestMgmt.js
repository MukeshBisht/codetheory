
$(function () {
    $('a[data-toggle="tab"]').on('shown.bs.tab', function (e) {
        var target = $(e.target).attr("href").replace('#', '');
        switch (target) {
            case 'Customization':
                break;
            case 'Content':
                break;
            case 'Moderators':
                loadModerators();
                break;
            case 'Notifications':
                break;
            case 'Advance':
                break;
        }
    });

    $('#modselect').autocomplete({
        delay: 100,
        minLength: 2,
        source: function (req, res) {
            $.ajax({
                url: 'http://localhost:8080/api/user/suggestion/' + req.term,
                type: 'GET',
                success: function (data) {
                    res(data);
                }
            });
        }
    });
});

function addModerator(){
    var newmod = $('#modselect').val();
    if(confirm("Are you sure ?\r\n Add "+ newmod + "?")){

        loadModerators();
    }
}

function loadModerators() {
    $('#outloading').show();
    //$('#outloading').hide();
}