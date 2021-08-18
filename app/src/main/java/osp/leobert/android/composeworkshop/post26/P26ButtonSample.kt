package osp.leobert.android.composeworkshop.post26

import android.os.Bundle
import android.widget.ImageButton
import android.widget.Toast
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.text.InlineTextContent
import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.foundation.text.appendInlineContent
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Clear
import androidx.compose.material.icons.filled.Favorite
import androidx.compose.material.icons.filled.Info
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.focus.focusTarget
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.layoutId
import androidx.compose.ui.semantics.semantics
import androidx.compose.ui.text.*
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.TextFieldValue
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextDecoration
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.em
import androidx.compose.ui.unit.sp
import osp.leobert.android.composeworkshop.ui.theme.ComposeWorkShopTheme

class P26ButtonSample : ComponentActivity() {

    private fun toast(str: String) {
        Toast.makeText(this, str, Toast.LENGTH_SHORT).show()
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContent {
            ComposeWorkShopTheme {
                // A surface container using the 'background' color from the theme
                Surface(color = MaterialTheme.colors.background) {
                    LazyColumn() {
                        item {
                            Button(
                                onClick = {
                                    toast("onClick")
                                },
                                modifier = Modifier.clickable {
                                    toast("Modifier.onClick")
                                }
                            ) {
                                Text(
                                    text = "Button",
                                )
                            }
                        }
                        item {
                            Button(
                                onClick = {
                                    toast("onClick")
                                }
                            ) {
                                Icon(
                                    Icons.Filled.Favorite,
                                    contentDescription = "Favorite"
                                )
                                Text(
                                    text = "Button",
                                )
                            }
                        }
                        item {
                            OutlinedButton(
                                onClick = {}
                            ) {
                                Icon(
                                    Icons.Filled.Favorite,
                                    contentDescription = "Favorite"
                                )
                                Text(
                                    text = "Button",
                                )
                            }
                        }
                        item {
                            IconButton(
                                onClick = {
                                    toast("onClick")
                                },
                            ) {
                                Text(
                                    text = "Button",
                                )
                            }
                        }
                        item {
                            IconButton(
                                onClick = {
                                    toast("onClick")
                                },
                            ) {
                                Icon(
                                    imageVector = Icons.Filled.Favorite,
                                    contentDescription = "Favorite"
                                )
                            }
                        }
                        item {
                            val checkedState = remember { mutableStateOf(true) }

                            IconToggleButton(
                                checked = checkedState.value,
                                onCheckedChange = {
                                    checkedState.value = it
                                },
                            ) {
                                Icon(
                                    imageVector = Icons.Filled.Favorite,
                                    contentDescription = "Favorite",
                                    tint = if (checkedState.value) {
                                        Color.Red
                                    } else {
                                        Color.Gray
                                    }
                                )
                            }
                        }
                    }
                }
            }
        }
    }
}
