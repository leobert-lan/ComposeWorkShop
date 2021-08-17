package osp.leobert.android.composeworkshop.post26

import android.os.Bundle
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

class P26TextFieldSample : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val strOnFieldChanged: (String) -> Unit = {

        }


        setContent {
            ComposeWorkShopTheme {
                // A surface container using the 'background' color from the theme
                Surface(color = MaterialTheme.colors.background) {
                    LazyColumn() {
                        item {
                            TextField(
                                value = "文字",
                                onValueChange = {

                                },
                            )
                        }
                        item {
                            var text by rememberSaveable { mutableStateOf("文字") }
                            TextField(
                                value = text,
                                onValueChange = {
                                    text = it
                                }
                            )
                        }
                        item {
                            var text by rememberSaveable { mutableStateOf("") }
                            TextField(
                                value = text,
                                onValueChange = { text = it },
                                label = { Text("Label") },
                                placeholder = { Text("PlaceHolder") }
                            )
                        }
                        item {
                            var text by rememberSaveable { mutableStateOf("") }

                            TextField(
                                value = text,
                                onValueChange = { text = it },
                                placeholder = { Text("PlaceHolder") },
                                leadingIcon = { Icon(Icons.Filled.Favorite, contentDescription = "Favorite") },
                                trailingIcon = { Icon(Icons.Filled.Clear, contentDescription = "Clear",modifier = Modifier.clickable {
                                    text = ""
                                }) }
                            )
                        }

                        item {
                            var text by rememberSaveable { mutableStateOf("") }
                            var isError by rememberSaveable { mutableStateOf(false) }

                            fun validate(text: String) {
                                isError = text.count() < 5
                            }

                            TextField(
                                value = text,
                                onValueChange = {
                                    text = it
                                    isError = false
                                },
                                singleLine = true,
                                label = { Text(if (isError) "Email*" else "Email") },
                                isError = isError,
                                keyboardActions = KeyboardActions { validate(text) },
                                modifier = Modifier.semantics {
                                    // Provide localized description of the error
                                    if (isError) {
                                        Toast.makeText(this@P26TextFieldSample,"输入错误",Toast.LENGTH_SHORT).show()
                                    }
                                }
                            )
                        }
                    }
                }
            }
        }
    }
}
