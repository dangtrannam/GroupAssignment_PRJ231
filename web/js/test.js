/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


$(document).ready(function () {

    //interact with questionList buttons
    $("#show1").addClass("active");
    $(".clickcauhoi").click(function () {
        
        let ID = $(this).attr("id").trim().slice(length-1);
        for(let i=1; i<= 25;i++){
            //active questionButton
            $("#show"+i).removeClass("active");
       
            //display cauhoi
            $("#cauhoi" + i).removeClass("d-block");
            $("#cauhoi" + ID).addClass("d-none");
        }
        $("#cauhoi" + ID).addClass("d-block");
        $("#show"+ID).addClass("active");
    });
    
    
    //hide and show the question blockD
    $("#cauhoi1").removeClass("d-none");
    $("#cauhoi1").addClass("d-block");
    $(".").each(function(e) {
        if (e != 0)
            $(this).hide();
    });

    $("#next").click(function(){}
        

    $("#prev").click(function(){}
        

});