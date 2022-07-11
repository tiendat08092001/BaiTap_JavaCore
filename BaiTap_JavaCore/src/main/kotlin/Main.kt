fun main() {
    val listStudent = mutableListOf<Student>() // giống Array list trong java
    var name: String
    var year: Int
    var phone: String
    var specialization: String

    showMenu()
    val input: String? = readLine()
    var choose = input?.toInt()

    while (choose != 8) {
        when (choose) {
            0 -> { // hiện menu
                showMenu()
                val input1 = readLine().toString()
                choose = input1.toInt()
            }
            1 -> { // thêm sinh viên
                println("Hay nhap thong tin sinh vien: ")
                println("Ten sinh vien: ")
                name = readLine().toString()
                println("Hay nhap nam sinh: ")
                year = readLine()!!.toInt()
                println("Nhap so dien thoai: ")
                phone = readLine().toString()
                println("Hay nhap chuyen nganh: ")
                specialization = readLine().toString()
                listStudent.add(Student(name, year, phone, specialization))
                println("Ban co muon nhap them sinh vien ko : Y/N?")
                val input1 = readLine().toString()
                if (input1 == "Y") {
                    choose = 1
                } else {
                    choose = 0
                }
            }
            2 -> { // sửa thông tin sinh viên
                println("Nhap so dien thoai de sua thong tin sinh vien: ")
                var phone = readLine().toString()
                val studentOld = listStudent.filter { it.phone == phone }
                if (studentOld.isNullOrEmpty()) {
                    println("Khong co sinh vien nay!!")
                    choose = 0
                } else {
                    println("Nhap ten can sua:")
                    name = readLine().toString()
                    println("Nhap nam can sua")
                    year = readLine()!!.toInt()
                    println("Nhap so dien thoai can sua")
                    phone = readLine().toString()
                    println("Nhap chuyen nganh can sua")
                    specialization = readLine().toString()
                    var studentUpdate = Student(name, year, phone, specialization)
                    listStudent.filter { it.phone == phone }.forEach { it == studentUpdate }
                }
            }
            3 -> { // xóa sinh viên
                println("Nhap so dien thoai sinh vien can xoa: ")
                var phone = readLine().toString()
                var studentOld = listStudent.filter { it.phone == phone }
                if (studentOld.isNullOrEmpty()) {
                    println("Khong co sinh vien nay!!")
                    choose = 3
                } else {
                    listStudent.removeIf { it.phone == phone }
                    println("Xoa thanh cong !!")
                    println("Ban muon xoa them khong: Y/N?")
                    phone = readLine().toString()
                    if (phone == "Y") {
                        choose = 3
                    } else {
                        choose = 0
                    }
                }

            }
            4 -> { // danh sách sinh viên đã sắp xếp theo thứ tự số điện thoại
                println("Danh sach sinh vien: ")
                if (listStudent.size == 0) {
                    println("Chua co sinh vien nao!!")
                    choose = 0
                } else {
                    listStudent.sortBy { it.phone }
                    for (student in listStudent) {
                        student.showInfo()
                    }
                    println("Bam phim C de tro ve menu chinh")
                    var input1 = readLine().toString()
                    if (input1 == "C") {
                        choose = 0
                    }
                }

            }
            5 -> { // lọc sinh viên theo hệ cao đẳng
                val listSinhVienCaoDang = listStudent.filter { it.specialization == "Cao Dang" }
                if (listSinhVienCaoDang.size == 0) {
                    println("Khong co sinh vien nao !!")
                    choose = 0
                } else {
                    for (student in listSinhVienCaoDang) {
                        student.showInfo()
                    }
                    println("Bam C de tro ve man hinh chinh: ")
                    val input1 = readLine().toString()
                    if (input1 == "C") {
                        choose = 0
                    }
                }
            }
            6 -> { // lọc sinh viên đại học
                val listSinhVienDaiHoc = listStudent.filter { it.specialization == "Dai Hoc" }
                if (listSinhVienDaiHoc.size == 0) {
                    println("Khong co sinh vien nao !!")
                    choose = 0
                } else {
                    for (student in listSinhVienDaiHoc) {
                        student.showInfo()
                    }
                    println("Bam C de tro ve man hinh chinh: ")
                    val input1 = readLine().toString()
                    if (input1 == "C") {
                        choose = 0
                    }
                }
            }
            7 -> {
                println("Nhap ten sinh vien can tim: ")
                val tenCanTim = readLine().toString()
                val listSinhVienDaThay = listStudent.filter {
                    it.name.lowercase().contains(tenCanTim.lowercase())
                }
                if (listSinhVienDaThay.size == 0) {
                    println("Khong co sinh vien nao!!")
                    println("Bam C de tro ve man hinh chinh: ")
                    val input1 = readLine().toString()
                    if (input1 == "C") {
                        choose = 0
                    }
                } else {
                    for (student in listSinhVienDaThay) {
                        student.showInfo()
                    }
                    println("Bam C de tro ve man hinh chinh: ")
                    val input1 = readLine().toString()
                    if (input1 == "C") {
                        choose = 0
                    }
                }
            }
        }
    }

    println("Cam on ban da su dung chuong trinh")

}

fun showMenu() {
    println("Hay nhap lua chon : ")
    println("1: them sinh vien ")
    println("2: sua thong tin sinh vien")
    println("3: xoa sinh vien")
    println("4: danh sach sinh vien")
    println("5: Loc sinh vien theo he cao dang")
    println("6: Loc sinh vien theo he dai hoc")
    println("7: Tim kiem sinh vien")
    println("8: Thoat")
}