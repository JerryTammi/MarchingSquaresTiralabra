# Marching Squares luolastogeneraattori

Ohjelma koodattu Java 8:lla.

17.3.21 Lisätty seed:ille määrityspainike

29.4.21 Lisätty A* reitinhakualgoritmi

## Dokumentaatio

[Määrittelydokumentti](https://github.com/JerryTammi/MarchingSquaresTiralabra/blob/main/Dokumentaatio/M%C3%A4%C3%A4rittelydokumentti.md)

[Toteutusdokumentti](https://github.com/JerryTammi/MarchingSquaresTiralabra/blob/main/Dokumentaatio/Toteutusdokumentti.md)

[Testausdokumentti](https://github.com/JerryTammi/MarchingSquaresTiralabra/blob/main/Dokumentaatio/Testausdokumentti.md)

[Käyttöohje](https://github.com/JerryTammi/MarchingSquaresTiralabra/blob/main/Dokumentaatio/Käyttöohje.md)

Viikkoraportit
  - [Viikkoraportti 1](https://github.com/JerryTammi/MarchingSquaresTiralabra/blob/main/Dokumentaatio/viikkoraportti1.md)
  - [Viikkoraportti 2](https://github.com/JerryTammi/MarchingSquaresTiralabra/blob/main/Dokumentaatio/viikkoraportti2.md)
  - [Viikkoraportti 3](https://github.com/JerryTammi/MarchingSquaresTiralabra/blob/main/Dokumentaatio/viikkoraportti3.md)
  - [Viikkoraportti 4](https://github.com/JerryTammi/MarchingSquaresTiralabra/blob/main/Dokumentaatio/viikkoraportti4.md)
  - [Viikkoraportti 5](https://github.com/JerryTammi/MarchingSquaresTiralabra/blob/main/Dokumentaatio/viikkoraportti5.md)
  - [Viikkoraportti 6](https://github.com/JerryTammi/MarchingSquaresTiralabra/blob/main/Dokumentaatio/viikkoraportti6.md)

## Komentorivitoiminnot

###

Ohjelma käynnistyy komennolla

```
mvn compile exec:java -Dexec.mainClass=msluola.marchingsquaresluola.Main
```

### Testaus

Testit komennolla

```
mvn test
```
Testikattavuusraportti komennolla

```
mvn jacoco:report
```
Raportti sijaitsee: "target/site/jacoco/index.html"

### Checkstyle

Checkstyle raportti komennolla

```
mvn jxr:jxr checkstyle:checkstyle
```
Raportti sijaitsee: "target/site/checkstyle.html"
