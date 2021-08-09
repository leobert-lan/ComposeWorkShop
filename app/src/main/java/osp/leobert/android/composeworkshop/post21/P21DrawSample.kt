package osp.leobert.android.composeworkshop.post21

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.alpha
import androidx.compose.ui.draw.rotate
import androidx.compose.ui.draw.scale
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.RectangleShape
import androidx.compose.ui.unit.dp
import osp.leobert.android.composeworkshop.ui.theme.ComposeWorkShopTheme
import osp.leobert.android.composeworkshop.ui.theme.MainTxt

class P21DrawSample : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            ComposeWorkShopTheme {
                // A surface container using the 'background' color from the theme
                Surface(color = MaterialTheme.colors.background) {


                    LazyColumn() {
                        item {
                            CodeSample("Box(Modifier.size(100.dp).alpha(alpha = 0.5f).background(Color.Red))")
                            Box(Modifier
                                .size(100.dp)
                                .alpha(alpha = 0.5f)
                                .background(Color.Red))
                        }
                        item {
                            CodeSample(code = "Box(Modifier.rotate(45f).size(100.dp, 100.dp).background(Color.Red))")
                            Box(Modifier
                                .rotate(45f)
                                .size(100.dp, 100.dp)
                                .background(Color.Red))
                        }

                        item {
                            CodeSample(code = "注意次序带来的影响：Box(Modifier.size(100.dp, 100.dp).background(Color.Red).rotate(45f)")
                            Box(Modifier
                                .size(100.dp, 100.dp)
                                .background(Color.Red)
                                .rotate(45f))
                        }

                        item {
                            CodeSample(code = "Box(Modifier.scale(scaleX = 0.2f, scaleY = 0.3f).size(100.dp, 100.dp).background(Color.Red))")
                            Box(Modifier
                                .scale(scaleX = 0.2f, scaleY = 0.3f)
                                .size(100.dp, 100.dp)
                                .background(Color.Red))
                        }

                        item {
                            CodeSample(code = "Box(Modifier.scale(0.2f).size(100.dp, 100.dp).background(Color.Red))")
                            Box(Modifier
                                .scale(0.2f)
                                .size(100.dp, 100.dp)
                                .background(Color.Red))
                        }

                        item {
                            CodeSample(code = "Box(Modifier.shadow(12.dp, RectangleShape).size(100.dp, 100.dp).background(Color.Red))")
                            Box(Modifier
                                .shadow(12.dp, RectangleShape)
                                .size(100.dp, 100.dp)
                                .background(Color.Red))
                        }
                    }

                }
            }
        }
    }
}

@Composable
fun CodeSample(code: String) {
    Box(modifier = Modifier
        .wrapContentHeight()
        .padding(5.dp)
        .fillMaxWidth()
        .background(color = Color.LightGray),
        contentAlignment = Alignment.Center) {

        Text(
            text = code,
            color = MainTxt,
        )
    }
}