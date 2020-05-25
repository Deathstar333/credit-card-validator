<html>
<head>
    <title>CreditCard-Home Page</title>
</head>
<body style="background-color: aqua;">
<h2>Check For Credit Card Eligibility</h2>
<label>Enter PAN Number</label>
<form action="checkEligibility" method="post">
    <input type="text" id="panNo" name="panNo" pattern="[a-zA-Z0-9]{10}" title="10 character alpha numeric" required>
    <input type="submit" id="submit" value="Check">
</form>
</body>
</html>
