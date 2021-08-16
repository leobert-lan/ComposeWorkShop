package osp.leobert.android.composeworkshop.post26

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.text.InlineTextContent
import androidx.compose.foundation.text.appendInlineContent
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.*
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextDecoration
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.em
import androidx.compose.ui.unit.sp
import osp.leobert.android.composeworkshop.ui.theme.ComposeWorkShopTheme

class P26TextSample : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        //* text - 要显示的内容
        //* modifier - 需要应用的修饰器.
        //* color - 文字色. 如果是 `Color.Unspecified`, 同时 style 没有配饰颜色, 将会使用 `LocalContentColor`.
        //* fontSize - 字号. See TextStyle.fontSize.
        //* fontStyle - 文字样式，例如斜体，See TextStyle.fontStyle.
        //* fontWeight - 字重，例如加粗.
        //* fontFamily - 字体系列. See TextStyle.fontFamily.
        //* letterSpacing - 字间距. See TextStyle.letterSpacing.
        //* textDecoration - 文字装饰效果，例如下划线. See TextStyle.textDecoration.
        //* textAlign - 文字段落对齐方式. See TextStyle.textAlign.
        //* lineHeight - 行高. See TextStyle.lineHeight.
        //* overflow - 溢出时的处理方案，所谓溢出即文本框显示不下这么多文字.
        //* softWrap - 是否应用换行符. 如果不应用，则一行写完，`overflow` 、`TextAlign` 无效.
        //* maxLines - 最大行数，必须大于0.
        //* inlineContent - 占位的替代信息匹配
        //* onTextLayout - 绘制文字计算布局时的回调
        //* style - 样式，例如： color, font, line height 等.

        setContent {
            ComposeWorkShopTheme {
                // A surface container using the 'background' color from the theme
                Surface(color = MaterialTheme.colors.background) {
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
