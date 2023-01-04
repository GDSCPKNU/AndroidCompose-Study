package com.example.composearticle

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.composearticle.ui.theme.ComposeArticleTheme
import java.io.StringReader

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            ComposeArticleTheme{
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colors.background
                ){
                    ComposeArticleApp(
                        stringResource(R.string.title_jetpack_compose_tutorial)
                        , stringResource(R.string.compose_short_desc)
                        , stringResource(R.string.compose_long_desc))

                }
            }
        }
    }
}

@Composable
fun ComposeArticleApp(title: String, about: String , plan: String) {

    ArticleCard(stringResource(R.string.title_jetpack_compose_tutorial)
        , stringResource(R.string.compose_short_desc)
        , stringResource(R.string.compose_long_desc)
        ,painterResource(R.drawable.bg_compose_background))
}

@Composable
private fun ArticleCard(
    title: String,
    shortDescription: String,
    longDescription: String,
    imagePainter: Painter,
    modifier: Modifier = Modifier
) {
    Column(modifier = Modifier
        .fillMaxWidth()
        .fillMaxHeight()) {

        Image(
            painter = imagePainter,
            contentDescription = null,
        modifier.fillMaxWidth()
        )
        Text(
            text=title,
            fontSize = 24.sp,
            modifier = Modifier
                .padding(start = 16.dp, end = 16.dp, bottom = 16.dp, top = 16.dp)
        )
        Text(
            text=shortDescription,
            modifier = Modifier
                .padding(start = 16.dp, end = 16.dp),
            textAlign = TextAlign.Justify
        )
        Text(
            text=longDescription,
            modifier = Modifier
                .padding(start = 16.dp, end = 16.dp, bottom = 16.dp, top = 16.dp)

        )


    }

}


@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    ComposeArticleApp(
        stringResource(R.string.title_jetpack_compose_tutorial)
        , stringResource(R.string.compose_short_desc)
        , stringResource(R.string.compose_long_desc))
}