<?php
$con=mysql_connect("localhost","root","");
if(!$con)
{
	die('Could not connect :' . mysql_error());
}
$lang = $_GET['prog'];
mysql_select_db("mepg",$con);

$result=mysql_query("SELECT pname,pdetails,ptime FROM program WHERE cname= '$lang' ORDER BY ptime LIMIT 0, 30 ");
while($row=mysql_fetch_assoc($result))
{
	$output[]=$row;
}

print(json_encode($output));
mysql_close($con);

?>