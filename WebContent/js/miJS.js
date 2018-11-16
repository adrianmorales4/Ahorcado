    var colors = ["grey","white"];
    var active = 0;
    var letrasNoIntroducidas=document.getElementsByClassName("letraNoAcertada");
    setInterval(
        function(){
            for(i=0;i<letrasNoIntroducidas.length;i++){
                letrasNoIntroducidas[i].style.background = colors[active];
            }
            active++;
            if (active == colors.length) active = 0;
        }
        , 1000);