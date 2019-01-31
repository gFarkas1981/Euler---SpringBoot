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









$(document).ready(function(){


    var $content, $modal, $apnData, $modalCon;

    $content = $(".min");


    //To fire modal
    $(".mdlFire").click(function(e){

        e.preventDefault();

        var $id = $(this).attr("data-target");

        $($id).modal({backdrop: false, keyboard: false});

    });


    $(".modalMinimize").on("click", function(){

        $modalCon = $(this).closest(".mymodal").attr("id");

        $apnData = $(this).closest(".mymodal");

        $modal = "#" + $modalCon;

        $(".modal-backdrop").addClass("display-none");

        $($modal).toggleClass("min");

        if ( $($modal).hasClass("min") ){

            $(".minmaxCon").append($apnData);

            $(this).find("i").toggleClass( 'fa-minus').toggleClass( 'fa-clone');

        }
        else {

            $(".container").append($apnData);

            $(this).find("i").toggleClass( 'fa-clone').toggleClass( 'fa-minus');

        };

    });

    $("button[data-dismiss='modal']").click(function(){

        $(this).closest(".mymodal").removeClass("min");

        $(".container").removeClass($apnData);

        $(this).next('.modalMinimize').find("i").removeClass('fa fa-clone').addClass( 'fa fa-minus');

    });

});
