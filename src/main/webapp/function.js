/**
 * 
 */
function welcome(){
	alert("Welcome");
}

function modifyUpdate(id){
		document.getElementById('hidden_field_operation').value = 'update';
		document.getElementById('selectedrow').value=id;
	}
	
function modifyDelete(id){
		document.getElementById('hidden_field_operation').value = 'delete';
		document.getElementById('selectedrow').value=id;
	}

function employees(){
	document.getElementById('allEmployees').value = 'employees';
}

function index() {
	document.getElementById('logout').value = 'index.jsp';
}

function home(){
	document.getElementById('welcome').value = 'welcome.jsp';
}

function newemp(){
	document.getElementById('new').value = 'FormNewEmployee.jsp';
}

function download(){
	document.getElementById('download').value = 'download';
}

function exportExcel(){
	window.location.href = uri + base64(format(template, ctx));
	document.getElementById("dlink").href = uri + base64(format(template, ctx));
    document.getElementById("dlink").download = filename;
    document.getElementById("dlink").click();
	
}
