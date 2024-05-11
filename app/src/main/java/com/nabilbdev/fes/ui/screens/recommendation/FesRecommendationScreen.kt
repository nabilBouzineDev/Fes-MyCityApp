package com.nabilbdev.fes.ui.screens.recommendation

import androidx.compose.animation.animateContentSize
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.CornerSize
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.KeyboardArrowLeft
import androidx.compose.material.icons.automirrored.rounded.ArrowBack
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.dimensionResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.style.TextDecoration
import androidx.compose.ui.tooling.preview.Devices
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.nabilbdev.fes.R
import com.nabilbdev.fes.data.DataSourceProvider
import com.nabilbdev.fes.data.model.Recommendation
import com.nabilbdev.fes.ui.navigation.navItemList
import com.nabilbdev.fes.ui.theme.FesTheme
import com.nabilbdev.fes.ui.utils.FesNavigationType

@Composable
fun RecommendationScreen(
    recommendation: Recommendation,
    onBackButtonClicked: () -> Unit,
    stars: Int,
    navigationType: FesNavigationType,
) {

    when (navigationType) {
        FesNavigationType.BOTTOM_NAVIGATION -> {
            CompactRecommendationScreen(
                recommendation = recommendation,
                onBackButtonClicked = onBackButtonClicked,
                stars = stars
            )
        }

        FesNavigationType.NAVIGATION_RAIL -> {
            MediumRecommendationScreen(
                recommendation = recommendation,
                onBackButtonClicked = onBackButtonClicked,
                stars = stars
            )
        }

        else -> {
            ExpandedRecommendationScreen(
                recommendation = recommendation,
                onBackButtonClicked = onBackButtonClicked,
                stars = stars
            )
        }
    }
}


@Composable
fun CompactRecommendationScreen(
    recommendation: Recommendation,
    onBackButtonClicked: () -> Unit,
    stars: Int,
    modifier: Modifier = Modifier
) {
    var expanded by remember { mutableStateOf(false) }

    Column(
        modifier = modifier
            .animateContentSize()
            .fillMaxSize()
    ) {

        ImageAndHeader(
            recommendation = recommendation,
            onBackButtonClicked = onBackButtonClicked,
            isCompact = true
        )

        Box(modifier = Modifier.weight(1f, fill = true)) {
            PlaceNameAndDescription(
                recommendation = recommendation,
                modifier = Modifier
                    .fillMaxHeight()
                    .offset(x = 0.dp, y = if (expanded) (-80).dp else (-20).dp)
            )
            CategoryBadge(
                categoryOption = recommendation.categoryOptions.name,
                modifier = Modifier
                    .padding(dimensionResource(id = R.dimen.padding_medium))
                    .align(Alignment.TopEnd)
                    .offset(x = 0.dp, y = if (expanded) (-126).dp else (-66).dp)
                    .shadow(
                        elevation = 6.dp,
                        shape = CircleShape
                    )
                    .clickable { expanded = !expanded }
            )
            ReviewBar(
                stars = stars,
                expanded = expanded,
                isCompact = true,
                modifier = Modifier
                    .align(Alignment.BottomCenter)
            )
        }
    }
}

@Composable
fun MediumRecommendationScreen(
    recommendation: Recommendation,
    onBackButtonClicked: () -> Unit,
    stars: Int,
    modifier: Modifier = Modifier
) {

    Column(
        modifier = modifier
            .fillMaxSize()
            .background(
                color = Color.White
            )
            .padding(
                start = 95.dp
            )
            .verticalScroll(rememberScrollState())
    ) {
        Box(
            modifier = Modifier
                .padding(top = dimensionResource(id = R.dimen.padding_medium))
        ) {
            ImageAndHeader(
                recommendation = recommendation,
                onBackButtonClicked = onBackButtonClicked,
                isCompact = false
            )
            BackButtonIcon(
                onBackButtonClicked = onBackButtonClicked,
                isCompact = false
            )
        }
        Row(
            horizontalArrangement = Arrangement.SpaceEvenly,
            modifier = Modifier
                .fillMaxWidth()
        ) {
            Column(
                modifier = Modifier
                    .fillMaxWidth(0.4f)
            ) {
                PlaceName(
                    recommendation = recommendation
                )
                ReviewBar(
                    stars = stars,
                    expanded = false,
                    isCompact = false
                )
            }
            Description(
                recommendation = recommendation,
                modifier = Modifier
                    .fillMaxWidth(0.6f)
                    .padding(top = 24.dp)
            )
        }
    }
}

