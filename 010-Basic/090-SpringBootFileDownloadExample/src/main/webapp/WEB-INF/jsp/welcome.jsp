<!DOCTYPE html>

<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<html lang="en">

<head>
	<script>
		function download(){
			var request = new XMLHttpRequest();
			request.open("POST", "/getFile", true);
			request.responseType = "arraybuffer";

			request.onreadystatechange = function () {
				if (request.readyState != 4 || request.status != 200) return;
				// ready
				var blob = new Blob([new Uint8Array(request.response)]);
				var url = window.URL.createObjectURL(blob);
				var a = document.createElement("a");
				a.href = url;
				a.download = "testing.zip";
				a.click();
				window.URL.revokeObjectURL(url);
			};
			request.send();
		}
	</script>
</head>

<body>
	<h1>Hello World! This is Spring Boot JSP Page!!!</h1>
	<div>
		<button onclick="download()">Download</button>
	</div>
	
</body>

</html>