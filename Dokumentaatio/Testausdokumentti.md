# Testausdokumentti

Testit komennolla
```
mvn test
```
Testikattavuusraportti komennolla

```
mvn jacoco:report
```
Raportti sijaitsee: "target/site/jacoco/index.html"

Checkstyle raportti komennolla

```
mvn jxr:jxr checkstyle:checkstyle
```
Raportti sijaitsee: "target/site/checkstyle.html"

## Ohjelman testikattavuus

![testikattavuus](https://github.com/JerryTammi/MarchingSquaresTiralabra/blob/main/Dokumentaatio/Kuvat/testikattavuusyleinen.png)

Gui- ja Main -luokat eivät kuulu testaukseen.

### Utilityn testaus

![testikattavuusutility](https://github.com/JerryTammi/MarchingSquaresTiralabra/blob/main/Dokumentaatio/Kuvat/testikattavuusutil.png)

#### Tärkeimmät testit
  - Luolan taulukko luodaan oikein eikä sisällä kiellettyjä numeroita.
  - Marching squares -algoritmi toimii oikein lisäämällä luolan seinien palaset oikeisiin paikkoihin. Se myös tarkistaa ettei esiinny kiellettyjä lukuja.
  - Tarkistetaan että muodostetaan oikea määrä huoneita luolaan.
  - Tarkistetaan että luolan huoneiden yhdistämisen jälkeen luolassa ei ole huoneita, jotka eivät ole liitettynä muihin. 
  - Soluautomaatti tarkistaa solun vierussolut oikein 

### Luolan/luolaston testaus

Luolan testikattavuus näyttää paljon huonommalta kuin todellisuudessa. Luolan taulukon tulostusta tai pisteiden esittäistä ei ole testattu.

![testikattavuusluola](https://github.com/JerryTammi/MarchingSquaresTiralabra/blob/main/Dokumentaatio/Kuvat/testikattavuusluola.png)

#### Tärkeimmät testit
  - Luolastoon oikea määrä luolia
  - Luola ja sen taulukko muodostetaan oikein

## Ohjelman suorituskyvyn testausta

Suorituskykyä on mitattu generoimalla n-määrä luolia, jossa taulukko on ollut 50x50

* Pelkän taulukon generoiminen

| Luolien määrä | aika (s) |
|---------------|----------|
|     1         | 0.00098  |
|     10        | 0.0099   |
|     100       | 0.10     |
|     1000      | 1.04     |
|     10000     | 10.17    |
|     100000    | 102.14   |

* Luolan generoiminen mukaan lukien grafiikka

| Luolien määrä | aika (s) |
|---------------|----------|
|     1         | 0.13     |
|     10        | 0.27     |
|     100       | 0.66     |
|     1000      | 3.20     |
|     10000     | 28.55    |
|     100000    | 275.61   |
