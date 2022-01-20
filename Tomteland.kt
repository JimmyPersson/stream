package Inlämningsuppgift2


/*
Tomtarna på Nordpolen har en strikt chefs-hierarki
Högsta chefen för allt är "Tomten"
Under "Tomten" jobbar "Glader" och "Butter"
Under "Glader" jobbar "Tröger", "Trötter"och "Blyger"
Under "Butter" jobbar "Rådjuret", "Nyckelpigan", "Haren" och "Räven"
Under "Trötter" jobbar "Skumtomten"
Under "Skumtomten" jobbar "Dammråttan"
Under "Räven" jobbar "Gråsuggan" och "Myran"
Under "Myran" jobbar "Bladlusen"

Er uppgift är att illustrera tomtens arbetshierarki i en lämplig datastruktur.
(Det finns flera tänkbara datastrukturer här)

Skriv sedan en funktion där man anger ett namn på tomten eller någon av hens underhuggare som
inparameter.
Funktionen listar sedan namnen på alla underlydandesom en given person har
Expempel: Du anger "Trötter" och får som svar ["Skumtomten", "Dammråttan"]"

För att bli godkänd på uppgiften måste du använda rekursion.

 */

class Tomteland {


    val listOfUnderlings = mapOf(
        "Tomten" to mutableListOf("Glader", "Butter"),
        "Glader" to mutableListOf("Tröger", "Trötter", "Blyger"),
        "Butter" to mutableListOf("Rådjuret", "Nyckelpigan", "Haren", "Räven"),
        "Trötter" to mutableListOf("Skumtomten"),
        "Skumtomten" to mutableListOf("Dammråttan"),
        "Räven" to mutableListOf("Gråsuggan", "Myran"),
        "Myran" to mutableListOf("Bladlusen")
    )

    fun getUnderlings(currentName: String, res: MutableList<String>): List<String> {
        var resultList:MutableList<String> = mutableListOf()

        for((key, value) in listOfUnderlings)

            if (key == currentName) {
                resultList += value

                for(i in 0 until resultList.size) {
                    var currentName = resultList[i]
                        if (listOfUnderlings.containsKey(currentName))
                        resultList += getUnderlings(currentName, resultList)
                }
        }

        return resultList
    }

    fun main() {

        //Exempel på anrop till den rekursiva funktionen getUnderlings,
        // här är tanken att hitta Gladers underlydande
        //listan fylls på successivt när vi rekurserar

        var list: MutableList<String> = mutableListOf()
        println(getUnderlings("Glader", list))

    }
}
