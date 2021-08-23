package osp.leobert.android.composeworkshop.post27

import android.annotation.SuppressLint
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material.Icon
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Call
import androidx.compose.material.icons.outlined.Call
import androidx.compose.material.icons.rounded.Call
import androidx.compose.material.icons.sharp.Call
import androidx.compose.material.icons.twotone.Call
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.ImageBitmap
import androidx.compose.ui.res.imageResource
import androidx.compose.ui.res.painterResource
import osp.leobert.android.composeworkshop.R
import osp.leobert.android.composeworkshop.post21.CodeSample
import osp.leobert.android.composeworkshop.ui.theme.ComposeWorkShopTheme

class P27IconSample : ComponentActivity() {

    @SuppressLint("UseCompatLoadingForDrawables")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContent {
            ComposeWorkShopTheme {
                // A surface container using the 'background' color from the theme
                Surface(color = MaterialTheme.colors.background) {
                    LazyColumn() {
                        item {
                            Row {
                                Icon(
                                    Icons.Filled.Call,
                                    contentDescription = "Call"
                                )
                                Icon(
                                    Icons.Outlined.Call,
                                    contentDescription = "Call"
                                )
                                Icon(
                                    Icons.Rounded.Call,
                                    contentDescription = "Call"
                                )
                                Icon(
                                    Icons.TwoTone.Call,
                                    contentDescription = "Call"
                                )
                                Icon(
                                    Icons.Sharp.Call,
                                    contentDescription = "Call"
                                )
                            }
                        }
                        item {
                            CodeSample(
                                code =
                                """
                                imageVector:
                                Icon(
                                    Icons.Filled.Call,
                                    contentDescription = "Call",
                                )
                                """.trimIndent()
                            )
                            Icon(
                                Icons.Filled.Call,
                                contentDescription = "Call",
                            )
                        }
                        item {
                            CodeSample(
                                code =
                                """
                                bitmap demo:
                                Icon(
                                    ImageBitmap.imageResource(id = R.drawable.baseline_fingerprint_black_24dp),
                                    contentDescription = "Check fingerprint",
                                )
                                """.trimIndent()
                            )
                            Icon(
                                ImageBitmap.imageResource(id = R.drawable.baseline_fingerprint_black_24dp),
                                contentDescription = "Check fingerprint",
                            )
                        }
                        item {
                            CodeSample(
                                code =
                                """
                                painter demo:
                                Icon(
                                painterResource(id = R.drawable.baseline_fingerprint_black_24dp),
                                contentDescription = "Call",
                                )
                                """.trimIndent()
                            )
                            Icon(
                                painterResource(id = R.drawable.baseline_fingerprint_black_24dp),
                                contentDescription = "Call",
                            )
                        }
                        item {
                            Icon(
                                ImageBitmap.imageResource(id = R.drawable.baseline_fingerprint_black_24dp),
                                contentDescription = "Check fingerprint",
                                tint = Color.Green
                            )
                        }

                    }
                }
            }
        }
    }
}
