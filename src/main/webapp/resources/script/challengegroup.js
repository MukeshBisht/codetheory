
$(function () {
    $('#category').autocomplete({
        delay: 100,
        minLength: 1,
        source: function (req, res) {
            $.ajax({
                url: '/api/challenge/category/' + req.term,
                success: function (data) {
                    res(data);
                }
            });
        }
    });
} );