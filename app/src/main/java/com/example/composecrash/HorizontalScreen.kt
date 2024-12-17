package com.example.composecrash

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp


@Composable
fun HorizontalView() {
    Row(Modifier
        .fillMaxWidth()
        .height(100.dp)
        .background(Color.Blue),
        horizontalArrangement = Arrangement.SpaceAround,
        verticalAlignment = Alignment.CenterVertically
    ) {
        TextViewComponent(labelName = "Hello Dev")
        TextViewComponent(labelName = "Hello Arti")
        TextViewComponent(labelName = "Hello Ivaan")
        TextViewComponent(labelName = "Hello Hazel")
    }

}

@Preview(showBackground = true)
@Composable
fun HorizontalViewPreview() {
    HorizontalView()
}