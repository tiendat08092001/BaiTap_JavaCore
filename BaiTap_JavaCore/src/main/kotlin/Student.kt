class Student(name: String, year: Int, phone: String, specialization: String) {
    var name : String
    var year : Int
    var phone : String
    var specialization : String

    init {
        this.name = name
        this.year = year
        this.phone = phone
        this.specialization = specialization
    }

    fun showInfo(){
        println("name: ${this.name}  year: ${this.year}  phone: ${this.phone} specialization: ${this.specialization}")
    }

}