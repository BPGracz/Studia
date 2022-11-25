<?php
    include 'model.php';

    dbconfig("mariadb106.server754863.nazwa.pl", "server754863", "Cewniczek1!", "server754863");
    $model = new Model();
    session_start();

    $query = "DELETE FROM bdp_paczki WHERE id_paczki = '".$_POST["numer"]."';";
    $model->get($query);
    header("Location: zwr-pacz.php");
?>