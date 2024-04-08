package com.karry.loginregnardos

import android.graphics.ColorSpace.Model
import android.inputmethodservice.Keyboard.Row
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.layout.VerticalAlignmentLine
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.karry.loginregnardos.ui.theme.LoginregnardosTheme

class ColumnActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            LoginregnardosTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
//                    Greeting2("Android")
                    Mylist()

                }
            }
        }
    }
}
data class Fruitmodel(val name:String ,val images:Int)
@Composable
fun Column(model: Fruitmodel) {
    val context= LocalContext.current
    Row(verticalAlignment = Alignment.CenterVertically,
        modifier = Modifier
            .wrapContentHeight()
            .fillMaxWidth()
            .background(color = Color.Black)

    ) {
        Image(painter = painterResource(id = model.images)
            , contentDescription = "", contentScale = ContentScale.Crop
        , modifier = Modifier
                .size(100.dp)
                .padding(5.dp)
        )
        Text(text = model.name,
            fontSize = 22.sp,
            fontFamily = FontFamily.Cursive,
            color = Color.White
        )
    }}

    private val fruitlist= mutableListOf<Fruitmodel>().apply {
        add(Fruitmodel("Apple",R.drawable.apple))
            add(Fruitmodel("DragonFruit",R.drawable.dragon))
            add(Fruitmodel("Lemon",R.drawable.lemon))
            add(Fruitmodel("Mango", R.drawable.img))
            add(Fruitmodel("Strawberry",R.drawable.strawberry))
            add(Fruitmodel("Orange",R.drawable.orange))
            add(Fruitmodel("Coconut",R.drawable.coconut))
            add(Fruitmodel("Kiwi",R.drawable.kiwi))
    }






    @Composable
    fun Mylist() {

        LazyColumn(
            modifier = Modifier
                .fillMaxSize()
                .background(Color.White)
        ) {
            items(fruitlist) { model ->
                Column(model = model)
            }

        }

    }


@Preview
@Composable
private fun Columnprev() {
    Mylist()
}


    



