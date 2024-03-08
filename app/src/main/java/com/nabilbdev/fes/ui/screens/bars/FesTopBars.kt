package com.nabilbdev.fes.ui.screens.bars

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Card
import androidx.compose.material3.CenterAlignedTopAppBar
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.dimensionResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.LineBreak
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextOverflow
import com.nabilbdev.fes.R

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun FesTopAppBar(
    currentScreen: String,
    modifier: Modifier = Modifier
) {
    CenterAlignedTopAppBar(
        title = {
            Text(
                text = currentScreen,
                style = MaterialTheme.typography.headlineLarge
            )
        },
        modifier = modifier,
    )
}

@Composable
fun FesTopBanner() {
    Card(
        shape = MaterialTheme.shapes.medium,
        modifier = Modifier
            .fillMaxWidth()
            .height(dimensionResource(id = R.dimen.image_height))
            .padding(
                start = dimensionResource(id = R.dimen.padding_small),
                top = dimensionResource(id = R.dimen.padding_medium),
                end = dimensionResource(id = R.dimen.padding_small),
                bottom = dimensionResource(id = R.dimen.padding_medium)
            )
    ) {
        Row(
            horizontalArrangement = Arrangement.SpaceAround,
            modifier = Modifier
                .fillMaxWidth()
                .padding(dimensionResource(id = R.dimen.padding_small)),
        ) {
            Column(
                modifier = Modifier
                    .weight(1f),
                horizontalAlignment = Alignment.CenterHorizontally,
                verticalArrangement = Arrangement.SpaceEvenly
            ) {
                Text(
                    text = stringResource(id = R.string.feed_top_title),
                    softWrap = true,
                    textAlign = TextAlign.Justify,
                    style = MaterialTheme.typography.bodyLarge.copy(
                        lineBreak = LineBreak.Heading
                    )
                )
                Text(
                    text = stringResource(id = R.string.feed_top_description),
                    softWrap = true,
                    textAlign = TextAlign.Left,
                    overflow = TextOverflow.Clip,
                    style = MaterialTheme.typography.bodySmall.copy(
                        lineBreak = LineBreak.Paragraph
                    ),
                    modifier = Modifier.padding(
                        bottom = dimensionResource(id = R.dimen.padding_very_small),
                        top = dimensionResource(id = R.dimen.padding_very_small),
                        start = dimensionResource(id = R.dimen.padding_small),
                        end = dimensionResource(id = R.dimen.padding_small)
                    )
                )
            }
            Image(
                painter = painterResource(id = R.drawable.fes_banner),
                contentDescription = null,
                modifier = Modifier
                    .clip(MaterialTheme.shapes.medium)
                    .weight(1f),
                contentScale = ContentScale.Crop
            )
        }
    }
}