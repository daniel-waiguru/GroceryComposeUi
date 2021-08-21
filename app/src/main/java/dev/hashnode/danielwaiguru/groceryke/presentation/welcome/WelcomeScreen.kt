package dev.hashnode.danielwaiguru.groceryke.presentation.welcome

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import dev.hashnode.danielwaiguru.groceryke.R
import dev.hashnode.danielwaiguru.groceryke.presentation.components.GradientButton
import dev.hashnode.danielwaiguru.groceryke.ui.theme.GroceryKeTheme
import dev.hashnode.danielwaiguru.groceryke.ui.theme.faintGreen
import dev.hashnode.danielwaiguru.groceryke.ui.theme.primaryColor
import dev.hashnode.danielwaiguru.groceryke.ui.theme.primaryVariantColor

@Composable
fun WelcomeScreen() {
    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(faintGreen)
    ) {
        Column(horizontalAlignment = Alignment.CenterHorizontally) {
            Image(
                painter = painterResource(id = R.drawable.grocery),
                contentDescription = stringResource(R.string.welcome_logo),
                modifier = Modifier
                    .size(450.dp)
                    .padding(top = 16.dp)
            )
            WelcomeIntro()
        }
    }
}

@Composable
fun WelcomeIntro() {
    Column(
        modifier = Modifier
            .fillMaxWidth()
            .fillMaxHeight()
            .clip(RoundedCornerShape(topStart = 40.dp, topEnd = 40.dp))
            .background(Color.White)
        ,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Spacer(modifier = Modifier.height(40.dp))
        Text(
            modifier = Modifier.padding(top = 16.dp),
            text = stringResource(R.string.intro),
            fontWeight = FontWeight.ExtraBold,
            fontSize = 28.sp,
            textAlign = TextAlign.Right
        )
        Spacer(modifier = Modifier.height(30.dp))
        Text(
            modifier = Modifier.padding(end = 8.dp, start = 8.dp),
            text = stringResource(R.string.intro_subtitle),
            fontWeight = FontWeight.Normal,
            fontSize = 20.sp,
            textAlign = TextAlign.Center
        )
        Spacer(modifier = Modifier.height(30.dp))
        GradientButton(
            text = stringResource(R.string.get_started),
            textColor = Color.White,
            gradient = Brush.horizontalGradient(
                colors = listOf(primaryVariantColor, primaryColor)
            )
        ) {
            
        }
    }
}

@Preview
@Composable
fun WelcomeScreenPreview() {
    GroceryKeTheme {
        WelcomeScreen()
    }
}