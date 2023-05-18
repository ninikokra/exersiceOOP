fun main(){

    val politician = Person("ZURA", 100f, 100f, "politic")
    val musician = Person("NIKA", 100f, 100f, "musician")
    val artist = Person("NINI", 100f, 100f, "artist")

    val bank = Bank()

    bank.transferFee(politician,10f)
    bank.transferFee(musician,10f)
    bank.transferFee(artist,10f)
    //bank.monthlyFee(listOf(politician, musician, artist))

    println("Politician balance after: ${politician.balance}")
    println("Musician balance after: ${musician.balance}")
    println("Artist balance after: ${artist.balance}")
    println("collect after sending money: ${bank.comision}")

}
class Person(val name: String, var income: Float, var balance: Float, val job: String)

class Bank() {
    var comision: Float =0.0f

    fun transferFee(person: Person, amount: Float) {
        when (person.job) {
            "musician" -> {
                val amount = person.income *0.1f
                person.balance -= amount
                comision +=amount
            }
            "artist" -> {
                val amount = person.income *0.2f
                person.balance -= amount
                comision +=amount
            }
        }
    }
    fun monthlyFee(people: List<Person>) {
        for (person in people) {
            when (person.job) {
                "politic" -> {
                    val taxAmount = person.income * 0.02f
                    comision += taxAmount
                    person.income -= taxAmount
                }
                "musician" -> {
                    val taxAmount = person.income * 0.04f
                    comision += taxAmount
                    person.income -= taxAmount
                }
                "artist" -> {
                    val taxAmount = person.income * 0.06f
                    comision += taxAmount
                    person.income -= taxAmount
                }
            }
        }
    }

}




