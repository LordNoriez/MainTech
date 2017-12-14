function snackBarFunction() {
    // Get the snackbar DIV
    var x = document.getElementById("snackbar")

    // Add the "show" class to DIV
    x.className = "show";

    // After 3 seconds, remove the show class from DIV
    setTimeout(function(){ x.className = x.className.replace("show", ""); }, 5500);
}

function showSelection()
{
//     var selectedLine = document.getElementById("objPadreInput").value;
//     var selectedExt = document.getElementById("firstname").value;
//     DBOps.insertDN(selectedLine, selectedExt);
    var selectBox = document.getElementById("selectBox");
    var selectedValue = selectBox.options[selectBox.selectedIndex].value;
    alert(selectedValue);
}

function openNav() {
    document.getElementById("mySidenav").style.width = "250px";
    document.body.style.backgroundColor = "rgba(0,0,0,0.4)";
}

/* Set the width of the side navigation to 0 and the left margin of the page content to 0, and the background color of body to white */
function closeNav() {
    document.getElementById("mySidenav").style.width = "0";
    document.body.style.backgroundColor = "white";
}

function industryAjax()
{
	alert("i am here")
var businessNatureId= $("#industrySelect option:selected").val();
	
	$.ajax({
		url : "/getAllIndustries",
		type : "get",
		success : function(response) {
			$('#industrySelect').empty();
			$('#industrySelect').append($('<option>', {
			    value: 0,
			    text:  'Select'
			}));
			for (item in response) {
				$('#industrySelect').append($('<option>', {
				    value: response[item].idMantenimiento,
				    text:  response[item].nombreMantenimiento
				}));
			}
		},
		error : function(e) {
			// alert("Submit failed" + JSON.stringify(e));
		}
	});
}

function ajaxPost(){
	
	// PREPARE FORM DATA
	var formData = {
		idObjeto : $("#ddlObjeto").val()
	}
	
	// DO POST
	$.ajax({
		type : "POST",
		contentType : "application/json",
		url : window.location + "api/customer/save",
		data : JSON.stringify(formData),
		dataType : 'json',
		success : function(result) {
			if(result.status == "Done"){
				$("#postResultDiv").html("<p style='background-color:#7FA7B0; color:white; padding:20px 20px 20px 20px'>" + 
											"Post Successfully! <br>" +
											"---> Customer's Info: FirstName = " + 
											result.data.firstname + " ,LastName = " + result.data.lastname + "</p>");
			}else{
				$("#postResultDiv").html("<strong>Error</strong>");
			}
			console.log(result);
		},
		error : function(e) {
			alert("Error!")
			console.log("ERROR: ", e);
		}
	});
	
	// Reset FormData after Posting
	resetData();

}




