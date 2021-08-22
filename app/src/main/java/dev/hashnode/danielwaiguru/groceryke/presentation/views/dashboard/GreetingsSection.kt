package dev.hashnode.danielwaiguru.groceryke.presentation.views.dashboard

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Search
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import dev.hashnode.danielwaiguru.groceryke.R
import dev.hashnode.danielwaiguru.groceryke.domain.models.Product
import dev.hashnode.danielwaiguru.groceryke.domain.models.Shop
import dev.hashnode.danielwaiguru.groceryke.ui.theme.faintGreen
import dev.hashnode.danielwaiguru.groceryke.ui.theme.primaryColor
import dev.hashnode.danielwaiguru.groceryke.ui.theme.secondaryColor

@Composable
fun GreetingSection() {
    Row(
        verticalAlignment = Alignment.CenterVertically
    ) {
        Column(modifier = Modifier.weight(1f)) {
            Text(
                text = stringResource(R.string.welcome),
                fontSize = 15.sp,
                color = Color.LightGray
            )
            Text(
                text = "Daniel Waiguru",
                fontWeight = FontWeight.ExtraBold,
                color = secondaryColor,
                fontSize = 20.sp
            )
        }
        Image(
            modifier = Modifier
                .size(40.dp)
                .clip(RoundedCornerShape(8.dp))
            ,
            painter = painterResource(id = R.drawable.danny),
            contentDescription = stringResource(R.string.profile_image),
            contentScale = ContentScale.Crop
        )
    }
}

@Composable
fun SearchSection() {
    var text by remember {
        mutableStateOf("")
    }
    Row(
        verticalAlignment = Alignment.CenterVertically) {
        TextField(
            value = text,
            onValueChange = {
                            text = it
            },
            maxLines = 1,
            singleLine = true,
            modifier = Modifier
                .height(60.dp)
                .weight(1f)
            ,
            leadingIcon = {
                Icon(
                    imageVector = Icons.Default.Search,
                    contentDescription = stringResource(id = R.string.search_bar)
                )
            },
            colors = TextFieldDefaults.textFieldColors(
                backgroundColor = Color.White,
                focusedIndicatorColor =  Color.Transparent,
                unfocusedIndicatorColor = Color.Transparent
            ),
            shape = RoundedCornerShape(10.dp),
            placeholder = {
                Text(
                    text = stringResource(id = R.string.search),
                    color = Color.LightGray
                )
            }
        )
        Spacer(modifier = Modifier.width(10.dp))
        Box(
            modifier = Modifier
                .size(60.dp)
                .clip(RoundedCornerShape(10.dp))
                .background(faintGreen)
                .padding(16.dp)
            ,
            contentAlignment = Alignment.Center
        ) {
            Icon(
                painter = painterResource(id = R.drawable.slider),
                contentDescription = null,
                tint = primaryColor,
                modifier = Modifier.fillMaxSize()
            )
        }
    }
}

@Composable
fun ChipSection(
    chips: List<String>
) {
    var selectedChipIndex by remember {
        mutableStateOf(0)
    }
    LazyRow(modifier = Modifier.fillMaxWidth()) {
        items(chips.size) {
            Box(
                contentAlignment = Alignment.Center,
                modifier = Modifier
                    .clickable {
                        selectedChipIndex = it
                    }
                    .padding(15.dp)
            ) {
                val isSelected = selectedChipIndex == it
                ChipItem(
                    text = chips[it],
                    color = if (isSelected) primaryColor else Color.LightGray,
                    isSelected = isSelected
                )
            }
        }
    }
}
@Composable
fun ChipItem(text: String, color: Color, isSelected: Boolean) {
    Column {
        Text(
            text = text,
            color = color
        )
        Spacer(modifier = Modifier.height(4.dp))
        if (isSelected) {
            Box(
                modifier = Modifier
                    .size(6.dp)
                    .clip(CircleShape)
                    .background(primaryColor)
                    .align(Alignment.CenterHorizontally),

                )
        }
    }
}
@Composable
fun RecentShop(shops: List<Shop>) {
    Column(
        modifier = Modifier.fillMaxWidth(),
        verticalArrangement = Arrangement.SpaceEvenly
    ) {
        Text(
            text = stringResource(R.string.recent_shop),
            style = MaterialTheme.typography.h6,
        )
        LazyColumn(modifier = Modifier.fillMaxWidth()) {
            items(shops.size) {
                ShopItem(shop = shops[it])
            }
        }
    }
}
@Composable
fun ShopItem(shop: Shop) {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(vertical = 8.dp)
            .background(Color.White)
            .clip(RoundedCornerShape(10.dp)),
        horizontalArrangement = Arrangement.SpaceBetween,
        verticalAlignment = Alignment.CenterVertically
    ) {
        Image(
            painter = painterResource(id = shop.photo),
            contentDescription = null,
            modifier = Modifier
                .size(60.dp)
                .clip(RoundedCornerShape(10.dp))
        )
        Column {
            Text(
                text = shop.name,
                fontWeight = FontWeight.Bold,
                color = secondaryColor,
                fontSize = 22.sp
            )
            Spacer(modifier = Modifier.height(6.dp))
            Text(
                text = shop.category,
                color = Color.LightGray,
                fontSize = 14.sp
            )
        }
        Text(
            text = "$ ${shop.price}",
            color = primaryColor,
            fontWeight = FontWeight.Bold,
            fontSize = 25.sp,
        )
    }
}

@Composable
fun RowItem(product: Product) {
    Card(
        Modifier.fillMaxWidth()
            .padding(horizontal = 8.dp)
            .background(Color.White)
            .clip(RoundedCornerShape(10.dp)),
        elevation = 2.dp,
    ) {
        Column (modifier = Modifier.padding(10.dp)) {
            Image(
                painter = painterResource(id = product.image),
                contentDescription = product.name,
                modifier = Modifier
                    .fillMaxWidth()
                    .height(120.dp)
                    .padding(4.dp)
            )
            Spacer(modifier = Modifier.height(4.dp))
            Column(verticalArrangement = Arrangement.SpaceEvenly) {
                Text(
                    text = product.name,
                    fontSize = 22.sp,
                    color = secondaryColor,
                    fontWeight = FontWeight.Bold
                )
                Spacer(modifier = Modifier.height(2.dp))
                Text(
                    text = product.category,
                    color = Color.LightGray,
                    fontSize = 14.sp
                )
                Spacer(modifier = Modifier.height(2.dp))
                Text(
                    text = "$${product.price}",
                    fontWeight = FontWeight.Bold,
                    color = primaryColor,
                    fontSize = 19.sp
                )
            }
        }
    }
}
@Preview
@Composable
fun GreetingPreview() {

}