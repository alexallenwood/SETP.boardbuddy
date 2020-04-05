<?php
require "conn.php";
$name = $_POST["name"];
$surname = $_POST["surname"];
$age = $_POST["age"];
$email = $_POST["email"];
$password = $_POST["password"];
$latitude = $_POST["latitude"];
$longitude = $_POST["longitude"];

$mysql_qry = "insert into users (name, surname, age, email, password, latitude, longitude) values ('$name', '$surname', '$age', '$email', '$password', '$latitude', '$longitude')";

if($conn->query($mysql_qry)===TRUE) {
  echo "Insert Success";

}

else{
  echo "Error:" . $mysql_qry . "<br>" . $conn->error;
}
$conn->close();
?>
