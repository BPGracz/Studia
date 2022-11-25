<?php

$SQLservername = "aa1ktw3yzwo9y6l.cu01wefbfdo1.us-east-2.rds.amazonaws.com";
$SQLusername = "root";
$SQLpassword = "Cewniczek1!";
$SQLdbname = "ebdb";

function dbconfig($_s, $_u, $_p, $_d) {
	global $SQLservername, $SQLusername, $SQLpassword, $SQLdbname;
	$SQLservername = $_s;
	$SQLusername = $_u;
	$SQLpassword = $_p;
	$SQLdbname = $_d;
}

class Model {
	public function __construct() {
		$result;
	}

	public function get($_query) {
		global $result, $SQLservername, $SQLusername, $SQLpassword, $SQLdbname;
		// Create connection
		$connection = new mysqli($SQLservername, $SQLusername, $SQLpassword, $SQLdbname, 3306);
		// Check connection
		if ($connection->connect_error) {
			echo $connection->connect_error;
			die($connection->connect_error);
		}

		$sql = $_query;
		$result = $connection->query($sql);

		$connection->close();
	}
}

class Controller {
	public function __construct($_model) {
		start();
		$query;
		$model = $_model;
	}

	public function start() {
		
	}

	public function runQuery($query) {
		$model->get($query);
		return $model->result;
	}
}


/*

$servername = "localhost";
$username = "root";
$password = "";
$dbname = "users";

// Create connection
$conn = new mysqli($servername, $username, $password, $dbname);
// Check connection
if ($conn->connect_error) {
  die("Connection failed: " . $conn->connect_error);
}

$sql = "SELECT id, password FROM table_users";
$result = $conn->query($sql);

if ($result->num_rows > 0) {
  // output data of each row
  while($row = $result->fetch_assoc()) {
    echo "id: " . $row["id"].  " id: " . $row["password"]. "<br>";
  }
} else {
  echo "0 results";
}
$conn->close();

?>

*/