package com.example.deliveryapp.presentation.ui.component.category

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.example.deliveryapp.R
import com.example.deliveryapp.domain.model.CategoryModel
import com.example.deliveryapp.presentation.screen.category.CategoryEvent
import com.example.deliveryapp.presentation.screen.category.CategoryViewModel
import com.example.deliveryapp.presentation.ui.component.LoadingIndicator

@Composable
fun CategoryItem(
    navController: NavController,
    categoryViewModel: CategoryViewModel,
    model: CategoryModel
) {
    val viewModel = CategoryItemViewModel()
    val stateCategoryItem = viewModel.stateCategoryItem.collectAsState()
    viewModel.send(InitDataEvent(model.category, model.img, model.id_category))
    Box(
        modifier = Modifier
            .fillMaxWidth()
            .wrapContentHeight()
            .padding(5.dp)
            .clip(RoundedCornerShape(15.dp))
            .border(width = 2.dp, color = Color.LightGray, shape = RoundedCornerShape(15.dp))
            .background(Color.Transparent)
    ) {
        if (stateCategoryItem.value.isLoading) {
            CircularProgressIndicator(
                modifier = Modifier
                    .size(35.dp)
                    .padding(5.dp)
            )
        } else {
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .wrapContentHeight()
                    .padding(5.dp),
                horizontalArrangement = Arrangement.spacedBy(15.dp)
            ) {
                if (stateCategoryItem.value.decodeImg == null) {
                    Image(
                        painter = painterResource(id = R.drawable.not_image),
                        contentDescription = null,
                        modifier = Modifier
                            .size(60.dp)
                    )
                } else {
                    Image(
                        bitmap = stateCategoryItem.value.decodeImg!!,
                        contentDescription = null,
                        modifier = Modifier
                            .size(60.dp)
                    )
                }
                Text(
                    modifier = Modifier.wrapContentHeight(),
                    text = stateCategoryItem.value.title,
                    color = Color.Black,
                    fontFamily = FontFamily.SansSerif,
                    textAlign = TextAlign.Center,
                    style = TextStyle(fontSize = 16.sp, fontWeight = FontWeight.SemiBold)
                )
            }
        }
    }
}
