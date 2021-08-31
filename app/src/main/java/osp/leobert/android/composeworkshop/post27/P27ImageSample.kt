package osp.leobert.android.composeworkshop.post27

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Call
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.ColorFilter
import androidx.compose.ui.graphics.ImageBitmap
import androidx.compose.ui.res.imageResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import com.bumptech.glide.Glide
import osp.leobert.android.composeworkshop.R
import osp.leobert.android.composeworkshop.glide.ComposeImageTarget
import osp.leobert.android.composeworkshop.ui.theme.ComposeWorkShopTheme

class P27ImageSample : ComponentActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContent {
            ComposeWorkShopTheme {
                // A surface container using the 'background' color from the theme
                Surface(color = MaterialTheme.colors.background) {
                    LazyColumn() {

                        item {
                            Image(
                                Icons.Filled.Call,
                                contentDescription = "Call",
                            )
                        }
                        item {
                            Image(
                                ImageBitmap.imageResource(id = R.drawable.baseline_fingerprint_black_24dp),
                                contentDescription = "Check fingerprint",
                            )
                        }
                        item {
                            Image(
                                painterResource(id = R.drawable.baseline_fingerprint_black_24dp),
                                contentDescription = "Call",
                            )
                        }
                        item {
                            Image(
                                ImageBitmap.imageResource(id = R.drawable.baseline_fingerprint_black_24dp),
                                contentDescription = "Check fingerprint",
                                colorFilter = ColorFilter.tint(Color.Green)
                            )
                        }

                        item {
                            val res = ImageBitmap.imageResource(id = R.drawable.text_demo)

                            val imgRes = remember { mutableStateOf(res) }

                            Image(
                                imgRes.value,
                                contentDescription = "Check fingerprint",
                                modifier = Modifier.size(200.dp)
                            )

                            if (imgRes.value == res)
                                Glide.with(this@P27ImageSample)
                                    .asBitmap()
                                    .load("https://img1.baidu.com/it/u=1678797598,221669148&fm=26&fmt=auto&gp=0.jpg")
                                    .placeholder(R.drawable.text_demo)
                                    .into(ComposeImageTarget(imgRes))
                        }

                    }
                }
            }
        }
    }
}
