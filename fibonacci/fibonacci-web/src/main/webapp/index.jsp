<!DOCTYPE html>
<html>
<head>
<title>Fibonacci</title>
<script src="./js/jquery-2.1.1.min.js" type="text/javascript"></script>

<script type="text/javascript">
	$(document).ready(function() {
		$(':submit').on('click', function() { // This event fires when a button is clicked
			var button = $(this).val();
			$.ajax({ // ajax call starts
				url : 'rest/fibonacci/' + document.getElementById('sequenceLength').value, // JQuery loads serverside.php
				dataType : 'json', // Choosing a JSON datatype
				success : function(data) // Variable data contains the data we get from serverside
				{
					$('#fibonaccisequence').html('');
	                
					var seqString = '';
					for (var i in data) {
						seqString.concat('a');
						seqString = seqString.concat(data[i] + ', ');
	                }
					seqString = seqString.substring(0, seqString.length - 2);
					$('#fibonaccisequence').append(seqString);
				}
			});
			return false; // keeps the page from not refreshing 
		});
	});
</script>

</head>

<body>
	<h2>Fibonacci</h2>
	<hr/>
	<form method="get" action="">
		Sequence length: <input type="text" name="sequenceLength" id="sequenceLength">
		<button type="submit" id="getfibonacci">Get Fibonacci</button>
	</form>
	<br/>
	<hr/>
		Result:<br><br>
	<div id="fibonaccisequence">
	</div>

</body>
</html>