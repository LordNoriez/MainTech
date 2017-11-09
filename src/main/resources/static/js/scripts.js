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