@Composable
fun ExpandedRecommendationScreen(
    recommendation: Recommendation,
    onBackButtonClicked: () -> Unit,
    stars: Int,
    modifier: Modifier = Modifier
) {
    Row(
        modifier = modifier
            .fillMaxSize()
            .background(
                color = Color.White
            )
            .padding(
                start = 95.dp
            )
    ) {
        Box(
            modifier = Modifier
                .weight(1f)
                .padding(
                    top = dimensionResource(id = R.dimen.padding_medium),
                    bottom = dimensionResource(id = R.dimen.padding_medium)
                )
        ) {
            ExpandedImageAndHeader(
                recommendation = recommendation
            )
            BackButtonIcon(
                onBackButtonClicked = onBackButtonClicked,
                isCompact = false
            )
        }
        Column(
            modifier = Modifier
                .weight(1f)
                .verticalScroll(rememberScrollState())
        ) {
            Column {
                PlaceName(
                    recommendation = recommendation
                )
                ReviewBar(
                    stars = stars,
                    expanded = false,
                    isCompact = false
                )
            }
            HorizontalDivider(
                modifier = Modifier.padding(
                    start = 95.dp,
                    end = 95.dp,
                    top = 48.dp,
                    bottom = 24.dp,
                )
            )
            Description(
                recommendation = recommendation,
                modifier = Modifier
                    .padding(end = 95.dp)
            )
        }
    }
}

@Composable
fun BackButtonIcon(
    onBackButtonClicked: () -> Unit,
    isCompact: Boolean,
    modifier: Modifier = Modifier
) {
    if (isCompact) {
        IconButton(
            onClick = onBackButtonClicked,
            modifier = modifier
                .fillMaxWidth(0.3f)
                .padding(
                    top = dimensionResource(id = R.dimen.padding_small)
                )
        ) {
            Row(verticalAlignment = Alignment.CenterVertically) {
                Icon(
                    imageVector = Icons.AutoMirrored.Filled.KeyboardArrowLeft,
                    contentDescription = null,
                    tint = Color.White,
                    modifier = Modifier
                        .size(dimensionResource(id = R.dimen.back_icon_size))
                )
                Text(
                    text = stringResource(id = R.string.back_button_label),
                    style = MaterialTheme.typography.bodyMedium.copy(
                        fontSize = 20.sp
                    ),
                    color = Color.White
                )
            }
        }
    } else {
        Card(
            shape = CardDefaults.elevatedShape,
            modifier = modifier
                .offset(x = 15.dp, y = (-12).dp)
                .padding(
                    end = dimensionResource(id = R.dimen.padding_large),
                )
                .clip(CircleShape),
            colors = CardDefaults.cardColors(
                containerColor = Color.White
            ),
        ) {
            IconButton(
                onClick = onBackButtonClicked
            ) {
                Icon(
                    imageVector = Icons.AutoMirrored.Rounded.ArrowBack,
                    contentDescription = null,
                    modifier = Modifier
                        .size(dimensionResource(id = R.dimen.icon_border_size))
                )
            }
        }
    }
}

@Composable
fun ExpandedImageAndHeader(
    recommendation: Recommendation,
    modifier: Modifier = Modifier
) {
    val painter = painterResource(id = recommendation.imageResourceId)
    Card(
        shape = MaterialTheme.shapes.medium,
        modifier = modifier
            .padding(
                start = dimensionResource(id = R.dimen.padding_large),
                end = dimensionResource(id = R.dimen.padding_large),
            )
    ) {
        Image(
            painter = painter,
            contentDescription = null,
            modifier = Modifier
                .aspectRatio(
                    ratio = 2f / 3f
                )
                .fillMaxWidth()
                .fillMaxHeight(),
            contentScale = ContentScale.Crop
        )
    }
}

@Composable
fun ImageAndHeader(
    recommendation: Recommendation,
    onBackButtonClicked: () -> Unit,
    isCompact: Boolean,
    modifier: Modifier = Modifier
) {
    val painter = painterResource(id = recommendation.imageResourceId)
    if (isCompact) {
        Box {
            Image(
                painter = painter,
                contentDescription = null,
                modifier = modifier
                    .aspectRatio(
                        ratio = 1f / 1f
                    )
                    .fillMaxWidth()
                    .fillMaxHeight(),
                contentScale = ContentScale.Crop
            )
            BackButtonIcon(
                onBackButtonClicked = onBackButtonClicked,
                isCompact = true
            )
        }
    } else {
        Card(
            shape = MaterialTheme.shapes.medium,
            modifier = modifier
                .padding(
                    start = dimensionResource(id = R.dimen.padding_large),
                    end = dimensionResource(id = R.dimen.padding_large),
                )
        ) {
            Image(
                painter = painter,
                contentDescription = null,
                modifier = Modifier
                    .aspectRatio(
                        ratio = 16f / 9f
                    )
                    .fillMaxWidth()
                    .fillMaxHeight(),
                contentScale = ContentScale.Crop
            )
        }
    }
}

