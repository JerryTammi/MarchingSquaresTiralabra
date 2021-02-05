## Viikkoraportti 2

Käytetty aika: n. 10h

Aloitin viikon gui:n kimpussa. Lisäsin napin, joka korvaa nykyisen luolan uudella. Tarkoituksena olisi lisätä sen kaveriksi lisää utilityy kuten esimerkiksi: käytetty aika luolan muodostamiseen ja nappi jonka avulla voi näyttää/piilottaa pisteet (vakiona ne ovat piilossa). Seinät ja lattia ovat erotettu täyttämällä seinien sisäinen alue viivoilla. En ole täysin tyytyväinen tähän toteutukseen tosin se ei ole ollut mikään prioriteetti. Halusin nopeasti vain väsätä jotain jolla erottaa seinät ja lattian ja vilkaisen sitä uudelleen ensi viikolla.

Perlin noise vaikutti epäkäytännölliseltä koodiini, joten päädyin käyttämään cellular automataa (jatkossa "ca") luolan generoimisessa. Tällä hetkellä eka vaihe luolan generoimisessa käyttää random -luokkaa ja sen korvaus omalla rng:llä on ensimmäinen tehtävä tulevalla viikolla. En ole ihan 100% varma ca ja saatan korvata sen toisella jos tulee vastaan parempi vaihtoehto. Generoidut luolat ovat loppujen lopuksi suht. hyvät joten todennäköisesti jään tähän ratkaisuun. 

Koodin testaus on ollut haasteellisin työ tämän viikon aikana. Luola loppujen lopuksi on vain iso kasa viivoja oikeissa paikoissa. Ca:n testaus tuntuu hölmöltä ja tällä hetkellä se vain tarkistaa että randomisti luotuun taulukkoon tulee muutoksia. Siihen pitää keksiä lisää jossain vaiheesa.

Ensi viikon tavotteina random -luokasta eroon korvaamalla se omalla rng luokalla sekä lisää dataa ohjelmasta näkyviin. Generoituun luolaan myös sisääntulo- ja ulospääsyaukko. Jos jää aikaa niin hahmoon lisäys, jota voi liikuttaa luolan sisällä. Tulen myös testaamaan luolan editoimista ohjelman ollessa käynnissä ja lisään sen ohjelmaan jos on tarpeeksi sulava (Luolan päivityksen pitäisi tuntua välittömältä).  
