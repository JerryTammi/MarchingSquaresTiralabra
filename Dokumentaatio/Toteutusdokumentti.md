# Toteutusdokumentti

### Ohjelman yleisrakenne

#### Gui
* Sisältää käyttöliittymän ja sen toiminnallisuuden

#### Util
* LehmerRng: Vastaa ohjelman rng:sta  
* MarchingSquares: Algoritmi jolla luolan grafiikka on generoitu
* Mst: Luokka yhdistää luolan huoneet Kruskalin algoritmilla
* Soluautomaatti: Muuntaa randmosti luodun taulukon suljetuiksi huoneiksi
* Unionfind: Käytetään Mst -luokassa luolan huoneiden yhdistämiseen 
  
#### Luola
* Luola: Vastaa luolan generoimisesta ja tiedon talennuksesta  
* Luolasto: Huolehtii luolien määrästäja koosta.

### Aika- ja tilavaativuudet

#### Tärkeimmät algoritmit ja toiminnot
* Kruskal:in algoritmi: O(e + v log e), jossa e = solmujen määrä ja v = kaarien määrä
* Syvyyshaku: O(n^2)
* Pikajärjestämninen: Parhaimmassa tapauskessa O(n log n) ja huonoimmassa O(n^2)
* Soluautomaatti: O(n^2)
* Marching squares: O(n^2)

### Puutteet ja parannusehdotukset

Suurin virhe oli ohjelman koodaaminen ilman kunnon suunnitelmaa tai ideaa mihin halusi viedä ohjelman.  

### Lähteet
