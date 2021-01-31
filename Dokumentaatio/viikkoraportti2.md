## Viikkoraportti 2

Käytetty aika: n. 13h

Ohjelman perustoiminnallisuus on pistetty pystyyn. Tällä hetkellä se täyttää Random -luokan avulla taulukon täyteen 1 tai 0 ja muodostaa niistä ikkunan täynnä valkoisia (taulukossa 1) ja mustia (taulukossa 0) pisteitä. Tämän jälkeen käydään loopin avulla läpi jokainen piste (x,y), josta muodostetaan neliö, jonka jokainen kulma vastaa pistettä: (x,y), (x,y+1), (x+1,y+1), (x+1,y). Näistä saadaan muodostettua binääriesitys riippuen onko taulukon arvo 1 tai 0, esim. "1111", joka muutetaan sen desimaaliin. Mahdollisia tuloksia on 16, joista ohjelma valitsee saadun numeron ja muodostaa viivan sen mukaan. Viivan muodostamisesta tarkempaa tietoa kuvassa. Tällä hetkellä pisteet näkyvät ohjelmassa, mutta tarkoituksena on piilottaa ne kun ohjelma on edennyt riittävän pitkälle. Tälle hetkelle ne auttavat visualisoimaan miten algoritmi toimii.

![Yhden viivan muodostaminen algoritmissa](https://github.com/JerryTammi/MarchingSquaresTiralabra/blob/main/Dokumentaatio/Kuvat/ms3.JPG)

Tällä hetkellä taulukon arvojen muodostaminen tehdään random -luokan avulla ja seuraavaksi ideana olisi poistaa se ja lisätä algoritmi, joka luo hieman avonnaisemman luolan. Olen jonkin aikaa halunnut päästä testailemaan Perlin -noisea, joten aloitan siitä ja katsotaan mitä käy. Haluan myös että napin painaluksella se generoi uuden luolan ilman että ohjelma pitää käynnistää uudelleen. Koodi on javadocilla kommentoitu ja checkstyle käytössä.

Koodin testauksessa on ollut ongelmia. Kun sijoitan junit rivit pom.xml:ään alkaa jatkuvat virheet eikä ohjelma suostu käynnistymään. Testejä ei ole tällä hetkellä sillä heti alkuvaiheissa homma hajoo käsiin. Tähän jotain vinkkejä? Itse pomiin en ole koskenut muuten kun lisäämällä siihen checkstyle -pluginin. 

Seuraavan viikon tavotteina testaus kuntoon, jonka jälkeen lähden kokeilemaan eri tapoja generoida luolia. Itse Marching squares -algoritmi toimii jo ja haasteena on taulukon täyttö numeroilla, jotka eivät ole liian satunnaiset. Jos jää aikaa tarkoituksena myös koodata käyttöliittymä, jonka avulla voi määrittää esim. luolan koon ja pisteiden välin pituuden.

1.2.21 Päivitys 

Piti poistaa java ja netbeans sekä asentaa uudelleen, mutta nyt kaikki toimii kuten pitää.

