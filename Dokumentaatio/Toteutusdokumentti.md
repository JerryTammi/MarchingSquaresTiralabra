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
* Lista: Oma listarakenne, joka soveltuu erikokoisten taulukoiden (int) säilytykseen.
  
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

Suurin virhe oli ohjelman koodaaminen ilman kunnon suunnitelmaa tai ideaa mihin olisin halunnut viedä ohjelman. Luolan generoiminen toimii kuten pitää, mutta jos pitäisi jotain lisätä niin aloitus- ja  lopetuspisteet ja esim. a*:lla lyhyin reitti niiden välillä. Saatan palata tähän jossain vaiheessa ja koodata tämän javan omilla tietorakenteilla. 

### Lähteet
- https://www.youtube.com/watch?v=yOgIncKp0BE
- https://en.wikipedia.org/wiki/Marching_squares
- https://www.reddit.com/r/gamedev/comments/dx95df/cave_generation_using_bsp_and_cellular_automaton/
- https://gamedevelopment.tutsplus.com/tutorials/generate-random-cave-levels-using-cellular-automata--gamedev-9664
- https://en.wikipedia.org/wiki/Lehmer_random_number_generator
- Tirakirja