@Composable
fun CategoryBadge(
    categoryOption: String,
    modifier: Modifier = Modifier
) {
    Box(
        modifier = modifier
            .size(dimensionResource(id = R.dimen.icon_border_size))
            .clip(CircleShape)
            .background(
                color = Color.White
            ),
        contentAlignment = Alignment.Center
    ) {
        Icon(
            painter = painterResource(
                id = navItemList.filter { it.route.uppercase() == categoryOption }[0]
                    .icon
            ),
            contentDescription = null,
            tint = Color.Black,
            modifier = Modifier
                .size(dimensionResource(id = R.dimen.icon_size))
                .padding(dimensionResource(id = R.dimen.padding_small))
        )
    }
}

@Composable
fun PlaceName(
    recommendation: Recommendation,
    modifier: Modifier = Modifier
) {
    Text(
        text = recommendation.name,
        color = Color.Black.copy(0.87f),
        style = MaterialTheme.typography.headlineLarge.copy(
            fontFamily = FontFamily.Serif,
        ),
        modifier = modifier
            .padding(
                top = dimensionResource(id = R.dimen.padding_large),
                bottom = dimensionResource(id = R.dimen.padding_small)
            )
    )
}

@Composable
fun PlaceNameAndDescription(
    recommendation: Recommendation,
    modifier: Modifier = Modifier
) {

    Card(
        shape = MaterialTheme.shapes.extraSmall,
        colors = CardDefaults.cardColors(containerColor = Color.White),
        modifier = modifier
            .fillMaxSize()
    ) {
        Text(
            text = recommendation.name,
            color = Color.Black.copy(0.87f),
            style = MaterialTheme.typography.headlineLarge.copy(
                fontFamily = FontFamily.Serif,
            ),
            modifier = Modifier
                .padding(
                    top = dimensionResource(id = R.dimen.padding_large),
                    start = dimensionResource(id = R.dimen.padding_large),
                    end = dimensionResource(id = R.dimen.padding_large),
                    bottom = dimensionResource(id = R.dimen.padding_small)
                )
        )
        Description(
            recommendation = recommendation,
            modifier = Modifier
                .padding(
                    start = dimensionResource(id = R.dimen.padding_large),
                    end = dimensionResource(id = R.dimen.padding_large),
                )
        )
    }
}

@Composable
fun Description(
    recommendation: Recommendation,
    modifier: Modifier = Modifier
) {
    Column(
        modifier = modifier
            .padding(dimensionResource(id = R.dimen.padding_small))
    ) {
        Text(
            text = stringResource(id = R.string.des_title),
            color = Color.Black.copy(0.8f),
            textDecoration = TextDecoration.Underline,
            style = MaterialTheme.typography.bodyLarge.copy(
                fontSize = 25.sp,
                fontFamily = FontFamily.Serif,
            ),
            modifier = Modifier
                .padding(
                    bottom = dimensionResource(id = R.dimen.padding_medium)
                )
        )
        Text(
            text = recommendation.description,
            style = MaterialTheme.typography.bodySmall,
        )
    }
}

@Composable
fun ReviewBar(
    stars: Int,
    expanded: Boolean,
    isCompact: Boolean,
    modifier: Modifier = Modifier
) {
    if (isCompact) {
        Card(
            shape = MaterialTheme.shapes.extraSmall,
            colors = CardDefaults.cardColors(
                containerColor = Color.Black
            ),
            modifier = modifier
                .fillMaxHeight(if (expanded) 0.22f else 0.15f)
        ) {
            FesRatingBar(
                stars = stars,
                color = Color.White,
                isCompact = true,
                size = dimensionResource(id = R.dimen.stars_icon_size)
            )
        }
    } else {
        Card(
            shape = RoundedCornerShape(
                corner = CornerSize(25.dp),
            ),
            colors = CardDefaults.cardColors(
                containerColor = Color.Black
            ),
            modifier = modifier
                .wrapContentSize(Alignment.Center)
        ) {
            FesRatingBar(
                stars = stars,
                color = Color.White,
                isCompact = false,
                size = dimensionResource(id = R.dimen.stars_icon_size)
            )
        }
    }
}


@Preview(device = Devices.TABLET, apiLevel = 33, showSystemUi = true)
@Composable
fun RecommendationScreenPreview() {
    FesTheme {
        RecommendationScreen(
            recommendation = DataSourceProvider.allRecommendations[7],
            onBackButtonClicked = {},
            stars = 2,
            navigationType = FesNavigationType.SPLIT_NAV_RAIL
        )
    }
}