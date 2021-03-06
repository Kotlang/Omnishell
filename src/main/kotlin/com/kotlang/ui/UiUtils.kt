package com.kotlang.ui

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Card
import androidx.compose.material.DropdownMenuItem
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import kotlin.random.Random

@Composable
fun Chip(text: String, onClick: () -> Unit) {
    val colors = listOf(
        Color(red = 253, green = 224, blue = 222),
        Color(red = 231, green = 252, blue = 223),
        Color(red = 254, green = 252, blue = 218),
    )

    Box(Modifier.clickable { onClick() }) {
        Text(text, modifier = Modifier
            .background(color = colors[Random.nextInt(0, 3)],
                shape = RoundedCornerShape(15.dp))
            .padding(8.dp))
    }
}

@Composable
fun PromptIcon() {
    Text(
        "~",
        color = MaterialTheme.colors.primary,
        style = TextStyle(fontSize = 15.sp, fontWeight = FontWeight.W500)
    )
}

@Composable
fun SearchSuggestions(items: List<String>,
                      selectedIdx: Int = -1,
                      modifier: Modifier,
                      onClick: (String) -> Unit) {
    if (items.isNotEmpty()) {
        Card(
            shape = RoundedCornerShape(8.dp),
            modifier = modifier) {
            Column {
                items.forEachIndexed { idx, item ->
                    val bckgndColor = if (idx == selectedIdx) Color.Blue
                        else Color.Transparent
                    val textColor = if (idx == selectedIdx) Color.White
                        else Color.DarkGray

                    DropdownMenuItem(onClick = { onClick(item) },
                        modifier = Modifier.background(bckgndColor)
                    ) {
                        Text(item, color = textColor)
                    }
                }
            }
        }
    }
}