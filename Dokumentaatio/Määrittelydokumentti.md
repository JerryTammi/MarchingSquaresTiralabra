# Määrittelydokumentti

Työn idea on generoida erilaisia 2D-luolia käyttäen Marching squares -algoritmia. Ohjelmalle joko annetaan erilaisia parametrejä joiden avulla se generoi uuden luolan tai antaa ohjelman valita satunnaisesti lopputuloksen. Ohjelmalle annettavat parametrit määrittävät kuinka vaikeakulkuista/satunnasita maasto tulee olemaan. Jos riittää aikaa, ohjelmassa tulee olemaan pieni hahmo jota voi liikuttaa luolan sisällä. Aikavaativuuden tavoitteeksi tulee olemaan O(n^2).

Työ ohjelmoidaan javalla ja kieli tulee olemaan suomi.

Opinto-ohjelma: Kemian kandiohjelma

## Marching squares

Algoritmin idea on jakaa ruutu samankokoisiin neliöihin, jossa jokaisen neliön reunassa on solu jonka arvo on 1 tai 0. Erilaisia ruutuja on 16 ja yhdistämällä niitä tiettyjen ehtojen mukaan ideana on generoida yhtenäinen luola. 

![Marching squares](https://github.com/JerryTammi/MarchingSquaresTiralabra/blob/main/Dokumentaatio/Kuvat/ms2.JPG)

Tavoitteena myös olisi että luolaa voisi vielä muokata generoimisen jälkeen joko satunnaisesti muuttamalla koko luola tai eri osaalueita.

Lähteet:
 - https://en.wikipedia.org/wiki/Marching_squares
 - https://www.youtube.com/watch?v=0ZONMNUKTfU
 - http://jamie-wong.com/2014/08/19/metaballs-and-marching-squares/
