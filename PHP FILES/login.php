<?php
require "conn.php";
$email = $_POST["email"];
$password = $_POST["password"];
$mysql_qry = "select * from users where email like '$email' and password like '$password'";
$result = mysqli_query($conn, $mysql_qry);

if(mysqli_num_rows($result) > 0) {
  echo "true";

}

else{
  echo "false";
}

?>
