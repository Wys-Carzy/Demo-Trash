$(document).ready(function(e){
	$(function(){

	    $('.num').blur(function(){
	    
	        var $this = $(this);
	    
	        var numPallets = $this.val();
	        var multiplier = $this
	                            .parent().parent()
	                            .find("td.money span")
	                            .text();
	        if ( (IsNumeric(numPallets)) && (numPallets != '') ) {
	            
	            var rowTotal = numPallets * multiplier;
	            $this
	                .css("border-color", "white")
	                .parent().parent()
	                .find("td.money_td input")
	                .val(rowTotal);              
	        } else {
	        
	            $this.css("border-color", "red"); 
	                        
	        };
	        
	        calcProdSubTotal();
	    
	    });

	});
});

function num(ID) {
	var num = $("#"+ID).val();
	$.post("ProductServlet",{param:'update',id:ID,num:num},function( result ){
		var msg = "";
			msg = result;
		$(".dialog_msg:first").html(msg);
		$("#dialog").slideToggle('fast');
		window.setTimeout("hide_dialog()", 2000);
	});
}

function hide_dialog() {
	$("#dialog").slideToggle();
}

function IsNumeric(sText){
   var ValidChars = "0123456789";
   var IsNumber=true;
   var Char;
   for (i = 0; i < sText.length && IsNumber == true; i++) 
      { 
      Char = sText.charAt(i); 
      if (ValidChars.indexOf(Char) == -1) 
         {
         IsNumber = false;
         }
      }
   return IsNumber;
   
};

function calcProdSubTotal() {
    
    var prodSubTotal = 0;

    $(".money_input").each(function(){
    
        var valString = $(this).val() || 0;
        
        prodSubTotal += parseInt(valString);           
    });
    $("#money_td").val(prodSubTotal);

};

