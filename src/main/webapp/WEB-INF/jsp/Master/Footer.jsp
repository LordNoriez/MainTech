
<div>		
    <footer class="footer">
        <p> &copy; 2018 POFASA S.A.</p>
    </footer>

	<script src="https://ajax.googleapis.com/ajax/libs/angularjs/1.4.8/angular.min.js"></script>
	<script type="text/javascript">
		var app = angular.module('MainTech', []);
	
		app.config([ '$httpProvider', function($httpProvider) {
			$httpProvider.defaults.headers.common['X-Requested-With'] = 'XMLHttpRequest';
		} ]);
		app.controller('AppCtrl', function($http, $scope) {
	
		// method for getting user details
		var getUser = function() {
			$http.get('/user').success(function(user) {
				$scope.user = user;
				console.log('Logged User : ', user);		   
			}).error(function(error) {
				$scope.resource = error;
			});
		};
		getUser();
	    
		// method for logout
		$scope.logout = function() {
			$http.post('/logout').success(function(res) {
				$scope.user = null;
			}).error(function(error) {
				console.log("Logout error : ", error);
			});
		};
	});

		function openNav() {
		    document.getElementById("mySidenav").style.width = "250px";
		    document.body.style.backgroundColor = "rgba(0,0,0,0.4)";
		}

		/* Set the width of the side navigation to 0 and the left margin of the page content to 0, and the background color of body to white */
		function closeNav() {
		    document.getElementById("mySidenav").style.width = "0";
		    document.body.style.backgroundColor = "white";
		}

		$(document).ready(function(){
		  $("#myInput").on("keyup", function() {
		    var value = $(this).val().toLowerCase();
		    $("#myTable tr").filter(function() {
		      $(this).toggle($(this).text().toLowerCase().indexOf(value) > -1)
		    });
		  });
		});
	</script>
	
	
<script type="text/javascript">

	$(function() {
	  $("#ddlObjeto").on("change",function() {
	    var period = this.value;
	    $.ajax({
	        type: 'POST',
	        url: "/myPage",
	        data: {
	           item: period
	        },
	        success: function (html) {
	        	
	        	document.getElementById("lmitmax").value = parseInt(html);
	        },
	        error: function(e) {
	            console.log("Error:" + e);
	        }
	    });
	  }); 
	});
	
	function minmax(value, min, max) 
	{
	    if(parseInt(value) < min || isNaN(parseInt(value))) 
	        return 0; 
	    else if(parseInt(value) > document.getElementById("lmitmax").value) 
	        return document.getElementById("lmitmax").value; 
	    else return value;
	}
	</script>

    	<script type="text/javascript">
        function callMealert(ddl) {
          alert(ddl.value);
          
        }    
    </script> 
    
    
	<script type="text/javascript">
	     function configureDropDownLists(ddl1,ddl2) {
	    var colours = ['Black', 'White', 'Blue'];
	    var shapes = ['Square', 'Circle', 'Triangle'];
	    var names = ['John', 'David', 'Sarah'];
	
	    switch (ddl1.value) {
	        case 'Colours':
	            ddl2.options.length = 0;
	            for (i = 0; i < colours.length; i++) {
	                createOption(ddl2, colours[i], colours[i]);
	            }
	            break;
	        case 'Shapes':
	            ddl2.options.length = 0; 
	        for (i = 0; i < shapes.length; i++) {
	            createOption(ddl2, shapes[i], shapes[i]);
	            }
	            break;
	        case 'Names':
	            ddl2.options.length = 0;
	            for (i = 0; i < names.length; i++) {
	                createOption(ddl2, names[i], names[i]);
	            }
	            break;
	            default:
	                ddl2.options.length = 0;
	            break;
	    }​

	}
	
	    function createOption(ddl, text, value) {
	        var opt = document.createElement('option');
	        opt.value = value;
	        opt.text = text;
	        ddl.options.add(opt);
	    }
	    
	    
	</script>
	
	<script type="text/javascript">
        function callMe(objtoid) {
            var districtId = objtoid.value;
          
            $.ajax({
                type: "POST",
                url: "someUrl",
                dataType: "json",
                data: {
                    varname1 : "varvalue1",
                    varname2 : "varvalue2"
                },
                success: function (data) {
                    $('#ddl2').empty(); // empty existing list
                    $('#ddl2').append('<option value="">Some Label</option>');
                    $.each(data, function (varvalue, vartext){
                        $('#ddl2').append($('<option></option>').val(varvalue).html(vartext));
                    });  
                }
            });
        }    
    </script> 

	<script type="text/javascript">
	     function configureDropDownLists(ddl1,ddl2) {
	    var colours = ['Black', 'White', 'Blue'];
	    var shapes = ['Square', 'Circle', 'Triangle'];
	    var names = ['John', 'David', 'Sarah'];
	
	    switch (ddl1.value) {
	        case 'Colours':
	            ddl2.options.length = 0;
	            for (i = 0; i < colours.length; i++) {
	                createOption(ddl2, colours[i], colours[i]);
	            }
	            break;
	        case 'Shapes':
	            ddl2.options.length = 0; 
	        for (i = 0; i < shapes.length; i++) {
	            createOption(ddl2, shapes[i], shapes[i]);
	            }
	            break;
	        case 'Names':
	            ddl2.options.length = 0;
	            for (i = 0; i < names.length; i++) {
	                createOption(ddl2, names[i], names[i]);
	            }
	            break;
	            default:
	                ddl2.options.length = 0;
	            break;
	    }​

	}
	
	    function createOption(ddl, text, value) {
	        var opt = document.createElement('option');
	        opt.value = value;
	        opt.text = text;
	        ddl.options.add(opt);
	    }
	</script>
	
	<script>
		var today = new Date();
		var dd = today.getDate();
		var mm = today.getMonth()+1; //January is 0!
	
		var yyyy = today.getFullYear();
		if(dd<10){dd='0'+dd} if(mm<10){mm='0'+mm} today = mm+'/'+dd+'/'+yyyy;
	
		$('#theDate').attr('value', today);
	</script>

</div>
