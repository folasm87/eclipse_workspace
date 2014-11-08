/**
 * 
 */

$(function(){
	$('#submit').click(function(){
		$('#container').append('<img src="ajax-loader.gif" alt="Currently Loading" id="loading"/>');
		var name = $('#name').val(); //grabs the value for the id='name';
		var email = $('#email').val();
		var comment = $('#comment').val();
		
		$.ajax({
			url: 'submit.do', //how it knows what Servlet to call
			type: 'POST', //what type of http method	
			data: 'name='+name+'&email='+email+'&comment='+comment,
			success: function(response){
				$('#response').remove();
				$('#loading').remove();
				$('#container').append('<p id="response"></p>');
				$('#loading').fadeOut(500);
				$('#response').fadeOut(2000);
		}});
		return false;
		
	});
});