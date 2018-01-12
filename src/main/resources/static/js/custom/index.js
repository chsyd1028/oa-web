jQuery(document).ready(function(){
								
	///// TRANSFORM CHECKBOX /////							
	jQuery('input:checkbox').uniform();
	
	///// LOGIN FORM SUBMIT /////
	jQuery('#login').submit(function(){

		if(jQuery('#username').val() == '' ) {

			jQuery('.nousername').fadeIn();
			document.getElementById("loginmsg").innerHTML="请输入用户名";
			//jQuery('#loginmsg').innerHTML = "请输入用户名";
			//jQuery('.nopassword').hide();
			return false;
		}
		if(jQuery('#password').val() == '') {
			// jQuery('.nopassword').fadeIn().find('.userlogged h4, .userlogged a span').text(jQuery('#username').val());
			// jQuery('.nousername,.username').hide();
            jQuery('.nousername').fadeIn();
            document.getElementById("loginmsg").innerHTML="请输入密码";
            //$('#loginmsg').innerHTML = "请输入密码";
			return false;;
		}


        // var username = document.getElementById('username').value;
        // var password = document.getElementById('password').value;
        // var data = {};
        // data.username = username;
        // data.password = password;
        //
        // jQuery.ajax({
        //     type : "POST",
        //     dataType : "json",
        //     url : "/login/check",
        //     data : data,
        //     async : false,
        //     success : function (result) {
        //         if (result.status == 'OK'){
        //             //window.location.href = "/index";
			// 		document.forms[0].action = "/index";
			// 		document.forms[0].submit();
        //             return false;
			// 		//jQuery.post("/index");
        //         }else{
        //             jQuery('.nousername').fadeIn();
        //
        //             document.getElementById("loginmsg").innerHTML=result.errorMessage;
        //             return false;
        //         }
        //     },
			// error : function () {
			// 	console.log( "error..");
        //     }
        // })

	});
	
	///// ADD PLACEHOLDER /////
	jQuery('#username').attr('placeholder','用户名');
	jQuery('#password').attr('placeholder','密码');
});
