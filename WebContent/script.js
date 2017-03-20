$(document).ready(function(){

	$('.chat_head').click(function(){
		$('.chat_body').slideToggle('slow');
	});
	$('.msg_head').click(function(){
		$('.msg_wrap').slideToggle('slow');
	});
	
	$('.close').click(function(){
		$('.msg_box').hide();
	});
	
	$('.user').click(function(){

		$('.msg_wrap').show();
		$('.msg_box').show();
	});
	
	$('textarea').keypress(
    function(e){
        if (e.keyCode == 13) {
            e.preventDefault();
            var msg = $(this).val();
			$(this).val('');
			if(msg != '')
				$('<div class="msg_b">'+msg+'</div>').insertBefore('.msg_push');
			$('.msg_body').scrollTop($('.msg_body')[0].scrollHeight);
			console.log("typed-"+msg)
			$.ajax({
		        type: 'POST',
		        contentType: 'application/json',
		        url: "/ShoppingMallWebApp-0.1/webapp/shoppingmall",
		        data: JSON.stringify({
		        	"message": msg
		        }),
		        success: function(data, textStatus, jqXHR){
		        	console.log("Response: " + data + "\nStatus: " + textStatus);
		        	if(data != '')
		        		$('<div class="msg_a">'+data+'</div>').insertBefore('.msg_push');
 					$('.msg_body').scrollTop($('.msg_body')[0].scrollHeight);
		        },
		        error: function(jqXHR, textStatus, errorThrown){
		            console.log('error: ' + textStatus);
		        }
			});
			
        }
    });
	
});