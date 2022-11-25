<?php

    include 'model.php';

    dbconfig("mariadb106.server754863.nazwa.pl", "server754863", "Cewniczek1!", "server754863");
    $model = new Model();
    session_start();

?>
<html>
    <head>
        <title>Nadawanie paczek</title>
    </head>
    <body>
        <h1>Nadawanie paczek</h1>

        <form action='nadaj.php' method='POST'>
            <label for='odbiorca'>Odbiorca:&nbsp;&nbsp;&nbsp;&nbsp;</label>
            <select name='odbiorca'>
            <?php
            $model->get("SELECT * FROM bdp_klienci T1 JOIN bdp_placowki T2 ON T1.id_placowki=T2.id_placowki;");
            if ($result->num_rows > 0) {
                while($row = $result->fetch_assoc()) {
                        echo "<option value=\"".$row["id_klienta"]."\">".$row["imie"]." ".$row["nazwisko"].", ".$row["adres"].", ".$row["miasto"]." (".$row["nazwa"].") </option>";
                    }
                }
            ?>
            </select>
            <br>
            <label for='nadawca'>Nadawca:&nbsp;&nbsp;&nbsp;&nbsp;</label>
            <select name='nadawca'>
            <?php
            $model->get("SELECT * FROM bdp_klienci T1 JOIN bdp_placowki T2 ON T1.id_placowki=T2.id_placowki;");
            if ($result->num_rows > 0) {
                while($row = $result->fetch_assoc()) {
                        echo "<option value=\"".$row["id_klienta"]."\">".$row["imie"]." ".$row["nazwisko"].", ".$row["adres"].", ".$row["miasto"]." (".$row["nazwa"].") </option>";
                    }
                }
            ?>
            </select>
            <br>
            
            <label for='kurier'>Kurier:&nbsp;&nbsp;&nbsp;&nbsp;</label>
            <select name='kurier'>
            <?php
            $model->get("SELECT * FROM bdp_kurierzy;");
            if ($result->num_rows > 0) {
                while($row = $result->fetch_assoc()) {
                        echo "<option value=\"".$row["id_kuriera"]."\">".$row["imie"]." ".$row["nazwisko"]."</option>";
                    }
                }
            ?>
            </select>
            <br>
            <label for='placowka'>Placówka:&nbsp;&nbsp;&nbsp;&nbsp;</label>
            <select name='placowka'>
            <?php
            $model->get("SELECT * FROM bdp_placowki;");
            if ($result->num_rows > 0) {
                while($row = $result->fetch_assoc()) {
                        echo "<option value=\"".$row["id_placowki"]."\">".$row["nazwa"].", ".$row["adres"].", ".$row["miasto"]."</option>";
                    }
                }
            ?>
            </select>
            <br>
            <button type='submit'>Prześlij</button>
        </form>
    </body>
</html>