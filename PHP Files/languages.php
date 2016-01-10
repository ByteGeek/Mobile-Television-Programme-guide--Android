<?php
$con=mysql_connect("mysql1.000webhost.com","a3311905_project","mobile9972680173");
if(!$con)
{
	die('Could not connect :' . mysql_error());
}

mysql_select_db("a3311905_project",$con);

$result=mysql_query("SELECT distinct language FROM CHANNEL ORDER BY language LIMIT 0, 30 ");
while($row=mysql_fetch_assoc($result))
{
	$output[]=$row;
}

print(json_encode($output));
mysql_close($con);

?>