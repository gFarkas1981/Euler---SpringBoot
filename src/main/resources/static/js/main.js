$(document).ready(function () {

    $('.navbar .dropdown-item').on('click', function (e) {
        var $el = $(this).children('.dropdown-toggle');
        var $parent = $el.offsetParent(".dropdown-menu");
        $(this).parent("li").toggleClass('open');

        if (!$parent.parent().hasClass('navbar-nav')) {
            if ($parent.hasClass('show')) {
                $parent.removeClass('show');
                $el.next().removeClass('show');
                $el.next().css({"top": -999, "left": -999});
            } else {
                $parent.parent().find('.show').removeClass('show');
                $parent.addClass('show');
                $el.next().addClass('show');
                $el.next().css({"top": $el[0].offsetTop, "left": $parent.outerWidth() - 4});
            }
            e.preventDefault();
            e.stopPropagation();
        }
    });

    $('.navbar .dropdown').on('hidden.bs.dropdown', function () {
        $(this).find('li.dropdown').removeClass('show open');
        $(this).find('ul.dropdown-menu').removeClass('show open');
    });

});



$('.modal-content , .modal-dialog').resizable({
    //alsoResize: ".modal-dialog",


    minHeight: 300,
    minWidth: 300
});


$('.modal-dialog').draggable();

$('#isPrimeModal').on('show.bs.modal', function() {
    $(this).find('.modal-body').css({
        'max-height': '100%',
        'width': '100%'
    });
});



(function($) {
    $.fn.flash_message = function(options) {

        options = $.extend({
            text: 'Done',
            time: 1000,
            how: 'before',
            class_name: ''
        }, options);

        return $(this).each(function() {
            if( $(this).parent().find('.flash_message').get(0) )
                return;

            var message = $('<span />', {
                'class': 'flash_message ' + options.class_name,
                text: options.text
            }).hide().fadeIn('fast');

            $(this)[options.how](message);

            message.delay(options.time).fadeOut('normal', function() {
                $(this).fadeOut();
            });

        });
    };
})(jQuery);


$('#sendIsPrime, #sendIsPalindrome, #sendFibonaccisUnder, #sendReverseNumber, #largestPrimeFactor').on('click touchstart', function () {
    $('#responseField').empty();
});
