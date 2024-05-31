package vn.poly.mob305.myapplication

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateListOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.RectangleShape
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import kotlin.random.Random

class MainActivity : ComponentActivity() {
    // cách thể hiện 1 danh sách từ Array Object lên LazyColumn
    // cập nhật, sửa, xóa trên LazyColumn

    // tao class Sinh Vien
    data class Student(val name: String, val number: String)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        // tao Array Sinh Vien - Load Students from DB

        var arrList = mutableListOf<Student>()
        // tao du lieu mau
        for (i in 1..100){
            arrList.add(Student("Huy " + Random.nextInt(), "1234"))
        }
        setContent {
            // nạp mảng SV vào 1 biến list state (trạng thái)
            // khi tác động vào state này thì dữ liệu sẽ được cập nhật lên màn hình
            val stateList = remember {
                mutableStateListOf(*arrList.toTypedArray())
            }
            LazyColumn {
                itemsIndexed(stateList){ position , it ->
                    Row {
                        Text(text = it.name, fontSize = 22.sp )
                        Button(onClick = {
                            stateList.remove(it)
                        }) {
                            Text(text = "Delete")
                        }
                        Button(onClick = {
                            // cập nhật 1 item bằng các nhân bản item hiện tại,
                            // thuộc tính nào được cập nhật thì gán giá trị mới
                            stateList[position] = it.copy(name = "UPDATE", number = "OKOKO")
                        }) {
                            Text(text = "Update")
                        }
                    }
                }
            }
        }


    }
}
