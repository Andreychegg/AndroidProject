package com.example.androidproject

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.constraintlayout.compose.ConstraintLayout
import coil.compose.AsyncImage

@Composable
fun ItemInfo(itemId: Int) {
    ConstraintLayout(
        modifier = Modifier
            .fillMaxSize()
    ) {
        val (title, image, details, description) = createRefs()

        Text(
            text = "Интерстеллар",
            fontSize = 28.sp,
            fontWeight = FontWeight.Bold,
            color = Color.Black,
            modifier = Modifier.constrainAs(title) {
                top.linkTo(parent.top, margin = 16.dp)
                start.linkTo(parent.start, margin = 16.dp)
            }
        )

        AsyncImage(
            model = "https://avatars.mds.yandex.net/get-kinopoisk-image/1600647/430042eb-ee69-4818-aed0-a312400a26bf/300x450",
            contentDescription = "Movie Poster",
            modifier = Modifier
                .constrainAs(image) {
                    top.linkTo(title.bottom, margin = 16.dp)
                    start.linkTo(parent.start, margin = 16.dp)
                },
            contentScale = ContentScale.Crop
        )

        Text(
            text = """
                Год производства: 2014
                Страна: США, Великобритания, Канада
                Жанр: фантастика, драма, приключения
                Режиссер: Кристофер Нолан
            """.trimIndent(),
            fontSize = 16.sp,
            color = Color.Gray,
            modifier = Modifier.constrainAs(details) {
                top.linkTo(title.bottom, margin = 16.dp)
                start.linkTo(image.end, margin = 16.dp)
                end.linkTo(parent.end, margin = 16.dp)
                width = androidx.constraintlayout.compose.Dimension.fillToConstraints
            }
        )

        Text(
            text = "Когда засуха, пыльные бури и вымирание растений приводят человечество к продовольственному кризису, " +
                    "коллектив исследователей и учёных отправляется сквозь червоточину (которая предположительно соединяет области " +
                    "пространства-времени через большое расстояние) в путешествие, чтобы превзойти прежние ограничения для космических " +
                    "путешествий человека и найти планету с подходящими для человечества условиями.",
            fontSize = 18.sp,
            modifier = Modifier
                .padding(vertical = 16.dp)
                .constrainAs(description) {
                    top.linkTo(image.bottom, margin = 16.dp)
                    start.linkTo(parent.start, margin = 16.dp)
                    end.linkTo(parent.end, margin = 16.dp)
                    width = androidx.constraintlayout.compose.Dimension.fillToConstraints
                }
        )
    }
}