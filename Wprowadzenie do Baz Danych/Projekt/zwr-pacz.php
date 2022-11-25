<?php

    include 'model.php';

    dbconfig("mariadb106.server754863.nazwa.pl", "server754863", "Cewniczek1!", "server754863");
    $model = new Model();
    session_start();

?>
<html>
    <head>
        <title>Zwrot paczek</title>
    </head>
    <body>
        <h1>Zwrot paczek</h1>

        <form action='zwrot.php' method='POST'>
            <label for='numer'>Odbiorca:&nbsp;&nbsp;&nbsp;&nbsp;</label>
            <select name='numer'>
            <?php
            $model->get("SELECT t2.imie AS odb_imie, t2.nazwisko AS odb_nazw, t3.imie AS nad_imie, t3.nazwisko AS nad_nazw, t1.id_paczki AS idp FROM (bdp_paczki t1 JOIN bdp_klienci t2 ON t1.id_odbiorcy=t2.id_klienta) JOIN bdp_klienci t3 ON t1.id_nadawcy=t3.id_klienta;");
            if ($result->num_rows > 0) {
                while($row = $result->fetch_assoc()) {
                        echo "<option value=\"".$row["idp"]."\">".$row["idp"].". ".$row["nad_imie"]." ".$row["nad_nazw"]." → ".$row["odb_imie"]." ".$row["odb_nazw"]." </option>";
                    }
                }
            ?>
            </select>
            <br>
            <button type='submit'>Prześlij</button>
        </form>

    </body>
</html>