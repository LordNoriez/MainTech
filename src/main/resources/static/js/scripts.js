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



function ajaxPost(var){
	alert("it suppose to works")
	
	$.ajax({
        type: 'POST',
        url: "/myPage",
        data: {
           item: var
        },
        success: function (html) {

            alert(html);
        },
        error: function(e) {
            console.log("Error:" + e);
        }
    });

}




