package vn.poly.mob305.myapplication

import android.content.Intent
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Column
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController

class MainActivity : ComponentActivity() {
    // remember : hoc roi
    // từ khóa để lưu trạng thái (state) của 1 biến
    // khi state thay đổi thì giao diện cũng được cập nhật giá trị mới
    // rememberSavable
    // navigation : chuyển hướng màn hình != startActivity
    // navigation ~ fragment : chuyển đổi giao diện componsable
    // ViewModel
    // MVVM
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            // getValue - setValue 
//            var count: Int by remember { mutableStateOf(0) }
//            Button(onClick = { count++ }) {
//                Text(text = "Dem $count", fontSize = 44.sp)
//            }
            // su dung giong remember : saveable : lưu trạng thái lâu hơn so với remember
            // cụ thể : khi ứng dụng đổi language hoặc xoay màn hình thì biến vẫn được lưu
            // remember : reset
//            var count: Int by rememberSaveable { mutableStateOf(0) }
//            Button(onClick = { count++ }) {
//                Text(text = "Dem $count", fontSize = 44.sp)
//            }

            // chuyen man hinh : Intent
            // Chuyen sang 1 man moi hoan toan, ko lien quan man hinh hien tai
//            Button(onClick = {
//                val intent = Intent(this, DetailActivity::class.java)
//                startActivity(intent)
//            }) {
//                Text(text = "Open Activity")
//            }
            // fragment : view nam tren activity : tab, viewpager, menu drawer
            val navController = rememberNavController()
            // NavHost liệt kê các màn hình có trong MainActivity thông qua navController
            // Mỗi màn hình là 1 composable : được đặt tên (route - địa chỉ)
            NavHost(navController = navController, startDestination = "login") {
                composable("login") {
                    LoginScreen(navController = navController)
                }
                composable("signup") {
                    SignUpScreen(navController = navController)
                }
            }
        }
    }
    @Composable
    fun LoginScreen(navController: NavController) {
        Column {
            Text(text = "Login", fontSize = 44.sp)
            Button(onClick = {
                navController.navigate("signup")
            }) {
                Text(text = "Sign Up", fontSize = 22.sp)
            }
        }
    }
    @Composable
    fun SignUpScreen(navController: NavController) {
        Column {
            Text(text = "Sign Up", fontSize = 44.sp)
            Button(onClick = {
                navController.navigate("login")
            }) {
                Text(text = "Login", fontSize = 22.sp)
            }
        }
    }


}