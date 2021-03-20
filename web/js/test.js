/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

function showQuestion(index)
{
    console.log(index);

}
$(document).ready(function () {
    let n=$("#number_question").prop("value");
    let id = 1;
    //interact with questionList buttons
    $("#show1").addClass("active");
    $("#cauhoi1").addClass("d-block");
    $(".clickcauhoi").click(function () {
        $("#cauhoi" + id).removeClass("d-block");
        $("#cauhoi" + id).addClass("d-none");
        $("#show" + id).removeClass("active");
        let ID = $(this).attr("id").trim().slice(4);//skip "cauhoi"
        id = ID;
//        for (let i = 1; i <= 25; i++) {
//            //active questionButton
//            $("#cauhoi" + i).removeClass("d-block");
//        $("#cauhoi" + i).addClass("d-none");
//        $("#show" + i).removeClass("active");
//        }
    
        $("#cauhoi" + id).addClass("d-block");
        $("#cauhoi" + id).removeClass("d-none");
        $("#show" + id).addClass("active");
    });


    //hide and show the question blockD
//    $("#cauhoi1").removeClass("d-none");
//    $("#cauhoi1").addClass("d-block");
//    $(".").each(function (e) {
//        if (e != 0)
//            $(this).hide();
//    });
//
    $("#next").click(function () {
        console.log("next");
        $("#cauhoi" + id).removeClass("d-block");
        $("#cauhoi" + id).addClass("d-none");
        $("#show" + id).removeClass("active");
        id = id % n + 1;
        $("#cauhoi" + id).addClass("d-block");
        $("#cauhoi" + id).removeClass("d-none");
        $("#show" + id).addClass("active");
    })
//
//
    $("#prev").click(function () {
        console.log('pre');
        $("#cauhoi" + id).removeClass("d-block");
        $("#cauhoi" + id).addClass("d-none");
        $("#show" + id).removeClass("active");
        id--;
        if (id == 0)
            id = n;
        $("#cauhoi" + id).addClass("d-block");
        $("#cauhoi" + id).removeClass("d-none");
        $("#show" + id).addClass("active");
    })

    var seconds = 60;


    function timer() {
        var days = Math.floor(seconds / 24 / 60 / 60);
        var hoursLeft = Math.floor((seconds) - (days * 86400));
        var hours = Math.floor(hoursLeft / 3600);
        var minutesLeft = Math.floor((hoursLeft) - (hours * 3600));
        var minutes = Math.floor(minutesLeft / 60);
        var remainingSeconds = seconds % 60;
        if (remainingSeconds < 10) {
            remainingSeconds = "0" + remainingSeconds;
        }

        let countdown = document.getElementById('countdown');
        if (countdown != null) {
            countdown.innerHTML = minutes + ":" + remainingSeconds;
        } else {
            clearInterval(countdownTimer);
        }



        if (seconds === -1) {
            clearInterval(countdownTimer);
            confirm("Hết thời gian");
            $('#f-doquiz').submit();
            countdown.innerHTML = "Finish!";
        } else {
            seconds--;
        }
//        console.log('seconds:' + seconds);
    }
    ;

    let countdownTimer = setInterval(timer, 1000);



});