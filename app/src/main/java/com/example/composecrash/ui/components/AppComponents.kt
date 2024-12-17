package com.example.composecrash.ui.components

import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.layout.wrapContentWidth
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.pager.HorizontalPager
import androidx.compose.foundation.pager.VerticalPager
import androidx.compose.foundation.pager.rememberPagerState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import coil.compose.AsyncImage
import com.example.composecrash.R
import com.example.composecrash.data.entity.Article
import com.example.composecrash.data.entity.NewsResponse

@Composable
fun Loader() {
    Box(
        modifier = Modifier.fillMaxSize(),
        contentAlignment = Alignment.Center
    ) {
        CircularProgressIndicator(
            color = MaterialTheme.colorScheme.primary, // Custom color
            strokeWidth = 4.dp                         // Custom stroke width
        )
    }
}

@Composable
fun LazyVerticalList(response: NewsResponse) {
    LazyColumn {
        items(response.articles) { article ->
            NormalTextView(article)
        }
    }
}

@OptIn(ExperimentalFoundationApi::class)
@Composable
fun VerticalPagerScreen(response: NewsResponse) {
    val state = rememberPagerState(pageCount = { response.articles.size })
    VerticalPager(
        state = state,
        modifier = Modifier
            .fillMaxSize()
    ) {
        val article = response.articles[state.currentPage]
        Column(modifier = Modifier
            .fillMaxSize()) {
            ImageView(article = article)
            NormalTextView(
                article = article,
                fontSize = 24,
                fontWeight = FontWeight.Medium,
                fontStyle = FontStyle.Italic
            )
            NormalTextView(
                article = article,
                text = article.description ?: "No description available",
                fontSize = 18,
                fontFamily = FontFamily.Monospace
            )
            Spacer(modifier = Modifier.weight(1f))
            LeftRightTextView(article = article)
        }
    }
}

@OptIn(ExperimentalFoundationApi::class)
@Composable
fun HorizontalPagerScreen(response: NewsResponse) {
    val state = rememberPagerState(pageCount = { response.articles.size })
    HorizontalPager(
        state = state,
        modifier = Modifier
            .fillMaxWidth()
            .wrapContentHeight()
    ) {
        val article = response.articles[state.currentPage]
        Column {
            ImageView(article = article)
            NormalTextView(
                article = article,
                fontSize = 24,
                fontWeight = FontWeight.Medium,
                fontStyle = FontStyle.Italic
            )
            NormalTextView(
                article = article,
                text = article.description ?: "No description available",
                fontSize = 18,
                fontFamily = FontFamily.Monospace
            )
            LeftRightTextView(article = article)
        }
    }
}

@Composable
fun ImageView(article: Article) {
    val imageUrl = article.urlToImage
    if (!imageUrl.isNullOrEmpty()) {
        AsyncImage(
            modifier = Modifier
                .padding(top = 5.dp, bottom = 10.dp)
                .fillMaxWidth()
                .height(250.dp)
                .clip(RoundedCornerShape(10.dp)), // Rounded corners
            model = imageUrl,  // Safe null check for imageUrl
            contentDescription = "Rounded Image",
            placeholder = painterResource(id = R.drawable.ic_launcher_background), // Placeholder while loading
            error = painterResource(id = R.drawable.ic_launcher_foreground),
        )
    }
}

@Composable
fun LeftRightTextView(article: Article) {
    Row(
        modifier = Modifier
            .fillMaxSize()
            .padding(10.dp)
    ) {
        Text(text = article.author ?: "No author found")  // Handle null author
        Spacer(modifier = Modifier.weight(1f))
        Text(text = article.source?.name ?: "No source available")  // Handle null source
    }
}

@Composable
fun NormalTextView(
    article: Article,
    text: String = article.title ?: "No title available",  // Handle null title
    fontSize: Int = 18,
    fontWeight: FontWeight = FontWeight.Normal,
    fontFamily: FontFamily = FontFamily.Serif,
    fontStyle: FontStyle = FontStyle.Normal
) {
    Text(
        modifier = Modifier
            .wrapContentWidth()
            .wrapContentHeight()
            .padding(8.dp),
        text = text,
        color = Color.DarkGray,
        fontStyle = fontStyle,
        fontSize = fontSize.sp,
        fontWeight = fontWeight,
        fontFamily = fontFamily
    )
}
