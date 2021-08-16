package osp.leobert.android.composeworkshop.post26

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.text.InlineTextContent
import androidx.compose.foundation.text.appendInlineContent
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
import androidx.compose.ui.text.*
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextDecoration
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.TextUnit
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.em
import androidx.compose.ui.unit.sp
import osp.leobert.android.composeworkshop.ui.theme.ComposeWorkShopTheme
import osp.leobert.android.composeworkshop.ui.theme.MainTxt

class P26TextSample : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContent {
            ComposeWorkShopTheme {
                // A surface container using the 'background' color from the theme
                Surface(color = MaterialTheme.colors.background) {

//* softWrap - 是否应用换行符. 如果不应用，则一行写完，`overflow` 、`TextAlign` 无效.
//* maxLines - 最大行数，必须大于0.
//* inlineContent - A map store composables that replaces certain ranges of the text. It's used to insert composables into text layout. Check InlineTextContent for more information.
//* onTextLayout - 绘制文字计算布局时的回调
//* style - 样式，例如： color, font, line height 等.
                    LazyColumn() {
                        item {
                            Text(text = "文字")
                        }
                        item {
                            Text(
                                text = "红色文字",
                                color = Color.Red
                            )
                        }
                        item {
                            Text(
                                text = "30sp 红色文字",
                                color = Color.Red,
                                fontSize = 30.sp
                            )
                        }
                        item {
                            Text(
                                text = "斜体 30sp 红色文字",
                                color = Color.Red,
                                fontSize = 30.sp,
                                fontStyle = FontStyle.Italic
                            )
                        }

                        item {
                            Text(
                                text = "加粗(w700) 30sp 红色文字",
                                color = Color.Red,
                                fontSize = 30.sp,
                                fontWeight = FontWeight.Bold
                            )
                        }
                        item {
                            Text(
                                text = "特细(w100) 30sp 红色文字",
                                color = Color.Red,
                                fontSize = 30.sp,
                                fontWeight = FontWeight.Thin
                            )
                        }

                        item {
                            Text(
                                text = "Monospace 30sp 红色文字",
                                color = Color.Red,
                                fontSize = 30.sp,
                                fontFamily = FontFamily.Monospace
                            )
                        }

                        item {
                            Text(
                                text = "10sp字间距文字",
                                letterSpacing = 10.sp
                            )
                        }

                        item {
                            Text(
                                text = "下划线文字",
                                textDecoration = TextDecoration.Underline
                            )
                        }
                        item {
                            Text(
                                text = "居中文字",
                                textAlign = TextAlign.Center
                            )
                        }

                        item {
                            Text(
                                text = "150dp宽，超长超长longlonglonglong文字",
                                Modifier.width(150.dp),
                            )
                        }
                        item {
                            Text(
                                text = "20sp行高，150dp宽，超长超长longlonglonglong文字",
                                Modifier.width(150.dp),
                                lineHeight = 20.sp
                            )
                        }

                        item {
                            Text(
                                text = "overflow= TextOverflow.Ellipsis，超长超长longlonglonglong文字11212wenwenwenwenwenwenwen",
                                overflow = TextOverflow.Ellipsis,
                                maxLines = 1
                            )
                        }
                        item {
                            Text(
                                text = AnnotatedString.Builder("AnnotatedString ")
                                    .apply {
                                        pushStyle(
                                            SpanStyle(
                                                color = Color.Red,
                                                fontSize = 24.sp,
                                                fontStyle = FontStyle.Italic,
                                            )
                                        )
                                        append("一段文字")
                                        pop()
                                        append(" end")
                                    }
                                    .toAnnotatedString()

                            )
                        }

                        item {
                            val myId = "inlineContent"

                            Text(
                                text = buildAnnotatedString {
                                    append("inlineContent 演示")
                                    // Append a placeholder string "[myBox]" and attach an annotation "inlineContent" on it.
                                    appendInlineContent(myId, "[myBox]")
                                },
                                inlineContent = mapOf(
                                    Pair(
                                        // This tells the [CoreText] to replace the placeholder string "[myBox]" by
                                        // the composable given in the [InlineTextContent] object.
                                        myId,
                                        InlineTextContent(
                                            // Placeholder tells text layout the expected size and vertical alignment of
                                            // children composable.
                                            Placeholder(
                                                width = 0.5.em,
                                                height = 0.5.em,
                                                placeholderVerticalAlign = PlaceholderVerticalAlign.AboveBaseline
                                            )
                                        ) {
                                            // This [Box] will fill maximum size, which is specified by the [Placeholder]
                                            // above. Notice the width and height in [Placeholder] are specified in TextUnit,
                                            // and are converted into pixel by text layout.
                                            Box(
                                                modifier = Modifier
                                                    .fillMaxSize()
                                                    .background(color = Color.Red)
                                            )
                                        }
                                    )
                                )

                            )
                        }


                    }
                }
            }
        }
    }
}
