package com.kursatdrhistoryapp.ebookapp.view.screen

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.alpha
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavController
import com.kursatdrhistoryapp.ebookapp.model.BookModel
import com.kursatdrhistoryapp.ebookapp.viewmodel.MainScreenViewModel

@Composable
fun DetailScreen(navController: NavController, bookId: Int?) {
    val viewModel: MainScreenViewModel = viewModel()
    val bookList: List<BookModel> = viewModel.bookList.observeAsState().value!!.filter {
        it.id == bookId
    }
    Column() {
        Box() {
            Image(
                painter = painterResource(id = bookList[0].image),
                contentDescription = "",
                modifier = Modifier
                    .fillMaxWidth()
                    .height(240.dp)
                    .alpha(0.3f),
                contentScale = ContentScale.Crop
            )
            Box(modifier = Modifier.size(300.dp , 380.dp)
                .padding(20.dp , 60.dp)) {
                Image(
                    painter = painterResource(id = bookList[0].image),
                    contentDescription = "",
                    modifier = Modifier
                        .clip(shape = RoundedCornerShape(26.dp))
                        .size(160.dp, 260.dp)
                )
            }
        }
        Text(
            text = bookList[0].title,
            color = Color.White,
            fontWeight = FontWeight.Medium,
            fontSize = 24.sp,
            modifier = Modifier.padding(horizontal = 20.dp)
        )
        Spacer(modifier = Modifier.height(10.dp))
        Text(
            text = bookList[0].author,
            color = Color.LightGray,
            fontWeight = FontWeight.Normal,
            fontSize = 24.sp,
            fontStyle = FontStyle.Italic,
            modifier = Modifier.padding(horizontal = 20.dp)
        )
        Spacer(modifier = Modifier.height(10.dp))
        Text(
            text = bookList[0].description,
            color = Color(0xFF55618F),
            fontWeight = FontWeight.Normal,
            fontSize = 16.sp,
            modifier = Modifier.padding(horizontal = 20.dp)
        )

    }
}

