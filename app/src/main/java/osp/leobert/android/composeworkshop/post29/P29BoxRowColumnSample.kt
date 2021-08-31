package osp.leobert.android.composeworkshop.post29

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyListScope
import androidx.compose.material.Button
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import osp.leobert.android.composeworkshop.DemoActivity
import osp.leobert.android.composeworkshop.post21.CodeSample

class P29BoxRowColumnSample : DemoActivity() {

    @Composable
    override fun content() {
        LazyColumn {
            this.boxDemo()

            this.rowDemo()

        }
    }

    private fun LazyListScope.boxDemo() {
        item {
            CodeSample(code = "一些常用的配套Modifier效果")
            Box {
                Box(Modifier
                    .fillMaxSize()
                    .background(Color.Cyan))
                Box(
                    Modifier
                        .matchParentSize()
                        .padding(top = 20.dp, bottom = 20.dp)
                        .background(Color.Yellow)
                )
                Box(
                    Modifier
                        .matchParentSize()
                        .padding(40.dp)
                        .background(Color.Magenta)
                )
                Box(
                    Modifier
                        .align(Alignment.Center)
                        .size(300.dp, 300.dp)
                        .background(Color.Green)
                )
                Box(
                    Modifier
                        .align(Alignment.TopStart)
                        .size(150.dp, 150.dp)
                        .background(Color.Red)
                )
                Box(
                    Modifier
                        .align(Alignment.BottomEnd)
                        .size(150.dp, 150.dp)
                        .background(Color.Blue)
                )
            }
        }

        item {

            CodeSample(code = "基于当前节点的布局限制：例如最大高度、最小宽度等调整内容")
            var height by rememberSaveable { mutableStateOf(80) }
            BoxWithConstraints(
                modifier = Modifier.height(height.dp)
            ) {
                val rectangleHeight = 50.dp
                if (maxHeight < rectangleHeight * 2) {
                    Box(Modifier
                        .size(50.dp, rectangleHeight)
                        .background(Color.Blue))
                } else {
                    Column {
                        Box(Modifier
                            .size(50.dp, rectangleHeight)
                            .background(Color.Blue))
                        Box(Modifier
                            .size(50.dp, rectangleHeight)
                            .background(Color.Gray))
                    }
                }
            }

            Button(onClick = {
                height = if (height < 100) 100 else 80
            }) {
                Text(text = "点击切换高度")
            }
        }
    }

    private fun LazyListScope.rowDemo() {
        item {
            CodeSample(code = "row sample 1:")
            Row {
                // The child with no weight will have the specified size.
                Box(Modifier
                    .size(40.dp, 80.dp)
                    .background(Color.Magenta))
                // Has weight, the child will occupy half of the remaining width.
                Box(Modifier
                    .height(40.dp)
                    .weight(1f)
                    .background(Color.Yellow))
                // Has weight and does not fill, the child will occupy at most half of the remaining width.
                // Therefore it will occupy 80.dp (its preferred width) if the assigned width is larger.
                Box(
                    Modifier
                        .size(80.dp, 40.dp)
                        .weight(1f, fill = false)
                        .background(Color.Green)
                )
            }
        }

        item {
            CodeSample(code = "row sample 2:纵向居中对齐")
            Row(verticalAlignment = Alignment.CenterVertically) {
                // The child with no weight will have the specified size.
                Box(Modifier
                    .size(40.dp, 80.dp)
                    .background(Color.Magenta))
                // Has weight, the child will occupy half of the remaining width.
                Box(Modifier
                    .height(40.dp)
                    .weight(1f)
                    .background(Color.Yellow))
                // Has weight and does not fill, the child will occupy at most half of the remaining width.
                // Therefore it will occupy 80.dp (its preferred width) if the assigned width is larger.
                Box(
                    Modifier
                        .size(80.dp, 40.dp)
                        .weight(1f)
                        .background(Color.Green)
                )
            }
        }

        item {
            CodeSample(code = "row sample 3:Weight是在剩余的空间基础上进行分配")
            Row {
                // The child with no weight will have the specified size.
                Box(Modifier
                    .size(40.dp, 80.dp)
                    .background(Color.Magenta))
                // Has weight, the child will occupy half of the remaining width.
                Box(Modifier
                    .height(40.dp)
                    .weight(1f)
                    .background(Color.Yellow))
                // Has weight and does not fill, the child will occupy at most half of the remaining width.
                // Therefore it will occupy 80.dp (its preferred width) if the assigned width is larger.
                Box(
                    Modifier
                        .size(80.dp, 40.dp)
                        .weight(1f, fill = false)
                        .background(Color.Green)
                )
                Box(Modifier
                    .size(40.dp, 80.dp)
                    .background(Color.Magenta))
            }
        }

        item {
            CodeSample(code = "row sample 4: 不同于LinearLayout")
            Row {
                // The child with no weight will have the specified size.
                Box(Modifier
                    .size(40.dp, 80.dp)
                    .background(Color.Magenta))
                // Has weight, the child will occupy half of the remaining width.
                Box(Modifier
                    .height(40.dp)
                    .weight(1f)
                    .background(Color.Yellow))
                // Has weight and does not fill, the child will occupy at most half of the remaining width.
                // Therefore it will occupy 80.dp (its preferred width) if the assigned width is larger.
                Box(
                    Modifier
                        .size(80.dp, 40.dp)
                        .weight(1f)
                        .background(Color.Green)
                )
                Box(Modifier
                    .size(40.dp, 80.dp)
                    .background(Color.Magenta))
            }
        }

        item {
            CodeSample(code = "row sample 5: Arrangement")
            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.Center) {
                // The child with no weight will have the specified size.
                Box(Modifier
                    .size(40.dp, 80.dp)
                    .background(Color.Magenta))
            }
        }
    }

}
