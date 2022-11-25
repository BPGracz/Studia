<?php
    include 'model.php';

    dbconfig("mariadb106.server754863.nazwa.pl", "server754863", "Cewniczek1!", "server754863");
    $model = new Model();
    session_start();

    $query = "INSERT INTO bdp_paczki(id_odbiorcy, id_nadawcy, id_kuriera, id_placowki) VALUES (".$_POST["odbiorca"].", ".$_POST["nadawca"].", ".$_POST["kurier"].", ".$_POST["placowka"].");";
    $model->get($query);
    header("Location: nad-pacz.php");
?>