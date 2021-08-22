package osp.leobert.android.composeworkshop

import android.app.Activity
import android.content.Intent
import android.graphics.drawable.shapes.Shape
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.foundation.shape.CornerSize
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.ColorMatrix
import androidx.compose.ui.graphics.RectangleShape
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import osp.leobert.android.composeworkshop.post21.P21DrawSample
import osp.leobert.android.composeworkshop.post21.P21LayoutSample
import osp.leobert.android.composeworkshop.post26.P26ButtonSample
import osp.leobert.android.composeworkshop.post26.P26TextFieldSample
import osp.leobert.android.composeworkshop.post26.P26TextSample
import osp.leobert.android.composeworkshop.post27.P27IconSample
import osp.leobert.android.composeworkshop.ui.theme.ComposeWorkShopTheme
import osp.leobert.android.composeworkshop.ui.theme.MainTxt

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            ComposeWorkShopTheme {
                // A surface container using the 'background' color from the theme
                Surface(color = MaterialTheme.colors.background) {
                    Column {
                        Box(
                            modifier = Modifier
                                .height(48.dp)
                                .fillMaxWidth()
                                .background(color = Color.LightGray),
                            contentAlignment = Alignment.Center
                        ) {

                            Text(
                                text = "Jetpack Compose Work Shop",
                                color = MainTxt,
                                textAlign = TextAlign.Center
                            )
                        }

                        TestList(
                            activity = this@MainActivity, cases = arrayListOf(
                                "Layout samples" to P21LayoutSample::class.java,
                                "Draw samples" to P21DrawSample::class.java,
                                "Text samples" to P26TextSample::class.java,
                                "TextField samples" to P26TextFieldSample::class.java,
                                "Button samples" to P26ButtonSample::class.java,
                                "Icon samples" to P27IconSample::class.java,
                            )
                        )
                    }
                }
            }
        }
    }
}

@Composable
fun Greeting(name: String) {
    Text(text = "Hello $name!")
}

@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    ComposeWorkShopTheme {
        Greeting("Android")
    }
}


@Composable
fun TestList(activity: Activity, cases: List<Pair<String, Class<out Activity>>>) {
    LazyColumn(contentPadding = PaddingValues(horizontal = 16.dp, vertical = 8.dp)) {
        itemsIndexed(items = cases) { _, item ->
            Box(
                modifier = Modifier
                    .height(48.dp)
                    .fillMaxWidth()
                    .background(
                        color = Color.LightGray,
                        shape = RoundedCornerShape(CornerSize(6.dp))
                    )
                    .clickable {
                        activity.startActivity(Intent(activity, item.second))
                    },
                contentAlignment = Alignment.Center
            ) {
                Text(
                    text = item.first,
                    color = MainTxt,
                    textAlign = TextAlign.Center
                )
            }
        }
    }
}