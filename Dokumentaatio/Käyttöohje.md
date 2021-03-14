# Käyttöohje

Ohjelma on koodattu Java 8:lla, jonka pitää löytyä koneelta, jotta ohjelma käynnistyy

Kun ohjelma on ladattu ja zip-tiedosto purettu ohjelman voi käynnistää joko komennolla: 
```
mvn compile exec:java -Dexec.mainClass=msluola.marchingsquaresluola.Main
```
tai generoimalla uusi jar-tiedosto:
```
mvn package
```
joka löytyy target -kansiosta.  Toinen vaihtoehto on ladata pelkkä jar-tiedosto release:ista

#### Luolan määrittely

![asetusten määrittely](https://github.com/JerryTammi/MarchingSquaresTiralabra/blob/main/Dokumentaatio/Kuvat/asetuksetkuva.png)

Voidaan määrittää: 
* Luolien määrä: 2 - 100000
* Luolan leveys: 500 - 2560 pikseliä
* Luolan korkeus: 500 - 1440 pikseliä
* Luolan tiheys: Kaksi vaihtoaehtoa, 10 tai 20 pikseliä

#### Luola

![luola](https://github.com/JerryTammi/MarchingSquaresTiralabra/blob/main/Dokumentaatio/Kuvat/luolakuva.png)

Voidaan:
* Generoida seuraava luola
* Näyttää pisteet
* Tulostaa luola, jos ohjelma on käynnistetty komentorivin kautta tai konsoliin on pääsy
* Muuttaa luolatyyppiä: 3 eri vaihtoehtoa
* Palata asetuksiin

