<?php

    include 'model.php';

    dbconfig("mariadb106.server754863.nazwa.pl", "server754863", "Cewniczek1!", "server754863");
    $model = new Model();
    session_start();

?>
<html>
    <head>
        <title>Pokaż paczki po placówkach</title>
    </head>
    <style>
    td {
    border: 2px solid black;
    }
    table {
    border-collapse: collapse;
    }
    </style>
    <body>
        <h1>Pokaż paczki po placówkach</h1>

        <form action='pokaz.php' method='POST'>
            <label for='plac'>Odbiorca:&nbsp;&nbsp;&nbsp;&nbsp;</label>
            <select name='plac'>
            <?php
            $model->get("SELECT * FROM bdp_placowki");
            if ($result->num_rows > 0) {
                while($row = $result->fetch_assoc()) {
                        echo "<option value=\"".$row["id_placowki"]."\">".$row["id_placowki"].". ".$row["nazwa"].", ".$row["adres"].", ".$row["miasto"]." </option>";
                    }
                }
            ?>
            </select>
            <br>
            <button type='submit'>Prześlij</button>
        </form>

        <?php
            if (array_key_exists("plac",$_GET)){
                $model->get("SELECT t2.imie AS odb_imie, t2.nazwisko AS odb_nazw, t3.imie AS nad_imie, t3.nazwisko AS nad_nazw, t1.id_paczki AS idp, t4.imie AS kur_imie, t4.nazwisko AS kur_nazw FROM ((bdp_paczki t1 JOIN bdp_klienci t2 ON t1.id_odbiorcy=t2.id_klienta) JOIN bdp_klienci t3 ON t1.id_nadawcy=t3.id_klienta) JOIN bdp_kurierzy t4 ON t1.id_kuriera=t4.id_kuriera WHERE t1.id_placowki=".$_GET["plac"]."");
                $paczki_info = array(array(),array(),array(),array());
                
                if ($result->num_rows > 0) {
                    while($row = $result->fetch_assoc()) {
                        array_push($paczki_info[0],$row["idp"].".");
                        array_push($paczki_info[1],$row["nad_imie"]." ".$row["nad_nazw"]);
                        array_push($paczki_info[2],$row["odb_imie"]." ".$row["odb_nazw"]);
                        array_push($paczki_info[3],$row["kur_imie"]." ".$row["kur_nazw"]);
                    }
                }

                echo<<<END
    <table>
    <tr>
        <td>identyfikator</td>
        <td>od</td>
        <td>do</td>
        <td>kurier</td>
    </tr>
END;
        for($i=0; $i<count($paczki_info[0]); $i++) {
            echo('<tr><td>'.$paczki_info[0][$i].'</td>');
            echo('<td>'.$paczki_info[1][$i].'</td>');
            echo('<td>'.$paczki_info[2][$i].'</td>');
            echo('<td>'.$paczki_info[3][$i].'</td></tr>');
        }
    echo "</table>";
            }
            else
            echo "<h2>Wybierz placówkę</h2>";
        ?>

    </body>
</html>