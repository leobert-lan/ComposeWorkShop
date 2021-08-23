package osp.leobert.android.composeworkshop.post27

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material.Icon
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Call
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.ColorFilter
import androidx.compose.ui.graphics.ImageBitmap
import androidx.compose.ui.res.imageResource
import androidx.compose.ui.res.painterResource
import osp.leobert.android.composeworkshop.R
import osp.leobert.android.composeworkshop.post21.CodeSample
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

                    }
                }
            }
        }
    }
}
