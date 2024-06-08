package vn.poly.mob305.myapplication

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.AlertDialog
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.mutableStateListOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import coil.compose.AsyncImage
import androidx.compose.runtime.getValue
import androidx.compose.runtime.setValue
import androidx.compose.ui.window.Dialog

class MainActivity : ComponentActivity() {
    // LazyColum là 1 compose hiển thị danh sách từ mảng - List - Array ...

    data class Cat(val id: Int, val name: String, val des: String, val url: String)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        // tạo 1 array các loài mèo
        var catList = listOf(
            Cat(
                1, "MEOMEO",
                "Meo rat quy hiem",
                "https://cdn.britannica.com/70/234870-050-D4D024BB/Orange-colored-cat-yawns-displaying-teeth.jpg"
            ),
            Cat(
                2, "MeoBeo",
                "Meo rat quy hiem, nhung hoi luoi an",
                "https://cdn.britannica.com/34/235834-050-C5843610/two-different-breeds-of-cats-side-by-side-outdoors-in-the-garden.jpg"
            ), Cat(
                3, "MEOMEO",
                "Meo rat quy hiem, nhung rat hay an",
                "https://www.animalfriends.co.uk/siteassets/media/images/article-images/cat-articles/51_afi_article1_the-secret-language-of-cats.png"
            ), Cat(
                4, "<MEOMEO>123",
                "Meo rat quy hiem",
                "https://cdn.britannica.com/25/172925-050-DC7E2298/black-cat-back.jpg"
            )
        )

        setContent {
            var catSelected = remember {
                mutableStateOf<Cat?>(null)
            }

            var listStateCatS = remember {
                mutableStateListOf(*catList.toTypedArray())
            }

            LazyColumn {
                itemsIndexed(listStateCatS) { i, it ->
                    Column {
                        Button(onClick = {
                            catSelected.value = it
                        }) {
                            Text(text = "Detail")
                        }
                        Button(onClick = {
                            listStateCatS.remove(it)
                        }) {
                            Text(text = "Delete")
                        }
                        Text(text = "ID : ${it.id}")
                        Text(text = "Name : ${it.name}")
                        Text(text = "Des : ${it.des}")
                        AsyncImage(
                            modifier = Modifier.size(90.dp, 90.dp),
                            model = "${it.url}",
                            contentDescription = "ABC"
                        )
                        Text(text = "-------------------------------------")
                    }
                }
            }
            // cu phap lambda de goi gia tri cua mutableState
            catSelected.value?.let {
                Dialog(onDismissRequest = { catSelected.value = null }) {
                    Column {
                        Text(text = "${catSelected.value?.des}")
                        Text(text = "${catSelected.value?.name}")
                        AsyncImage(
                            modifier = Modifier.size(90.dp, 90.dp),
                            model = "${it.url}",
                            contentDescription = "ABC"
                        )
                    }
                }
//                AlertDialog(
//                    onDismissRequest = {
//                        catSelected.value = null
//                    },
//                    confirmButton = {
//                        Button(
//                            onClick = {
//                                catSelected.value = null
//                            }) {
//                            Text(text = "OK")
//                        }
//                    },
//                    title = { Text(text = "${catSelected.value?.name}") },
//                    text = { Text(text = "${catSelected.value?.des}") },
//                )
            }
        }
    }
}
