package vn.poly.mob305.myapplication

// ham start kotlin
const val NAME = "HUY NGUYEN"
const val OLD = 33

fun main(args:Array<String>){
    println("Hello World")
    // cach khai bao bien
    // int a = 129;
    var a = 129 // tu hieu day la bien a so kieu la so nguyen int
    a = 444
    a = 234
    var b : Int = 111;
    var c : Float = 34.4f // 1 so la float
    var d = 3.4 // 1 so thuc

    val e = 100 // khoi tao bien nhung chi dc cap phat gia tri 1 lan
    val f:Float
    f = 33f
    // f = 22f // dong 18 se bao loi

    // cach khai bao mang
    var mangSoNguyen = intArrayOf(3,4,5,6,7,4,3,3,4,6,5,4)
    var mangSoThuc = floatArrayOf(3f,45f,6f,56f)
    var mangKiTu = charArrayOf('3','d','f','d','f')

    // truy cap 1 doi tuong trong mang
    var test = mangKiTu[3]
    var test2 = mangSoNguyen[0]
    println("truy cap 1 phan tu ${mangKiTu[3]}")
    println("truy cap 1 phan tu ${mangSoNguyen[0]}")
    println("ki tu thu 4 : $test")
    println("gia tri dau tien : $test2")
    // cach khai bao void - function

    tinhTong(a,b).also {
        println("Ket qua = $it")
    }

    displayName()

    // cach su dung toan tu - operator
    // + - * / % ++ -- += -= *= .... < > != <= >= ....
    var tong = a.plus(b) // a + b
    var hieu = a.minus(b) // a - b
    var nhan = a.times(b) // a * b
    var chia = a.div(b) // a / b
    var chiaLayDU = a.rem(b) // a % b
    a++
    ++a
    var sosanh = a < b
    var ss = a.compareTo(b)
    println("sossanh : $sosanh")
    println("ss : $ss")

}

fun tinhTong(a:Int, b:Int) : Int{
    return a +  b
}

fun displayName(){
    println(NAME)
}