package com.example.composecrash

import android.util.Log
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.RectangleShape
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.TextUnit
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.composecrash.ui.theme.ComposeCrashTheme

@Composable
fun Greeting(name: String, modifier: Modifier = Modifier) {
    TextViewComponent(
        modifier,
        "Hello $name!",
        24.sp,
        Color.Magenta,
        FontWeight.SemiBold,
        FontStyle.Italic,
        1
    )
}

//@Preview(showBackground = true, showSystemUi = true)
@Composable
fun GreetingPreview() {
    ComposeCrashTheme {
        Greeting("Dev")
    }
}

@Composable
fun TextViewComponent(
    modifier: Modifier = Modifier
        .fillMaxWidth()
        .wrapContentHeight()
        .background(Color.White)
        .padding(20.dp), // Default modifier
    labelName: String = "Default Text", // Default text
    labelSize: TextUnit = 16.sp, // Default font size
    labelColor: Color = Color.Black, // Default color
    labelWeight: FontWeight = FontWeight.Normal, // Default font weight
    labelStyle: FontStyle = FontStyle.Normal, // Default font style
    maxLines: Int? = Int.MAX_VALUE // Default max lines to unlimited
) {
    Text(
        modifier = modifier,
        text = labelName,
        fontSize = labelSize,
        color = labelColor,
        fontWeight = labelWeight,
        fontStyle = labelStyle,
        maxLines = maxLines ?: Int.MAX_VALUE,
        overflow = TextOverflow.Ellipsis
    )
}

@Composable
fun SimpleButton() {
    Button(
        onClick = {
            Log.d("SimpleButton", "Button Clicked")
        },
        modifier = Modifier
            .fillMaxWidth()
            .padding(16.dp),
        shape = RoundedCornerShape(12)
    ) {
        ButtonText()
    }
}

//@Preview(showBackground = true, showSystemUi = true)
@Composable
fun SimpleButtonPreview() {
    SimpleButton()
}

@Composable
fun ButtonText(labelName: String = "Click here") {
    Text(text = labelName)
}

@Composable
fun TextFieldComponent() {
    var text by rememberSaveable {
        mutableStateOf("")
    }
    TextField(
        modifier = Modifier
            .fillMaxWidth()
            .padding(16.dp)
            .border(1.dp, Color.Gray, RectangleShape),
        value = text,
        onValueChange = { text = it },
        label = { Text(text = "Your name") },
        placeholder = { Text(text = "Please enter your name") },
        keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Number)
    )
}

//@Preview(showBackground = true, showSystemUi = true)
@Composable
fun TextFieldComponentPreview() {
    TextFieldComponent()
}

@Composable
fun ImageComponent() {
    Image(painter = painterResource(id = R.drawable.insta),
        contentDescription = "Insta img",
        modifier = Modifier
            .size(55.dp),
        )
}

@Preview(showBackground = true, showSystemUi = true)
@Composable
fun ImageComponentPreview() {
    ImageComponent()
}