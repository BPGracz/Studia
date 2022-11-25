<?php
    include 'model.php';

    dbconfig("mariadb106.server754863.nazwa.pl", "server754863", "Cewniczek1!", "server754863");
    $model = new Model();
    session_start();

    header("Location: pok-pacz-p-plac.php?plac=".$_POST["plac"]."");
?>