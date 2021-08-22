package osp.leobert.android.composeworkshop.post27

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
import osp.leobert.android.composeworkshop.ui.theme.ComposeWorkShopTheme

class P27IconSample : ComponentActivity() {

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

                        }
                        item {

                        }
                        item {

                        }

                    }
                }
            }
        }
    }
}
