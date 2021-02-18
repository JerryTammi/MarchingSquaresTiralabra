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

## Ohjelman testikattavuus

![testikattavuus](https://github.com/JerryTammi/MarchingSquaresTiralabra/blob/main/Dokumentaatio/Kuvat/testikattavuusyleinen.png)

Gui- ja Main -luokat eivät kuulu testaukseen.

### Utilityn testaus

![testikattavuusutility](https://github.com/JerryTammi/MarchingSquaresTiralabra/blob/main/Dokumentaatio/Kuvat/testikattavuusutil.png)

#### Tärkeimmät testit
  - Luolan taulukko luodaan oikein eikä sisällä kiellettyjä numeroita.
  - Marching squares -algoritmi toimii oikein lisäämällä luolan seinien palaset oikeisiin paikkoihin. Se myös tarkistaa ettei tuu kiellettyjä lukuja.
  - Tarkistetaan että muodostetaan oikea määrä huoneita luolaan.
  - Tarkistetaan että luolan huoneiden yhdistämisen jälkeen luolassa ei ole huoneita, jotka eivät ole liitettynä muihin. 
  - Soluautomaatti tarkistaa solun vierussolut oikein 

### Luolan/luolaston testaus

![testikattavuusluola](https://github.com/JerryTammi/MarchingSquaresTiralabra/blob/main/Dokumentaatio/Kuvat/testikattavuusluola.png)

#### Tärkeimmät testit
  - Luolastoon oikea määrä luolia
  - Luola ja sen taulukko muodostetaan oikein
