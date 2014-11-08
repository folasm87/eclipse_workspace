/**
 * 
 */

$(function(){
	$("form").submit(function() {
        // Getting the form ID
        var  formID = $(this).attr('id');
        
        var url = "";
        
        var username = $('#username').val(); //grabs the value for the id='name';
		var password ="";
		var first = "";
		var last = "";
		var balance = "";
		var amount = "";
        
        switch (formID){
        
	        case("deposit"):
	        	url = "deposit.do";
	        	balance = $('#balance').val();
	        	amount = $('#amount').val();
	        	break;
	        case("withdraw"):
	        	url = "withdraw.do";
	        	balance = $('#balance').val();
	        	amount = $('#amount').val();
	        	break;
	        case("add"):
	        	url = "add.do";
	        	password = $('#password').val();
        		first = $('#first').val();
        		last =$('#last').val();
        		break;
	        default:
	        	url = "login.do";
	        	password = $('#password').val();
        
        
        }
        var formDetails = $('#'+formID);
        
        console.log("formID is " + formID + ". URL is " + url + " balance is " + balance + " amount is " + amount);
        $.ajax({
            type: "POST",
            url: url,
            data: 'username='+username+'&password='+password+'&first='+first+'&last='+last+'&amount='+amount+'&balance='+balance,
            success: function (data) {    
                // Inserting html into the result div
                //$('#results').html(data);
            },
            /*
            error: function(jqXHR, text, error){
            // Displaying if there are any errors
                $('#result').html(error);       
               
              */
        });
        
    });
        
	/*
	$('#submit').click(function(){
		//$('#container').append('<img src="ajax-loader.gif" alt="Currently Loading" id="loading"/>');
		var username = $('#username').val(); //grabs the value for the id='name';
		var password = $('#password').val();
		//var comment = $('#comment').val();
		
		$.ajax({
			url: 'login.do', //how it knows what Servlet to call
			type: 'POST', //what type of http method	
			data: 'username='+username+'&password='+password,
			success: function(response){
				//$('#response').remove();
				//$('#loading').remove();
				//$('#container').append('<p id="response"></p>');
				//$('#loading').fadeOut(500);
				//$('#response').fadeOut(2000);
		}});
		return false;
		
	});
	
	$('#deposit').click(function(){
		
		var amount = $('#amount').val();
		var balance = $('#balance').val();
	
		
		$.ajax({
			url: 'deposit.do', //how it knows what Servlet to call
			type: 'POST', //what type of http method	
			data: 'amount='+amount+'&balance='+balance,
			success: function(response){

		}});
		return false;
		
	});
	*/
});