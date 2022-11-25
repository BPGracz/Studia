function funa()
{

  function sub1()
  {
    var x = 13;    
  document.getElementById("dziw1").innerHTML = "dziw1:oto wartosc x z sub1 "+x;
  sub2();
   }
  function sub2() 
  {
	var y = x;
	document.getElementById("dziw2").innerHTML = "dziw2:wartosc y z sub2= "+ y;
	//y = [2.5, 3.6, 7.7];
	//document.getElementById("dziw4").innerHTML = "dziw4:a po kolejnym podstawieniu w sub2 y[0]= "+ y[0];
	// odkomentuj zakomentowane polecenia i sprawdź, czy te instrukcje są wykonalne?
   }	
  var x = 5; 
  
  sub1();
 
}

