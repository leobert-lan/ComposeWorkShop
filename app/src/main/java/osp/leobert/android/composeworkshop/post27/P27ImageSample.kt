package osp.leobert.android.composeworkshop.post27

import android.os.Bundle
import android.util.Log
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material.Button
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Call
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.ColorFilter
import androidx.compose.ui.graphics.ImageBitmap
import androidx.compose.ui.res.imageResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.lifecycle.MutableLiveData
import com.bumptech.glide.Glide
import com.bumptech.glide.load.engine.DiskCacheStrategy
import osp.leobert.android.composeworkshop.R
import osp.leobert.android.composeworkshop.glide.ComposeImageTarget
import osp.leobert.android.composeworkshop.ui.theme.ComposeWorkShopTheme

class P27ImageSample : ComponentActivity() {
    val imgLiveData by lazy {
        MutableLiveData(ImageBitmap.imageResource(this.resources, id = R.drawable.text_demo))
    }


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

                            Column {

                                val res = ImageBitmap.imageResource(id = R.drawable.text_demo)

                                val imgRes = imgLiveData.observeAsState(res)

                                Log.e("lmsg", "compute ${imgRes.value == res}")
                                Image(
                                    imgRes.value,
                                    contentDescription = null,
                                    modifier = Modifier
                                        .size(200.dp)
                                        .background(Color.LightGray)
                                )
                                Spacer(modifier = Modifier.size(10.dp))
                                Row {
                                    Button(onClick = { loadImage1() }) {
                                        Text(text = "加载图片1")
                                    }

                                    Spacer(modifier = Modifier.size(10.dp))

                                    Button(onClick = { loadImage2() }) {
                                        Text(text = "加载图片2")
                                    }

                                    Spacer(modifier = Modifier.size(10.dp))

                                    Button(onClick = { loadImage3() }) {
                                        Text(text = "加载图片3")
                                    }
                                }
                            }
                        }
                    }
                }
            }
        }
    }

    private fun loadImage1() {
        Glide.with(this@P27ImageSample)
            .asBitmap()
            .load("https://img1.baidu.com/it/u=1678797598,221669148&fm=26&fmt=auto&gp=0.jpg")
            .into(ComposeImageTarget(imgLiveData))
    }

    private fun loadImage2() {
        Glide.with(this@P27ImageSample)
            .asBitmap()
            .load("https://img0.baidu.com/it/u=2244828323,710305807&fm=11&fmt=auto&gp=0.jpg")
            .into(ComposeImageTarget(imgLiveData))
    }

    private fun loadImage3() {
        Glide.with(this@P27ImageSample)
            .asBitmap()
            .load("https://img1.baidu.com/it/u=2882162007,1208714680&fm=11&fmt=auto&gp=0.jpg")
            .skipMemoryCache(true)
            .diskCacheStrategy(DiskCacheStrategy.NONE)
            .into(ComposeImageTarget(imgLiveData))

        Glide.with(this@P27ImageSample)
            .asBitmap()
            .load("https://img0.baidu.com/it/u=2244828323,710305807&fm=11&fmt=auto&gp=0.jpg")
            .into(ComposeImageTarget(imgLiveData))
    }
}
