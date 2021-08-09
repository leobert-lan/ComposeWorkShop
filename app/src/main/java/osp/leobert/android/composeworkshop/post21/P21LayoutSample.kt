package osp.leobert.android.composeworkshop.post21

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.verticalScroll
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

class P21LayoutSample : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContent {
            ComposeWorkShopTheme {
                // A surface container using the 'background' color from the theme
                Surface(color = MaterialTheme.colors.background) {


                    LazyColumn() {
                        item {
                            CodeSample("TODO")

                            Box {
                                Box(Modifier.fillMaxSize().background(Color.Cyan))
                                Box(
                                    Modifier.matchParentSize()
                                        .padding(top = 20.dp, bottom = 20.dp)
                                        .background(Color.Yellow)
                                )
                                Box(
                                    Modifier.matchParentSize()
                                        .padding(40.dp)
                                        .background(Color.Magenta)
                                )
                                Box(
                                    Modifier.align(Alignment.Center)
                                        .size(300.dp, 300.dp)
                                        .background(Color.Green)
                                )
                                Box(
                                    Modifier.align(Alignment.TopStart)
                                        .size(150.dp, 150.dp)
                                        .background(Color.Red)
                                )
                                Box(
                                    Modifier.align(Alignment.BottomEnd)
                                        .size(150.dp, 150.dp)
                                        .background(Color.Blue)
                                )
                            }
                        }

                    }

                }
            }
        }
    }
}
