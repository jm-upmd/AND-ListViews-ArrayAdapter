package com.example.profesor.ejemplolistviewyadapters;

public class ListaQuesos {

    private static final ListaQuesos ourInstance = new ListaQuesos();

    private String[] quesos = {
            "Abbaye du Mont des Cats",
            "Abertam",
            "Ackawi",
            "Acorn",
            "Allgauer Emmentaler",
            "Anejo Enchilado",
            "Anthoriro",
            "Ardi Gasna",
            "Asiago",
            "Balaton",
            "Barry's Bay Cheddar",
            "Basing",
            "Bavarian Bergkase",
            "Beauvoorde",
            "Berkswell",
            "Blue",
            "Boeren Leidenkaas",
            "Bra",
            "Buffalo",
            "Cabrales",
            "Caerphilly",
            "Cairnsmore",
            "Canestrato",
            "Castellano",
            "Castelleno",
            "Castelmagno",
            "Castigliano",
            "Comte",
            "Coolea",
            "Coquetdale",
            "Corleggy",
            "Cotherstone",
            "Cotija",
            "Coverdale",
            "Crayeux de Roncq",
            "Crottin de Chavignol",
            "Curworthy",
            "Cwmtawe Pecorino",
            "Denhany Dorset Drum",
            "Derby",
            "Doolin",
            "Dorset Blue Vinney",
            "Double Worcester",
            "Dry Jack",
            "Duddleswell",
            "Dunlop",
            "Duroblando",
            "Dutch Mimolette (Commissiekaas)",
            "Emmental",
            "Etorki",
            "Evora De L'Alentejo",
            "Finlandia Swiss",
            "Fiore Sardo",
            "Folded cheese with mint",
            "Four Herb Gouda",
            "Fourme de Montbrison",
            "Fribourgeois",
            "Friesekaas",
            "Friesian",
            "Fromage a Raclette",
            "Frying Cheese",
            "Gabriel",
            "Gammelost",
            "Gaperon a l'Ail",
            "Garrotxa",
            "Gornyaltajski",
            "Gospel Green",
            "Gowrie",
            "Grafton Village Cheddar",
            "Grana",
            "Grana Padano",
            "Graviera",
            "Gruyere",
            "Halloumi",
            "Halloumy (Australian)",
            "Haloumi-Style Cheese",
            "Heidi Gruyere",
            "Herriot Farmhouse",
            "Iberico",
            "Idaho Goatster",
            "Idiazabal",
            "Isle of Mull",
            "Jarlsberg",
            "Jindi Brie",
            "Kadchgall",
            "Kefalotyri",
            "Laguiole",
            "Lairobell",
            "Lancashire",
            "Laruns",
            "Lavistown",
            "Leafield",
            "Leicester",
            "Leyden",
            "Lincolnshire Poacher",
            "Llanboidy",
            "Llanglofan Farmhouse",
            "Loch Arthur Farmhouse",
            "Longhorn",
            "Lou Palou",
            "Mahon",
            "Malvern",
            "Manchego",
            "Manur",
            "Marble Cheddar",
            "Menallack Farmhouse",
            "Mihalic Peynir",
            "Montasio",
            "Monterey Jack Dry",
            "Northumberland",
            "Orkney Extra Mature Cheddar",
            "Oschtjepka",
            "Parmesan (Parmigiano)",
            "Parmigiano Reggiano",
            "Pecorino",
            "Pecorino Romano",
            "Penbryn",
            "Piora",
            "Plymouth Cheese",
            "Pressato",
            "Pyengana Cheddar",
            "Queso del Tietar",
            "Queso Iberico",
            "Queso Majorero",
            "Queso Para Frier",
            "Raclette",
            "Ragusano",
            "Reggianito",
            "Remedou",
            "Ricotta Salata",
            "Romano",
            "Roncal",
            "Saanenkaese",
            "Sainte Maure",
            "Salers",
            "Sancerre",
            "Sap Sago",
            "Sardo",
            "Sardo Egyptian",
            "Sbrinz",
            "Schabzieger",
            "Serat",
            "Seriously Strong Cheddar",
            "Shelburne Cheddar",
            "Shropshire Blue",
            "Smoked Gouda",
            "Spenwood",
            "Sraffordshire Organic",
            "Stinking Bishop",
            "Swaledale",
            "Swiss",
            "Syrian (Armenian)",
            "Tala",
            "Teifi",
            "Tillamook Cheddar",
            "Tomme d'Abondance",
            "Tyn Grug",
            "Tyning",
            "Ubriaco",
            "Wellington",
            "Wensleydale",
            "White Stilton",
            "Xynotyro",
            "Yarg Cornish",
            "Zamorano",
            "Zanetti Grana Padano",
            "Zanetti Parmigiano Reggiano"
    };

    public static ListaQuesos getInstance() {
        return ourInstance;
    }

    private ListaQuesos() {  // Constructor privado
    }

    public String[] getQuesos() {
        return quesos;
    }
}
