/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


$(document).ready(function () {

    //interact with questionList buttons
    $("#show1").addClass("active");
    $("#cauhoi1").addClass("d-block");
    $(".clickcauhoi").click(function () {

        let ID = $(this).attr("id").trim().slice(4);//skip "cauhoi"
        for (let i = 1; i <= 25; i++) {
            //active questionButton
            $("#show" + i).removeClass("active");

            //display cauhoi
            $("#cauhoi" + i).removeClass("d-block");
            $("#cauhoi" + ID).addClass("d-none");
        }
        $("#cauhoi" + ID).addClass("d-block");
        $("#show" + ID).addClass("active");
    });


    //hide and show the question blockD
//    $("#cauhoi1").removeClass("d-none");
//    $("#cauhoi1").addClass("d-block");
//    $(".").each(function (e) {
//        if (e != 0)
//            $(this).hide();
//    });
//
//    $("#next").click(function () {})
//
//
//    $("#prev").click(function () {})


<<<<<<< HEAD
    $("#next").click(function(){})
        

    $("#prev").click(function(){})
        
=======

    //timer
>>>>>>> 68d24e3549edec486f7d574e0068c7d7e62995e8

    var seconds = 1140;
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
        document.getElementById('countdown').innerHTML = minutes + ":" + remainingSeconds;
        if (seconds == -1) {
            clearInterval(countdownTimer);
            confirm("Hết thời gian");
            $('#form2').submit();
            document.getElementById('countdown').innerHTML = "Finish!";
        } else {
            seconds--;
        }
    }
    var countdownTimer = setInterval('timer()', 1000);//chỗ này là số 1000 là đúng.
    
});