package osp.leobert.android.composeworkshop.post28

import android.os.Bundle
import android.util.Log
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material.*
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import osp.leobert.android.composeworkshop.ui.theme.ComposeWorkShopTheme

class P28SwitchRbCbSample : ComponentActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContent {
            ComposeWorkShopTheme {
                // A surface container using the 'background' color from the theme
                Surface(color = MaterialTheme.colors.background) {
                    LazyColumn() {

                        item {
                            Switch(checked = false, onCheckedChange = {
                                Log.d("tag", "onCheckChanged:$it")
                            })
                        }

                        item {
                            var checked by rememberSaveable { mutableStateOf(false) }

                            Switch(checked = checked, onCheckedChange = {
                                checked = it
                                Log.d("tag", "onCheckChanged:$it")
                            })
                        }

                        item {
                            val checked = remember { mutableStateOf(false) }

                            Switch(checked = checked.value, onCheckedChange = {
                                checked.value = it
                                Log.d("tag", "onCheckChanged:$it")
                            })
                        }

                        item {
                            var checked by rememberSaveable { mutableStateOf(false) }

                            Checkbox(checked = checked, onCheckedChange = {
                                checked = it
                                Log.d("tag", "onCheckChanged:$it")
                            })
                        }

                        item {
                            val tags = arrayListOf("A", "B", "C", "D")
                            val selectedTag = remember { mutableStateOf("") }

                            Row {
                                tags.forEach {
                                    Row {
                                        RadioButton(
                                            selected = it == selectedTag.value,
                                            onClick = {
                                                selectedTag.value = it
                                            }
                                        )

                                        Text(text = it)
                                    }

                                    Spacer(modifier = Modifier.width(20.dp))
                                }
                            }
                        }

                        item {
                            val tags = arrayListOf("A", "B", "C", "D")
                            var selectedTag by rememberSaveable { mutableStateOf("") }


                            Row {
                                tags.forEach {
                                    Row {
                                        RadioButton(
                                            selected = selectedTag == it,
                                            onClick = {
                                                selectedTag = it
                                            }
                                        )

                                        Text(text = it, modifier = Modifier.clickable {
                                            selectedTag = it
                                        })
                                    }

                                    Spacer(modifier = Modifier.width(20.dp))
                                }
                            }
                        }

                        item {
                            Text(text = "一个错误的多选示例")
                            val tags = arrayListOf("A", "B", "C", "D")
                            var selectedItems by rememberSaveable { mutableStateOf(linkedSetOf<String>()) }


                            Row {
                                tags.forEach {
                                    Row {
                                        Checkbox(
                                            checked = selectedItems.contains(it),
                                            onCheckedChange = { selected ->
                                                if (selected) {
                                                    selectedItems.add(it)
                                                } else {
                                                    selectedItems.remove(it)
                                                }
                                                Log.d("tag", "onCheckChanged:$it,$selected")
                                            })

                                        Text(text = it)
                                    }

                                    Spacer(modifier = Modifier.width(20.dp))
                                }
                            }
                        }

                        item {
                            Text(text = "会被lint警告的实现方案")
                            val tags = arrayListOf("A", "B", "C", "D")
                            val selectedItems by rememberSaveable { mutableStateOf(linkedSetOf<String>()) }
                            var version by rememberSaveable { mutableStateOf(0) }


                            Row {
                                tags.forEach {
                                    Row {
                                        Checkbox(
                                            checked = version != null && selectedItems.contains(
                                                it
                                            ), onCheckedChange = { selected ->
                                                if (selected) {
                                                    selectedItems.add(it)
                                                } else {
                                                    selectedItems.remove(it)
                                                }
                                                version++
                                                Log.d("tag", "onCheckChanged:$it,$selected")
                                            })

                                        Text(text = it)
                                    }

                                    Spacer(modifier = Modifier.width(20.dp))
                                }
                            }
                        }

                    }
                }
            }
        }
    }
}
