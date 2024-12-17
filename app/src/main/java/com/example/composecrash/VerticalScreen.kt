package com.example.composecrash

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp


@Composable
fun VerticalView() {
    Column(
        Modifier
            .fillMaxSize()
            .background(Color.White)
            .padding(bottom = 20.dp),
        verticalArrangement = Arrangement.Top,
        horizontalAlignment = Alignment.Start,
    ) {
        TextViewComponent(
            labelName = "Hi there!",
            labelSize = 24.sp,
            labelStyle = FontStyle.Italic,
            labelWeight = FontWeight.Bold
        )
        Row(horizontalArrangement = Arrangement.Start,
            verticalAlignment = Alignment.CenterVertically) {
            ImageComponent()
            TextFieldComponent()
        }
        TextViewComponent(
            labelName = "Hello Ivaan"
        )
        TextViewComponent(
            labelName = "Hello Hazel"
        )
    }

}

@Preview(showBackground = true)
@Composable
fun VerticalViewPreview() {
    VerticalView()
}